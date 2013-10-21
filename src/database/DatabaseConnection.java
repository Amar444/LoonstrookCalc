/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import model.WorkHour;
import model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

    /**
     * Opens the database connection
     * @return database successfully openened
     */
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

    /**
     * Inserts a given workhour in the database, links it to the given id
     * @param id 
     * @param workHour 
     * @return successfull
     */
    public static boolean insertWorkHour(int id, WorkHour workHour) {
        boolean successfull = false;

        try {
            stmt = c.prepareStatement("INSERT INTO workhours (day, month, year, euro, factor, hour, user_id) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, workHour.getDay());
            stmt.setInt(2, workHour.getMonth());
            stmt.setInt(3, workHour.getYear());
            stmt.setDouble(4, workHour.getEuro());
            stmt.setInt(5, workHour.getFactor());
            stmt.setDouble(6, workHour.getHours());
            stmt.setInt(7, id);

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

    /**
     * Inserts a given user
     * @param user
     * @return successfully inserted
     */
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

    /**
     *
     */
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
    /** 
     * Retrieves the user from the database
     * @return user
     */
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

                ArrayList<WorkHour> workHours = getWorkHoursFromUserId(user.getId());
                user.setWorkHours(workHours);
            }
        } catch (SQLException a) {
        }
        return user;
    }

    /**
     * Retrieves workhours with given user_id
     * @param id 
     * @return ArrayList<WorkHour>
     */
    public static ArrayList<WorkHour> getWorkHoursFromUserId(int id) {
        ArrayList<WorkHour> workHours = new ArrayList<WorkHour>();

        try {
            stmt = c.prepareStatement("SELECT * FROM workhours WHERE user_id = ? ORDER BY id DESC");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int workId = rs.getInt("id");
                int day = rs.getInt("day");
                int month = rs.getInt("month");
                int year = rs.getInt("year");
                double hour = rs.getDouble("hour");
                double euro = rs.getDouble("euro");
                int factor = rs.getInt("factor");

                workHours.add(new WorkHour(workId, day, month, year, hour, euro, factor));
            }

        } catch (SQLException b) {
        }

        return workHours;
    }
    
    public static boolean deleteUren(WorkHour hour) {
        try {
            stmt = c.prepareStatement("DELETE FROM workhours WHERE id = ?");
            stmt.setInt(1, hour.getId());           
            return stmt.executeUpdate() > 0;  
        }
        catch(SQLException e) {
            logger.info("Delete failed: " + e.getMessage());
        }
        return false;
    }
    
    public static boolean editUren(WorkHour hour){
        try{
            stmt = c.prepareStatement("UPDATE workhours SET day = ?, month = ?, year = ?, hour = ?, euro = ?, factor = ? WHERE id = ? ");
            stmt.setInt (1, hour.getDay() );
            stmt.setInt (2, hour.getMonth() );
            stmt.setInt (3, hour.getYear() );
            stmt.setDouble (4, hour.getHours() );
            stmt.setDouble (5, hour.getEuro() );
            stmt.setInt (6, hour.getFactor() );
            stmt.setInt (7, hour.getId() ); 
            return stmt.executeUpdate() > 0;  
        }
        catch(SQLException e){
            logger.info("Edit failed: " + e.getMessage());
        }
        return true;
    }
    
}
