package org.example.dao;

import org.example.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {

    private final List<User> store = new ArrayList<>();

    public User getUserByLoginPassword(String login, String password) {

        User result = new User();
        result.setId(-1);

        for (User user : store) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = user;
            }
        }
        return result;
    }

    public boolean add(User user) {

        for (User u : store) {
            if (u.getLogin().equals(user.getLogin()) &&
                    u.getPassword().equals(user.getPassword())) {
                return false;
            }
        }
        return store.add(user);
    }

    public boolean userIsExist(String login, String password) {

        boolean result = false;

        for (User user : store) {
            if (!store.isEmpty() && user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public List<User> getStore() {
        return store;
    }
}
