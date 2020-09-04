import com.mysql.jdbc.Driver;

import java.sql.*;

public class DbAuthService {

//    public static boolean checkExistence(String login, String password){
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Driver not found");
//        }
//        Connection conn;
//        try {
//            DriverManager.registerDriver(new Driver());
//            conn = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/users?useSSL=false", "root", null
//            );
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Can't register driver!");
//
//        }
//
//        try {
//            Statement statement = conn.createStatement();
//            ResultSet resultSet = statement.executeQuery(
//                    String.format("SELECT * FROM users WHERE (login) = '%s' AND (password) = '%s'", login, password)
//            );
//            int a = 0;
//            while (resultSet.next()){
//                a = resultSet.getInt("id");
//            }
//            if(a != 0) {
//                return true;
//            }
//
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        try {
//            conn.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return false;
//
//    }

    public User findUser(String login, String password){
        Connection conn = DbConnection.getConnection();
        try {
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM users WHERE login = ? AND password = ?");
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new User(
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
        return null;
    }
}
