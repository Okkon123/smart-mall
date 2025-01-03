package com.cqu.cs.mall.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.cqu.cs.mall.domain.CommentDO;
import com.cqu.cs.mall.domain.ProductDO;
import com.cqu.cs.mall.domain.UserDO;
import com.cqu.cs.mall.service.CommentService;
import com.cqu.cs.mall.service.CommonService;
import com.cqu.cs.mall.service.ProductService;
import com.cqu.cs.mall.service.UserService;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {

    private final ProductService productService;
    private final UserService userService;
    private final CommentService commentService;

    @Override
    public void importProductByExcel(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), ProductDO.class, new ReadListener<ProductDO>() {
            private static final int BATCH_COUNT = 100;
            private List<ProductDO> cachedList = Lists.newArrayListWithCapacity(BATCH_COUNT);
            @Override
            public void invoke(ProductDO elem, AnalysisContext analysisContext) {
                cachedList.add(elem);
                if (cachedList.size() >= BATCH_COUNT) {
                    log.info("入库数据条数：{}", cachedList.size());
                    productService.saveProductBatch(cachedList);
                    cachedList = Lists.newArrayListWithCapacity(BATCH_COUNT);
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                productService.saveProductBatch(cachedList);
            }
        }).sheet().doRead();
    }

    @Override
    public void importUserByExcel(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), UserDO.class, new ReadListener<UserDO>() {
            private static final int BATCH_COUNT = 100;
            private List<UserDO> cachedList = Lists.newArrayListWithCapacity(BATCH_COUNT);
            @Override
            public void invoke(UserDO elem, AnalysisContext analysisContext) {
                cachedList.add(elem);
                if (cachedList.size() >= BATCH_COUNT) {
                    log.info("入库数据条数：{}", cachedList.size());
                    userService.saveUserBatch(cachedList);
                    cachedList = Lists.newArrayListWithCapacity(BATCH_COUNT);
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                userService.saveUserBatch(cachedList);
            }
        }).sheet().doRead();
    }

    @Override
    public void importCommentByExcel(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), CommentDO.class, new ReadListener<CommentDO>() {
            private static final int BATCH_COUNT = 100;
            private List<CommentDO> cachedList = Lists.newArrayListWithCapacity(BATCH_COUNT);
            @Override
            public void invoke(CommentDO elem, AnalysisContext analysisContext) {
                cachedList.add(elem);
                if (cachedList.size() >= BATCH_COUNT) {
                    log.info("入库数据条数：{}", cachedList.size());
                    commentService.saveCommentBatch(cachedList);
                    cachedList = Lists.newArrayListWithCapacity(BATCH_COUNT);
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                commentService.saveCommentBatch(cachedList);
            }
        }).sheet().doRead();
    }
}