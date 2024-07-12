package com.example.spring_practice.jpa_practice.service;

import com.example.spring_practice.jpa_practice.entity.Student;
import com.example.spring_practice.jpa_practice.repo.InstructorRepo;
import com.example.spring_practice.jpa_practice.repo.StudentRepo;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;
    private final InstructorRepo instructorRepo;

    public void create(
        String name,
        Integer age,
        String phone,
        String email,
        Long advisorId

    ) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setPhone(phone);
        student.setEmail(email);
        student.setAdvisor(
                instructorRepo.findById(advisorId).orElse(null)
        );
        studentRepo.save(student);
    }

    public List<Student> readStudentAll() {
        List<Student> students = studentRepo.findAll();
        for (Student student : students) {
            System.out.println(student.toString());
        }
        return students;
    }

    public Student readStudent(Long id) {
        Optional<Student> optionalStudent = studentRepo.findById(id);
        // 실제 데이터가 있으면 해당 데이터를
        return optionalStudent
                // 없으면 null을 반환한다.
                .orElse(null);
    }

    public void update(
            // 수정할 데이터의 PK가 무엇인지
            Long id,
            String name,
            Integer age,
            String phone,
            String email
    ) {
        // 1. 업데이트 할 대상 데이터를 찾고
        Student target = readStudent(id);
        // 2. 데이터의 내용을 전달받는 내용으로 갱신하고
        target.setName(name);
        target.setAge(age);
        target.setPhone(phone);
        target.setEmail(email);
        // 3. repository를 이용해 저장한다.
        studentRepo.save(target);
    }

    public void delete(Long id) {
        studentRepo.deleteById(id);
    }
}
