package com.cqu.cs.mall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult {
    /**
     * 总记录数
     */
    private long total;
    /**
     * 当前页数据集合
     */
    private List records;
}
