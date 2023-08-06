package com.example.sigga.subjects;

import com.example.sigga.phase.Phase;
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
            name = "id",
            nullable = false,
            updatable = false

    )
    private Long id;
    private String name;
    private String description;
    private String syllabus;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
                          CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "subjects_id")
    private Phase phase;

    @ManyToMany
    @JoinTable(
            name = "teacher_subjects",
            joinColumns = @JoinColumn(name = "subjects_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<Teacher> teachers;

    public Subjects() {

    }

    public Subjects(Long id, String name, String description, String syllabus) {
        this.id           = id;
        this.name         = name;
        this.description  = description;
        this.syllabus     = syllabus;
    }

    public Subjects( String name, String description, String syllabus) {
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

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Id do Disciplina").append(id).append("\n");
        sb.append("Nome = ").append(name).append("\n");
        sb.append("Descrição = ").append(description).append("\n");
        sb.append("Ementa = ").append(syllabus).append("\n");
        return sb.toString();
    }
}