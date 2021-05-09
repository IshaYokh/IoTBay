/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.model.dao;

/**
 *
 * @author kaushikdeshpande
 */
import iotbay.g15.model.User;
import java.sql.*;
public class DBManager {
    private Statement st;
   
    public DBManager(Connection conn) throws SQLException {       
        st = conn.createStatement();
    }
    
    //adds user to the database
    public void addUser(String firstname, String lastname, String password, String phonenumber, String streetnumber, String streetname, String streettype, String suburb, String state, String postcode, String country, String email) throws SQLException{
        //st.executeUpdate();
        String fetch = "INSERT INTO TEMP.USERS (USERID,FIRSTNAME, LASTNAME, PASSWORD, PHONENUMBER, STREETNUMBER, STREETNAME, STREETTYPE, SUBURB, STATE, POSTCODE, COUNTRY, EMAIL) VALUES (DEFAULT,'" + firstname + "', '" + lastname + "', '"+ password + "'," + phonenumber + ", " + streetnumber +", '" + streetname +"', '" + streettype + "', '" + suburb + "', '" + state + "'," + postcode + ", '" +country+ "', '"+email+"')";
    
       st.execute(fetch);
    
    
    }
    //removes user
    public void deleteUser() throws SQLException{
    
    
    
    
    }
    //check user email is alredy registered
    public boolean checkUserEmail(String email) throws SQLException{
        String fetch ="select EMAIL from TEMP.USERS where EMAIL ="+ "'" + email+ "'";
        System.out.println(fetch);
        ResultSet rs = st.executeQuery(fetch);
        while(rs.next()){

            String emails = rs.getString(1);

            if(email.equals(emails)){
                return false;

                }
            }
        return true;
    }
    
   public boolean checkUser(String email, String password) throws SQLException{
        
           
        String fetch = "SELECT EMAIL, PASSWORD from TEMP.USERS WHERE EMAIL = '" + email + "' AND PASSWORD = '" + password +"'" ;
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()){

            String emails = rs.getString(1);
            String passwords = rs.getString(2);

            if((password.equals(passwords)) && email.equals(emails)){
                return true;

                }
            }
        return false;
        
    }
   
   public User getUser(String email, String password) throws SQLException{
   
   String fetch = "SELECT * from TEMP.USERS WHERE EMAIL = '" + email + "' AND PASSWORD = '" + password +"'" ;
   ResultSet rs = st.executeQuery(fetch);
    while (rs.next()){
   String userid = rs.getString(1);
   String firstname =  rs.getString(2);
   String lastname = rs.getString(3);
   String emails = rs.getString(4);
   String passwords = rs.getString(5);
   String phonenumber = rs.getString(6);
   String streetnumber = rs.getString(7);
   String streetname = rs.getString(8);
   String streettype = rs.getString(9);
   String suburb = rs.getString(10);
   String state = rs.getString(11);
   String postcode = rs.getString(12);
   String country = rs.getString(13);
   
   User user = new User(firstname, lastname, emails, passwords, phonenumber ,streetnumber, streetname, streettype, suburb, state, postcode, country);
   return user;
   }
  
   
   return null;
   
 
   
   }
    
}
