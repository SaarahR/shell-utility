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
public class quicklinksHelper {

    private Connection c = null;

    public quicklinksHelper() {
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

    public boolean insertLink(String web_name, String link) {
        usersHelper user = new usersHelper();

        try {
            c.setAutoCommit(false);

            int user_id = user.getLoggedInUser();

            String sql = "INSERT INTO quicklinks (user_id, web_name, link) VALUES (?, ?, ?);";

            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, user_id);
            stmt.setString(2, web_name);
            stmt.setString(3, link);

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

    public String[] getWebNames(int user_id) {
        String[] names = new String[4];

        try {

            String sql = "SELECT web_name FROM quicklinks WHERE user_id = ? LIMIT 4;";

            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, user_id);

            ResultSet rs = statement.executeQuery();

            int i = 0;

            while (rs.next()) {
                names[i] = rs.getString("web_name");
                i++;
            }

            return names;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
        return null;
    }

    public String[] getWebLinks(int user_id) {
        String[] links = new String[4];

        try {

            String sql = "SELECT link FROM quicklinks WHERE user_id = ? LIMIT 4;";

            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, user_id);

            ResultSet rs = statement.executeQuery();

            int i = 0;

            while (rs.next()) {
                links[i] = rs.getString("link");
                i++;
            }

            return links;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
        return null;
    }

    public int[] getLinkIDs(int user_id) {
        int[] ids = new int[4];

        try {

            String sql = "SELECT quicklinks_id FROM quicklinks WHERE user_id = ? LIMIT 4;";

            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, user_id);

            ResultSet rs = statement.executeQuery();

            int i = 0;

            while (rs.next()) {
                ids[i] = rs.getInt("quicklinks_id");
                i++;
            }

            return ids;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
        return null;
    }

    public int webNum(int id) {
        int n = 0;

        try {
            String sql = "SELECT COUNT(quicklinks_id) from quicklinks WHERE user_id = ?;";

            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, id);

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
        return n;

    }
    
    public void deleteLink(int link_id) {
        try {
            String sql = "DELETE FROM quicklinks WHERE quicklinks_id = ?;";

            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, link_id);

            stmt.executeUpdate();

            stmt.close();

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
    }   
    
    public void incrementUsageCount(int user_id){
        try {               
            String sql = "UPDATE quicklinks SET usage_count = usage_count + 1 WHERE user_id = ?;";
            
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
            String sql = "SELECT usage_count FROM quicklinks WHERE user_id = ? LIMIT 1;";

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
