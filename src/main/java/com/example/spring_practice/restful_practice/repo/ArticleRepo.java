package com.example.spring_practice.restful_practice.repo;

import com.example.spring_practice.restful_practice.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article, Long> {
}
