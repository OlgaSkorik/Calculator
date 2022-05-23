package org.example.service;

import org.example.dao.UserDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private final UserDao userDao;

    public UserService(@Qualifier("inSQLUserDao") UserDao userDao) {
        this.userDao = userDao;
    }
}
