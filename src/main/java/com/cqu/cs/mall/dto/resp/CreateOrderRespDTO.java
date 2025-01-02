package com.cqu.cs.mall.dto.resp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateOrderRespDTO {
    /**
     * 订单id
     */
    private int orderId;
    /**
     * 总金额
     */
    private Integer amount;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 图片url
     */
    private String imUrl;
}
