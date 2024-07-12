package com.example.spring_practice.jpa_practice.repo;

import com.example.spring_practice.jpa_practice.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepo extends JpaRepository<Instructor, Long> {
}



