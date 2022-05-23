package org.example.dao;

import org.example.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryUserDao implements UserDao {

    private final Map<String, User> map = new HashMap<>();

    @Override
    public void save(User user) {
        map.put(user.getLogin(), user);
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        map.values().forEach(value -> userList.add(value));
        return userList;
    }

    @Override
    public User findByUsername(String login) {
        if (map.containsKey(login)) {
            return map.get(login);
        }
        return null;
    }

    @Override
    public boolean userIsExist(String login, String password) {

        boolean result = false;

        for (User user : map.values()) {
            if (!map.values().isEmpty() && user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public Map<String, User> getMap() {
        return new HashMap<>(map);
    }
}
