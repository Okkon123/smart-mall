package com.cqu.cs.mall.service;

import com.cqu.cs.mall.domain.CommentDO;
import com.cqu.cs.mall.dto.req.AddCommentReqDTO;
import com.cqu.cs.mall.dto.req.AllCommentPageReqDTO;
import com.cqu.cs.mall.dto.req.CommentPageReqDTO;
import com.cqu.cs.mall.dto.resp.AllCommentPageRespDTO;
import com.cqu.cs.mall.dto.resp.CommentPageRespDTO;

import java.util.List;

public interface CommentService {
    void addComment(AddCommentReqDTO addCommentReqDTO);

    void deleteComment(Integer commentId);

    List<CommentPageRespDTO> pageComment(CommentPageReqDTO commentPageReqDTO);

    void saveCommentBatch(List<CommentDO> cachedList);

    List<AllCommentPageRespDTO> pageAllComment(AllCommentPageReqDTO allCommentPageReqDTO);
}
