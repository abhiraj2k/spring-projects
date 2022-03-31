package com.springboot.springbootdemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class DBConnection {
    static final String url = "jdbc:mysql://localhost:3306/myOrg";
    static final String username = "root";
    static final String password = "abhiraj2k2000";
    static Connection connection;


    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection != null) {
            return connection;
        }
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to Database");
        return connection;
    }
    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}


