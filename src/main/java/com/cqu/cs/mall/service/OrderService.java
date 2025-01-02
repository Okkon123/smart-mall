package com.cqu.cs.mall.service;

import com.cqu.cs.mall.dto.req.CreateOrderReqDTO;
import com.cqu.cs.mall.dto.req.OrderPageReqDTO;
import com.cqu.cs.mall.dto.resp.CreateOrderRespDTO;
import com.cqu.cs.mall.dto.resp.OrderPageRespDTO;

import java.util.List;

public interface OrderService {
    List<CreateOrderRespDTO> createOrder(CreateOrderReqDTO param);

    List<OrderPageRespDTO> pageOrder(OrderPageReqDTO orderPageReqDTO);
}
