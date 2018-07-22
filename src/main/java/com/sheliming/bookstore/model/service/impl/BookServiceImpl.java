package com.sheliming.bookstore.model.service.impl;

import com.sheliming.bookstore.model.dao.DaoFactory;
import com.sheliming.bookstore.model.dao.ICommonDao;
import com.sheliming.bookstore.model.dao.impl.BookDaoImpl;
import com.sheliming.bookstore.model.entity.Book;

import java.util.List;

public class BookServiceImpl extends CommonServiceImpl<Book> {
    @Override
    public List<Book> findAll() {
        BookDaoImpl bookDao = (BookDaoImpl) DaoFactory.getDao("book");
        return bookDao.findAll();
    }

    @Override
    public Book findById(int id) {
        BookDaoImpl bookDao = (BookDaoImpl) DaoFactory.getDao("book");
        return bookDao.findById(id);
    }
}
