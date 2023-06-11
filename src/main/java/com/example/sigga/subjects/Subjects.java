package com.example.sigga.subjects;

import com.example.sigga.student.ListStudent;
import com.example.sigga.student.Student;
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
    private Long id;
    private Long teacherId;
    private Long departmentId;
    private String description;
    private ListStudent students;

    public Subjects() {

    }

    public Subjects(Long id, Long teacherId, Long departmentId, String description) {
        this.id = id;
        this.teacherId = teacherId;
        this.departmentId = departmentId;
        this.description = description;
    }

    public Subjects(Long teacherId, Long departmentId, String description) {
        this.teacherId = teacherId;
        this.departmentId = departmentId;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ListStudent getStudents() {
        return students;
    }

    public void setStudents(ListStudent students) {
        this.students = students;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Id do Disciplina").append(id);
        sb.append("Id do Professor").append(teacherId);
        sb.append("Departamento = ").append(departmentId);
        sb.append("Descrição = ").append(description);
        return sb.toString();
    }
}
