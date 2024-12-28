package com.cqu.cs.mall.dto.req;

import lombok.Data;

@Data
public class UserLoginReqDTO {
    private String phone;
    private String password;
}
