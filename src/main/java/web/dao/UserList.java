package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class UserList {

    private int COUNT;

    private static final String URL = "jdbc:mysql://localhost:3306/javawolf";
    private static final String NAME = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static Connection connection;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try {
            Statement statement =connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public User getUserById(int id){
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setFirstName(resultSet.getString("firstName"));
            user.setLastName(resultSet.getString("lastName"));
            user.setAge(resultSet.getInt("age"));
            user.setEmail(resultSet.getString("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void save(User user){
        String sql = "INSERT INTO users (firstName, lastName, age, email) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, User updateUser){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE users " +
                    "SET firstName=?, lastName=?, age=?, email=? WHERE id=?");
            statement.setString(1, updateUser.getFirstName());
            statement.setString(2, updateUser.getLastName());
            statement.setInt(3, updateUser.getAge());
            statement.setString(4, updateUser.getEmail());
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
