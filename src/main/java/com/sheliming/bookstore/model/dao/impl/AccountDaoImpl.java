package com.sheliming.bookstore.model.dao.impl;

import com.sheliming.bookstore.commons.JdbcTemplate;
import com.sheliming.bookstore.model.entity.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl extends CommonDaoImpl<Account> {

    @Override
    public int save(final Account account) {
        String sql = "insert into account(username,password,email) values(?,?,?)";
        int res = JdbcTemplate.update(sql, new JdbcTemplate.PreparedStatemntSetter() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                pstmt.setString(1, account.getUsername());
                pstmt.setString(2, account.getPassword());
                pstmt.setString(3, account.getEmail());
            }
        });
        return res;
    }

    @Override
    public List<Account> findByCondition(final String... conditions) {
        String sql = "select * from account where username=?";

        List<Account> accountList = JdbcTemplate.query(sql, new JdbcTemplate.PreparedStatemntSetter() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                pstmt.setString(1, conditions[0]);
            }
        }, new JdbcTemplate.RowCallBackHandler<Account>() {
            @Override
            public Account processRow(ResultSet rs) throws SQLException {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setEmail(rs.getString("email"));

                return account;
            }
        });

        return accountList;
    }
}
