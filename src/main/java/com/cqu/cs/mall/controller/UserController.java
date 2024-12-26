package com.cqu.cs.mall.controller;

import com.cqu.cs.mall.dto.Result;
import com.cqu.cs.mall.dto.req.UserLoginReqDTO;
import com.cqu.cs.mall.dto.req.UserRegisterReqDTO;
import com.cqu.cs.mall.dto.req.UserUpdateReqDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/login")
    public Result<Void> login(@RequestBody UserLoginReqDTO userLoginReqDTO) {
        return Result.success();
    }

    @PostMapping("/register")
    public Result<Void> register(@RequestBody UserRegisterReqDTO userRegisterReqDTO) {
        return Result.success();
    }

    @GetMapping("/logout")
    public Result<Void> logout() {
        return Result.success();
    }

    @PostMapping("/update")
    public Result<Void> update(@RequestBody UserUpdateReqDTO userUpdateReqDTO) {
        return Result.success();
    }
}
