package com.ace.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface Connections {

    Connection getConnection() throws ClassNotFoundException, SQLException;

}
