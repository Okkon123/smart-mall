package com.cqu.cs.mall.dao;

import com.cqu.cs.mall.domain.CommentDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    int insert(CommentDO commentDO);

    int deleteById(Integer commentId);

    List<String> pageQuery(int offset, int pageSize, String asin);

    int importComment(CommentDO comment);
}
