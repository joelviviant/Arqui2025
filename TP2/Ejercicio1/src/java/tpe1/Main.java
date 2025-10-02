package tpe1;

import tpe1.ABM.Select;
import tpe1.dao.Persona;
import tpe1.dao.Turno;
import tpe1.dto.PersonaSocioDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public class Main {
public static void main(String[] args) {
    Select select = new Select();
    //recuperar todas las personas asignadas a un turno
    List<Persona> personas = select.getPersonasPorTurno(2); // cambiamos el id para los distintos turnos
    for (Persona p : personas) {
        System.out.println("Persona en turno: " + p.getNombre());
    }


    //recuperar todas las personas asignadas a un turno, y marcar cuales de ellas son socios.
    List<PersonaSocioDTO> resultados = select.getPersonasYSociosPorTurno(2);
    for (PersonaSocioDTO dto : resultados) {
        System.out.println("Persona: " + dto.getPersona().getNombre() +
                (dto.isEsSocio() ? " (Es socio)" : " (No es socio)"));
    }


    //recuperar todas las personas que viven en una ciudad predeterminada.
    String ciudad = "Tandil";
    List<Persona> personasCiudad = select.getPersonasPorCiudad(ciudad);
    if (personasCiudad.isEmpty()) {
        System.out.println("No se encontraron personas en la ciudad: " + ciudad);
    } else {
        System.out.println("Personas que viven en " + ciudad + ":");
        for (Persona p : personasCiudad) {
            System.out.println("- " + p.getNombre());
        }
    }
    Select.cerrar();
}
}