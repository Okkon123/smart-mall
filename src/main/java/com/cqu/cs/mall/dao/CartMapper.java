package com.cqu.cs.mall.dao;

import com.cqu.cs.mall.domain.CartDO;
import com.cqu.cs.mall.dto.resp.CartPageRespDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    int insert(CartDO cartDO);

    List<CartPageRespDTO> pageQuery(int offset, int pageSize, String reviewerId);

    int deleteById(Integer cartId);

    CartDO selectById(Integer cartId);
}

