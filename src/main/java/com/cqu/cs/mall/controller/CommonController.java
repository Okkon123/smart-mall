package com.cqu.cs.mall.controller;

import com.cqu.cs.mall.dto.Result;
import com.cqu.cs.mall.util.AliOssUtil;
import com.google.common.base.Throwables;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping("/upload")
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
    public Result<Void> importUserByExcel(MultipartFile file) {
        return Result.success();
    }

    @PostMapping("/importCommentByExcel")
    public Result<Void> importCommentByExcel(MultipartFile file) {
        return Result.success();
    }

    @PostMapping("/importProductByExcel")
    public Result<Void> importProductByExcel(MultipartFile file) {
        return Result.success();
    }
}
