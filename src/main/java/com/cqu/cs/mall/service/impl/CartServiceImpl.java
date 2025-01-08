package com.cqu.cs.mall.service.impl;
import cn.hutool.core.bean.BeanUtil;
import com.cqu.cs.mall.context.BaseContext;
import com.cqu.cs.mall.convention.exception.ClientException;
import com.cqu.cs.mall.dao.CartMapper;
import com.cqu.cs.mall.dao.ProductMapper;
import com.cqu.cs.mall.domain.CartDO;
import com.cqu.cs.mall.domain.ProductDO;
import com.cqu.cs.mall.dto.req.CartAddItemReqDTO;
import com.cqu.cs.mall.dto.req.CartCheckoutReqDTO;
import com.cqu.cs.mall.dto.req.CartPageReqDTO;
import com.cqu.cs.mall.dto.resp.CartPageRespDTO;
import com.cqu.cs.mall.service.CartService;
import com.cqu.cs.mall.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartMapper cartMapper;
    private final ProductMapper productMapper;
    private final OrderService orderService;

    @Override
    public int addItem(CartAddItemReqDTO cartAddItemReqDTO) {
        if (cartAddItemReqDTO.getQuantity() <= 0) {
            throw new ClientException("商品数量必须大于0");
        }
        ProductDO productDO = productMapper.selectById(cartAddItemReqDTO.getProductId());
        if (productDO == null) {
            throw new ClientException("商品不存在");
        }
        CartDO cartDO = CartDO.builder()
                .reviewerId(BaseContext.getCurrentToken())
                .asin(productDO.getAsin())
                .productId(cartAddItemReqDTO.getProductId())
                .price(productDO.getPrice())
                .quantity(cartAddItemReqDTO.getQuantity())
                .title(productDO.getTitle())
                .imUrl(productDO.getImUrl())
                .build();
        return cartMapper.insert(cartDO);
    }

    @Override
    public List<CartPageRespDTO> pageCart(CartPageReqDTO cartPageReqDTO) {
        int pageSize = cartPageReqDTO.getPageSize();
        int pageNum = cartPageReqDTO.getPageNum() > 0 ? cartPageReqDTO.getPageNum() : 1;
        int offset = (pageNum - 1) * pageSize;
        String reviewerId = BaseContext.getCurrentToken();
        return cartMapper.pageQuery(offset, pageSize, reviewerId);
    }

    @Override
    public int deleteItem(Integer cartId) {
        return cartMapper.deleteById(cartId);

    }

    @Override
    public void checkout(CartCheckoutReqDTO cartCheckoutReqDTO) {
        for (Integer cartId : cartCheckoutReqDTO.getCartIdList()) {
            CartDO cartDO = cartMapper.selectById(cartId);
            orderService.createOrderByCart(cartDO);
            cartMapper.deleteById(cartId);
        }
    }

}
