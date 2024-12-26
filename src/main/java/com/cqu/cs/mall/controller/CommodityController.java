package com.cqu.cs.mall.controller;

import com.cqu.cs.mall.dto.Result;
import com.cqu.cs.mall.dto.req.CommodityReqDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommodityController {

    @PostMapping
    public Result<Void> addCommodity(@RequestBody CommodityReqDTO commodityReqDTO) {
        return null;
    }

    @GetMapping
    public Result<Void> deleteCommodity() {
        return null;
    }

    @GetMapping
    public Result<Void> listCommodity() {
        return null;
    }

}
