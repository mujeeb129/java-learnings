package org.example;
import java.sql.*;

public class JDBCStatementFetchExample {

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName(
                    "org.postgresql.Driver"
            );
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:postgresql://localhost:5432/jdbc_demo";
        String username = "postgres";
        String password = "qburst";
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to db");
        String st = "SELECT * FROM users_data";
        PreparedStatement statement = con.prepareStatement(st);
        ResultSet resultSet = statement.executeQuery();

        ResultSetMetaData metaData = resultSet.getMetaData();
        con.close();
        for( int i=1; i<=metaData.getColumnCount(); i++){
            System.out.print(metaData.getColumnLabel(i) + "\t");
        }
        System.out.println();
        while (resultSet.next()){
            System.out.print(resultSet.getString(1) + "\t");
            System.out.print(resultSet.getString(2) + "\t");
            System.out.println(resultSet.getString(3) + "\t");
        }

    }

}
