package org.app.menu.items.user;

import org.app.dao.UserDao;
import org.app.db.DBConfig;
import org.app.entities.User;
import org.app.menu.MainMenu;
import org.app.menu.items.NotesMenu;
import org.app.service.UserDaoImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class EnterMenu {
    public static void enter() throws SQLException, IOException, InterruptedException {
        UserDao userDao = new UserDaoImpl(DBConfig.dataSource());


            System.out.println("Введите имя пользователя:");
            Scanner scanner = new Scanner(System.in);
            String username = scanner.nextLine();

            User user = userDao.getByUsername(username);

            if (user == null) {
                System.out.println("Пользователь \"" + username + "\" не найден");
                MainMenu.mainMenu();
            } else {
                System.out.println("Введите пароль:");
                String password = scanner.nextLine();

                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    System.out.println("Успешно");
                    NotesMenu.note(user);
                } else {
                    System.out.println("Неверный Имя пользователя или пароль");
                    MainMenu.mainMenu();
                }
            }
    }

    public static String description(){
        return "Войти";
    }
}
