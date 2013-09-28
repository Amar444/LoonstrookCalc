/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package loonstrookcalc;

import java.sql.*;

/**
 *
 * @author Amar Tursic
 */
public class DatabaseConnection {

    public static void OpenConnection() {
        {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:LoonStrookCalc.db");
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                String CreateUserTable =
                        "CREATE TABLE IF NOT EXISTS users "
                        + "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,"
                        + " name VARCHAR NOT NULL, "
                        + " brutoloon DOUBLE NOT NULL, "
                        + " nettoloon DOUBLE NOT NULL ) ";
                String CreateWorkhoursTable =
                        "CREATE TABLE IF NOT EXISTS workhours "
                        + "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,"
                        + " day INTEGER NOT NULL, "
                        + " month INTEGER NOT NULL, "
                        + " year INTEGER NOT NULL, "
                        + " hour DOUBLE NOT NULL, "
                        + " euro DOUBLE NOT NULL, "
                        + " factor INTEGER NOT NULL, "
                        + " user_id INTEGER NOT NULL, "
                        + " FOREIGN KEY (user_id) REFERENCES users (id) ON UPDATE CASCADE ON DELETE CASCADE );";
                stmt.executeUpdate(CreateUserTable);
                stmt.executeUpdate(CreateWorkhoursTable);
                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Table created successfully");
        }
    }
}
