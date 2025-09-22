package tpe1.ABM;

import tpe1.dao.Direccion;
import tpe1.dao.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Select {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaBasico");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Persona j = em.find(Persona.class,2);
        System.out.println(j);
        List<Persona> personas = em.createQuery("SELECT p FROM Persona p").getResultList();
        personas.forEach(System.out::println);
        em.persist(j);
        em.getTransaction().commit();
        em.close();
        emf.close();
    } }

