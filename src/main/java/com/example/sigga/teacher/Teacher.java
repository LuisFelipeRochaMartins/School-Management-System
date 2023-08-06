package com.example.sigga.teacher;

import com.example.sigga.person.Person;
import jakarta.persistence.*;

import java.util.List;

import com.example.sigga.subjects.Subjects;

@Entity
@Table
@PrimaryKeyJoinColumn(name = "id")
public class Teacher extends Person {
    @ManyToMany
    @JoinTable(
            name = "teacher_subjects",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subjects_id")
    )
    private List<Subjects> subjects;
    public Teacher() {

    }

    public Teacher(Long id, List<Subjects> subjects) {
        this.subjects = subjects;
    }

    public List<Subjects> getSubjects() {
        return this.subjects;
    }

    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb.toString();
    }
}