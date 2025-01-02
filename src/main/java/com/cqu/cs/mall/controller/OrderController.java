package com.cqu.cs.mall.controller;

import com.cqu.cs.mall.dto.Result;
import com.cqu.cs.mall.dto.req.CreateOrderReqDTO;
import com.cqu.cs.mall.dto.req.OrderPageReqDTO;
import com.cqu.cs.mall.dto.resp.CreateOrderRespDTO;
import com.cqu.cs.mall.dto.resp.OrderPageRespDTO;
import com.cqu.cs.mall.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public Result<List<CreateOrderRespDTO>> createOrder(@RequestBody CreateOrderReqDTO param) {
        return Result.success(orderService.createOrder(param));
    }

    @GetMapping("/page")
    public Result<List<OrderPageRespDTO>> pageOrder(OrderPageReqDTO orderPageReqDTO) {
        return Result.success(orderService.pageOrder(orderPageReqDTO));
    }


}
