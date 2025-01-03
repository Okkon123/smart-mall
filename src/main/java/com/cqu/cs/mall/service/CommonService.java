package com.cqu.cs.mall.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CommonService {
    void importProductByExcel(MultipartFile file) throws IOException;

    void importUserByExcel(MultipartFile file) throws IOException;

    void importCommentByExcel(MultipartFile file) throws IOException;
}
