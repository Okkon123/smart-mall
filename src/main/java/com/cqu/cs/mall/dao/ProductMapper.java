package com.cqu.cs.mall.dao;

import com.cqu.cs.mall.domain.ProductDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    int insert(ProductDO productDO);

    int deleteById(int productId);
}
