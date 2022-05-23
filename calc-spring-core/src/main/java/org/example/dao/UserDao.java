package org.example.dao;

import org.example.entity.User;

import java.util.List;

public interface UserDao {

    void save(User user);
    List<User> findAll();
    User findByUsername(String login);
    boolean userIsExist(String login, String password);
}
