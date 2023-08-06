package com.example.sigga.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository<T extends Person> extends JpaRepository<T, Long> {

    Optional<T> findPersonByEmail(String email);
}
