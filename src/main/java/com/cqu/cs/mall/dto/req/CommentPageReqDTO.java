package com.cqu.cs.mall.dto.req;

import lombok.Data;

@Data
public class CommentPageReqDTO {
    private Integer pageNum;
    private Integer pageSize;
    private String asin;
}
