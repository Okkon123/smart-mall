package com.cqu.cs.mall.dao;

import com.cqu.cs.mall.domain.CommentDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    int insert(CommentDO commentDO);

    int deleteById(Integer commentId);
}
