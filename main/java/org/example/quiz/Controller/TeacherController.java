package org.example.quiz.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.quiz.Api.ApiResponse;
import org.example.quiz.Model.Student;
import org.example.quiz.Model.Teacher;
import org.example.quiz.Service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("teacher")
@RequiredArgsConstructor

public class TeacherController {


    private final TeacherService teacherService ;



    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        return ResponseEntity.status(200).body(teacherService.getTeacher());
    }



    @PostMapping("/add")
    public ResponseEntity addTeacher (@RequestBody @Valid Teacher teacher , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("added"));


    }


    @PutMapping("/update/{Id}")
    private ResponseEntity updateTeacher(@PathVariable int Id , @RequestBody @Valid Teacher teacher , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isUpdate = teacherService.updateTeacher(Id , teacher);

        if (isUpdate){
            return ResponseEntity.status(200).body(new ApiResponse("updated"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("Id not found"));
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteTeacher(@PathVariable int Id ){


        if (teacherService.deleteTeacher(Id) == null){
            return ResponseEntity.status(400).body(new ApiResponse("Invalid Id"));
        }

        return ResponseEntity.status(200).body(new ApiResponse("deleted"));

    }

    @GetMapping("/search/{Id}")
    public ResponseEntity searchById(@PathVariable int Id){

        if (teacherService.searchById(Id) == null){
            return ResponseEntity.status(400).body(new ApiResponse("Id not found"));
        }

        return ResponseEntity.status(200).body(teacherService.searchById(Id));

    }

    @GetMapping("/getSalary/{salary}")
    public ResponseEntity getSalary(@PathVariable int salary){

        return ResponseEntity.status(200).body(teacherService.getSalary(salary));

    }










}
