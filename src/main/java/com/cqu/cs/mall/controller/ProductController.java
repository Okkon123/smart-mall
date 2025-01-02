package com.cqu.cs.mall.controller;

import com.cqu.cs.mall.dto.Result;
import com.cqu.cs.mall.dto.req.AddProductReqDTO;
import com.cqu.cs.mall.dto.req.DeleteProductReqDTO;
import com.cqu.cs.mall.dto.req.ProductPageReqDTO;
import com.cqu.cs.mall.dto.resp.ProductPageRespDTO;
import com.cqu.cs.mall.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping("/add")
    public Result<Void> addProduct(@RequestBody AddProductReqDTO addProductReqDTO) {
        productService.addProduct(addProductReqDTO);
        return Result.success();
    }

    @PostMapping("delete")
    public Result<Void> deleteProducts(@RequestBody DeleteProductReqDTO deleteProductReqDTO) {
        productService.deleteProducts(deleteProductReqDTO);
        return Result.success();
    }

    @GetMapping("page")
    public Result<List<ProductPageRespDTO>> pageProduct(ProductPageReqDTO productPageReqDTO) {
        return Result.success(productService.pageQuery(productPageReqDTO));
    }

}
