package org.app.menu.items.notes;

import org.app.dao.NoteDao;
import org.app.db.DBConfig;
import org.app.entities.User;
import org.app.menu.items.NotesMenu;
import org.app.service.NoteDaoImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateNote {
    public static void createNote(User user) throws SQLException, IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        NoteDao noteDao = new NoteDaoImpl(DBConfig.dataSource());

        System.out.println("Введите заголовок");
        String heading = scanner.nextLine();
        if (heading.isEmpty()){
            heading = "NONE";
        }

        System.out.println("Введите текст");
        String text = scanner.nextLine();

        noteDao.addNote(heading, text, user);
        NotesMenu.note(user);
    }

    public static String description(){
        return "Добавить заметку";
    }
}
