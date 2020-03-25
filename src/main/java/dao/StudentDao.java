package main.java.dao;

import main.java.entity.Student;

public class StudentDao implements SuperDAO<Student> {

    @Override
    public boolean save(Student student) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return false;
    }


    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Student findById(Long id) {
        Student student = null;
        try {
            student = entityManager.find(Student.class, id);
        } catch (Exception e) {
            System.out.println("erro ao buscar por id\n" + e);
        } finally {
            entityManager.close();
        }
        return student;
    }

    @Override
    public Student update(Student student) {
        try {
            entityManager.getTransaction().begin();
            if (student.getId() == null) {
                entityManager.persist(student);
            } else {
                entityManager.merge(student);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return student;
    }
}
