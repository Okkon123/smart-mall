package com.cqu.cs.mall.controller;

import com.cqu.cs.mall.dto.Result;
import com.cqu.cs.mall.dto.req.AddCommentReqDTO;
import com.cqu.cs.mall.dto.req.CommentPageReqDTO;
import com.cqu.cs.mall.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @RequestMapping("/add")
    public Result<Void> addComment(@RequestBody AddCommentReqDTO addCommentReqDTO) {
        commentService.addComment(addCommentReqDTO);
        return Result.success();
    }

    @GetMapping("/delete")
    public Result<Void> deleteComment(Integer commentId) {
        commentService.deleteComment(commentId);
        return Result.success();
    }

    @GetMapping("/page")
    public Result<List<String>> pageComment(CommentPageReqDTO commentPageReqDTO) {
        return Result.success(commentService.pageComment(commentPageReqDTO));
    }
}
