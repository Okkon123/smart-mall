package com.cqu.cs.mall.controller;

import com.cqu.cs.mall.dto.Result;
import com.cqu.cs.mall.dto.req.CartAddItemReqDTO;
import com.cqu.cs.mall.dto.req.CartCheckoutReqDTO;
import com.cqu.cs.mall.dto.req.CartPageReqDTO;
import com.cqu.cs.mall.dto.resp.CartPageRespDTO;
import com.cqu.cs.mall.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @GetMapping("/addItem")
    @CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
    public Result<Void> addCartItem(CartAddItemReqDTO cartAddItemReqDTO) {
        cartService.addItem(cartAddItemReqDTO);
        return Result.success();
    }

    @GetMapping("/page")
    @CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
    public Result<List<CartPageRespDTO>> pageCart(CartPageReqDTO cartPageReqDTO) {
        return Result.success(cartService.pageCart(cartPageReqDTO));
    }

    @GetMapping("/delete")
    @CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
    public Result<Void> deleteCartItem(Integer cartId) {
        cartService.deleteItem(cartId);
        return Result.success();
    }
    @PostMapping("/checkout")
    public Result<Void> cartCheckout(@RequestBody CartCheckoutReqDTO cartCheckoutReqDTO) {
        cartService.checkout(cartCheckoutReqDTO);
        return Result.success();
    }
}
