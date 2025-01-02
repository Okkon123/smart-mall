package com.cqu.cs.mall.domain;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class CommentDO {
    /**
     * 主键id
     */
    private int id;
    /**
     * 评论用户id
     */
    private String reviewerId;
    /**
     * 亚马逊标准识别码
     */
    private String asin;
    /**
     * 评论者姓名
     */
    private String reviewerName;
    /**
     * 评论是否有帮助的数组数据
     */
    private String helpful;
    /**
     * 评论文本内容
     */
    private String reviewText;
    /**
     * 评分，1-5
     */
    private int overall;
    /**
     * 总结
     */
    private String summary;
    /**
     * 评论unix时间戳
     */
    private String unixReviewTime;
    /**
     * 评论时间
     */
    private Timestamp reviewTime;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 更新时间
     */
    private Timestamp updateTime;
}
