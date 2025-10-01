package tpe1;

import tpe1.dao.Persona;
import tpe1.dao.Turno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpe2");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
       Persona persona = new Persona();
       persona.setNombre("Ana");
       em.persist(persona);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}