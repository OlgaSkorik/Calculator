package org.example.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


@Configuration
@ComponentScan("org.example")
public class RootConfiguration {
    private static final String URL = "jdbc:mysql://localhost:3306/calc";
    private static final String USER = "root";
    private static final String PASSWORD = "8893960";

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
    @Bean
    public Connection connection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
