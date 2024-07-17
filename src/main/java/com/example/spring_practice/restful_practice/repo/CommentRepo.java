package com.example.spring_practice.restful_practice.repo;

import com.example.spring_practice.restful_practice.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
