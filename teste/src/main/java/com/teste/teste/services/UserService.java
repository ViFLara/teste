package com.teste.teste.services;

import com.teste.teste.entities.User;
import com.teste.teste.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        try {
            List<User> list = repository.findAll();
            for (User user : list ) {
                if (user.getName() == null) {
                    user.setName("");
                }
                if (user.getEmail() == null) {
                    user.setEmail("");
                }
            }
            return list ;
        }
        catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }
}
