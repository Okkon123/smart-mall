package com.cqu.cs.mall.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDO {
    private int productId;
    private String productName;
    private String description;
    private int price;
    private int categoryId;
    private String imageUrl;
    private Timestamp createTime;
    private Timestamp updateTime;
}
