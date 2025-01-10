package com.cqu.cs.mall.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class AllCommentPageRespDTO {
    private String reviewText;
    private Integer overall;
    private Timestamp reviewTime;
    private String reviewerId;
    private String title;
    private String imUrl;
    private String asin;
}
