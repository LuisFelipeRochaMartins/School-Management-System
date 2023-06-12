package com.example.sigga.department;

import jakarta.persistence.*;


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
            name = "department_id"
    )
    private Long id;

    @Column(
            name = "teacher_id"
    )
    @OneToOne(cascade = CascadeType.ALL)
    @
    private Long TeacherId;

    public Department() {

    }

    public Department(Long id, Long teacherId) {
        this.id = id;
        TeacherId = teacherId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(Long teacherId) {
        TeacherId = teacherId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Id = ").append(id);
        sb.append("Teacher = ").append(TeacherId);
        return sb.toString();
    }
}
