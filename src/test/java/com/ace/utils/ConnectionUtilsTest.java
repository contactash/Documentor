package com.ace.utils;

import com.mysql.jdbc.Connection;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConnectionUtilsTest {

    @Test
    public void testGetConnection() throws Exception {
        ConnectionUtils connectionUtils = new ConnectionUtils();
        Connection connection = (Connection) connectionUtils.getConnection();
        assertNotNull(connection);
    }
}