package com.example.spring_practice.jpa_practice.service;

import com.example.spring_practice.jpa_practice.entity.Instructor;
import com.example.spring_practice.jpa_practice.repo.InstructorRepo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstructorService {
    private final InstructorRepo instructorRepo;

    // public InstructorDto readInstructor(Long id) {return new InstructorDto();}
    public Instructor readInstructor(Long id) {
        return instructorRepo.findById(id).orElse(null);
    }


    // public List<InstructorDto> readInstructorAll() { return new ArrayList<>();}
    public List<Instructor> readInstructorAll() {
        return instructorRepo.findAll();
    }
}
