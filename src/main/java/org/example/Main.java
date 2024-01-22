package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(url, username, password);
             var stm = conn.prepareStatement("SELECT datname FROM pg_database");) {

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                System.out.printf("%s\n", rs.getString(1));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Properties getProperties() {
        String path = String.format("src/main/resources/db.properties", System.getProperty("user.dir"));
        Properties properties = new Properties();

        try (InputStream is = new FileInputStream(new File(path))) {
            properties.load(is);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        return properties;
    }

}