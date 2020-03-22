package main.java.dao;

import main.java.entity.Student;

public class StudentDao implements SuperDAO<Student> {

    @Override
    public boolean save(Class<Student> entityType) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Student search(Long id) {
        return null;
    }
}
