package com.cqu.cs.mall.service;

import com.cqu.cs.mall.dto.req.CartAddItemReqDTO;
import com.cqu.cs.mall.dto.req.CartCheckoutReqDTO;
import com.cqu.cs.mall.dto.req.CartPageReqDTO;
import com.cqu.cs.mall.dto.resp.CartPageRespDTO;

import java.util.List;

public interface CartService {
    int addItem(CartAddItemReqDTO cartAddItemReqDTO);

    List<CartPageRespDTO> pageCart(CartPageReqDTO cartPageReqDTO);

    int deleteItem(Integer cartId);

    void checkout(CartCheckoutReqDTO cartCheckoutReqDTO);
}
