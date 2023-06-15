package com.example.sigga.department;

import com.example.sigga.teacher.Teacher;
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
            name = "id"
    )
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "id"
    )
    private Teacher TeacherId;

    public Department() {

    }

    public Department(Long id, Teacher teacherId) {
        this.id = id;
        TeacherId = teacherId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(Teacher teacherId) {
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
