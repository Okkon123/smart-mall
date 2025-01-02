package com.cqu.cs.mall.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.cqu.cs.mall.dao.ProductMapper;
import com.cqu.cs.mall.domain.ProductDO;
import com.cqu.cs.mall.dto.req.AddProductReqDTO;
import com.cqu.cs.mall.dto.req.DeleteProductReqDTO;
import com.cqu.cs.mall.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    @Override
    public void addProduct(AddProductReqDTO addProductReqDTO) {
        ProductDO productDO = BeanUtil.copyProperties(addProductReqDTO, ProductDO.class);
        productDO.setAsin(UUID.randomUUID().toString().replace("-", ""));
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
}
