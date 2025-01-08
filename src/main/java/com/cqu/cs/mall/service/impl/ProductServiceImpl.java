package com.cqu.cs.mall.service.impl;

import cn.hutool.core.bean.BeanUtil;


import com.cqu.cs.mall.dao.ProductMapper;
import com.cqu.cs.mall.domain.ProductDO;
import com.cqu.cs.mall.dto.req.AddProductReqDTO;
import com.cqu.cs.mall.dto.req.DeleteProductReqDTO;
import com.cqu.cs.mall.dto.req.ProductInfoReqDTO;
import com.cqu.cs.mall.dto.req.ProductPageReqDTO;
import com.cqu.cs.mall.dto.resp.ProductBrandTypeRespDTO;
import com.cqu.cs.mall.dto.resp.ProductInfoRespDTO;
import com.cqu.cs.mall.dto.resp.ProductPageRespDTO;
import com.cqu.cs.mall.service.ProductService;
import com.cqu.cs.mall.util.Snowflake;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    @Override
    public void addProduct(AddProductReqDTO addProductReqDTO) {
        ProductDO productDO = BeanUtil.copyProperties(addProductReqDTO, ProductDO.class);
        productDO.setAsin(Snowflake.getID());
        productMapper.insert(productDO);
    }

    @Override
    public void deleteProducts(DeleteProductReqDTO deleteProductReqDTO) {
        for (int productId : deleteProductReqDTO.getProductIdList()) {
            productMapper.deleteById(productId);
        }
    }

    @Override
    public ProductDO getProductById(int productId) {
        return productMapper.selectById(productId);
    }

    @Override
    public List<ProductPageRespDTO> pageQuery(ProductPageReqDTO productPageReqDTO) {
        int pageSize = productPageReqDTO.getPageSize();
        int pageNum = productPageReqDTO.getPageNum() > 0 ? productPageReqDTO.getPageNum() : 1;
        int offset = (pageNum - 1) * pageSize;
        return productMapper.pageQuery(offset,
                pageSize,
                productPageReqDTO.getLowBound(),
                productPageReqDTO.getHighBound(),
                productPageReqDTO.getTitle(),
                productPageReqDTO.getBrand());
    }

    @Override
    public void saveProductBatch(List<ProductDO> cachedList) {
        for (ProductDO product : cachedList) {
            productMapper.insert(product);
        }
    }

    @Override
    public ProductBrandTypeRespDTO getAllProductBrandType() {
        List<String> list =  productMapper.getAllProductBrandType();
        ProductBrandTypeRespDTO res = new ProductBrandTypeRespDTO();
        res.setBrandTypeList(list);
        return res;
    }

    @Override
    public List<ProductInfoRespDTO> getProductInfoById(ProductInfoReqDTO productInfoReqDTO) {
        List<ProductInfoRespDTO> list = new ArrayList<>();
        for (Integer productId : productInfoReqDTO.getProductIdList()) {
            ProductDO product = productMapper.selectById(productId);
            list.add(BeanUtil.copyProperties(product, ProductInfoRespDTO.class));
        }
        return list;
    }

    @Override
    public List<ProductInfoRespDTO> getProductInfoByAsin(ProductInfoReqDTO productInfoReqDTO) {
        List<ProductInfoRespDTO> list = new ArrayList<>();
        for (String asin : productInfoReqDTO.getAsinList()) {
            ProductDO product = productMapper.selectByAsin(asin);
            list.add(BeanUtil.copyProperties(product, ProductInfoRespDTO.class));
        }
        return list;
    }


}
