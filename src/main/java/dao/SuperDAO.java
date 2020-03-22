package main.java.dao;

import main.java.connection.ConnectionFactory;

import javax.persistence.EntityManager;

public interface SuperDAO<T> {
    EntityManager entityManager = new ConnectionFactory().getConnection();

    public abstract boolean save(Class<T> entityType);

    public abstract boolean delete(Long id);

    public abstract T search(Long id);
}
