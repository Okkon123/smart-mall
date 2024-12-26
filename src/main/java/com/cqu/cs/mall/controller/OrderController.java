package com.cqu.cs.mall.controller;

import com.cqu.cs.mall.dto.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping
    public Result<Void> createOrder() {
        return null;
    }

    @GetMapping
    public Result<Void> listOrder() {
        return null;
    }


}
