package com.cqu.cs.mall.service.impl;

import com.cqu.cs.mall.context.BaseContext;
import com.cqu.cs.mall.convention.exception.ClientException;
import com.cqu.cs.mall.dao.CommentMapper;
import com.cqu.cs.mall.dao.ProductMapper;
import com.cqu.cs.mall.dao.UserMapper;
import com.cqu.cs.mall.domain.CommentDO;
import com.cqu.cs.mall.domain.ProductDO;
import com.cqu.cs.mall.domain.UserDO;
import com.cqu.cs.mall.dto.req.AddCommentReqDTO;
import com.cqu.cs.mall.dto.req.CommentPageReqDTO;
import com.cqu.cs.mall.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;
    private final ProductMapper productMapper;
    private final UserMapper userMapper;

    @Override
    public void addComment(AddCommentReqDTO addCommentReqDTO) {
        ProductDO productDO = productMapper.selectById(addCommentReqDTO.getProductId());
        if (productDO == null) {
            throw new ClientException("商品不存在");
        }
        // todo 优化
        UserDO userDO = userMapper.selectByReviewerId(BaseContext.getCurrentToken());
        CommentDO commentDO = CommentDO.builder()
                .asin(productDO.getAsin())
                .reviewerName(userDO.getReviewerName())
                .reviewerId(BaseContext.getCurrentToken())
                .reviewText(addCommentReqDTO.getReviewText())
                .overall(addCommentReqDTO.getOverall())
                .build();
        commentMapper.insert(commentDO);
    }

    @Override
    public void deleteComment(Integer commentId) {
        commentMapper.deleteById(commentId);
    }

    @Override
    public List<String> pageComment(CommentPageReqDTO commentPageReqDTO) {
        int pageSize = commentPageReqDTO.getPageSize();
        int pageNum = commentPageReqDTO.getPageNum() > 0 ? commentPageReqDTO.getPageNum() : 1;
        int offset = (pageNum - 1) * pageSize;
        return commentMapper.pageQuery(offset, pageSize, commentPageReqDTO.getAsin());
    }
}
