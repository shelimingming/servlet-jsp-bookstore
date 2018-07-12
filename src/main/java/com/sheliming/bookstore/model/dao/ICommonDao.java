package com.sheliming.bookstore.model.dao;

import java.io.Serializable;
import java.util.List;

public interface ICommonDao<T extends Serializable> {
    int save(T t);

    int update(T t);

    int delete(int id);

    int delete(T t);

    T findById(int t);

    List<T> findAll();

    List<T> findByInstance(T t);

    List<T> find(int start, int count, String order);

}
