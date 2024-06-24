package org.app.menu.items.notes;

import org.app.dao.NoteDao;
import org.app.db.DBConfig;
import org.app.entities.User;
import org.app.menu.items.NotesMenu;
import org.app.service.NoteDaoImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteNote {
    public static void delete(User user) throws SQLException, IOException, InterruptedException {
        NoteDao noteDao = new NoteDaoImpl(DBConfig.dataSource());

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ID записи для удаления:");
        int id = scanner.nextInt();

        noteDao.delete(id);
        System.out.println("Запись " + id + " удалена");
        NotesMenu.note(user);
    }

    public static String description(){
        return "Удалить запись";
    }
}
