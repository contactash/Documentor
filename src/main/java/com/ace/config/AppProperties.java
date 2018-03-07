package com.ace.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {
    private static InputStream inputStream;

     public static Properties getPropertyValues() throws IOException {
         Properties prop = null;
         try {
             prop = new Properties();
             String propFileName = "config.properties";

             inputStream = AppProperties.class.getClassLoader().getResourceAsStream(propFileName);

             if (inputStream != null) {
                 prop.load(inputStream);
             } else {
                 throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
             }

         } catch (Exception e) {
             System.out.println("Exception: " + e);
         } finally {
             inputStream.close();
         }
         return prop;
     }
}
