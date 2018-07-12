package com.sheliming.bookstore.model.dao;

import com.sheliming.bookstore.model.dao.impl.BookDaoImpl;

import java.util.WeakHashMap;

public class DaoFactory {
    private final static WeakHashMap<String,ICommonDao> map = new WeakHashMap<>();

    public static ICommonDao getDao(String name) {
        ICommonDao dao = map.get(name);
        if(dao != null) {
            return dao;
        }
        else {
            return createDao(name);
        }
    }

    private static ICommonDao createDao(String name) {

        ICommonDao dao = null;
        if("book".equals(name)) {
            dao = new BookDaoImpl();
        }
        return dao;
    }
}
