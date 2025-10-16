package com.example.integradorDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString

public class CarreraInscriptosDTO {
    private String nombreCarrera;
    private Long cantidadInscriptos;
}