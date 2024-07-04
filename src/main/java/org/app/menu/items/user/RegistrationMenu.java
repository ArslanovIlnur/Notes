package org.app.menu.items.user;

import org.app.dao.UserDao;
import org.app.db.DBConfig;
import org.app.menu.MainMenu;
import org.app.service.UserDaoImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class RegistrationMenu {
    public static void registration() throws SQLException, IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        UserDao userDao = new UserDaoImpl(DBConfig.dataSource());

        System.out.println("Введите имя пользователя:");
        String username = scanner.nextLine();

        if (userDao.getByUsername(username) != null){
            System.out.println("Пользователь с данным именем уже существует");
            MainMenu.mainMenu();
        } else {

            System.out.println("Введите пароль:");
            String password = scanner.nextLine();

            userDao.addUser(username, password);

            System.out.println("Регистрация прошла успешно");
            MainMenu.mainMenu();
        }
    }

    public static String description(){
        return "Зарегистрироваться";
    }
}
