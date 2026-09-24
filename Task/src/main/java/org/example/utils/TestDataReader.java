package org.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * TestDataReader - Reads test data from properties file
 */
public class TestDataReader {
    private static Properties properties;
    
    static {
        properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/test/resources/testdata.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            System.err.println("Error loading test data file: " + e.getMessage());
        }
    }
    
    public static String getFirstName() {
        return properties.getProperty("firstName");
    }
    
    public static String getLastName() {
        return properties.getProperty("lastName");
    }
    
    public static String getPhoneNumber() {
        return properties.getProperty("phoneNumber");
    }
    
    public static String getAddress() {
        return properties.getProperty("address");
    }
    
    public static String getEmail() {
        return properties.getProperty("email");
    }
}

