package com.example.spring_practice.restful_practice.controller;

import com.example.spring_practice.restful_practice.dto.CommentDto;
import com.example.spring_practice.restful_practice.service.CommentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles/{articleId}/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public CommentDto craate(
            @PathVariable("articleId")
            Long articleId,
            @RequestBody
            CommentDto dto
    ) {
        return commentService.create(articleId, dto);
    }

    @GetMapping
    public List<CommentDto> readAll(
            @PathVariable("articleId")
            Long articleId
    ) {
        return commentService.readCommentAll(articleId);
    }

    @PutMapping("/{commentId}")
    public CommentDto update(
            @PathVariable("articleId")
            Long articleId,
            @PathVariable("commentId")
            Long commentId,
            @RequestBody
            CommentDto dto
    ) {
        return commentService.updateComment(articleId, commentId, dto);
    }

    @DeleteMapping("/{commentId}")
    public void delete(
            @PathVariable("articleId")
            Long articleId,
            @PathVariable("commentId")
            Long commentId
    ) {
        commentService.deleteComment(articleId, commentId);
    }
}
