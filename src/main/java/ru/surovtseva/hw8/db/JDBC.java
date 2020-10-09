package ru.surovtseva.hw8.db;

import ru.surovtseva.hw8.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBC {

    public static List<User> getUsersInfo (Connection connection) throws SQLException {
        List<User> users = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM user");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getInt("age"));
            user.setEmail(resultSet.getString("email"));
            users.add(user);
        }
//        System.out.println(users);
        statement.close();
        resultSet.close();
        return users;
    }

    public static List<User> showUsersByAge(Connection connection, int min, int max) throws SQLException {
        List<User> users = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM user WHERE age BETWEEN ? AND ?");
        statement.setInt(1,min);
        statement.setInt(2,max);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getInt("age"));
            user.setEmail(resultSet.getString("email"));
            users.add(user);
        }
//        System.out.println(users);
        statement.close();
        resultSet.close();
        return users;
    }

    public static void addUser(Connection connection,String str) throws SQLException {
        String[] values = str.split("\\s");
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO user (name, age, email) VALUES (?,?,?)");
        statement.setString(1,values[0]);
        statement.setInt(2, Integer.parseInt(values[1]));
        statement.setString(3,values[2]);
        statement.executeUpdate();
        statement.close();
    }

    //В базе поле name уникально
    public static User searchUserByName (Connection connection, String str) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM user WHERE name=?");
        statement.setString(1,str);
        ResultSet resultSet = statement.executeQuery();
        User user = new User();
        if (resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getInt("age"));
            user.setEmail(resultSet.getString("email"));
        } else {
            user = null;
        }
        statement.close();
        resultSet.close();
        return user;
    }

    public static void deleteUserByName(Connection connection, String str) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM user WHERE name=?");
        statement.setString(1,str);
        statement.executeUpdate();
        statement.close();
    }
}
