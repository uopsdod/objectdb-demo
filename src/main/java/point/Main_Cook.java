package point;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Main_Cook {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("/Users/stsai/Desktop/points007.odb");
        EntityManager em = emf.createEntityManager();

        // Store 1000 Cook objects in the database:
        em.getTransaction().begin();
        for (int i = 1000; i < 1500; i++) {
            Cook c = new Cook(i, i, i);
            em.persist(c);
        }
        em.getTransaction().commit();

        // Find the number of Cook objects in the database:
        Query q1 = em.createQuery("SELECT COUNT(c) FROM Cook c");
        System.out.println("Total Cooks: " + q1.getSingleResult());

        // Find the average X value:
        Query q2 = em.createQuery("SELECT AVG(c.x) FROM Cook c");
        System.out.println("Average X: " + q2.getSingleResult());

        // Retrieve all the Cook objects from the database:
        TypedQuery<Cook> query =
            em.createQuery("SELECT c FROM Cook c", Cook.class);
        List<Cook> results = query.getResultList();
        for (Cook c : results) {
            System.out.println(c);
        }

        // Close the database connection:
        em.close();
        emf.close();
    }
}