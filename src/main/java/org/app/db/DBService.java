package org.app.db;

import java.io.IOException;
import java.sql.SQLException;

public class DBService {
    public static void dbRun() throws SQLException, IOException, InterruptedException {
        DBConfig dbConfig = new DBConfig();
        System.out.println("Database loading...");
        dbConfig.usersDBCreate();
        dbConfig.notesDBCreate();
        System.out.println();
    }
}
