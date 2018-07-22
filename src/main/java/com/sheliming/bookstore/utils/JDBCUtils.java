package com.sheliming.bookstore.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
    private static DataSource dataSource = null;

    static {
        // dataSource资源只能初始化一次
        dataSource = new ComboPooledDataSource("mvcApp");
    }

    /**
     * 释放连接
     *
     * @param connection
     */
    public static void releaseConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        //connection.setAutoCommit(false);
        return connection;
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static void release(ResultSet rs) {
        if (rs != null) {
            try {
                release(rs.getStatement());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void release(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}