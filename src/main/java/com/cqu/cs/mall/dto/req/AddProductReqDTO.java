package com.cqu.cs.mall.dto.req;

import lombok.Data;

@Data
public class AddProductReqDTO {
    private String productName;
    private String description;
    private int price;
    private int categoryId;
    private String imageUrl;
}
