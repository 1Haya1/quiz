package org.example.quiz.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.quiz.Api.ApiResponse;
import org.example.quiz.Model.Student;
import org.example.quiz.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {


    private final StudentService studentService ;


    @GetMapping("/get")
    public ResponseEntity getStudent(){
        return ResponseEntity.status(200).body(studentService.getStudent());
    }


    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student1 , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        studentService.addStudent(student1);
        return ResponseEntity.status(200).body(new ApiResponse("added"));

    }



    @PutMapping("/update/{Id}")
    public ResponseEntity updateStudent(@PathVariable int Id , @RequestBody @Valid Student student , Errors errors ){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isUpdate = studentService.updateStudent(Id , student);
        if (isUpdate){
            return ResponseEntity.status(200).body(new ApiResponse("updated"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("Invalid Id"));
    }



    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteStudent(@PathVariable int Id ){


        if (studentService.deleteStudent(Id) == null){
            return ResponseEntity.status(400).body(new ApiResponse("Invalid Id"));
        }

        return ResponseEntity.status(200).body(new ApiResponse("deleted"));

    }



    @GetMapping("/search/{SName}")
    public ResponseEntity searchByName(@PathVariable String SName){

        if (studentService.searchByName(SName) == null){
            return ResponseEntity.status(400).body(new ApiResponse("please enter invalid name"));
        }

        return ResponseEntity.status(200).body(studentService.searchByName(SName));

    }


    @GetMapping("/allStudent/{major}")
    private ResponseEntity AllStudent(@PathVariable String major){

        return ResponseEntity.status(200).body(studentService.AllStudent(major));

    }










}
