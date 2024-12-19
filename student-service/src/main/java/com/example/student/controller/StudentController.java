package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Endpoint pour récupérer tous les étudiants
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Endpoint pour récupérer un étudiant par ID (sans école)
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    // Endpoint pour récupérer un étudiant par ID avec école associée
    @GetMapping("/{id}/with-school")
    public Student getStudentByIdWithSchool(@PathVariable String id) {
        return studentService.getStudentByIdWithSchool(id);
    }

    // Endpoint pour créer un nouvel étudiant
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
}
