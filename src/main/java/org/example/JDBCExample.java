package org.example;
import java.sql.*;

public class JDBCExample {

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName(
                    "org.postgresql.Driver"
            );
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:postgresql://localhost:5432/production_neo_be";
        String username = "postgres";
        String password = "qburst";
        Connection con = DriverManager.getConnection(url, username, password);
        String st = "SELECT * FROM neo_app_candidateprofile where id=19";
        PreparedStatement statement = con.prepareStatement(st);
        ResultSet x = statement.executeQuery();
        x.next();

        System.out.println(x.getRow());
        con.close();
        System.out.println(x.getString("neo_status"));
    }

}
