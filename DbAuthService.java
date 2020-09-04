import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbAuthService {
    public static void main(String[] args) {
//        System.out.println(ConnectionTest.checkExistence("l1","p1"));
//        System.out.println(ConnectionTest.getNickname("l1","p1"));
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Driver not found");
//        }
//        Connection conn = null;
//        try {
//           DriverManager.registerDriver(new Driver());
//           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?useSSL=false", "root", null);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Can't register driver!");
//
//        }
//        System.out.println("test");
//        try {
//            Statement statement = conn.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
//            List<Users> users = new ArrayList<>();
//            while (resultSet.next()) {
//                users.add(new Users(
//                                resultSet.getInt("id"),
//                                resultSet.getString("nickname"),
//                                resultSet.getString("login"),
//                                resultSet.getString("password")
//                        )
//                );
//            }  System.out.println(users);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }
    public static boolean checkExistence(String login, String password){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not found");
        }
        Connection conn;
        try {
            DriverManager.registerDriver(new Driver());
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/users?useSSL=false", "root", null
            );

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't register driver!");

        }

        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    String.format("SELECT * FROM users WHERE (login) = '%s' AND (password) = '%s'", login, password)
            );
            int a = 0;
            while (resultSet.next()){
                a = resultSet.getInt("id");
            }
            if(a != 0) {
                return true;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;

    }

    public static Users findUser(String login, String password){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not found");
        }
        Connection conn;
        try {
            DriverManager.registerDriver(new Driver());
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/users?useSSL=false", "root", null
            );

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't register driver!");

        }
        Users user = null;
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    String.format("SELECT * FROM users WHERE (login) = '%s' AND (password) = '%s'", login, password)
            );

            while (resultSet.next()) {
                user = new Users(
                                resultSet.getInt("id"),
                                resultSet.getString("nickname"),
                                resultSet.getString("login"),
                                resultSet.getString("password")
                        );

            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;

    }

    public static String getNickname(String login, String password){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not found");
        }
        Connection conn = null;
        try {
            DriverManager.registerDriver(new Driver());
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?useSSL=false", "root", null);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't register driver!");

        }

        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    String.format("SELECT * FROM users WHERE (login) LIKE '%s' AND (password) LIKE '%s'", login, password)
            );
            String nickname;
            while (resultSet.next()){
                nickname = resultSet.getString("nickname");
                return nickname;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "No user with this login and password";

    }
}
