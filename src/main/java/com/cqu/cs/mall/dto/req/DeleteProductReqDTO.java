package com.cqu.cs.mall.dto.req;

import lombok.Data;

import java.util.List;

@Data
public class DeleteProductReqDTO {
    List<Integer> productIdList;
}
