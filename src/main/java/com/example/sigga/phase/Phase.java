package com.example.sigga.phase;

import com.example.sigga.department.Department;
import com.example.sigga.subjects.Subjects;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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
    private String name;
    private String description;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
                          CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "phase_id")
    private Department department;

    @OneToMany(mappedBy = "phase")
    private List<Subjects> subjects;

    public Phase() {

    }

    public Phase(String name, String description, List<Subjects> subjects, Department department) {
        this.name = name;
        this.description = description;
        this.subjects    = subjects;
        this.department  = department;
    }

    public Phase(Long id, String name, String description, List<Subjects> subjects, Department department) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.subjects    = subjects;
        this.department  = department;
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

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Criando o Relacionamento bidirecional.
     *
     * @param tempSubject Subjects
     */
    public void addSubjects(Subjects tempSubject){
        if (subjects == null) {
            this.subjects = new ArrayList<>();
        }

        subjects.add(tempSubject);
        tempSubject.setPhase(this);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        return sb.toString();
    }
}