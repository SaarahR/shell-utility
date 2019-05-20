package Core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shahlin
 */
public class usersHelper {
    
    private Connection c = null;
    
    public usersHelper() {
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
    
    public boolean checkUsername(String user){
        boolean userFound = false;
        
        try {
               
            String sql = "SELECT username FROM users WHERE username = ?;";
            
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setString(1, user);
            
            ResultSet rs= statement.executeQuery();
            
            while(rs.next()){
                userFound = true;
            }
            
            rs.close();
            statement.close();
            
            return userFound;
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
        
        return userFound;
    }
    
    //Checks if the given email exists in the users table
    public boolean checkEmail(String email){
        boolean emailFound = false;
        
        try {
            String sql = "SELECT email FROM users WHERE email = ?;";
            
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setString(1, email);
            
            ResultSet rs= statement.executeQuery();
            
            while(rs.next()){
                emailFound = true;
            }
            
            rs.close();
            statement.close();
            
            return emailFound;
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
        
        return emailFound;
    }
    
    public boolean checkLogin(String user, String password){
        boolean valid = false;
        
        try {
            String sql = "SELECT username, password FROM users WHERE username = ? AND password = ?;";
            
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setString(1, user);
            statement.setString(2, password);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                valid = true;
            }
            
            rs.close();
            statement.close();
            
            return valid;
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
        
        return valid;
    }
    
    public int getIdbyEmail(String email){
        int id = 0;
        
        try {
            String sql = "SELECT id FROM users WHERE email = ?;";
            
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setString(1, email);
            
            ResultSet rs= statement.executeQuery();
            
            while(rs.next()){
                id = rs.getInt("id");
            }
            
            rs.close();
            statement.close();
            
            return id;
            
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
        
        return id;
    }
    
    public String getUsername(int id){
        String username = "";
        
        try {
            String sql = "SELECT username FROM users WHERE id = ?;";
            
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet rs= statement.executeQuery();
            
            while(rs.next()){
                username = rs.getString("username");
            }
            
            rs.close();
            statement.close();
            
            return username;
            
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
        
        return username;
    }
    
    public String getPassword(int id){
        String password = "";
        
        try {
            String sql = "SELECT password FROM users WHERE id = ?;";
            
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet rs= statement.executeQuery();
            
            while(rs.next()){
                password = rs.getString("password");
            }
            
            rs.close();
            statement.close();
            
            return password;
            
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
        
        return password;
    }
    
    public String getEmail(int id){
        String email = "";
        
        try {
            String sql = "SELECT email FROM users WHERE id = ?;";
            
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet rs= statement.executeQuery();
            
            while(rs.next()){
                email = rs.getString("email");
            }
            
            rs.close();
            statement.close();
            
            return email;
            
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
        
        return email;
    }
    
    public String getFname(int id){
        String fname = "";
        
        try {
            String sql = "SELECT first_name FROM users WHERE id = ?;";
            
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                fname = rs.getString("first_name");
            }
            
            rs.close();
            statement.close();
            
            return fname;
            
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
        
        return fname;
    }
    
    public String getLname(int id){
        String lname = "";
        
        try {
            String sql = "SELECT last_name FROM users WHERE id = ?;";
            
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                lname = rs.getString("last_name");
            }
            
            rs.close();
            statement.close();
            
            return lname;
            
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
        
        return lname;
    }
    
    public void setFname(String fname, int id){
        try {
            String sql = "UPDATE users SET first_name = ? WHERE id = ?;";
            
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setString(1, fname);
            statement.setInt(2, id);
            
            statement.executeUpdate();
            statement.close();
            
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
    }
    
    public void setLname(String lname, int id){
        try {
            String sql = "UPDATE users SET last_name = ? WHERE id = ?;";
            
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setString(1, lname);
            statement.setInt(2, id);
            
            statement.executeUpdate();
            statement.close();
            
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
    }
    
    public void setPassword(String password, int id){
        try {
            String sql = "UPDATE users SET password = ? WHERE id = ?;";
            
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setString(1, password);
            statement.setInt(2, id);
            
            statement.executeUpdate();
            statement.close();
            
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
    }
    
    public void logout(){
        Statement stmt = null;
        
        try {
            stmt = c.createStatement();
            
            String sql = "UPDATE users SET isLogged_in = 0;";
            
            stmt.executeUpdate(sql);
            stmt.close();
            
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
    }
    
    public void setLoggedIn(String username){
        try {
            //Logout all users by default
            logout();
            
            //Then log the user in
            String sql = "UPDATE users SET isLogged_in = 1 WHERE username = ?;";
            
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setString(1, username);
            
            statement.executeUpdate();
            statement.close();
            
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
    }
    
    public boolean insertUser(String username, String password, String email){
        try {
            c.setAutoCommit(false);
            
            String sql = "INSERT INTO users (username, password, email, join_date, isLogged_in) VALUES (?, ?, ?, NOW(), 1);";
            
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);
            
            statement.executeUpdate();
            statement.close();
            
            c.commit();
            return true;
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
        return false;
    }
    
    public int getLoggedInUser(){
        Statement stmt = null;
        
        int id = 0;
        
        try {
            stmt= c.createStatement();
               
            String sql = "SELECT id FROM users WHERE isLogged_in = 1;";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                id = rs.getInt("id");
            }
            
            rs.close();
            stmt.close();
            
            return id;
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
        
        return id;
    }
}
