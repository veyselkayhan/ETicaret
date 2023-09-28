package com.veysel.util;

import java.util.List;

public interface ICrud <T>{
    void save(T entity);

    void update(T entity);

    void delete(long id);

    List<T> findAll();

    T findById(long id);


}
