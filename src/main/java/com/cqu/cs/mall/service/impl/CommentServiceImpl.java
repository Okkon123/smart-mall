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
import com.cqu.cs.mall.dto.req.AllCommentPageReqDTO;
import com.cqu.cs.mall.dto.req.CommentPageReqDTO;
import com.cqu.cs.mall.dto.resp.AllCommentPageRespDTO;
import com.cqu.cs.mall.dto.resp.CommentPageRespDTO;
import com.cqu.cs.mall.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
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
    public List<CommentPageRespDTO> pageComment(CommentPageReqDTO commentPageReqDTO) {
        int pageSize = commentPageReqDTO.getPageSize();
        int pageNum = commentPageReqDTO.getPageNum() > 0 ? commentPageReqDTO.getPageNum() : 1;
        int offset = (pageNum - 1) * pageSize;
        return commentMapper.pageQuery(offset, pageSize, commentPageReqDTO.getAsin());
    }

    @Override
    public void saveCommentBatch(List<CommentDO> cachedList) {
        for (CommentDO comment : cachedList) {
            commentMapper.importComment(comment);
        }
    }

    @Override
    public List<AllCommentPageRespDTO> pageAllComment(AllCommentPageReqDTO allCommentPageReqDTO) {
        List<AllCommentPageRespDTO> res = new ArrayList<>();
        int pageSize = allCommentPageReqDTO.getPageSize();
        int pageNum = allCommentPageReqDTO.getPageNum() > 0 ? allCommentPageReqDTO.getPageNum() : 1;
        int offset = (pageNum - 1) * pageSize;
        List<CommentDO> commentDOList = commentMapper.pageQueryAllComment(offset, pageSize, BaseContext.getCurrentToken());
        for (CommentDO comment : commentDOList) {
            ProductDO productDO = productMapper.selectByAsin(comment.getAsin());
            AllCommentPageRespDTO allCommentPageRespDTO = AllCommentPageRespDTO.builder()
                    .title(productDO.getTitle() == null ? "伸腿瞪眼丸" : productDO.getTitle())
                    .imUrl(productDO.getImUrl() == null ? "https://image.baidu.com/search/detail?ct=503316480&z=&tn=baiduimagedetail&ipn=d&word=%E4%BC%B8%E8%85%BF%E7%9E%AA%E7%9C%BC%E4%B8%B8&step_word=&lid=10571688174997315500&ie=utf-8&in=&cl=2&lm=-1&st=-1&hd=&latest=&copyright=&cs=740394099,3840205120&os=3300541923,3193345153&simid=3499101852,218219595&pn=9&rn=1&di=7448669010159206401&ln=212&fr=&fmq=1736480941033_R&ic=&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&is=0,0&istype=2&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=1e&objurl=https%3A%2F%2Fpic.rmb.bdstatic.com%2Fbjh%2F0d2887c912a7b99caf2fd1e866a174b4.jpeg%40h_1280&rpstart=0&rpnum=0&adpicid=0&nojc=undefined&dyTabStr=MCwxMiwzLDEsMiwxMyw3LDYsNSw5" : productDO.getImUrl())
                    .asin(comment.getAsin())
                    .reviewText(comment.getReviewText())
                    .overall(comment.getOverall())
                    .reviewTime(Timestamp.valueOf(comment.getReviewTime()))
                    .overall(comment.getOverall())
                    .build();
            res.add(allCommentPageRespDTO);
        }
        return res;
    }
}
