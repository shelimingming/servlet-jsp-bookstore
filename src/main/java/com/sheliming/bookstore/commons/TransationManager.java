package com.sheliming.bookstore.commons;

import com.sheliming.bookstore.utils.JDBCUtils;

import java.sql.SQLException;

public final class TransationManager {
    public static void begin() {
        try {
            JDBCUtils.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            throw new TransationException();
        }
    }

    public static void commit() {
        try {
            JDBCUtils.getConnection().commit();
        } catch (SQLException e) {
            throw new TransationException();
        }
    }

    public static void rollback() {
        try {
            JDBCUtils.getConnection().rollback();
        } catch (SQLException e) {
            throw new TransationException();
        }
    }

    public static class TransationException extends RuntimeException {

        public TransationException() {
            super();
        }

        public TransationException(String message) {
            super(message);
        }

        public TransationException(String message, Throwable cause) {
            super(message, cause);
        }

        public TransationException(Throwable cause) {
            super(cause);
        }

        protected TransationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}
