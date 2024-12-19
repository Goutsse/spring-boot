package com.example.student.service;

import com.example.student.entity.Student;
import com.example.student.dto.School;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private final WebClient webClient;

    @Autowired
    public StudentService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081/api/schools").build();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }

    public Student getStudentByIdWithSchool(String id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();

            School school = webClient
                .get()
                .uri("/{id}", student.getSchoolId()) 
                .retrieve()
                .bodyToMono(School.class) 
                .block(); 

            student.setSchoolName(school.getName());
            student.setSchoolAddress(school.getAddress());

            return student;
        } else {
            throw new RuntimeException("Student not found with ID: " + id);
        }
    }

    // Créer un nouvel étudiant
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
}
