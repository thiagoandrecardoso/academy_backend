package main.java.dao;

import main.java.connection.ConnectionFactory;
import main.java.entity.Lesson;

import javax.persistence.EntityManager;

public class LeasonDao {

    public Lesson save(Lesson lesson) {
        EntityManager entityManager = new ConnectionFactory().getConnection();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(lesson);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return lesson;
    }

}
