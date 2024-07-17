package com.example.spring_practice.restful_practice.dto;

import com.example.spring_practice.restful_practice.entity.Comment;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class CommentDto {
    @Id
    private Long id;
    @Setter
    private String content;
    @Setter
    private String writer;

    public CommentDto(Long id, String content, String writer) {
        this.id = id;
        this.content = content;
        this.writer = writer;
    }

    private static CommentDto fromEntity(Comment entity) {
        return new CommentDto(
                entity.getId(),
                entity.getContent(),
                entity.getWriter()
        );
    }

}
