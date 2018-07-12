package com.sheliming.bookstore.model.dao.impl;

import com.sheliming.bookstore.model.dao.DaoFactory;
import com.sheliming.bookstore.model.dao.ICommonDao;
import com.sheliming.bookstore.model.entity.Book;
import org.junit.Test;

import java.util.List;

public class BookDaoImplTest {
    @Test
    public void findAllTest() {
        ICommonDao bookDao = DaoFactory.getDao("book");
        List<Book> bookAll = bookDao.findAll();
        for (Book book : bookAll) {
            System.out.println(book);
        }
    }
}
