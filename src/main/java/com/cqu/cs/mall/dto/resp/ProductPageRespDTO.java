package com.cqu.cs.mall.dto.resp;

import lombok.Data;

@Data
public class ProductPageRespDTO {
    private Integer productId;
    private String asin;
    private String title;
    private Integer price;
    private String brand;
    private String imUrl;
}
