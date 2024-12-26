package com.cqu.cs.mall.dto.req;

import lombok.Data;

@Data
public class UserUpdateReqDTO {
    private String accountId;
    private String username;
    private String password;
    private String email;
}
