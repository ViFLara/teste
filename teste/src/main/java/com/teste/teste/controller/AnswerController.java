package com.teste.teste.controller;

import com.teste.teste.entities.Answer;
import com.teste.teste.entities.User;
import com.teste.teste.services.AnswerService;
import com.teste.teste.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/answers")
public class AnswerController {

    @Autowired
    private AnswerService service;

    @GetMapping
    public ResponseEntity<List<Answer>> findAll() {
        List<Answer> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Answer> findById(@PathVariable Long id) {
        Answer obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
