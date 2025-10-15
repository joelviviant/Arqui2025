package com.example.integradorDemo.controller;

import com.example.integradorDemo.model.Estudiante;
import com.example.integradorDemo.repository.PersonaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class EstudianteController {

    private final PersonaRepository repository;

    public EstudianteController(PersonaRepository repository) {
        this.repository = repository;
    }

}