package com.example.sigga.subjects;

import com.example.sigga.department.Department;
import com.example.sigga.teacher.Teacher;
import jakarta.persistence.*;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "id"
    )
    private Teacher teacherId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "department_id",
            referencedColumnName = "id"
    )
    private Department departmentId;

    @Column(
            name = "subject_name"
    )
    private String name;

    @Column(
            name = "subject_description"
    )
    private String description;

    public Subjects() {

    }

    public Subjects(Long id, Teacher teacherId, Department departmentId, String name, String description) {
        this.id           = id;
        this.teacherId    = teacherId;
        this.departmentId = departmentId;
        this.name         = name;
        this.description  = description;
    }

    public Subjects(Teacher teacherId, Department departmentId, String name, String description) {
        this.teacherId    = teacherId;
        this.departmentId = departmentId;
        this.name         = name;
        this.description  = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Teacher teacherId) {
        this.teacherId = teacherId;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Id do Disciplina").append(id);
        sb.append("Id do Professor").append(teacherId);
        sb.append("Departamento = ").append(departmentId);
        sb.append("Nome = ").append(name);
        sb.append("Descrição = ").append(description);
        return sb.toString();
    }
}
