package org.app.service;

import org.app.dao.NoteDao;
import org.app.entities.Notes;
import org.app.entities.User;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NoteDaoImpl implements NoteDao {
    private final DataSource dataSource;

    public NoteDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addNote(String heading, String text, User user) throws SQLException, IOException, InterruptedException {
        Random random = new Random();
        int id = random.nextInt(0, Integer.MAX_VALUE);

        String insertNoteSql = "INSERT INTO notes(id, user_id, heading, text) VALUES("
                + id +", " + user.getId() + ", '" + heading + "', '" + text + "')";

        try(Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement()) {
            statement.executeUpdate(insertNoteSql);
        }
    }

    @Override
    public List<Notes> readAllNotes(int userID) {
        List<Notes> notesList = new ArrayList<>();

        String selectSql = "SELECT id, user_id, heading, text From notes where user_id=" + userID;

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(selectSql)){

            while (rs.next()){
                Notes notes = new Notes(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4));

                notesList.add(notes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return notesList;
    }

    @Override
    public void delete(int id) {
        String deleteSql = "DELETE FROM notes WHERE id=?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)){
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
