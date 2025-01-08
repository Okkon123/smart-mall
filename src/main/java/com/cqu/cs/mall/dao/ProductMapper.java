package com.cqu.cs.mall.dao;

import com.cqu.cs.mall.domain.ProductDO;
import com.cqu.cs.mall.dto.resp.ProductBrandTypeRespDTO;
import com.cqu.cs.mall.dto.resp.ProductPageRespDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    int insert(ProductDO productDO);

    int deleteById(int productId);

    ProductDO selectById(int productId);

    List<ProductPageRespDTO> pageQuery(Integer offset, Integer pageSize, Integer lowBound, Integer highBound, String title, String brand);

    List<String> getAllProductBrandType();

    ProductDO selectByAsin(String asin);
}
