package org.example;


//LOAD the packages

import java.sql.*;

public class JDBCCreateUpdate {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/jdbc_demo";
        String username = "postgres";
        String password = "qburst";
        // Establish connections
        try (Connection con = DriverManager.getConnection(url, username, password);) {
            System.out.println("Connected to db");

            String name1 = "Mj";
            int age1 = 23;
            String name2 = "Rj";
            int age2 = 24;
            String sql = "INSERT INTO users_data(name, age) VALUES (?, ?), (?, ?)";
            //String sql = "DELETE FROM users_data";
            
            // Create statement
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, name1);
            preparedStatement.setInt(2, age1);
            preparedStatement.setString(3, name2);
            preparedStatement.setInt(4, age2);

            int x = preparedStatement.executeUpdate();
            System.out.println(x);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
