package com.olakunle.controller;

import com.olakunle.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1L, "Olakunle", "Balogun"),
            new Student(2L, "Henry", "Smith"),
            new Student(3L, "Joe", "Cole"),
            new Student(4L, "Mount", "Mason"),
            new Student(5L, "Tommy", "Edgar")

    );

    @GetMapping("")
    public List<Student> getAllStudent(){
        return STUDENTS;
    }

    @PostMapping("")
    public void registerStudent(@RequestBody Student student){
        System.out.println("Registering Student" + student) ;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") Integer studentId){
        System.out.println("Deleting Student" + studentId);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable("id") Integer studentId, @RequestBody Student student){
        System.out.println("Updating Student" + studentId + " with data " + student);
    }
}
