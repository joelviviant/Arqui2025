package tpe1.ABM;

import tpe1.dao.Direccion;
import tpe1.dao.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Insert {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpe2");
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();
    }
}
