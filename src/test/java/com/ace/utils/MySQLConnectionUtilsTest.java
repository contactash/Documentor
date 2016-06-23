package com.ace.utils;

import com.ace.connection.impl.MySQLConnection;
import com.mysql.jdbc.Connection;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MySQLConnectionUtilsTest {

    private MySQLConnection mySQLConnection;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mySQLConnection = new MySQLConnection();
    }

    @Test
    public void testGetConnection() throws Exception {
        Connection actualResult = (Connection) mySQLConnection .getConnection();
        assertThat(actualResult, is(instanceOf(Connection.class)));
    }

}
