package com.cqu.cs.mall.dto.resp;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentPageRespDTO {
    private String reviewTest;
    private Integer overall;
    private Timestamp reviewTime;
    private String reviewerId;
}
