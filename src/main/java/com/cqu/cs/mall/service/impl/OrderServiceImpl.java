package com.cqu.cs.mall.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.cqu.cs.mall.context.BaseContext;
import com.cqu.cs.mall.convention.exception.ClientException;
import com.cqu.cs.mall.dao.OrderMapper;
import com.cqu.cs.mall.domain.CartDO;
import com.cqu.cs.mall.domain.OrderDO;
import com.cqu.cs.mall.domain.ProductDO;
import com.cqu.cs.mall.dto.req.CreateOrderReqDTO;
import com.cqu.cs.mall.dto.req.OrderPageReqDTO;
import com.cqu.cs.mall.dto.resp.CreateOrderRespDTO;
import com.cqu.cs.mall.dto.resp.OrderPageRespDTO;
import com.cqu.cs.mall.service.OrderService;
import com.cqu.cs.mall.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final ProductService productService;

    @Override
    public List<CreateOrderRespDTO> createOrder(CreateOrderReqDTO param) {
        List<CreateOrderRespDTO> res = new ArrayList<>();
        for (int productId : param.getProductIdList()) {
            ProductDO productDO = productService.getProductById(productId);
            if (productDO == null) {
                throw new ClientException("商品不存在");
            }
            OrderDO orderDO = OrderDO.builder()
                    .productId(productId)
                    .price(productDO.getPrice())
                    .reviewerId(BaseContext.getCurrentToken())
                    .title(productDO.getTitle())
                    .imUrl(productDO.getImUrl())
                    .status(0)
                    .build();
            orderMapper.createOrder(orderDO);
            CreateOrderRespDTO createOrderRespDTO = CreateOrderRespDTO.builder()
                    .orderId(orderDO.getOrderId())
                    .title(productDO.getTitle())
                    .amount(productDO.getPrice())
                    .imUrl(productDO.getImUrl())
                    .build();
            res.add(createOrderRespDTO);
        }
        return res;
    }

    @Override
    public List<OrderPageRespDTO> pageOrder(OrderPageReqDTO orderPageReqDTO) {
        int pageSize = orderPageReqDTO.getPageSize();
        int pageNum = orderPageReqDTO.getPageNum() > 0 ? orderPageReqDTO.getPageNum() : 1;
        int offset = (pageNum - 1) * pageSize;
        String reviewerId = BaseContext.getCurrentToken();
        return orderMapper.pageQuery(offset, pageSize, reviewerId);
    }

    @Override
    public void createOrderByCart(CartDO cartDO) {
        OrderDO orderDO = OrderDO.builder()
                .reviewerId(cartDO.getReviewerId())
                .productId(cartDO.getProductId())
                .price(cartDO.getPrice())
                .quantity(cartDO.getQuantity())
                .title(cartDO.getTitle())
                .imUrl(cartDO.getImUrl())
                .build();
        orderMapper.createOrder(orderDO);
    }
}
