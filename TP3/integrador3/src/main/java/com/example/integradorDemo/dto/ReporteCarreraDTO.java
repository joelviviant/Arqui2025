package com.example.integradorDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString

public class ReporteCarreraDTO {
    private String nombreCarrera;
    private int anio;
    private long cantidadInscriptos;
    private long cantidadEgresados;
}
