package org.app.service;

import org.app.dao.UserDao;
import org.app.entities.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserDaoImpl implements UserDao {
    private final DataSource dataSource;

    public UserDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addUser(String username, String password) {
        Random random = new Random();
        int id = random.nextInt();

        String insertSql = "INSERT INTO users(id, username, password) VALUES("
                + id + ", '" + username + "', '" + password + "')";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){
            statement.executeUpdate(insertSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String selectSql = "SELECT id, username, password FROM users";

        try (Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(selectSql)){

            while (rs.next()){
                User user = new User(rs.getInt(1), rs.getString(2),
                        rs.getString(3));
                users.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public User getByUsername(String username) {
        User user = null;
        String selectByUsernameSql = "SELECT id, username, password FROM users WHERE username=?";

        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(selectByUsernameSql)){

            preparedStatement.setString(1, username);

            try (ResultSet rs = preparedStatement.executeQuery()){
                if (rs.next()){
                    user = new User(rs.getInt(1), rs.getString(2),
                            rs.getString(3));
                    return  user;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
