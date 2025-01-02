package com.cqu.cs.mall.dto.req;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class AddProductReqDTO {
    private String description;     // 描述
    private String title;           // 标题
    private int price;              // 价格
    private String imUrl;           // 图片链接
    private String brand;           // 品牌
}
