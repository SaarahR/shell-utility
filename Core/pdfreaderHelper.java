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
public class pdfreaderHelper {

    private Connection c = null;

    public pdfreaderHelper() {
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
    
    public boolean insertFile(String fileName, String file_path) {
        usersHelper user = new usersHelper();

        try {
            c.setAutoCommit(false);

            int user_id = user.getLoggedInUser();

            String sql = "INSERT INTO pdfreader (user_id, file_name, file_path) VALUES (?, ?, ?);";

            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, user_id);
            stmt.setString(2, fileName);
            stmt.setString(3, file_path);

            stmt.executeUpdate();
            stmt.close();
            c.commit();

            return true;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
        return false;
    }
    
    public int getRecentsCount(int user_id) {
        int n = 0;

        try {
            String sql = "SELECT COUNT(file_id) from pdfreader WHERE user_id = ?;";

            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, user_id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                n = rs.getInt(1);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
        
        if(n > 4) {
            return 4;
        } else {
            return n;
        }
    }
    
    public String[] getFileNames(int user_id) {
        String[] names = new String[4];

        try {

            String sql = "SELECT DISTINCT(file_name) FROM pdfreader WHERE user_id = ? ORDER BY date_posted DESC LIMIT 4;";

            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, user_id);

            ResultSet rs = statement.executeQuery();

            int i = 0;

            while (rs.next()) {
                names[i] = rs.getString("file_name");
                i++;
            }

            return names;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
        return null;
    }

    public String[] getFilePaths(int user_id) {
        String[] paths = new String[4];

        try {

            String sql = "SELECT DISTINCT(file_path) FROM pdfreader WHERE user_id = ? ORDER BY date_posted DESC LIMIT 4;";

            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, user_id);

            ResultSet rs = statement.executeQuery();

            int i = 0;

            while (rs.next()) {
                paths[i] = rs.getString("file_path");
                i++;
            }

            return paths;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
        return null;
    }
    
    public void incrementUsageCount(int user_id){
        try {               
            String sql = "UPDATE pdfreader SET usage_count = usage_count + 1 WHERE user_id = ?;";
            
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
            String sql = "SELECT usage_count FROM pdfreader WHERE user_id = ? LIMIT 1;";

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