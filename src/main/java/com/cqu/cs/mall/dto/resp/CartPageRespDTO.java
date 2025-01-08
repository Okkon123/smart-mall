package com.cqu.cs.mall.dto.resp;

import lombok.Data;

@Data
public class CartPageRespDTO {
    private Integer cartId;
    private Integer productId;
    private String asin;
    private String title;
    private String imUrl;
    private Integer price;
    private Integer quantity;
}
