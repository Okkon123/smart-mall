package com.cqu.cs.mall.controller;

import com.cqu.cs.mall.dto.Result;
import com.cqu.cs.mall.dto.req.UserLoginReqDTO;
import com.cqu.cs.mall.dto.req.UserRegisterReqDTO;
import com.cqu.cs.mall.dto.req.UserUpdateReqDTO;
import com.cqu.cs.mall.dto.resp.UserInfoRespDTO;
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
    @CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
    public Result<UserLoginRespDTO> login(@RequestBody UserLoginReqDTO userLoginReqDTO) {
        return Result.success(userService.login(userLoginReqDTO));
    }

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
    public Result<String> register(@RequestBody UserRegisterReqDTO userRegisterReqDTO) {
        userService.register(userRegisterReqDTO);
        return Result.success("register success");
    }

    @GetMapping("/logout")
    @CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
    public Result<String> logout() {
        return Result.success("logout success");
    }

    @PostMapping("/update")
    @CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
    public Result<Void> update(@RequestBody UserUpdateReqDTO userUpdateReqDTO) {
        userService.update(userUpdateReqDTO);
        return Result.success();
    }

    @GetMapping("/info")
    @CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
    public Result<UserInfoRespDTO> info() {
        return Result.success(userService.info());
    }
}
