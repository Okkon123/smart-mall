package com.cqu.cs.mall.controller;

import com.cqu.cs.mall.dto.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    @GetMapping("/create")
    public Result<Void> createOrder() {
        return null;
    }

    @GetMapping("/list")
    public Result<Void> listOrder() {
        return null;
    }


}
