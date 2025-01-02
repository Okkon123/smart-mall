package com.cqu.cs.mall.dto.req;

import lombok.Data;

@Data
public class UserUpdateReqDTO {
    private String reviewerName;
    private String password;
    private String email;
}
