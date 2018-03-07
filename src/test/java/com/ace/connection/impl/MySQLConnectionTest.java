package com.ace.connection.impl;

import com.ace.connection.Connections;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MySQLConnectionTest {
    private Connections mysqlConnection = new MySQLConnection();
    @Mock Connection mockConnection;

    @Before
    public void setUp() {
        //setup
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCreateConnection() throws Exception {
        //execution
        Connection actualConnection = mysqlConnection.getConnection();
        //verification
        assertThat(actualConnection, is(notNullValue()));

    }

    @Test
    public void shouldCloseConnection() throws Exception {
        mysqlConnection.closeConnection(mockConnection);
        verify(mockConnection, times(1)).close();
    }

    @After
    public void tearDown() throws SQLException, ClassNotFoundException {
        mysqlConnection.closeConnection(mysqlConnection.getConnection());
        mysqlConnection = null;
    }

}
