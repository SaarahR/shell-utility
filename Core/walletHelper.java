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
 * @author Shahlin
 */
public class walletHelper {

    private Connection c = null;

    public walletHelper() {
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

    //type -> 0 for expense, 1 for income
    public void insertRecord(String note, short type, double amount, String category) {
        usersHelper user = new usersHelper();

        try {
            c.setAutoCommit(false);
            int user_id = user.getLoggedInUser();

            String sql = "";

            if (type == 0) {
                //Expense
                sql = "INSERT INTO walletRecord (user_id, note, expense, category, date_added) VALUES (?, ?, ?, ?, NOW());";
            } else if (type == 1) {
                //Income
                sql = "INSERT INTO walletRecord (user_id, note, income, category, date_added) VALUES (?, ?, ?, ?, NOW());";
            }

            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, user_id);
            statement.setString(2, note);
            statement.setDouble(3, amount);
            statement.setString(4, category);

            statement.executeUpdate();
            statement.close();

            c.commit();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
    }

    public double getTotalExpense(int user_id) {
        try {
            String sql = "SELECT SUM(expense) FROM walletRecord WHERE user_id = ?;";

            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, user_id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return rs.getDouble(1);
            }

            rs.close();
            statement.close();

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }

        return 0;
    }

    public double getTotalIncome(int user_id) {
        try {
            String sql = "SELECT SUM(income) FROM walletRecord WHERE user_id = ?;";

            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, user_id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return rs.getDouble(1);
            }

            rs.close();
            statement.close();

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }

        return 0;
    }

    public int getUserRecordsCount(int user_id) {
        try {
            String sql = "SELECT COUNT(record_id) FROM walletRecord WHERE user_id = ?;";

            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, user_id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            rs.close();
            statement.close();

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }

        return 0;
    }

    public ResultSet getCategoryItems(int user_id) {
        try {
            String sql = "SELECT category, expense, income  FROM walletRecord WHERE user_id = ?;";

            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, user_id);

            ResultSet rs = statement.executeQuery();

            return rs;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }

        return null;
    }

    public ResultSet displayRecords(int id) {
        try {
            //Use prepared statement 
            String sql = "SELECT * FROM walletRecord WHERE user_id = ? ORDER BY date_added DESC;";

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

    public void incrementUsageCount(int user_id) {
        try {
            String sql = "UPDATE walletrecord SET usage_count = usage_count + 1 WHERE user_id = ?;";

            try (PreparedStatement statement = c.prepareStatement(sql)) {
                statement.setInt(1, user_id);

                statement.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
    }

    public int getUsageCount(int user_id) {
        int usageCount = 0;

        try {
            String sql = "SELECT usage_count FROM walletRecord WHERE user_id = ? LIMIT 1;";

            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, user_id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                usageCount = rs.getInt("usage_count");
            }

            rs.close();
            statement.close();

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }

        return usageCount;
    }
}
