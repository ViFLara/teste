package com.teste.teste.services;

import com.teste.teste.entities.Answer;
import com.teste.teste.entities.User;
import com.teste.teste.repositories.AnswerRepository;
import com.teste.teste.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository repository;

    public List<Answer> findAll() {
        try {
            List<Answer> list = repository.findAll();
            for (Answer answer : list ) {
                if (answer.getMessage() == null) {
                    answer.setMessage("");
                }
            }
            return list ;
        }
        catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }

    public Answer findById(Long id) {
        Optional<Answer> obj = repository.findById(id);
        return obj.get();
    }
}
