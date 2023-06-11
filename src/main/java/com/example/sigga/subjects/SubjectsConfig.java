package com.example.sigga.subjects;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubjectsConfig {
    @Bean
    CommandLineRunner commandLineRunner(SubjectsRepository repository){
        return args -> {
            Subjects matDisc = new Subjects(
                1L,
                1L,
                "Matemática Discreta: Interação. Indução e Recursão. " +
                            "Conjuntos e Relações sobre Conjuntos. Reticulados. " +
                            "Monóides. Grupos. Anéis. Teoria dos Códigos."
            );
        };
    }
}
