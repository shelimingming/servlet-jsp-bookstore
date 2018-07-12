package com.sheliming.bookstore.model.dao.impl;

import com.sheliming.bookstore.model.dao.ICommonDao;

import java.io.Serializable;
import java.util.List;

public abstract class CommonDaoImpl<T extends Serializable> implements ICommonDao<T> {
    @Override
    public int save(T t) {
        return 0;
    }

    @Override
    public int update(T t) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int delete(T t) {
        return 0;
    }

    @Override
    public T findById(int id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public List<T> findByInstance(T t) {
        return null;
    }

    @Override
    public List<T> find(int start, int count, String order) {
        return null;
    }
}
