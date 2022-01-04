package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BasicService {
    protected static EntityManagerFactory entityManagerFactory;
    protected static EntityManager em;
    protected static EntityTransaction transaction;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        em = entityManagerFactory.createEntityManager();
        transaction = em.getTransaction();
    }

    public static void run(){

    }
}
