package com.cqu.cs.mall.dto.resp;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserLoginRespDTO {
    private String token;
}
