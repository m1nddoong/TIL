package com.example.spring_practice.controller;

import com.example.spring_practice.entity.Article;
import com.example.spring_practice.repo.ArticleRepo;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleRepo repository;
    @GetMapping("/save")
    public String save() {
        Article article = new Article();
        article.setTitle("Test");
        article.setContent("Loram Ipsum");
        article.setWriter("Alex");
        repository.save(article);
        return "done";
    }

    @GetMapping("/find-all")
    public void findAll() {
        List<Article> articles =  repository.findAll();
        for (Article entity : articles) {
            System.out.println(entity.toString());
        }
    }

    @GetMapping("/read-one")
    public void readOne() {
        Optional<Article> optionalArticle = repository.findById(4L);
        if (optionalArticle.isPresent()) {
            System.out.println("found: 4L");
            System.out.println(optionalArticle.get());
        }
    }

    @PutMapping("/article/{id}")
    public void updateArticle(
            @PathVariable
            Long id
    ) {
        Optional<Article> optionalArticle = repository.findById(id);
        if (optionalArticle.isPresent()) {
            System.out.println("target found");
            Article entity = optionalArticle.get();
            entity.setTitle("updated title");
            repository.save(entity);
        }
    }

    @DeleteMapping("/article/{id}")
    public void deleteArticle (
            @PathVariable
            Long id
    ) {
        repository.deleteById(id);
    }
}