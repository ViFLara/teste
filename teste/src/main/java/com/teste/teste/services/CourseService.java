package com.teste.teste.services;

import com.teste.teste.entities.Course;
import com.teste.teste.entities.User;
import com.teste.teste.repositories.CourseRepository;
import com.teste.teste.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public List<Course> findAll() {
        try {
            List<Course> list = repository.findAll();
            for (Course course : list ) {
                if (course.getName() == null) {
                    course.setName("");
                }
                if (course.getCategory() == null) {
                    course.setCategory("");
                }
            }
            return list ;
        }
        catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }

    public Course findById(Long id) {
        Optional<Course> obj = repository.findById(id);
        return obj.get();
    }
}
