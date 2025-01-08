package com.cqu.cs.mall.controller;

import com.cqu.cs.mall.dto.Result;
import com.cqu.cs.mall.service.CommonService;
import com.cqu.cs.mall.util.AliOssUtil;
import com.google.common.base.Throwables;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;
@Slf4j
@RestController
@RequestMapping("/common")
@RequiredArgsConstructor
public class CommonController {
    private final AliOssUtil aliOssUtil;
    private final CommonService commonService;

    @PostMapping("/upload")
    @CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
    public Result<String> upload(MultipartFile file) {
        log.info("文件上传：{}", file);
        try {
            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String objectName = UUID.randomUUID().toString() + extension;
            String filePath = aliOssUtil.upload(file.getBytes(), objectName);
            return Result.success(filePath);
        } catch (IOException e) {
            log.error("文件上传失败：{}", Throwables.getStackTraceAsString(e));
        }
        return Result.fail("上传失败");
    }

    @PostMapping("/importUserByExcel")
    @CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
    public Result<Void> importUserByExcel(MultipartFile file) throws IOException {
        commonService.importUserByExcel(file);
        return Result.success();
    }

    @PostMapping("/importCommentByExcel")
    @CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
    public Result<Void> importCommentByExcel(MultipartFile file) throws IOException {
        commonService.importCommentByExcel(file);
        return Result.success();
    }

    @PostMapping("/importProductByExcel")
    @CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
    public Result<Void> importProductByExcel(MultipartFile file) throws IOException {
        commonService.importProductByExcel(file);
        return Result.success();
    }
}
