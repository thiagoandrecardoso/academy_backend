package main.java.dao;

import main.java.entity.Lesson;

public class LessonDao implements SuperDAO<Lesson> {

    @Override
    public boolean save(Class<Lesson> lesson) {
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
    public Lesson search(Long id) {
        Lesson lesson = null;
        try {
            lesson = entityManager.find(Lesson.class, id);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return lesson;
    }
}
