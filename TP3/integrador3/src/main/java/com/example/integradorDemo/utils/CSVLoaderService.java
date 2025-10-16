package com.example.integradorDemo.utils;

import com.example.integradorDemo.model.Carrera;
import com.example.integradorDemo.model.Estudiante;
import com.example.integradorDemo.model.EstudianteCarrera;
import com.example.integradorDemo.repository.CarreraRepository;
import com.example.integradorDemo.repository.EstudianteCarreraRepository;
import com.example.integradorDemo.repository.EstudianteRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;

@Service
public class CSVLoaderService {

    private static final String CARRERAS_CSV = "src/main/resources/carreras.csv";
    private static final String ESTUDIANTES_CSV = "src/main/resources/estudiantes.csv";
    private static final String ESTUDIANTE_CARRERA_CSV = "src/main/resources/estudianteCarrera.csv";

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private EstudianteCarreraRepository estudianteCarreraRepository;

    public void populateDB() {
        System.out.println("📥 Insertando datos en la base...");
        processEstudiantes();
        processCarreras();
        processEstudianteCarrera();
        System.out.println("✅ Datos insertados correctamente.");
    }

    private void processEstudiantes() {
        System.out.println("Insertando estudiantes...");
        try (CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(ESTUDIANTES_CSV))) {
            for (CSVRecord row : parser) {
                try {
                    Estudiante estudiante = new Estudiante();
                    estudiante.setDni(Integer.parseInt(row.get("DNI")));
                    estudiante.setNombre(row.get("nombre"));
                    estudiante.setApellido(row.get("apellido"));
                    estudiante.setEdad(Integer.parseInt(row.get("edad")));
                    estudiante.setGenero(row.get("genero"));
                    estudiante.setCiudad(row.get("ciudad"));
                    estudiante.setNumeroLibreta(Integer.parseInt(row.get("LU")));
                    estudianteRepository.save(estudiante);
                } catch (RuntimeException e) {
                    System.out.println("❌ Error al persistir estudiante: " + e.getMessage());
                    System.out.println("Record: " + row.toString());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo estudiantes.csv: " + e.getMessage(), e);
        }
    }

    private void processCarreras() {
        System.out.println("Insertando carreras...");
        try (CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(CARRERAS_CSV))) {
            for (CSVRecord row : parser) {
                try {
                    Carrera carrera = new Carrera();
                    carrera.setId(Integer.parseInt(row.get("id_carrera")));
                    carrera.setNombre(row.get("carrera"));
                    carrera.setDuracion(Integer.parseInt(row.get("duracion")));
                    carreraRepository.save(carrera);
                } catch (RuntimeException e) {
                    System.out.println("❌ Error al persistir carrera: " + e.getMessage());
                    System.out.println("Record: " + row.toString());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo carreras.csv: " + e.getMessage(), e);
        }
    }

    private void processEstudianteCarrera() {
        System.out.println("Insertando estudiante_carrera...");
        try (CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(ESTUDIANTE_CARRERA_CSV))) {
            for (CSVRecord row : parser) {
                try {
                    EstudianteCarrera ec = new EstudianteCarrera();

                    Estudiante estudiante = new Estudiante();
                    estudiante.setDni(Integer.parseInt(row.get("id_estudiante")));
                    ec.setEstudiante(estudiante);

                    Carrera carrera = new Carrera();
                    carrera.setId(Integer.parseInt(row.get("id_carrera")));
                    ec.setCarrera(carrera);

                    ec.setId(Integer.parseInt(row.get("id")));
                    ec.setInscripcion(Integer.parseInt(row.get("inscripcion")));
                    ec.setGraduacion(Integer.parseInt(row.get("graduacion")));
                    ec.setAntiguedad(Integer.parseInt(row.get("antiguedad")));

                    estudianteCarreraRepository.save(ec);
                } catch (RuntimeException e) {
                    System.out.println("❌ Error al persistir estudiante_carrera: " + e.getMessage());
                    System.out.println("Record: " + row.toString());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo estudianteCarrera.csv: " + e.getMessage(), e);
        }
    }
}
