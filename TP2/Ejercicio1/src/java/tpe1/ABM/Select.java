package tpe1.ABM;

import tpe1.dao.Direccion;
import tpe1.dao.Persona;
import tpe1.dto.PersonaSocioDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Select {
    private static EntityManagerFactory emf;
    private EntityManager em;

    public Select() {
        emf = Persistence.createEntityManagerFactory("tpe2"); // ⚡ Cambiar al nombre de tu persistence.xml
        em = emf.createEntityManager();
    }

    public List<Persona> getPersonasPorTurno(int idTurno) {
        String jpql = "SELECT p FROM Turno t JOIN t.jugadores p WHERE t.id = :idTurno";
        TypedQuery<Persona> query = em.createQuery(jpql, Persona.class);
        query.setParameter("idTurno", idTurno);
        return query.getResultList();
    }

    public List<PersonaSocioDTO> getPersonasYSociosPorTurno(int idTurno) {
        String jpql = "SELECT new tpe1.dto.PersonaSocioDTO(p, " +
                "CASE WHEN s IS NOT NULL THEN true ELSE false END) " +
                "FROM Turno t " +
                "JOIN t.jugadores p " +
                "LEFT JOIN Socio s ON s.persona.id = p.id " +
                "WHERE t.id = :idTurno";
        TypedQuery<PersonaSocioDTO> query = em.createQuery(jpql, PersonaSocioDTO.class);
        query.setParameter("idTurno", idTurno);
        return query.getResultList();
    }

    public List<Persona> getPersonasPorCiudad(String ciudad) {
        String jpql = "SELECT p " +
                "FROM Persona p " +
                "JOIN p.domicilio d " +
                "WHERE d.ciudad = :ciudad";
        TypedQuery<Persona> query = em.createQuery(jpql, Persona.class);
        query.setParameter("ciudad", ciudad);
        return query.getResultList();
    }


    public static void cerrar(){
        emf.close();
    }
}

