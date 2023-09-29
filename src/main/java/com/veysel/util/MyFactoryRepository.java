package com.veysel.util;

import com.sun.xml.bind.v2.model.core.ID;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class MyFactoryRepository <T,ID> implements ICrud <T, ID>{


    private Session session;

    private Transaction transaction;



    private void openSession(){
        session= HibernateUtility.getSessionFactory().openSession();
        transaction=session.beginTransaction();
    }

    private void closeSession(){
        transaction.commit();
        session.close();
    }


    @Override
    public T save(T entity) {
        return null;
    }

    @Override
    public Iterable saveAll(Iterable<T> entites) {
        return null;
    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public void deleteById(ID id) {

    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.empty();
    }

    @Override
    public boolean existById(ID id) {
        return false;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public List<T> findByEntity(T entity) {
        return null;
    }

    @Override
    public List<T> findByColumnNameAndValue(String columnName, String value) {
        return null;
    }
}
