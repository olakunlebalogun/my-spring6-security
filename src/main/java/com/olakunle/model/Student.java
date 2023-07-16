package com.olakunle.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class Student {
    @Id
    private Long id;
    private String firstName;
    private String lastName;

    public Student (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student() {}
}
