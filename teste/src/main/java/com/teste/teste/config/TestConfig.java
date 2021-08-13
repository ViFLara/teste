package com.teste.teste.config;

import com.teste.teste.entities.Answer;
import com.teste.teste.entities.Course;
import com.teste.teste.entities.Topic;
import com.teste.teste.entities.User;
import com.teste.teste.enums.TopicStatus;
import com.teste.teste.repositories.AnswerRepository;
import com.teste.teste.repositories.CourseRepository;
import com.teste.teste.repositories.TopicRepository;
import com.teste.teste.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public void run(String... args) throws Exception {

        User author = new User(null, "Pedro", "pedro@gmail.com", "12345");
        Course course = new Course(null, "Java", "Básico");

        List<Answer> answer = new ArrayList<>();

        author = userRepository.save(author);
        course = courseRepository.save(course);


        Topic topic1 = Topic.builder().author(author).course(course).createDate(LocalDateTime.now()).status(TopicStatus.NOT_ANSWERED).build();

//        Topic topic2 = new Topic(null, "Não funciona", "Projeto não roda",
//                LocalDateTime.now(), TopicStatus.NOT_ANSWERED, author, course, answer);

        topic1 = topicRepository.save(topic1);

        Answer answer1 = new Answer(null, "Qual o seu erro?", topic1, LocalDateTime.now(), author, false);
        Answer answer2 = new Answer(null, "Tenta instanciar", topic1, LocalDateTime.now(), author, false);

        answer1 = answerRepository.save(answer1);
        answer2 = answerRepository.save(answer2);

        answer.add(answer1);
        answer.add(answer2);
    }
}
