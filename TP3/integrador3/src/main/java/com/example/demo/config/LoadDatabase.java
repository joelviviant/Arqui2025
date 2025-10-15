package com.example.demo.config;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PersonaRepository repository) {
        return args -> {
            repository.save(new Persona(null, "Juan", "Pérez", 30, "juan@gmail.com"));
            repository.save(new Persona(null, "Ana", "López", 25, "ana@gmail.com"));
            repository.save(new Persona(null, "Carlos", "Gómez", 40, "carlos@gmail.com"));
        };
    }
}