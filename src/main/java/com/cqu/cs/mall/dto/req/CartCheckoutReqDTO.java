package com.cqu.cs.mall.dto.req;

import lombok.Data;
import java.util.List;

@Data
public class CartCheckoutReqDTO {
    private List<Integer> cartIdList;
}
