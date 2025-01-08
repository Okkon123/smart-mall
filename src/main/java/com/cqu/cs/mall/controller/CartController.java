package com.cqu.cs.mall.controller;

import com.cqu.cs.mall.dto.Result;
import com.cqu.cs.mall.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @PostMapping("/addItem")
    @CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
    public Result<Void> addCartItem() {
        return Result.success();
    }

    @GetMapping("/pageCart")
    @CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
    public Result<Void> pageCart() {
        return Result.success();
    }

    @GetMapping("/deleteItem")
    @CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
    public Result<Void> deleteCartItem() {
        return Result.success();
    }
}
