package com.example.sigga.subjects;

import com.example.sigga.department.Department;
import com.example.sigga.teacher.Teacher;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Subjects {
    @Id
    @SequenceGenerator(
            name           = "subjects_sequence",
            sequenceName   =  "subjects_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy  = GenerationType.SEQUENCE,
            generator = "subjects_sequence"
    )

    @Column(
            name = "subjects_id",
            nullable = false,
            updatable = false

    )
    private Long id;

    @OneToMany
    @JoinColumn(name = "person_id")
    private List<Teacher> teacher;

    @OneToOne
    @JoinColumn(
            name = "department_id",
            referencedColumnName = "id"
    )
    private Department department;

    @Column(
            name = "subject_name"
    )
    private String name;

    @Column(
            name = "subject_description"
    )
    private String description;


    @Column(
            name = "subject_syllabus"
    )
    public String syllabus;

    public Subjects() {

    }

    public Subjects(Long id, List<Teacher> teacher, Department departmentId, String name, String description, String syllabus) {
        this.id           = id;
        this.teacher      = teacher;
        this.department   = departmentId;
        this.name         = name;
        this.description  = description;
        this.syllabus     = syllabus;
    }

    public Subjects(List<Teacher> teacher, Department departmentId, String name, String description, String syllabus) {
        this.teacher      = teacher;
        this.department   = departmentId;
        this.name         = name;
        this.description  = description;
        this.syllabus     =  syllabus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<Teacher> teacher) {
        this.teacher = teacher;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Id do Disciplina").append(id).append("\n");
        sb.append("Id do Professor").append(teacher).append("\n");
        sb.append("Departamento = ").append(department).append("\n");
        sb.append("Nome = ").append(name).append("\n");
        sb.append("Descrição = ").append(description).append("\n");
        sb.append("Ementa = ").append(syllabus).append("\n");
        return sb.toString();
    }
}
