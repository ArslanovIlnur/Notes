package org.app.db;

import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConfig {
    public static DataSource dataSource(){
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:./db");
        dataSource.setUser("admin");
        dataSource.setPassword("admin");
        return dataSource;
    }

    public void usersDBCreate() throws IOException, SQLException {
        try (InputStream inputStream = this.getClass().getResourceAsStream("/users.sql")){
            String sql = new String(inputStream.readAllBytes());

            try (Connection connection = dataSource().getConnection();
                 Statement statement = connection.createStatement()){
                statement.executeUpdate(sql);
            }
        }
    }

    public  void notesDBCreate() throws IOException, SQLException {
        try (InputStream inputStream = this.getClass().getResourceAsStream("/notes.sql")){
            String sql = new String(inputStream.readAllBytes());

            try (Connection connection = dataSource().getConnection();
                 Statement statement = connection.createStatement()){
                statement.executeUpdate(sql);
            }
        }
    }
}
