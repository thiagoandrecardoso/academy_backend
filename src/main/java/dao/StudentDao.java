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
        }
        return student;
    }

    @Override
    public Student update(Student student) {
        entityManager.getTransaction().begin();
        Student s = null;
        try{
            s = entityManager.merge(student);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return s;
    }
}