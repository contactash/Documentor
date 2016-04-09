package com.ace.connection.impl;

import com.ace.connection.Connections;
import com.ace.constants.DBConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection implements Connections {

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName(DBConstants.DB_DRIVER);
        return DriverManager.getConnection(DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);

    }

    public void closeConnection(Connection conn) {
        try {
            System.out.println("gotya"+ conn);
            if (conn != null) {
                conn.close();
                System.out.println("shendi"+ conn);
                conn = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }

}
