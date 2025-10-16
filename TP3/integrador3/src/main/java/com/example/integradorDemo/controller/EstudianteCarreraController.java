package com.example.integradorDemo.controller;

import com.example.integradorDemo.dto.EstudianteCarreraDTO;
import com.example.integradorDemo.service.EstudianteCarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudianteCarrera")
public class EstudianteCarreraController {

    @Autowired
    private EstudianteCarreraService estudianteCarreraService;
    @GetMapping("")
    public List<EstudianteCarreraDTO> getAll() {
        return estudianteCarreraService.getAll();
    }

    @PostMapping("/inscribir")
    public EstudianteCarreraDTO inscribir(@RequestBody EstudianteCarreraDTO dto) {
        return estudianteCarreraService.inscribirEnCarrera(dto);
    }
}
