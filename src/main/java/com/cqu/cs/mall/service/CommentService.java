package com.cqu.cs.mall.service;

import com.cqu.cs.mall.domain.CommentDO;
import com.cqu.cs.mall.dto.req.AddCommentReqDTO;
import com.cqu.cs.mall.dto.req.CommentPageReqDTO;

import java.util.List;

public interface CommentService {
    void addComment(AddCommentReqDTO addCommentReqDTO);

    void deleteComment(Integer commentId);

    List<String> pageComment(CommentPageReqDTO commentPageReqDTO);

    void saveCommentBatch(List<CommentDO> cachedList);
}
