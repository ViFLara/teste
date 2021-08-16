package com.teste.teste.controller;

import com.teste.teste.entities.Course;
import com.teste.teste.entities.User;
import com.teste.teste.services.CourseService;
import com.teste.teste.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping
    public ResponseEntity<List<Course>> findAll() {
        List<Course> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id) {
        Course obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
