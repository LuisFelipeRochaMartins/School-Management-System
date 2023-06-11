package com.example.sigga.teacher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class TeacherConfig {

    @Bean
    CommandLineRunner commandLineRunner (TeacherRepository repository){
        return args -> {
            Teacher luis = new Teacher(
                    "Luís Felipe Rocha Martins",
                    "luisfelipetochamartins@gmail.com",
                    LocalDate.of(2003, Month.MAY,27)
            );
        };
    }
}
