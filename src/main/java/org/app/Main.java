package org.app;

import org.app.db.DBService;
import org.app.menu.MainMenu;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException, InterruptedException {
        DBService.dbRun();
        MainMenu.mainMenu();
    }
}
