package com.cqu.cs.mall.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDO {
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 用户id
     */
    private String reviewerId;
    /**
     * 产品id
     */
    private Integer productId;
    /**
     * 商品单价
     */
    private Integer price;
    /**
     * 商品数量
     */
    private Integer quantity;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 产品名称
     */
    private String title;
    /**
     * 产品图片
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
