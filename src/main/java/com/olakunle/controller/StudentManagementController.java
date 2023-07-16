package com.olakunle.controller;

import com.olakunle.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
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
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudent(){
        return STUDENTS;
    }

    @PostMapping("")
//    @PreAuthorize("hasAuthority('course:write')")
//    @PreAuthorize("hasPermission('course:write')")
    public void registerStudent(@RequestBody Student student){
        System.out.println("Registering Student" + student) ;
        log.error("Registering Student" + student);
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasAuthority('course:write')")
    public void deleteStudent(@PathVariable("id") Integer studentId){
        System.out.println("Deleting Student" + studentId);
        log.error("Deleting Student" + studentId);
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasAuthority('course:write')")
    public void updateStudent(@PathVariable("id") Integer studentId, @RequestBody Student student){
        System.out.println("Updating Student" + studentId + " with data " + student);
        log.error("Updating Student" + studentId + " with data " + student);
    }
}
