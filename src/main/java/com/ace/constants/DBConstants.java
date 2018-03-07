package com.ace.constants;

import com.ace.config.AppProperties;

import java.io.IOException;

public class DBConstants {
    public static final String DB_DRIVER = getProperty("DB_DRIVER");
    public static final String DB_URL = getProperty("DB_URL");
    public static final String USER = getProperty("USER");
    public static final String PASSWORD = getProperty("PASSWORD");
    public static final String QUERY = "QUERY";

    private static String getProperty(String propertyName) {
        String dbDriver = null;
        try {
            dbDriver = AppProperties.getPropertyValues().getProperty(propertyName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dbDriver;
    }

}
