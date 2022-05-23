package org.example.dao;

import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HibernateUserStorage implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        List resultList = session.createQuery("from User", User.class).getResultList();
        session.close();
        return resultList;
    }

    @Override
    public User findByUsername(String login) {
        Session session = sessionFactory.openSession();
        User singleResult = session.createQuery("from User where login = :login", User.class)
                .setParameter("login", login).getSingleResult();
        session.close();
        return singleResult;
    }

    @Override
    public boolean userIsExist(String login, String password) {
        Session session = sessionFactory.openSession();
        return true;
    }
}
