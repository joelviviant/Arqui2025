package com.example.integradorDemo.controller;

import com.example.integradorDemo.repository.CarreraRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carreras")
public class CarreraController {

    private final CarreraRepository repository;

    public CarreraController(CarreraRepository repository) {
        this.repository = repository;
    }

}