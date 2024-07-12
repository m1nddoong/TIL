package com.example.spring_practice.jpa_practice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


/*
CREATE TABLE student (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    NAME VARCHAR(255),
    AGE INTEGER,
    PHONE VARCHAR(255),
    EMAIL VARCHAR(255)
);
 */

@Data
@Entity
@Table(name="student") // 테이블의 student 로 변경
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String phone;
    private String email;

    // FK Column -> Join Column
    @ManyToOne
    @JoinColumn(name = "advisor")
    private Instructor advisor;
}
