package org.app.menu;

import org.app.menu.items.user.EnterMenu;
import org.app.menu.items.user.RegistrationMenu;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {
    public static void mainMenu() throws SQLException, IOException, InterruptedException {
        System.out.println("----------------------");
        System.out.println("     Главное меню     ");
        System.out.println("----------------------");
        System.out.println("1. " + EnterMenu.description());
        System.out.println("2. " + RegistrationMenu.description());
        System.out.println("3. " + ExitMenu.description());
        System.out.println("----------------------");

        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();

        if (command == 1){
            EnterMenu.enter();
        } else if (command == 2) {
            RegistrationMenu.registration();
        } else if (command == 3) {
            ExitMenu.exitFromApp();
        } else {
            System.out.println("Неверная команда");
            MainMenu.mainMenu();
        }
    }

    public static String description(){
        return "Главное меню";
    }
}
