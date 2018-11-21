package com.sheliming.bookstore.utils;

import java.sql.*;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sheliming.bookstore.utils.pool.PoolConnection;
import com.sheliming.bookstore.utils.pool.PoolManager;

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
        // 1.使用c3p0数据源
        // Connection connection = dataSource.getConnection();


        // 2.使用基本的连接
//        String driverName ="com.mysql.jdbc.Driver";
//        String URL = "jdbc:mysql://localhost:3306/servlet_jsp_bookstore?useUnicode=true&serverTimezone=UTC&characterEncoding=UTF-8";
//        String username = "root";
//        String password = "123456";
//        //加载驱动
//        try {
//            Driver.class.forName(driverName);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        //建立连接
//        Connection connection = DriverManager.getConnection(URL,username,password);


        //3.使用自己的连接池
        Connection connection = PoolManager.getInstance().getConnection().getConn();

        connection.setAutoCommit(false);
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