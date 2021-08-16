package com.teste.teste.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teste.teste.enums.TopicStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Topic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private LocalDateTime createDate = LocalDateTime.now();

    @Enumerated(EnumType.ORDINAL)
    private TopicStatus status = TopicStatus.valueOf(1);

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToOne
    private Course course;

    @JsonIgnore
    @OneToMany(mappedBy = "topic")
    private final List<Answer> answers = new ArrayList<>();
 }
