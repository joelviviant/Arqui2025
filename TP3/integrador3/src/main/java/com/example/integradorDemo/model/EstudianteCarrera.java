package com.example.integradorDemo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstudianteCarrera {
    @Id
    private int id;
    private int inscripcion;
    private int graduacion;
    private int antiguedad;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idEstudiante" , referencedColumnName = "dni")
    private Estudiante estudiante;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idCarerra" , referencedColumnName = "id")
    private Carrera carrera;
}
