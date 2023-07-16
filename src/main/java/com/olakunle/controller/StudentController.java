package com.olakunle.controller;


import com.olakunle.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private static List<Student> students () {
        return List.of(
                new Student(1L, "Olakunle", "Balogun"),
                new Student(2L, "Henry", "Smith"),
                new Student(3L, "Joe", "Cole"),
                new Student(4L, "Mount", "Mason"),
                new Student(5L, "Tommy", "Edgar")

        );
    }
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1L, "Olakunle", "Balogun"),
            new Student(2L, "Henry", "Smith"),
            new Student(3L, "Joe", "Cole"),
            new Student(4L, "Mount", "Mason"),
            new Student(5L, "Tommy", "Edgar")

    );


    @GetMapping
    public List<Student> fetchAllStudents() {
        return new ArrayList<>(STUDENTS);
    }
}
