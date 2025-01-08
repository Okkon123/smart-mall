package com.cqu.cs.mall.dto.req;

import lombok.Data;

@Data
public class ProductPageReqDTO {
    private Integer pageNum;
    private Integer pageSize;
    private String title;
    private String brand;
    private Integer lowBound;
    private Integer highBound;
}
