package com.teste.teste.services;

import com.teste.teste.entities.Topic;
import com.teste.teste.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository repository;

    public List<Topic> findAll() {
        try {
            List<Topic> a = repository.findAll();
            for (Topic topic : a ) {
                if ( topic.getTitle() == null) {
                    topic.setTitle("");
                }
                if ( topic.getMessage() == null) {
                    topic.setMessage("");
                }
            }
            return a ;
        }
        catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }

    public Topic findById(Long id) {
        Optional<Topic> obj = repository.findById(id);
        return obj.get();
    }
}
