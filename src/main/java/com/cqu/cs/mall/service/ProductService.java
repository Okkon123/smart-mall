package com.cqu.cs.mall.service;

import com.cqu.cs.mall.domain.ProductDO;
import com.cqu.cs.mall.dto.req.AddProductReqDTO;
import com.cqu.cs.mall.dto.req.DeleteProductReqDTO;
import com.cqu.cs.mall.dto.req.ProductInfoReqDTO;
import com.cqu.cs.mall.dto.req.ProductPageReqDTO;
import com.cqu.cs.mall.dto.resp.ProductBrandTypeRespDTO;
import com.cqu.cs.mall.dto.resp.ProductInfoRespDTO;
import com.cqu.cs.mall.dto.resp.ProductPageRespDTO;

import java.util.List;

public interface ProductService {
    void addProduct(AddProductReqDTO addProductReqDTO);

    void deleteProducts(DeleteProductReqDTO deleteProductReqDTO);

    ProductDO getProductById(int productId);

    List<ProductPageRespDTO> pageQuery(ProductPageReqDTO productPageReqDTO);

    void saveProductBatch(List<ProductDO> cachedList);

    ProductBrandTypeRespDTO getAllProductBrandType();

    List<ProductInfoRespDTO> getProductInfoById(ProductInfoReqDTO productInfoReqDTO);

    List<ProductInfoRespDTO> getProductInfoByAsin(ProductInfoReqDTO productInfoReqDTO);
}
