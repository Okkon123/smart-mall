package com.cqu.cs.mall.dto.req;

import lombok.Data;

import java.util.List;

@Data
public class ProductInfoReqDTO {
    private List<Integer> productIdList;
    private List<String> asinList;
}
