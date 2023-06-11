package com.example.sigga.department;

import com.example.sigga.subjects.ListSubjects;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table
public class Department {

    private Long id;
    private Long courseId;
    private ListSubjects subjects;




}
