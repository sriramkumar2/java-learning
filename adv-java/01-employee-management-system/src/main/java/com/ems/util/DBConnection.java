package com.ems.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Reads database credentials from src/main/resources/db.properties
 * (not committed to git) or from environment variables
 * DB_URL, DB_USERNAME, DB_PASSWORD, which take priority.
 * See db.properties.example for the expected format.
 */
public class DBConnection {

    private static final Properties PROPS = loadProperties();

    private static Properties loadProperties() {
        Properties props = new Properties();
        try (InputStream in = DBConnection.class.getClassLoader()
                .getResourceAsStream("db.properties")) {
            if (in != null) {
                props.load(in);
            }
        } catch (IOException e) {
            System.err.println("Could not read db.properties: " + e.getMessage());
        }
        return props;
    }

    private static String get(String envKey, String propKey) {
        String value = System.getenv(envKey);
        return (value != null && !value.isEmpty()) ? value : PROPS.getProperty(propKey);
    }

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL Driver Loaded Successfully!");

        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver Not Found!", e);
        }

        String url = get("DB_URL", "db.url");
        String username = get("DB_USERNAME", "db.username");
        String password = get("DB_PASSWORD", "db.password");

        if (url == null || username == null || password == null) {
            throw new SQLException("Database settings missing. Create "
                    + "src/main/resources/db.properties (see db.properties.example) "
                    + "or set DB_URL, DB_USERNAME, DB_PASSWORD.");
        }

        return DriverManager.getConnection(url, username, password);
    }
}
