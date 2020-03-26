package main.java.dao;

import main.java.entity.Lesson;
import main.java.entity.Student;

import java.awt.*;

public class LessonDao implements SuperDAO<Lesson> {

    @Override
    public boolean save(Lesson lesson) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(lesson);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return true;
    }

    @Override
    public boolean delete(Long id) {
        try {
            entityManager.getTransaction().begin();
            Lesson lesson = entityManager.find(Lesson.class, id);
            entityManager.remove(lesson);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return true;
    }

    @Override
    public Lesson findById(Long id) {
        Lesson lesson = null;
        try {
            lesson = entityManager.find(Lesson.class, id);
        } catch (Exception e) {
            System.out.println("erro ao buscar por id\n" + e);
        }
        return lesson;
    }

    @Override
    public Lesson update(Lesson lesson) {
        entityManager.getTransaction().begin();
        Lesson l = null;
        try {
            l = entityManager.merge(lesson);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return l;
    }

//    public List<Student> getListStudent(){
//
//    }
}
