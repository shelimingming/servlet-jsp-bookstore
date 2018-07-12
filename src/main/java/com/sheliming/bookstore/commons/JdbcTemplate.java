package com.sheliming.bookstore.commons;

import com.sheliming.bookstore.utils.JDBCUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class JdbcTemplate {
    public static <T> List<T> query(String sql, RowCallBackHandler<T> handler) {
        return query(sql, null, handler);
    }


    public static <T> List<T> query(String sql, PreparedStatemntSetter setter, RowCallBackHandler<T> handler) {
        ResultSet rs = null;
        List<T> list = null;
        try {
            rs = query(sql, setter);
            if (null != handler) {
                list = new ArrayList<>();
                while (rs.next()) {
                    list.add(handler.processRow(rs));
                }
            }
        } catch (SQLException e) {
            throw new JdbcTemplateException(e);
        } finally {
            JDBCUtils.release(rs);
        }
        return list;
    }

    public static <T> T singleQuery(String sql, RowCallBackHandler<T> handler) {
        return singleQuery(sql, null, handler);
    }

    public static <T> T singleQuery(String sql, PreparedStatemntSetter setter, RowCallBackHandler<T> handler) {
        ResultSet rs = null;
        try {
            rs = query(sql, setter);
            if (null != handler && rs.next()) {
                return handler.processRow(rs);
            }
        } catch (SQLException e) {
            throw new JdbcTemplateException(e);
        } finally {
            JDBCUtils.release(rs);
        }
        return null;
    }

    private static ResultSet query(String sql, PreparedStatemntSetter setter) throws SQLException {
        PreparedStatement pstmt = JDBCUtils.getConnection().prepareStatement(sql);
        if (null != setter) {
            setter.setValues(pstmt);
        }
        return pstmt.executeQuery();
    }

    public static int[] batchUpdate(String sql, PreparedStatemntSetter... setters) {
        PreparedStatement pstmt = null;
        try {
            pstmt = JDBCUtils.getConnection().prepareStatement(sql);
            for (PreparedStatemntSetter setter : setters) {
                setter.setValues(pstmt);
            }
            return pstmt.executeBatch();
        } catch (SQLException e) {
            throw new JdbcTemplateException(e);
        } finally {
            JDBCUtils.release(pstmt);
        }
    }


    public static int update(String sql, PreparedStatemntSetter setter) {
        PreparedStatement pstmt = null;
        try {
            pstmt = JDBCUtils.getConnection().prepareStatement(sql);
            if (null != pstmt) {
                setter.setValues(pstmt);
            }
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new JdbcTemplateException(e);
        } finally {
            JDBCUtils.release(pstmt);
        }
    }

    public static class JdbcTemplateException extends RuntimeException {
        public JdbcTemplateException() {
            super();
        }

        public JdbcTemplateException(String message) {
            super(message);
        }

        public JdbcTemplateException(String message, Throwable cause) {
            super(message, cause);
        }

        public JdbcTemplateException(Throwable cause) {
            super(cause);
        }

        protected JdbcTemplateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }

    public static interface PreparedStatemntSetter {
        void setValues(PreparedStatement pstmt) throws SQLException;
    }

    public static interface RowCallBackHandler<T> {
        T processRow(ResultSet rs) throws SQLException;
    }
}
