import com.mysql.jdbc.Driver;

import java.sql.*;

public class DbConnection {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not found");
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/users?useSSL=false", "root", null
            );

        } catch (SQLException throwables) {
            throw new RuntimeException("Connection getting error");
        }
    }
}
