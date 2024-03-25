package com.Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(fileName)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            // You might want to handle this exception in a better way, like logging it
        }
        return properties;
    }

    public static String getPropertyString(Properties properties, String key) {
        return properties.getProperty(key);
    }
}
