package com.sheliming.bookstore.model.service.impl;

import com.sheliming.bookstore.model.service.ICommonService;

import java.io.Serializable;
import java.util.List;

public abstract class CommonServiceImpl<T extends Serializable> implements ICommonService<T> {
    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T findById(int id) {
        return null;
    }

    @Override
    public List<T> findByCondition(String... conditions) {
        return null;
    }

    @Override
    public int save(T t) {
        return 0;
    }
}
