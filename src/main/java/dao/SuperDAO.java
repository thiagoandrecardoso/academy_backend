package main.java.dao;

import main.java.connection.ConnectionFactory;

import javax.persistence.EntityManager;

public interface SuperDAO<T> {
    EntityManager entityManager = new ConnectionFactory().getConnection();

    boolean save(T entityType);

    boolean delete(Long id);

    T findById(Long id);

    T update(T entityType);
}
