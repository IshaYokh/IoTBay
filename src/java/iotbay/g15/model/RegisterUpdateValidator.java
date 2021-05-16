/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.model;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author kaushikdeshpande
 */
public class RegisterUpdateValidator {
   
    public String validatePassword(String password){
    
        Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$");
        Matcher m = p.matcher(password);
        Boolean b = m.matches();
        if(b){
        
        return null;
        }else{
        
        
        return "Password must contain at least One Digit, One Uppercase and Lowercase character. Password must be 8-20 Characters long.";
        }
    }
    
 
    public String validateEmail(String email){
        Pattern p = Pattern.compile("^(.+)@(.+)$");
        Matcher m = p.matcher(email);
        Boolean b = m.matches();
        if(b){
        return null;
        }else{
        return "Please Enter Valid Email";}
    }
    
    public String validatePhone(String phone){
        Pattern p = Pattern.compile("[0-9]{8,12}");
        Matcher m = p.matcher(phone);
        Boolean b = m.matches();
        if(b){
        return null;
        }else{
        return "Please Enter Valid Phone Number";}
    }
    
    public String validatePostCode(String post){
        Pattern p = Pattern.compile("^\\d{4}$");
        Matcher m = p.matcher(post);
        Boolean b = m.matches();
        if(b){
        return null;
        }else{
        return "Please Enter Valid PostCode";}
    }
    
    public String validateStreetNo(String streetNo){
        Pattern p = Pattern.compile("^\\d{1,4}$");
        Matcher m = p.matcher(streetNo);
        Boolean b = m.matches();
        if(b){
        return null;
        }else{
        return "Please Enter Valid Street Number";}
    }
    
    public String validateFname(String name){
    
        Pattern p = Pattern.compile("[a-zA-Z]*");
        Matcher m = p.matcher(name);
        Boolean b = m.matches();
        if(b){
        return null;
        }else{
        return "Please Enter Valid First Name";}
    }
    public String validateLname(String name){
    
        Pattern p = Pattern.compile("[a-zA-Z]*");
        Matcher m = p.matcher(name);
        Boolean b = m.matches();
        if(b){
        return null;
        }else{
        return "Please Enter Valid Last Name";}
    }

}
