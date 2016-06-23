package com.ace.utils;

import com.ace.connection.impl.MySQLConnection;
import com.mysql.jdbc.Connection;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MySQLConnectionUtilsTest {

    @Mock MySQLConnection mockMySQLConnection;
    @Mock Connection mockConnection;
    private MySQLConnection mySQLConnection = new MySQLConnection();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetConnection() throws Exception {
        Mockito.when(mockMySQLConnection.getConnection()).thenReturn(mockConnection);
        Connection result = (Connection) mySQLConnection .getConnection();
        assertThat(result, is(mockConnection));
    }

}
