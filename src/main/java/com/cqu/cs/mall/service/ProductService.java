package com.cqu.cs.mall.service;

import com.cqu.cs.mall.domain.ProductDO;
import com.cqu.cs.mall.dto.PageResult;
import com.cqu.cs.mall.dto.req.AddProductReqDTO;
import com.cqu.cs.mall.dto.req.DeleteProductReqDTO;
import com.cqu.cs.mall.dto.req.ProductPageReqDTO;
import com.cqu.cs.mall.dto.resp.ProductPageRespDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductService {
    void addProduct(AddProductReqDTO addProductReqDTO);

    void deleteProducts(DeleteProductReqDTO deleteProductReqDTO);

    ProductDO getProductById(int productId);

    List<ProductPageRespDTO> pageQuery(ProductPageReqDTO productPageReqDTO);
}
