package org.example.quiz.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {


    @NotEmpty(message = "cant be empty")
    private Integer id;

    @NotEmpty(message = "cant be empty")
    private String name;


    @NotEmpty(message = "cant be empty")
    private Integer age;

    @NotEmpty(message = "cant be empty")
    private String major;



}
