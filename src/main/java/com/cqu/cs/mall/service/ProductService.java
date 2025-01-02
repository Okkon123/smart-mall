package com.cqu.cs.mall.service;

import com.cqu.cs.mall.domain.ProductDO;
import com.cqu.cs.mall.dto.req.AddProductReqDTO;
import com.cqu.cs.mall.dto.req.DeleteProductReqDTO;

public interface ProductService {
    void addProduct(AddProductReqDTO addProductReqDTO);

    void deleteProducts(DeleteProductReqDTO deleteProductReqDTO);

    ProductDO getProductById(int productId);
}
