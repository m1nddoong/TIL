package com.example.spring_practice.restful_practice.service;

import com.example.spring_practice.restful_practice.dto.CommentDto;
import com.example.spring_practice.restful_practice.entity.Article;
import com.example.spring_practice.restful_practice.entity.Comment;
import com.example.spring_practice.restful_practice.repo.ArticleRepo;
import com.example.spring_practice.restful_practice.repo.CommentRepo;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {
    private final ArticleRepo articleRepo;
    private final CommentRepo commentRepo;
    
    public CommentDto create(
            Long articleId, 
            CommentDto dto
    ) {
        Optional<Article> optionalArticle = articleRepo.findById(articleId);
        if (optionalArticle.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Comment newComment = new Comment();


    }

    public List<CommentDto> readCommentAll(Long articleId) {
    }

    public CommentDto updateComment(Long articleId, Long commentId, CommentDto dto) {
    }

    public void deleteComment(Long articleId, Long commentId) {
    }
}
