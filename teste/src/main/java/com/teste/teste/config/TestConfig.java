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

        User author = new User("Pedro", "pedro@gmail.com");
        Course course = new Course(null, "Java", "Básico");

        author = userRepository.save(author);
        course = courseRepository.save(course);

        Answer answer1 = Answer.builder().message("Qual o seu erro?").creationDate(LocalDateTime.now()).author(author).solution(false).build();
        Answer answer2 = Answer.builder().message("Tenta instanciar").creationDate(LocalDateTime.now()).author(author).solution(false).build();

        answerRepository.saveAll(Arrays.asList(answer1, answer2));

        Topic topic1 = new Topic(null, "Problemas no service", "Alguém pode me ajudar?",
                LocalDateTime.now(), TopicStatus.valueOf(1), author, course);

        Topic topic2 = new Topic(null, "Não funciona", "Projeto não roda",
                LocalDateTime.now(), TopicStatus.valueOf(2), author, course);

        topic1.getAnswers().add(answer1);
        topic2.getAnswers().add(answer2);
        topicRepository.saveAll(Arrays.asList(topic1, topic2));
    }
}
