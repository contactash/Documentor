package com.ace.utils;

import com.ace.constants.DBConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName(DBConstants.DB_DRIVER);
        return DriverManager.getConnection(DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);

    }
}
