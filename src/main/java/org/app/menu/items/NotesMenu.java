package org.app.menu.items;

import org.app.entities.User;
import org.app.menu.ExitMenu;
import org.app.menu.MainMenu;
import org.app.menu.items.notes.CreateNote;
import org.app.menu.items.notes.DeleteNote;
import org.app.menu.items.notes.ReadNotes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class NotesMenu {
    public static void note(User user) throws SQLException, IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("        Меню заметок       ");
        System.out.println("---------------------------");
        System.out.println("1. " + CreateNote.description());
        System.out.println("2. " + ReadNotes.description());
        System.out.println("3. " + DeleteNote.description());
        System.out.println("4. " + MainMenu.description());
        System.out.println("5. " + ExitMenu.description());
        System.out.println("---------------------------");

        int command = scanner.nextInt();

        if(command == 1){
            CreateNote.createNote(user);
        } else if (command == 2){
            ReadNotes.read(user);
        } else if (command == 3) {
            DeleteNote.delete(user);
        } else if (command == 4) {
            MainMenu.mainMenu();
        } else if (command == 5) {
            ExitMenu.exitFromApp();
        } else {
            System.out.println("неверная команда");
            NotesMenu.note(user);
        }
    }
}
