package com.example.integradorDemo.controller;

import com.example.integradorDemo.dto.EstudianteDTO;
import com.example.integradorDemo.model.Estudiante;
import com.example.integradorDemo.service.EstudianteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public List<Estudiante> findAll() {
        return estudianteService.findAll();
    }
    //Dar de alta un estudiante
    @PostMapping("/alta")
    public Estudiante crearEstudiante(@RequestBody EstudianteDTO dto) {
        return estudianteService.crearEstudiante(dto);
    }

}
