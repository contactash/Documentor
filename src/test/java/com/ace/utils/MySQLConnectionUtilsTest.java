package com.ace.utils;

import com.ace.connection.Connections;
import com.ace.connection.impl.MySQLConnection;
import com.mysql.jdbc.Connection;
import org.junit.Test;

import static org.junit.Assert.*;

public class MySQLConnectionUtilsTest {

    @Test
    public void testGetConnection() throws Exception {
        Connections connections = new MySQLConnection();
        Connection connection = (Connection) connections.getConnection();
        assertNotNull(connection);
    }
}