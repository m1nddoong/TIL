package com.example.spring_practice.restful_practice.controller;

import com.example.spring_practice.restful_practice.dto.ArticleDto;
import com.example.spring_practice.restful_practice.service.ArticleService;
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

// 뷰가 아니라 모든 메서드의 반환형에
// ResponseBody 애너테이션 (데이터 그 자체)
@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping
    public ArticleDto create(
            @RequestBody
            ArticleDto dto
    ) {
        return articleService.create(dto);
    }

    @GetMapping
    public List<ArticleDto> readAll() {
        return articleService.readAll();
    }

    @GetMapping("/{id}")
    public ArticleDto read(
            @PathVariable("id")
            Long id
    ) {
        return articleService.readArticle(id);
    }

    @PutMapping("/{id}")
    public ArticleDto update(
            @PathVariable("id")
            Long id,
            @RequestBody
            ArticleDto dto

    ) {
        return articleService.updateArticle(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id")
            Long id
    ) {
        articleService.deleteArticle(id);
    }
}
