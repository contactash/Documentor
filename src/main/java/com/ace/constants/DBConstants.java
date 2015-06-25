package com.ace.constants;

public class DBConstants {
    public static final String DB_DRIVER ="com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost/classicmodels";
    public static final String USER = "ash";
    public static final String PASSWORD = "password";
    public static final String QUERY = "QUERY";
    public static final String QUERY_VALUE = "select productCode, productName, productLine, productScale, productVendor from products LIMIT 3";
}
