package org.app.dao;

import org.app.entities.Notes;
import org.app.entities.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface NoteDao {
    void addNote(String heading, String text, User user) throws SQLException, IOException, InterruptedException;
    List<Notes> readAllNotes(int userId);
    void delete(int id);
}
