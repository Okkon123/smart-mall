package com.cqu.cs.mall.dto.req;

import lombok.Data;

@Data
public class AddCommentReqDTO {
    /**
     * 商品ID
     */
    private int productId;
    /**
     * 评论内容
     */
    private String reviewText;
    /**
     * 评分
     */
    private Integer overall;
}
