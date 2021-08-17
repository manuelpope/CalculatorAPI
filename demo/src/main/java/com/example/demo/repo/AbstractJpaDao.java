package com.example.demo.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractJpaDao<T extends Serializable> {

    @PersistenceContext
    EntityManager entityManager;
    private Class<T> clazz;

    public IGenericDao<T> setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
        return (IGenericDao<T>) this;
    }

    @Transactional
    public T findOne(Long id) {
        return entityManager.find(clazz, id);
    }

    @Transactional
    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName())
                .getResultList();
    }

    @Transactional
    public void create(T entity) {
        entityManager.persist(entity);
    }


    @Transactional
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Transactional
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Transactional
    public void deleteById(Long entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }
}