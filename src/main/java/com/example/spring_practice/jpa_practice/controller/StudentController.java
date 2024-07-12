package com.example.spring_practice.jpa_practice.controller;

import com.example.spring_practice.jpa_practice.service.InstructorService;
import com.example.spring_practice.jpa_practice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;
    private final InstructorService instructorService;


    @GetMapping("create-view")
    public String createView(Model model) {
        // 학생을 만들때
        model.addAttribute("instructors", instructorService.readInstructorAll());
        return "student/create";
    }

    @PostMapping("create")
    public String create(
            @RequestParam("name")
            String name,
            @RequestParam("age")
            Integer age,
            @RequestParam("phone")
            String phone,
            @RequestParam("email")
            String email,
            @RequestParam("advisor-id")
            Long advisorId
    ) {
        studentService.create(name, age, phone, email, advisorId);
        return "redirect:/student";
    }

    @GetMapping
    public String readAll(Model model) {
        model.addAttribute("students", studentService.readStudentAll());
        return "student/home";
    }

    @GetMapping("{id}")
    public String readOne(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("student", studentService.readStudent(id));
        return "student/read";
    }

    @GetMapping("{id}/update-view")
    public String updateView(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("student", studentService.readStudent(id));
        return "student/update";
    }

    @PostMapping("{id}/update")
    public String update(
            @PathVariable("id")
            Long id,
            @RequestParam("name")
            String name,
            @RequestParam("age")
            Integer age,
            @RequestParam("phone")
            String phone,
            @RequestParam("email")
            String email
    ) {
        studentService.update(
                id, name, age, phone, email);
        return String.format("redirect:/student/%d", id);
    }

    @PostMapping("{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        studentService.delete(id);
        return "redirect:/student";
    }
}
