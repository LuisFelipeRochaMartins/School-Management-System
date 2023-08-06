package com.example.sigga.student;

import com.example.sigga.person.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Transactional
@Repository
public interface StudentRepository extends PersonRepository<Student> {

 }
