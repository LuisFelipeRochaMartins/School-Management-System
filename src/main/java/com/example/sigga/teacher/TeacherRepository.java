package com.example.sigga.teacher;

import com.example.sigga.person.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface TeacherRepository extends PersonRepository<Teacher> {

}