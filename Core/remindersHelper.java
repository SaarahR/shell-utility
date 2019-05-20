package Core;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class remindersHelper {

    private Connection c = null;
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public remindersHelper() {
        try {  //Connecting to our database, shell.
            c = DriverManager.getConnection("jdbc:mysql://localhost/shell?user=root&password=password");

        } catch (SQLException exc) {
            System.out.println("SQLException: " + exc.getMessage());
            System.out.println("SQLState: " + exc.getSQLState());
        }
    }

    public boolean insertReminder(String title, int repeatdur, boolean priority, String date, boolean repeatState) {

        PreparedStatement statement = null;
        usersHelper user = new usersHelper();
        int user_id = user.getLoggedInUser();

        try {
            c.setAutoCommit(false);

            String sql = "INSERT INTO reminders (user_id, reminder_title, repeat_duration, priority, reminder_datetime, repeat_state, time_posted) VALUES(" + user_id + ", ?, ?, ?, ?, ?, NOW());";

            statement = c.prepareStatement(sql);
            statement.setString(1, title);
            statement.setInt(2, repeatdur);
            statement.setBoolean(3, priority);
            statement.setString(4, date);
            statement.setBoolean(5, repeatState);

            statement.executeUpdate();

            statement.close();

            c.commit();
            return true;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }

            } catch (SQLException se) {
            }// do nothing
            try {
                if (c != null) {
                    c.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return false;
    }

    public ResultSet displayReminders(int id, int complete) {
        try {
            //Use prepared statement 
            String sql = "SELECT * FROM reminders WHERE user_id = ? AND complete = ? ORDER BY time_posted DESC;";

            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setInt(2, complete);

            ResultSet rs = statement.executeQuery();

            return rs;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }

        return null;

    }

    public ResultSet displayCompletedReminders(int id) {
        try {
            //Use prepared statement 
            String sql = "SELECT * FROM reminders WHERE user_id = ? AND complete = 1 ORDER BY time_posted DESC;";

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

    public void updateComplete() {
        PreparedStatement stmt;

        try {
            String updateQuery = "UPDATE reminders SET complete = 1 WHERE STR_TO_DATE(reminder_datetime, '%Y-%m-%d %H:%i:%s')< NOW() AND repeat_state = 0;";

            stmt = c.prepareStatement(updateQuery);

            stmt.executeUpdate();

            stmt.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
    }

    public void updateRepeat(int userid, int repeatDuration) {
        PreparedStatement ps2 = null;

        String sql = "";

        if (repeatDuration == 0) {
            return;
        } else if (repeatDuration == 1) {
            sql = "UPDATE reminders SET reminder_datetime= DATE_ADD(reminder_datetime, INTERVAL 1 DAY)  WHERE STR_TO_DATE(reminder_datetime, '%Y-%m-%d %H:%i:%s')< NOW() AND user_id  = ? AND repeat_duration = 1;";
        } else if (repeatDuration == 2) {
            sql = "UPDATE reminders SET reminder_datetime= DATE_ADD(reminder_datetime, INTERVAL 7 DAY)  WHERE STR_TO_DATE(reminder_datetime, '%Y-%m-%d %H:%i:%s')< NOW() AND user_id  = ? AND repeat_duration = 2;";
        } else if (repeatDuration == 3) {
            sql = "UPDATE reminders SET reminder_datetime= DATE_ADD(reminder_datetime, INTERVAL 1 MONTH)  WHERE STR_TO_DATE(reminder_datetime, '%Y-%m-%d %H:%i:%s')< NOW() AND user_id  = ? AND repeat_duration = 3;";
        } else if (repeatDuration == 4) {
            sql = "UPDATE reminders SET reminder_datetime= DATE_ADD(reminder_datetime, INTERVAL 1 YEAR)  WHERE STR_TO_DATE(reminder_datetime, '%Y-%m-%d %H:%i:%s')< NOW() AND user_id  = ? AND repeat_duration = 4;";
        }

        try {
            ps2 = c.prepareStatement(sql);
            ps2.setInt(1, userid);

            ps2.executeUpdate();

            ps2.close();

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }

    }

    public void updateAllRepeats(int user_id) {
        updateRepeat(user_id, 1);
        updateRepeat(user_id, 2);
        updateRepeat(user_id, 3);
        updateRepeat(user_id, 4);
    }
    
    public void incrementUsageCount(int user_id){
        try {               
            String sql = "UPDATE reminders SET usage_count = usage_count + 1 WHERE user_id = ?;";
            
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
            String sql = "SELECT usage_count FROM reminders WHERE user_id = ? LIMIT 1;";

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
    
    public ArrayList<String> getFrequent(int user_id)
    {
        ArrayList<String> frequent= new ArrayList<>(6);
        int counter = 0;
        
         try {
            //Use prepared statement 
            String sql = "SELECT * FROM reminders WHERE user_id = ? AND complete = ? ORDER BY reminder_datetime DESC LIMIT 2;";

            PreparedStatement statement = c.prepareStatement(sql);
            statement.setInt(1, user_id);
            statement.setInt(2, 0);
            
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                counter++;
                frequent.add(rs.getString("reminder_title"));
                String datetime = rs.getString("reminder_datetime").substring(0, rs.getString("reminder_datetime").length() - 2);
                
                String date = datetime.substring(0, 10);
                String time = datetime.substring(11, datetime.length() - 3);
                
                frequent.add(date);
                frequent.add(time);
            }
            
            rs.close();

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
         
        if(counter < 2){
            return null;
        }
        return frequent;
        
    }
}
