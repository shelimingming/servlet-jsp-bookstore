package com.sheliming.bookstore.model.service.impl;

import com.sheliming.bookstore.model.dao.DaoFactory;
import com.sheliming.bookstore.model.dao.ICommonDao;
import com.sheliming.bookstore.model.dao.impl.BookDaoImpl;
import com.sheliming.bookstore.model.dao.impl.ImageDaoImpl;
import com.sheliming.bookstore.model.entity.Book;
import com.sheliming.bookstore.model.entity.Image;

import java.util.List;

public class BookServiceImpl extends CommonServiceImpl<Book> {
    @Override
    public List<Book> findAll() {
        BookDaoImpl bookDao = (BookDaoImpl) DaoFactory.getDao("book");
        List<Book> bookList = bookDao.findAll();

        for (Book book : bookList) {
            if (null != book.getImage()) {
                ImageDaoImpl imageDao = (ImageDaoImpl) DaoFactory.getDao("image");
                Image image = imageDao.findById(book.getImage().getId());

                book.setImage(image);
            }
        }

        return bookList;
    }

    @Override
    public Book findById(int id) {
        BookDaoImpl bookDao = (BookDaoImpl) DaoFactory.getDao("book");
        Book book = bookDao.findById(id);

        ImageDaoImpl imageDao = (ImageDaoImpl) DaoFactory.getDao("image");
        Image image = imageDao.findById(book.getImage().getId());

        book.setImage(image);

        return book;
    }
}
