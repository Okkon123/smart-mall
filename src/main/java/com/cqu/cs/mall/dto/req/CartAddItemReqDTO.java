package com.cqu.cs.mall.dto.req;

import lombok.Data;

@Data
public class CartAddItemReqDTO {
    private Integer productId;
    private Integer quantity;
}
