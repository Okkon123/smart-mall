package com.cqu.cs.mall.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.cqu.cs.mall.context.BaseContext;
import com.cqu.cs.mall.convention.exception.ClientException;
import com.cqu.cs.mall.dao.OrderMapper;
import com.cqu.cs.mall.domain.OrderDO;
import com.cqu.cs.mall.domain.ProductDO;
import com.cqu.cs.mall.dto.req.CreateOrderReqDTO;
import com.cqu.cs.mall.dto.resp.CreateOrderRespDTO;
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
                    .amount(productDO.getPrice())
                    .reviewerId(BaseContext.getCurrentToken())
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
}
