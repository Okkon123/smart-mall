package com.cqu.cs.mall.controller;

import com.cqu.cs.mall.dto.Result;
import com.cqu.cs.mall.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @PostMapping("/addItem")
    public Result<Void> addCartItem() {
        return Result.success();
    }

    @GetMapping("/pageCart")
    public Result<Void> pageCart() {
        return Result.success();
    }

    @GetMapping("/deleteItem")
    public Result<Void> deleteCartItem() {
        return Result.success();
    }
}
