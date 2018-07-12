package com.sheliming.bookstore.model.dao.impl;

import com.sheliming.bookstore.commons.JdbcTemplate;
import com.sheliming.bookstore.model.entity.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl extends CommonDaoImpl<Book> {
    @Override
    public List<Book> findAll() {
        return JdbcTemplate.query("select * from book", createHandler());
    }

    @Override
    public Book findById(final int id) {
        String sql = "select * from book where id=?";
        return JdbcTemplate.singleQuery(sql, new JdbcTemplate.PreparedStatemntSetter() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                pstmt.setInt(1, id);
            }
        }, createHandler());
    }

    private JdbcTemplate.RowCallBackHandler<Book> createHandler() {
        return new JdbcTemplate.RowCallBackHandler<Book>() {
            @Override
            public Book processRow(ResultSet rs) throws SQLException {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setDescription(rs.getString("description"));
                book.setPrice(rs.getDouble("price"));

                return book;
            }
        };
    }

}
