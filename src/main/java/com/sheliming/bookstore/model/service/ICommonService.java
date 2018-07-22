package com.sheliming.bookstore.model.service;

import java.io.Serializable;
import java.util.List;

public interface ICommonService<T extends Serializable> {

    List<T> findAll();

    T findById(int id);

    List<T> findByCondition(String... conditions);

    int save(T t);
}
