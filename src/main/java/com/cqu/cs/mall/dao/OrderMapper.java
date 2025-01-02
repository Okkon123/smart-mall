package com.cqu.cs.mall.dao;

import com.cqu.cs.mall.domain.OrderDO;
import com.cqu.cs.mall.dto.req.CreateOrderReqDTO;
import com.cqu.cs.mall.dto.resp.OrderPageRespDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    int createOrder(OrderDO order);

    List<OrderPageRespDTO> pageQuery(int offset, int pageSize, String reviewerId);
}
