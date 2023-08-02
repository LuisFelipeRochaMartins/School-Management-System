package com.example.sigga.phase;

import com.example.sigga.department.Department;
import com.example.sigga.subjects.Subjects;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table
public class Phase {

    @Id
    @SequenceGenerator(
            name           = "phase_sequence",
            sequenceName   = "phase_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy  = GenerationType.SEQUENCE,
            generator = "phase_sequence"
    )
    @Column(
            name = "person_id",
            nullable = false,
            updatable = false
    )
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "department_id",
            referencedColumnName = "id"
    )
    private Department department;

    @Column(
            name = "phase_name"
    )
    private String name;

    @Column(
            name = "phase_description"
    )
    private String description;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "subjects_id",
            referencedColumnName = "subjects_id"
    )
    private Subjects Subjects;

    public Phase() {

    }

    public Phase(Department department, String name, String description, Subjects subjects) {
        this.department = department;
        this.name = name;
        this.description = description;
        Subjects = subjects;
    }

    public Phase(Long id, Department  department, String name, String description, Subjects subjects) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.description = description;
        Subjects = subjects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Subjects getSubjects() {
        return Subjects;
    }

    public void setSubjects(Subjects subjects) {
        Subjects = subjects;
    }
}
