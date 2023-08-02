package com.example.sigga.person;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Person {
    @Id
    @SequenceGenerator(
            name           = "person_sequence",
            sequenceName   = "person_sequence",
            allocationSize = 1
    )

    @GeneratedValue (
            strategy  = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )

    @Column(
            name = "person_id",
            nullable = false,
            updatable = false
    )
    private Long id;

    @Column(
            name     = "person_name",
            nullable = false
    )
    private String name;

    @Column(
            name     = "person_email",
            nullable = false
    )
    private String email;

    @Column(
            name = "person_datebirth"
    )
    private LocalDate dob;

    private Integer age;

    /**
     * Retorna o Id da Pessoa
     *
     * @return Long - Id da Pessoa.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o id da Pessoa.
     *
     * @param id Long - Id da pessoa
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o nome da Pessoa.
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome da Pessoa
     *
     * @param name String - Nome da Pessoa.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o email da Pessoa.
     *
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o Email da Pessoa
     *
     * @param email String - Email da Pessoa.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna a data de Nascimento da Pessoa.
     *
     * @return LocalDate - Data de Nascimento da Pessoa
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * Define a data de Nascimento da Pessoa.
     *
     * @param dob
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    /**
     * Retorna a idade da Pessoa.
     *
     * @return Integer - Idade da Pessoa
     */
    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    /**
     * Define a Idade da Pessoa.
     *
     * @param age Integer
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Id = ").append(id).append('\n');
        sb.append("Nome: = ").append(name).append('\n');
        sb.append("Email: = ").append(email).append('\n');
        sb.append("Data de Nascimento: = ").append(dob).append('\n');
        sb.append("Email: = ").append(dob).append('\n');
        return sb.toString();
    }
}
