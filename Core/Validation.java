package Core;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.UrlValidator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shahlin
 */
public class Validation {
    
    public String error;
    
    public boolean validateUsername(String user){
        //Username must be over 5 characters
        if(user.length() < 5){
            error = "Username must contain at least 5 characters";
            return false;
        }
        
        //Username can only be 10 characters long
        if(user.length() > 10){
            error = "Username cannot be more than 10 characters";
            return false;
        }
        
        //Username cannot contain special characters
        if(containsSpecialCharacter(user) == true){
            error = "Username cannot contain special characters";
            return false;
        }
        
        return true;
    }
    
    public boolean validatePassword(String pass){
        //Minimum password length = 6
        if(pass.length() < 6){
            error = "Password must be greater than 6 characters";
            return false;
        }
        
        if(pass.length() > 20){
            error = "Password must be lesser than 20 characters";
            return false;
        }
        return true;
    }
      
    //Returns true if the email is valid
    public boolean validateEmail(String email){
        //Regex to match email IDs
        Pattern valid_regex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        Matcher matcher = valid_regex.matcher(email);
        
        if(matcher.find()){
            return true;
        } else {
            error = "Shell doesn't recognize this email, try again!";
            return false;
        }
    }
    
    public boolean validateName(String name, String type){
        if(name.length() < 3){
            error = type + " must contain at least 3 characters";
            return false;
        }
        
        //Name can only be 20 characters long
        if(validateTextLength(name, 20, "First Name") == false){
            error = type + " cannot be more than 20 characters";
            return false;
        }
        
        //Name cannot contain special characters
        if(containsSpecialCharacter(name, true) == true){
            error = type + " cannot contain special characters";
            return false;
        }
        
        if(countWhitespace(name) > 3){
            error = "You can't have so many spaces in your name!";
            return false;
        }
        
        if(containsDigits(name)){
            //Contains numbers
            error = "How can you have numbers in your name?";
            return false;
        }
        
        return true;
    }
    
    //Returns true if special characters exist
    public boolean containsSpecialCharacter(String s) {
        if (!s.matches("[a-zA-Z0-9]+")) {
            //Special characters found
            return true;
        }
        
        return false;
    }
    
    //Overload function to ignore spaces
    public boolean containsSpecialCharacter(String s, boolean ignoreSpaces) {
        if(ignoreSpaces == true){
            if (!s.matches("[a-zA-Z0-9 ]+")) {
                //Special characters found
                return true;
            }
        }
        
        return false;
    }
    
    public boolean containsDigits(String str){
        //Checks if the string contains numbers
        if(str.matches(".*\\d.*")){
            //Contains numbers
            return true;
        }
        
        return false;
    }
    
    //Returns true if valid
    public boolean validateTextLength(String text, int length, String name){
        if(text.length() > length){
            error = name + " must be lesser than " + length + " characters";
            return false;
        }
        
        return true;
    }
    
    //Returns true if string is empty
    public boolean stringIsEmpty(String text){
        if(text.trim().equals("")){
            return true;
        } else {
            return false;
        }
    }
    
    public int countWhitespace(String text){
        int count = 0;
        for(int i = 0; i < text.length(); i++) {
             if(Character.isWhitespace(text.charAt(i))) {
                 count++;
             }
        }
        
        return count;
    }
    
    public boolean validateURL(String str){
        UrlValidator urlValidator = new UrlValidator();
        Util utility = new Util();
        
        if(utility.findStringOccurrence(str, "www.") > 0){
             //Check if .com/.net/.* exists
            if(utility.findStringOccurrence(str.substring(11), ".") == -1){
                return false;
            }
        }
        if(urlValidator.isValid(str)) {
           return true;
        } else {
           return false;
        }
    }
}
