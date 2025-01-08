package com.cqu.cs.mall.domain;

import lombok.*;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CartDO {
    /**
     * 购物车id 主键
     */
    private Integer cartId;
    /**
     * 用户id
     */
    private String reviewerId;
    /**
     * 亚马逊码
     */
    private String asin;
    /**
     * 商品id
     */
    private Integer productId;
    /**
     * 商品价格
     */
    private Integer price;
    /**
     * 商品数量
     */
    private Integer quantity;
    /**
     * 商品名称
     */
    private String title;
    /**
     * 商品图片链接
     */
    private String imUrl;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 更新时间
     */
    private Timestamp updateTime;
}
