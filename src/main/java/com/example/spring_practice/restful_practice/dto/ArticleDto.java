package com.example.spring_practice.restful_practice.dto;


import com.example.spring_practice.restful_practice.entity.Article;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
// 엔티티에 ToStrin 을 붙이지 않고 DTO에만 붙인다.
// -> 엔티티간 관계 형성 시 순한 참조 문제가 발생하기 때문
@NoArgsConstructor // JPA 연동 시 기본 생성자 필요
// @AllArgsConstructor // 모든 필드를 인자로 받는 생성자 자동 생성
public class ArticleDto {
    private Long id;
    @Setter
    private String title;
    @Setter
    private String content;
    @Setter
    private String writer;

    private List<CommentDto> comments = new ArrayList<>();

    public ArticleDto(Long id, String title, String content, String writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    // Static Factory Method
    public static ArticleDto fromEntity(Article entity) {
        return new ArticleDto(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getWriter()
        );
    }
}
