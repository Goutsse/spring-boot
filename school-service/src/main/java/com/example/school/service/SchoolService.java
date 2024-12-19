package com.example.school.service;

import com.example.school.entity.School;
import com.example.school.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    private final SchoolRepository repository;

    public SchoolService(SchoolRepository repository) {
        this.repository = repository;
    }

    public List<School> getAllSchools() {
        return repository.findAll();
    }

    public School getSchoolById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public School saveSchool(School school) {
        return repository.save(school);
    }

    public void deleteSchool(Long id) {
        repository.deleteById(id);
    }
}
