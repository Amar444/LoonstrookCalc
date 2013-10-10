/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import model.WorkHour;
import model.User;
import java.sql.*;
import java.util.logging.Logger;

/**
 *
 * @author Amar Tursic
 */
public class DatabaseConnection {

    private static Connection c = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;
    private static Logger logger = Logger.getLogger("Database Connection");

    public static boolean openConnection() {
        try {
            Class.forName("org.sqlite.JDBC"); // Zoekt een class op naam, en initialiseert
            c = DriverManager.getConnection("jdbc:sqlite:LoonStrookCalc.db");
            logger.info("Database connection opened...");
            Statement statement = c.createStatement();

            String createUserTable =
                    "CREATE TABLE IF NOT EXISTS users "
                    + "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,"
                    + " name VARCHAR NOT NULL, "
                    + " brutoloon DOUBLE NOT NULL, "
                    + " nettoloon DOUBLE NOT NULL ) ";
            String createWorkhoursTable =
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
            statement.executeUpdate(createUserTable);
            statement.executeUpdate(createWorkhoursTable);

            return true;

        } catch (SQLException e) {
            closeConnection(e);
        } catch (ClassNotFoundException e) {
            closeConnection(e);
        }
        return false;
    }

    public static boolean insertWorkHour(WorkHour workHour) {
        boolean successfull = false;

        try {
            stmt = c.prepareStatement("INSERT INTO workhours (day, month, year, euro, factor, hour, user_id) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, workHour.getDay());
            stmt.setInt(2, workHour.getMonth());
            stmt.setInt(3, workHour.getYear());
            stmt.setDouble(4, workHour.getEuro());
            stmt.setInt(5, workHour.getFactor());
            stmt.setDouble(6, workHour.getHours());
            stmt.setInt(7, 1);

            successfull = stmt.executeUpdate() > 0;
            logger.info(String.valueOf(successfull));
            if (successfull) {
                rs = stmt.getGeneratedKeys(); // result set van DB = statement . haal laatst gegenereerde sleutels op
                workHour.setId(rs.getInt(1)); // id van workhour =  resultset, eerst gevonden id( in dit geval van je workhour )
                logger.info("Workhour id: " + workHour.getId());
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            return successfull;
        }

    }

    public static boolean insertUser(User user) {
        boolean successfull = false;

        try {
            stmt = c.prepareStatement("INSERT INTO users (name, brutoloon, nettoloon) VALUES (?, ?, ?)");
            stmt.setString(1, user.getName());
            stmt.setDouble(2, user.getBrutoUurloon());
            stmt.setDouble(3, user.getNettoUurloon());

            successfull = stmt.executeUpdate() > 0;
            logger.info(String.valueOf(successfull));
            if (successfull) {
                rs = stmt.getGeneratedKeys(); // result set van DB = statement . haal laatst gegenereerde sleutels op
                user.setId(rs.getInt(1)); // id van workhour =  resultset, eerst gevonden id( in dit geval van je workhour )
                logger.info("User id: " + user.getId());
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            return successfull;
        }


    }

    public static void closeConnection() {
        try {
            System.exit(0);
            c.close();
        } catch (SQLException ex) {
        }
    }

    private static void closeConnection(Exception e) {
        try {
            logger.severe(e.getMessage());
            System.exit(0);
            c.close();
        } catch (SQLException ex) {
        }

    }

    public static User getUser() { //Haal user op als deze bestaat
        User user = null;
        try {
            stmt = c.prepareStatement("SELECT * FROM users;");
            rs = stmt.executeQuery();
            if (rs.next()) {
                // haal attributen uit RS, en maak een user object van deze waarden uit de database
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double brutoLoon = rs.getDouble("brutoloon");
                double nettoLoon = rs.getDouble("nettoloon");
                user = new User(id, name, brutoLoon, nettoLoon);
            }
        } catch (SQLException a) {
        }
        return user;
    }
}
