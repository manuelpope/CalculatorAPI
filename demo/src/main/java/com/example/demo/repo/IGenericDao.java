package com.example.demo.repo;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T extends Serializable> {
    IGenericDao setClazz(Class<T> clazzToSet);

    T findOne(final Long id);

    List<T> findAll();

    void create(final T entity);

    void update(final T entity);

    void delete(final T entity);

    void deleteById(final Long entityId);
}