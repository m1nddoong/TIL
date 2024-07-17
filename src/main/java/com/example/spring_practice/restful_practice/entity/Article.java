package com.example.spring_practice.restful_practice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CREATE TABLE article(
 *     id INTEGER PRIMARY KEY AUTOINCREMENT,
 *     title TEXT,
 *     content TEXT,
 *     writer TEXT
 * )
 */

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String title;
    @Setter
    @Lob // Large Object
    private String content;
    @Setter
    private String writer;

    @OneToMany(mappedBy = "article")
    private final List<Comment> comments = new ArrayList<>();

    public Article(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
