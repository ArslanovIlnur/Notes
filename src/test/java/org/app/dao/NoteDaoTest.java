package org.app.dao;

import org.app.db.DBConfig;
import org.app.entities.Notes;
import org.app.entities.User;
import org.app.service.NoteDaoImpl;
import org.app.service.UserDaoImpl;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NoteDaoTest {

    @Test
    void addNote() throws SQLException, IOException, InterruptedException {
        NoteDao noteDao = new NoteDaoImpl(DBConfig.dataSource());
        UserDao userDao = new UserDaoImpl(DBConfig.dataSource());

        User user = userDao.getByUsername("test");

        noteDao.addNote("note", "note", user);
    }

    @Test
    void readAllNotes() {
        NoteDao noteDao = new NoteDaoImpl(DBConfig.dataSource());
        UserDao userDao = new UserDaoImpl(DBConfig.dataSource());

        User user = userDao.getByUsername("test");
        List<Notes> notes = new ArrayList<>();

        notes = noteDao.readAllNotes(user.getId());

        assertNotNull(notes);
    }
}