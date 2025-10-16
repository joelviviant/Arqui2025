package com.example.integradorDemo.service;

import com.example.integradorDemo.model.Estudiante;
import com.example.integradorDemo.repository.EstudianteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Transactional
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }
}
