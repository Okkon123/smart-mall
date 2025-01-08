package com.cqu.cs.mall.dto.resp;

import lombok.Data;

@Data
public class OrderPageRespDTO {
    private Integer orderId;
    private Integer price;
    private Integer quantity;
    private String title;
    private Integer productId;
    private String imUrl;
}
