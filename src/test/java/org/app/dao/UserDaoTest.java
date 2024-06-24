package org.app.dao;

import org.app.db.DBConfig;
import org.app.db.DBService;
import org.app.entities.User;
import org.app.service.UserDaoImpl;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void addUser() throws SQLException, IOException, InterruptedException {
        DBService.dbRun();
        UserDao userDao = new UserDaoImpl(DBConfig.dataSource());

        List<User> userList = new ArrayList<>();

        userDao.addUser("test", "test");
        userList = userDao.findAll();

        assertNotEquals(0, userList.size());
    }

    @Test
    void getByUsername() {
        UserDao userDao = new UserDaoImpl(DBConfig.dataSource());
        User user = null;
        user = userDao.getByUsername("test");

        assertNotNull(user);
    }
}