package com.cqu.cs.mall.dto.resp;

import lombok.Data;

@Data
public class UserInfoRespDTO {
    private String reviewerId;
    private String reviewerName;
    private String phone;
    private String email;
    private String address;
    private String avatar;
    private String gender;
    private Integer age;
}
