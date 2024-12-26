package com.cqu.cs.mall.dto.req;

import lombok.Data;

@Data
public class UserRegisterReqDTO {
    private String account;
    private String username;
    private String password;
    private String email;
}
