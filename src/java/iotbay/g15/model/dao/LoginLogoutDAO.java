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
import java.util.ArrayList;

public class LoginLogoutDAO {

    private final Statement st;

    public LoginLogoutDAO(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

    //adds user to the database
    public void addUser(String firstname, String lastname, String password, int phonenumber, int streetnumber, String streetname, String streettype, String suburb, String state, int postcode, String country, String email) throws SQLException {
        //st.executeUpdate();
        String fetch = "INSERT INTO IOTBAY.USERS (USERID,FIRSTNAME, LASTNAME, PASSWORD, PHONENUMBER, STREETNUMBER, STREETNAME, STREETTYPE, SUBURB, STATE, POSTCODE, COUNTRY, EMAIL) VALUES (DEFAULT,'" + firstname + "', '" + lastname + "', '" + password + "'," + phonenumber + ", " + streetnumber + ", '" + streetname + "', '" + streettype + "', '" + suburb + "', '" + state + "'," + postcode + ", '" + country + "', '" + email + "')";

        st.execute(fetch);

    }

    //removes user
    public void addCustomer(int userID) throws SQLException {

        String fetch = "INSERT INTO IOTBAY.CUSTOMER VALUES (" + userID + ", 0)";
        st.execute(fetch);
    }

    public void addStaff(int userID, String dob) throws SQLException {

        String fetch = "INSERT INTO IOTBAY.STAFF VALUES (" + userID + ", 0,'" + dob + "')";
        st.execute(fetch);
    }

    public void deleteCustomer(int userID) throws SQLException {

        String fetch = "DELETE FROM IOTBAY.CUSTOMER WHERE USERID=" + userID;

        st.executeUpdate(fetch);

    }

    //check user email is alredy registered
    public boolean checkUserEmail(String email) throws SQLException {
        String fetch = "select EMAIL from IOTBAY.USERS where EMAIL =" + "'" + email + "'";
        System.out.println(fetch);
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {

            String emails = rs.getString(1);

            if (email.equals(emails)) {
                return false;

            }
        }
        return true;
    }

    public boolean checkUser(String email, String password) throws SQLException {

        String fetch = "SELECT EMAIL, PASSWORD from IOTBAY.USERS WHERE EMAIL = '" + email + "' AND PASSWORD = '" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {

            String emails = rs.getString(1);
            String passwords = rs.getString(2);
            
            if ((password.equals(passwords)) && email.equals(emails)) {
                return true;

            }
        }
        return false;

    }

    public User getUser(String email, String password) throws SQLException {

        String fetch = "SELECT * from IOTBAY.USERS WHERE EMAIL = '" + email + "' AND PASSWORD = '" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            String userid = rs.getString(1);
            int userID = Integer.parseInt(userid);
            String firstname = rs.getString(2);
            String lastname = rs.getString(3);
            String emails = rs.getString(4);
            String passwords = rs.getString(5);
            int phonenumber =  Integer.parseInt(rs.getString(6));
            int streetnumber = Integer.parseInt(rs.getString(7));
            String streetname = rs.getString(8);
            String streettype = rs.getString(9);
            String suburb = rs.getString(10);
            String state = rs.getString(11);
            int postcode = Integer.parseInt(rs.getString(12));
            String country = rs.getString(13);

            User user = new User(userID, firstname, lastname, emails, passwords, phonenumber, streetnumber, streetname, streettype, suburb, state, postcode, country);
            return user;
        }

        return null;

    }

    public void editUser(String firstname, String lastname, String password, int phonenumber, int streetnumber, String streetname, String streettype, String suburb, String state, int postcode, String country, String email, int userID) throws SQLException {
        //st.executeUpdate();
        String fetch = "UPDATE IOTBAY.USERS SET FIRSTNAME = '" + firstname + "', LASTNAME = '" + lastname + "', PASSWORD = '" + password + "', PHONENUMBER = " + phonenumber + ", STREETNUMBER = " + streetnumber + ", STREETNAME = '" + streetname + "', STREETTYPE = '" + streettype + "', SUBURB= '" + suburb + "', STATE = '" + state + "', postcode =" + postcode + ", COUNTRY='" + country + "', EMAIL ='" + email + "' WHERE USERID =" + userID;
        //+ "(DEFAULT,'" + firstname + "', '" + lastname + "', '"+ password + "'," + phonenumber + ", " + streetnumber +", '" + streetname +"', '" + streettype + "', '" + suburb + "', '" + state + "'," + postcode + ", '" +country+ "', '"+email+"')";

        st.executeUpdate(fetch);

    }

    public int getUserID(String email, String password) throws SQLException {

        String fetch = "SELECT EMAIL, PASSWORD, USERID from IOTBAY.USERS WHERE EMAIL = '" + email + "' AND PASSWORD = '" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {

            String emails = rs.getString(1);
            String passwords = rs.getString(2);
            String userid = rs.getString(3);

            if ((password.equals(passwords)) && email.equals(emails)) {
                int userID = Integer.parseInt(userid);
                return userID;
            }

        }
        return 0;
    }

    public void deleteUser(int userID) throws SQLException {
        //st.executeUpdate();
        String fetch = "DELETE FROM IOTBAY.USERS WHERE USERID=" + userID;

        st.executeUpdate(fetch);

    }

    public void addlogslogout(int userID) throws SQLException {
        String logout1 = "Logged Out";
        String fetch = "INSERT INTO IOTBAY.ACCLOGS (USERID, ACTION ,Current_Time_Stamp) VALUES (" + userID + ",'" + logout1 + "',CURRENT_TIMESTAMP)";
        st.executeUpdate(fetch);

    }

    public void addlogslogin(int userID) throws SQLException {
        String login1 = "Logged In";
        String fetch = "INSERT INTO IOTBAY.ACCLOGS (USERID, ACTION ,Current_Time_Stamp) VALUES (" + userID + ",'" + login1 + "',CURRENT_TIMESTAMP)";
        st.executeUpdate(fetch);

    }

    public void addlogsregister(int userID) throws SQLException {
        String login1 = "Registered";
        String fetch = "INSERT INTO IOTBAY.ACCLOGS (USERID, ACTION ,Current_Time_Stamp) VALUES (" + userID + ",'" + login1 + "',CURRENT_TIMESTAMP)";
        st.executeUpdate(fetch);

    }

    public ArrayList getLogs(int userID) throws SQLException {

        ArrayList loglist = new ArrayList();

        String fetch = "select * from IOTBAY.ACCLOGS where USERID =" + userID;
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String action = rs.getString(2);

            loglist.add(action);

        }

        return loglist;
    }

    public ArrayList getTLogs(int userID) throws SQLException {

        ArrayList loglist = new ArrayList();

        String fetch = "select * from IOTBAY.ACCLOGS where USERID =" + userID;
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {

            String timedate = rs.getString(3);

            loglist.add(timedate);

        }

        return loglist;
    }
}
