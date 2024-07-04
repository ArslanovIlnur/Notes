package org.app.menu.items.notes;

import org.app.dao.NoteDao;
import org.app.db.DBConfig;
import org.app.entities.Notes;
import org.app.entities.User;
import org.app.menu.items.NotesMenu;
import org.app.service.NoteDaoImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ReadNotes {
    public static void read(User user) throws SQLException, IOException, InterruptedException {
        NoteDao noteDao = new NoteDaoImpl(DBConfig.dataSource());

        int userId = user.getId();
        List<Notes> notesList = noteDao.readAllNotes(userId);

        System.out.println("ID        |Заголовок     |     Текст");
        System.out.println("===============================================================");
        notesList.stream().forEach(notes ->
                System.out.println(notes.getId() + " | " + notes.getHeading() + "    |    " + notes.getText() +
                        "\n----------------------------------------------------------------"));

        NotesMenu.note(user);
    }

    public static String description(){
        return "Прочитать заметки";
    }
}
