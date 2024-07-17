package com.example.spring_practice.restful_practice.service;

import com.example.spring_practice.restful_practice.dto.ArticleDto;
import com.example.spring_practice.restful_practice.entity.Article;
import com.example.spring_practice.restful_practice.repo.ArticleRepo;
import java.util.ArrayList;
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
public class ArticleService {
    private final ArticleRepo articleRepo;

    // CREATE
    public ArticleDto create(ArticleDto dto) {
        Article newArticle = new Article (
                dto.getTitle(),
                dto.getContent(),
                dto.getWriter()
        );
        // article 엔티티 객체를 저장한 후 dto로 만들어 반환
        return ArticleDto.fromEntity(articleRepo.save(newArticle));
    }

    public List<ArticleDto> readAll() {
        List<ArticleDto> articleDtoList = new ArrayList<>();
        List<Article> articles = articleRepo.findAll();
        for (Article entity : articles) {
            articleDtoList.add(ArticleDto.fromEntity(entity));
        }
        return articleDtoList;
    }

    public ArticleDto readArticle(Long id) {
        Optional<Article> optionalArticle = articleRepo.findById(id);
        if (optionalArticle.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ArticleDto.fromEntity(optionalArticle.get());
    }

    public ArticleDto updateArticle(Long id, ArticleDto dto) {
        Optional<Article> optionalArticle = articleRepo.findById(id);
        if (optionalArticle.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Article targetArticle = optionalArticle.get();
        targetArticle.setTitle(dto.getTitle());
        targetArticle.setContent(dto.getContent());
        targetArticle.setWriter(dto.getWriter());
        return ArticleDto.fromEntity(articleRepo.save(targetArticle));
    }


    public void deleteArticle(Long id) {
        if (!articleRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND)
        }
        articleRepo.deleteById(id);
    }
}
