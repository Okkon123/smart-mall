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
    private int orderId;
    /**
     * 用户id
     */
    private String reviewerId;
    /**
     * 产品id
     */
    private int productId;
    /**
     * 订单总额
     */
    private int amount;
    /**
     * 订单状态
     */
    private int status;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 更新时间
     */
    private Timestamp updateTime;
}
