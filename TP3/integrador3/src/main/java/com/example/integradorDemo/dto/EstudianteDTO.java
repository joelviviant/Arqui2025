package com.example.integradorDemo.dto;

import lombok.*;

import java.io.Serializable;
@Data
@AllArgsConstructor
@Builder
@ToString

public class EstudianteDTO implements Serializable {
    private final String nombre;
    private final String apellido;
    private final String genero;
    private final int numeroLibreta;
    private final String ciudad;
}