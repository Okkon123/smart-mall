package com.cqu.cs.mall.service;

import com.cqu.cs.mall.dto.req.CreateOrderReqDTO;
import com.cqu.cs.mall.dto.resp.CreateOrderRespDTO;

import java.util.List;

public interface OrderService {
    List<CreateOrderRespDTO> createOrder(CreateOrderReqDTO param);
}
