package com.example.sigga.department;

import com.example.sigga.phase.Phase;
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

    @OneToMany(mappedBy = "department")
    private List<Phase> phase;

    public Department() {

    }

    public Department(Long id, String name, List<Phase> phases) {
        this.id     = id;
        this.name   = name;
        this.phase = phases;
    }

    public Department(String name, List<Phase> phase) {
        this.name = name;
        this.phase = phase;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phase> getPhases() {
        return phase;
    }

    public void setPhases(List<Phase> phases) {
        this.phase = phases;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Id = ").append(id);
        return sb.toString();
    }
}