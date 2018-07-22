package com.sheliming.bookstore.model.dao.impl;

import com.sheliming.bookstore.commons.JdbcTemplate;
import com.sheliming.bookstore.model.entity.Consignee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ConsigneeDaoImpl extends CommonDaoImpl<Consignee> {

    @Override
    public int save(Consignee consignee) {
        return JdbcTemplate.update("insert into consignee(account_id,tel,address) values(?,?,?)", new JdbcTemplate.PreparedStatemntSetter() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                pstmt.setInt(1,consignee.getAccountId());
                pstmt.setString(2,consignee.getTel());
                pstmt.setString(3,consignee.getAddress());
            }
        });
    }

    @Override
    public List<Consignee> findByCondition(String... conditions) {
        List<Consignee> consigneeList = JdbcTemplate.query("select * from consignee where account_id = ?", new JdbcTemplate.PreparedStatemntSetter() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                pstmt.setInt(1, Integer.parseInt(conditions[0]));
            }
        }, new JdbcTemplate.RowCallBackHandler<Consignee>() {
            @Override
            public Consignee processRow(ResultSet rs) throws SQLException {
                Consignee consignee = new Consignee();
                consignee.setId(rs.getInt("id"));
                consignee.setAccountId(rs.getInt("account_id"));
                consignee.setTel(rs.getString("tel"));
                consignee.setAddress(rs.getString("address"));
                return consignee;
            }
        });
        return consigneeList;
    }
}
