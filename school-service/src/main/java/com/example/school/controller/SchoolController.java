package com.example.school.controller;

import com.example.school.entity.School;
import com.example.school.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {
    private final SchoolService service;

    public SchoolController(SchoolService service) {
        this.service = service;
    }

    @GetMapping
    public List<School> getAllSchools() {
        return service.getAllSchools();
    }

    @GetMapping("/{id}")
    public School getSchoolById(@PathVariable Long id) {
        return service.getSchoolById(id);
    }

    @PostMapping
    public School createSchool(@RequestBody School school) {
        return service.saveSchool(school);
    }

    @DeleteMapping("/{id}")
    public void deleteSchool(@PathVariable Long id) {
        service.deleteSchool(id);
    }
}
