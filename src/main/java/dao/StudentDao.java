package main.java.dao;

import main.java.connection.ConnectionFactory;
import main.java.entity.Student;

import javax.persistence.EntityManager;

public class StudentDao {

    public Student save(Student student) {
        EntityManager entityManager = new ConnectionFactory().getConnection();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        } catch (Exception w) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return student;
    }
}
