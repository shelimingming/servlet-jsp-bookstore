package com.sheliming.bookstore.utils;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtilsTest {


    @Test
    public void test4() {
        try {
            Connection con = JDBCUtils.getConnection(); // 声明Connection对象
            PreparedStatement sql = con.prepareStatement("select * from book"); // 声明PreparedStatement对象
            ResultSet res = sql.executeQuery(); // 声明ResultSet对象
            while (res.next()) {
                System.out.println(res.getString(1) + "---" + res.getString(2) + "---" + res.getString(3));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
