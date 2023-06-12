package com.example.sigga.subjects;

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

    @Column(
            name = "teacher_id"
    )
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacher_id"
    )
    private Long teacherId;

    @Column(
            name = "department_id"
    )
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "department_id",
            referencedColumnName = "departmeent_id"
    )
    private Long departmentId;

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

    public Subjects(Long id, Long teacherId, Long departmentId, String name, String description) {
        this.id           = id;
        this.teacherId    = teacherId;
        this.departmentId = departmentId;
        this.name         = name;
        this.description  = description;
    }

    public Subjects(Long teacherId, Long departmentId, String name, String description) {
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

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
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
