package com.sheliming.bookstore.model.dao.impl;

import com.sheliming.bookstore.commons.JdbcTemplate;
import com.sheliming.bookstore.model.entity.Book;
import com.sheliming.bookstore.model.entity.Image;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageDaoImpl extends CommonDaoImpl<Image> {
    @Override
    public Image findById(int id) {
        String sql = "select * from image where id=?";
        return JdbcTemplate.singleQuery(sql, new JdbcTemplate.PreparedStatemntSetter() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                pstmt.setInt(1, id);
            }
        }, createHandler());
    }

    private JdbcTemplate.RowCallBackHandler<Image> createHandler() {
        return new JdbcTemplate.RowCallBackHandler<Image>() {
            @Override
            public Image processRow(ResultSet rs) throws SQLException {
                Image image = new Image();
                image.setId(rs.getInt("id"));
                image.setUrl(rs.getString("url"));
                image.setDescription(rs.getString("description"));

                return image;
            }
        };
    }
}
