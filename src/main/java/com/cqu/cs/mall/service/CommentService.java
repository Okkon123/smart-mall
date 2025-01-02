package com.cqu.cs.mall.service;

import com.cqu.cs.mall.dto.req.AddCommentReqDTO;

public interface CommentService {
    void addComment(AddCommentReqDTO addCommentReqDTO);

    void deleteComment(Integer commentId);
}
