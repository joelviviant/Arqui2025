package com.example.integradorDemo.service;

import com.example.integradorDemo.dto.EstudianteCarreraDTO;
import com.example.integradorDemo.model.Carrera;
import com.example.integradorDemo.model.Estudiante;
import com.example.integradorDemo.model.EstudianteCarrera;
import com.example.integradorDemo.repository.CarreraRepository;
import com.example.integradorDemo.repository.EstudianteCarreraRepository;
import com.example.integradorDemo.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteCarreraService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private EstudianteCarreraRepository estudianteCarreraRepository;

    public EstudianteCarreraDTO inscribirEnCarrera(EstudianteCarreraDTO dto) {
        // Buscar estudiante y carrera según los datos que vienen
        Estudiante estudiante = estudianteRepository.findByNumeroLibreta(dto.getLibretaEstudiante())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));



        Carrera carrera = carreraRepository.findById((long) dto.getIdCarrera())
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        EstudianteCarrera nueva = EstudianteCarrera.builder()
                .inscripcion(dto.getInscripcion())
                .graduacion(dto.getGraduacion())
                .antiguedad(dto.getAntiguedad())
                .estudiante(estudiante)
                .carrera(carrera)
                .build();


        EstudianteCarrera guardado = estudianteCarreraRepository.save(nueva);

        // Devolver el DTO completo con datos del estudiante y carrera
        return new EstudianteCarreraDTO(
                guardado.getId(),
                guardado.getInscripcion(),
                guardado.getGraduacion(),
                guardado.getAntiguedad(),
                carrera.getId(),
                estudiante.getDni(),
                estudiante.getNombre(),
                carrera.getNombre(),
                estudiante.getApellido(),
                estudiante.getGenero(),
                estudiante.getNumeroLibreta()
        );
    }
    public List<EstudianteCarreraDTO> getAll() {
        return estudianteCarreraRepository.findAll()
                .stream()
                .map(ec -> new EstudianteCarreraDTO(
                        ec.getId(),
                        ec.getInscripcion(),
                        ec.getGraduacion(),
                        ec.getAntiguedad(),
                        ec.getCarrera().getId(),
                        ec.getEstudiante().getDni(),
                        ec.getEstudiante().getNombre(),
                        ec.getCarrera().getNombre(),
                        ec.getEstudiante().getApellido(),
                        ec.getEstudiante().getGenero(),
                        ec.getEstudiante().getNumeroLibreta()
                ))
                .collect(Collectors.toList());
    }
}
