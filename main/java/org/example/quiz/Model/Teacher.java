package org.example.quiz.Model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {

    @NotEmpty(message = "cant be empty")
    private Integer id;

    @NotEmpty(message = "cant be empty")
    private String name;

    @NotEmpty(message = "cant be empty")
    private Integer salary;



}
