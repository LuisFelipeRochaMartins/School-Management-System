package com.example.sigga.department;

import com.example.sigga.phase.Phase;
import com.example.sigga.teacher.Teacher;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table
public class Department {
    @Id
    @SequenceGenerator(
            name           = "sequence_department",
            sequenceName   = "sequence_department",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy  = GenerationType.SEQUENCE,
            generator = "sequence_department"
    )

    @Column(
            name = "id"
    )
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(
            name = "person_id",
            referencedColumnName = "id"
    )
    private Teacher Teacher;

    @OneToMany
    @JoinColumn(name = "phase_id")
    private List<Phase> phases;

    public Department() {

    }

    public Department(Long id, Teacher teacherId) {
        this.id = id;
        Teacher = teacherId;
    }

    /**
     * Retorna o Id do Departamento
     *
     * @return Long - Id do Departamento
     */

    public Long getId() {
        return id;
    }

    /**
     * Define o  Id do Departamento
     *
     * @param id Long - Id do Departamento
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Id do Departamento
     *
     * @return Long - Id do Professor
     */
    public Teacher getTeacher() {
        return Teacher;
    }

    /**
     * Define o  Id do Departamento
     *
     * @param teacher Teacher - Id do Departamento
     */
    public void setTeacher(Teacher teacher) {
        Teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phase> getPhases() {
        return this.phases;
    }

    public void setPhases(List<Phase> phases) {
        this.phases = phases;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Id = ").append(id);
        sb.append("Teacher = ").append(Teacher);
        return sb.toString();
    }
}
