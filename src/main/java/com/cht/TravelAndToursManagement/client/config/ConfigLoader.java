package com.cht.TravelAndToursManagement.client.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final Properties PROPS = new Properties();

    static {
        try (InputStream inputStream = ConfigLoader.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (inputStream == null) {
                throw new RuntimeException("application.properties file not found");
            }
            PROPS.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config", e);
        }
    }

    private ConfigLoader() {
    }

    public static String get(String key) {
        return PROPS.getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }
}
