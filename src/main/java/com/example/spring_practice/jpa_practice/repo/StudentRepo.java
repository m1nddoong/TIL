package com.example.spring_practice.jpa_practice.repo;

import com.example.spring_practice.jpa_practice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
