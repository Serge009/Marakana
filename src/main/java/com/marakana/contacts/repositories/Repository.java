package com.marakana.contacts.repositories;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by SERGE on 10.09.2014.
 */
public class Repository<E> {
    private static final EntityManager em = Persistence.createEntityManagerFactory("training").createEntityManager();

    private final Class<E> entityClass;

    public Repository(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public E find(long id) {
        return em.find(entityClass, id);
    }

    public void save(E entity) {
        em.merge(entity);
    }

    public void delete(E entity) {
        em.remove(entity);
    }

    public List<E> findAll(){
        System.out.println(em);
        System.out.println("from " + entityClass.getSimpleName());
        return em.createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
    }
}
