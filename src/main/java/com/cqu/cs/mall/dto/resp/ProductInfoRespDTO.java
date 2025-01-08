package com.cqu.cs.mall.dto.resp;

import lombok.Data;

@Data
public class ProductInfoRespDTO {
    private String categories;
    private String description;
    private String title;
    private Integer price;
    private String imUrl;
}
