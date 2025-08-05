package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/wiprotraining"; // change if needed
        String username = "root"; 
        String password = "1234"; 

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }
}
