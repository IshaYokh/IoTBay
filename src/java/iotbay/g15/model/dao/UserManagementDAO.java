/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.model.dao;

import iotbay.g15.model.Customer;
import iotbay.g15.model.Staff;
import iotbay.g15.model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin
 */
public class UserManagementDAO {

    private Statement st;

    public UserManagementDAO(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

//Find user by email and password in the database   
//    public User findUser(String email, String password) throws SQLException {
//        //setup the select sql query string       
//        //execute this query using the statement field       
//        //add the results to a ResultSet       
//        //search the ResultSet for a user using the parameters               
//        return null;
//    }
//Add a user-data into the database   
    public void addUser(String firstName, String lastName, String email, String password,
            int phoneNumber, int streetNumber, String streetName, String streetType,
            String suburb, String state, int postcode, String country) throws SQLException {                   //code for add-operation       
        st.executeUpdate("INSERT INTO \"USERS\" (FIRSTNAME, LASTNAME, EMAIL, PASSWORD, PHONENUMBER,"
                + " STREETNUMBER, STREETNAME, STREETTYPE, SUBURB, STATE, POSTCODE, COUNTRY) VALUES ("
                + " ' " + firstName + " ', " + " ' " + lastName + " ', " + " ' " + email + " ', "
                + " ' " + password + " ', " + " " + phoneNumber + ", " + " " + streetNumber + " , " + " ' " + streetName + " ', "
                + " ' " + streetType + " ', " + " ' " + suburb + " ', " + " ' " + state + " ', " + " " + postcode + ", "
                + " ' " + country + " ' "
                + ")");
    }

    public List<User> getUsers() throws SQLException {
        String SQL = "SELECT * FROM \"USERS\"";
        ResultSet rs = st.executeQuery(SQL);
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add(new User(
                    rs.getInt("USERID"),
                    rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"),
                    rs.getString("EMAIL"),
                    rs.getString("PASSWORD"),
                    rs.getInt("PHONENUMBER"),
                    rs.getInt("STREETNUMBER"),
                    rs.getString("STREETNAME"),
                    rs.getString("STREETTYPE"),
                    rs.getString("SUBURB"),
                    rs.getString("STATE"),
                    rs.getInt("POSTCODE"),
                    rs.getString("COUNTRY")
            ));
        }
        System.out.print("LISTOFGETUSERS");
        System.out.print(users);
        return users;
    }

    public User getUserById(int id) throws SQLException {
        String SQL = "SELECT * FROM \"USERS\" WHERE USERID=" + id;
        ResultSet rs = st.executeQuery(SQL);
        while (rs.next()) {
            if (id == rs.getInt("USERID")) {
                return new User(
                        rs.getInt("USERID"),
                        rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"),
                        rs.getString("EMAIL"),
                        rs.getString("PASSWORD"),
                        rs.getInt("PHONENUMBER"),
                        rs.getInt("STREETNUMBER"),
                        rs.getString("STREETNAME"),
                        rs.getString("STREETTYPE"),
                        rs.getString("SUBURB"),
                        rs.getString("STATE"),
                        rs.getInt("POSTCODE"),
                        rs.getString("COUNTRY")
                );
            }
        }
        return null;
    }
//update a user details in the database   

    public void updateUser(int userId, String firstName, String lastName, String email, String password,
            int phoneNumber, int streetNumber, String streetName, String streetType,
            String suburb, String state, int postcode, String country) throws SQLException {

        String SQL = "UPDATE \"USERS\" "
                + "SET FIRSTNAME=" + "'" + firstName + "',"
                + "LASTNAME=" + "'" + lastName + "',"
                + "EMAIL=" + "'" + email + "',"
                + "PASSWORD=" + "'" + password + "',"
                + "PHONENUMBER=" + "" + phoneNumber + ","
                + "STREETNUMBER=" + "" + streetNumber + ","
                + "STREETNAME=" + "'" + streetName + "',"
                + "STREETTYPE=" + "'" + streetType + "',"
                + "SUBURB=" + "'" + suburb + "',"
                + "STATE=" + "'" + state + "',"
                + "POSTCODE=" + "" + postcode + ","
                + "COUNTRY=" + "'" + country + "'"
                + " WHERE USERID=" + userId;

        System.out.print(SQL);
        st.executeUpdate(SQL);

    }

    //delete a user from the database   
    public void deleteUser(int id) throws SQLException {
        String SQL = "DELETE FROM \"USERS\" WHERE USERID=" + id;
        st.executeUpdate(SQL);
//        String SQL2 = "DELETE FROM \"STAFF\" WHERE USERID=" + id;
//        st.executeUpdate(SQL2);
//        String SQL3 = "DELETE FROM \"CUSTOMER\" WHERE USERID=" + id;
//        st.executeUpdate(SQL3);
    }

    public Staff getStaff(int userID) throws SQLException {
        String SQL = "SELECT * FROM \"STAFF\" WHERE USERID=" + userID;
        ResultSet rs = st.executeQuery(SQL);
        while (rs.next()) {
            if (userID == rs.getInt("USERID")) {
                return new Staff(
                        rs.getInt("USERID"),
                        rs.getString("DOB"),
                        rs.getInt("SITEACCESSLEVEL")
                );
            }
        }
        return null;
    }

    public void addStaff(int userID, String DOB, int siteAccessLevel) throws SQLException {                   //code for add-operation       
        st.executeUpdate("INSERT INTO \"STAFF\" (USERID, DOB, SITEACCESSLEVEL) VALUES ("
                + "" + userID + ", " + " ' " + DOB + " ', " + "" + siteAccessLevel
                + ")");
    }
    
    public void upgradeStaff(int userID, String DOB, int siteAccessLevel) throws SQLException {                   //code for add-operation         
        String SQL = "UPDATE \"STAFF\" "
                + "SET DOB=" + "'" + DOB + "',"
                + "SITEACCESSLEVEL=" + "" + siteAccessLevel + ""
                + " WHERE USERID=" + userID;

        st.executeUpdate(SQL);
    }
    
        public Customer getCustomer(int userID) throws SQLException {
        String SQL = "SELECT * FROM \"CUSTOMER\" WHERE USERID=" + userID;
        ResultSet rs = st.executeQuery(SQL);
        while (rs.next()) {
            if (userID == rs.getInt("USERID")) {
                return new Customer(
                        rs.getInt("LOYALTYPOINTS"),
                        rs.getInt("USERID")
                );
            }
        }
        return null;
    }

    public void addCustomer(int userID, int loyaltyPoints) throws SQLException {                   //code for add-operation       
        st.executeUpdate("INSERT INTO \"CUSTOMER\" (USERID, LOYALTYPOINTS) VALUES ("
                + "" + userID + ", " + "" + loyaltyPoints
                + ")");
    }
    
    public void upgradeCustomer(int userID, int loyaltyPoints) throws SQLException {                   //code for add-operation         
        String SQL = "UPDATE \"CUSTOMER\" "
                + "SET LOYALTYPOINTS=" + "" + loyaltyPoints + ""
                + " WHERE USERID=" + userID;

        st.executeUpdate(SQL);
    }
}
