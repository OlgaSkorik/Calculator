package org.example.dao;

import org.example.entity.User;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class SQLUserDao implements UserDao{
    private final Connection connection;
    private static final String SAVING = "insert into user(name, login, password) values (?, ?, ?)";
    private static final String FINDALL = "select * from user";
    private static final String FINDBYLOGIN = "select * from user where login = ?";
    private static final String FINDBYID = "select * from user where id = ?";
    private static final String ISEXIST = "select * from user where login = ? and password = ?";


    public SQLUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(SAVING);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(FINDALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                userList.add(new User(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4)));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findByUsername(String login) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(FINDBYLOGIN);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User findById(Long id) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(FINDBYID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User(id, resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean userIsExist(String login, String password) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(ISEXIST);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                result = true;

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
