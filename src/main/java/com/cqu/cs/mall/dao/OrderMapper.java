package com.cqu.cs.mall.dao;

import com.cqu.cs.mall.domain.OrderDO;
import com.cqu.cs.mall.dto.req.CreateOrderReqDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    int createOrder(OrderDO order);
}
