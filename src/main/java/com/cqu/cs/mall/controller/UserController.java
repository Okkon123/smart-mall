package com.cqu.cs.mall.controller;

import com.cqu.cs.mall.dto.Result;
import com.cqu.cs.mall.dto.req.UserLoginReqDTO;
import com.cqu.cs.mall.dto.req.UserRegisterReqDTO;
import com.cqu.cs.mall.dto.req.UserUpdateReqDTO;
import com.cqu.cs.mall.dto.resp.UserLoginRespDTO;
import com.cqu.cs.mall.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public Result<UserLoginRespDTO> login(@RequestBody UserLoginReqDTO userLoginReqDTO) {
        return Result.success(userService.login(userLoginReqDTO));
    }

    @PostMapping("/register")
    public Result<String> register(@RequestBody UserRegisterReqDTO userRegisterReqDTO) {
        userService.register(userRegisterReqDTO);
        return Result.success("register success");
    }

    @GetMapping("/logout")
    public Result<String> logout() {
        return Result.success("logout success");
    }

    @PostMapping("/update")
    public Result<Void> update(@RequestBody UserUpdateReqDTO userUpdateReqDTO) {
        userService.update(userUpdateReqDTO);
        return Result.success();
    }
}
