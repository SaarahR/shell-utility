package Core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sarah
 */
public class notesHelper {

    private Connection c = null;

    public notesHelper() {
        //Connect to Database
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost/shell?user=root&password=password");
            //Connected
        } catch (SQLException ex) {
            //Handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
    }

    public boolean insertNote(String title, String body) {
        usersHelper user = new usersHelper();

        try {
            c.setAutoCommit(false);

            int user_id = user.getLoggedInUser();;

            String sql = "INSERT INTO notes (user_id, title, body) VALUES (?, ?, ?);";

            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, user_id);
            statement.setString(2, title);
            statement.setString(3, body);

            statement.executeUpdate();
            statement.close();

            c.commit();

            return true;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
        return false;
    }

    public ResultSet DisplayNoteInfo(int id) {

        try {
            String sql = "SELECT * FROM notes WHERE user_id = ? ORDER BY date_post DESC;";

            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            return rs;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }

        return null;

    }

    public void incrementUsageCount(int user_id){
        try {               
            String sql = "UPDATE notes SET usage_count = usage_count + 1 WHERE user_id = ?;";
            
            try (PreparedStatement statement = c.prepareStatement(sql)) {
                statement.setInt(1, user_id);
                
                statement.executeUpdate();
            }
            
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
    }

    public int getUsageCount(int user_id) {
        int usageCount = 0;

        try {
            String sql = "SELECT usage_count FROM notes WHERE user_id = ? LIMIT 1;";

            try (PreparedStatement statement = c.prepareStatement(sql)) {
                statement.setInt(1, user_id);
                
                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        usageCount = rs.getInt("usage_count");
                    }
                }
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }

        return usageCount;
    }
}
