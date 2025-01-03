package com.cqu.cs.mall.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductDO {
    /**
     * 商品id，主键
     */
    private int productId;
    /**
     * 亚马逊标准识别码
     */
    @ExcelProperty("asin")
    private String asin;
    /**
     * 种类
     */
    @ExcelProperty("categories")
    private String categories;
    /**
     * 描述
     */
    @ExcelProperty("description")
    private String description;
    /**
     * 标题
     */
    @ExcelProperty("title")
    private String title;
    /**
     * 价格
     */
    @ExcelProperty("price")
    private int price;
    /**
     * 图片链接
     */
    @ExcelProperty("imUrl")
    private String imUrl;
    /**
     * 品牌
     */
    @ExcelProperty("brand")
    private String brand;
    /**
     * 相关商品
     */
    @ExcelProperty("related")
    private String related;
    /**
     *
     */
    @ExcelProperty("salesRank")
    private String salesRank;
    /**
     *
     */
    @ExcelProperty("itemId")
    private int itemId;
    /**
     *
     */
    private Timestamp createTime;
    /**
     *
     */
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
