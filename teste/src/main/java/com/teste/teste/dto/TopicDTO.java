package com.teste.teste.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicDTO {

    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String title;

    @Column(nullable = false)
    private String message;
}
