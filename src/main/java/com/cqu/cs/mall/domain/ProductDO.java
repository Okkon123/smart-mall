package com.cqu.cs.mall.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDO {
    private int productId;          // 商品id，主键
    private String asin;            // 亚马逊标准识别码
    private String categories;      // 种类
    private String description;     // 描述
    private String title;           // 标题
    private int price;              // 价格
    private String imUrl;           // 图片链接
    private String brand;           // 品牌
    private String related;         // 相关商品
    private String salesRank;
    private int itemId;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Override
    public String toString() {
        return "ProductDO{" +
                "productId=" + productId +
                ", asin='" + asin + '\'' +
                ", categories='" + categories + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", imUrl='" + imUrl + '\'' +
                ", brand='" + brand + '\'' +
                ", related='" + related + '\'' +
                ", salesRank='" + salesRank + '\'' +
                ", itemId=" + itemId +
                '}';
    }
}
