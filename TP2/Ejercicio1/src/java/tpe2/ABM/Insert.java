package tpe1.ABM;

import tpe1.dao.Direccion;
import tpe1.dao.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Insert {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaBasico");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Direccion d = new Direccion("Tandil", "Sarmiento 987");
        em.persist(d);
        Persona j = new Persona(2,"Juan",23,d );
        Persona a = new Persona(1,"Ana",25,d );
        em.persist(j);
        em.persist(a);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
