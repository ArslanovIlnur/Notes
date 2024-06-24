package org.app.dao;

import org.app.entities.User;

import java.util.List;

public interface UserDao {
    void addUser(String username, String password);
    List<User> findAll();
    User getByUsername(String username);
}
