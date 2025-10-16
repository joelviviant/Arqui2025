package com.example.integradorDemo.controller;

import com.example.integradorDemo.repository.EstudianteCarreraRepository;
import com.example.integradorDemo.repository.EstudianteRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas")
public class EstudianteCarreraController {

    private final EstudianteCarreraRepository repository;

    public EstudianteCarreraController(EstudianteCarreraRepository repository) {
        this.repository = repository;
    }

}