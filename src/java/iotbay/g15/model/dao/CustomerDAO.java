package iotbay.g15.model.dao;

import iotbay.g15.model.Customer;
import iotbay.g15.model.CustomerUser;
import java.sql.*;
import java.util.ArrayList;

/* 
* CustomerDAO is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class CustomerDAO {
    private Statement st;

    public CustomerDAO(Connection conn) throws SQLException {       
       st = conn.createStatement();   
    }

    //Find user by email in the database   
    public Customer findCustomer(String email, String password) throws SQLException {       
        String fetch = "select * from USERS where EMAIL = '" + email +
                                            "' and PASSWORD = '" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        if (rs.next()){
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);
            int phoneNumber = Integer.parseInt(rs.getString(6));
            int streetNumber = Integer.parseInt(rs.getString(7));
            String streetName = rs.getString(8);
            String streetType = rs.getString(9);
            String suburb = rs.getString(10);
            String state = rs.getString(11);
            int postcode = Integer.parseInt(rs.getString(12));
            String country = rs.getString(13);

            return new Customer(firstName, lastName,
                                email, password, phoneNumber,
                                streetNumber, streetName, streetType,
                                suburb, state, postcode, country);
        }
        
        return null;   
    }

    //Add a user-data into the database   
    public void addCustomer(String firstName, String lastName, String email, String password, int phoneNumber, int streetNumber, String streetName, String streetType, String suburb, String state, int postcode, String country) throws SQLException {                   //code for add-operation       
        st.executeUpdate("INSERT INTO USERS (firstname, lastname, " +
                                               "email, password, phonenumber, " +
                                               "streetnumber, streetname, streettype, " +
                                               "suburb,state, postcode, country) " +
                         "VALUES ('" + firstName + "', '" + lastName + "', '" +
                                  email + "', '" + password + "', " + phoneNumber + ", " +
                                  streetNumber + ", '" + streetName + "', '" + streetType + "', '" +
                                  suburb + "', '" + state + "', " + postcode + ", '" + country + "')");   

    }

    //update a user details in the database   
    public void updateCustomer(String firstName, String lastName, String email, String password, int phoneNumber, int streetNumber, String streetName, String streetType, String suburb, String state, int postcode, String country) throws SQLException {       
        //code for update-operation   
        st.executeUpdate("UPDATE USERS SET FIRSTNAME='" + firstName +
                                          "', LASTNAME='" + lastName +
                                          "', PHONENUMBER=" + phoneNumber +
                                          ", STREETNUMBER=" + streetNumber +
                                          ", STREETNAME='" + streetName +
                                          "', STREETTYPE='" + streetType +
                                          "', SUBURB='" + suburb +
                                          "', STATE='" + state +
                                          "', POSTCODE=" + postcode +
                                          ", COUNTRY='" + country +
                         "' WHERE EMAIL = '" + email + "' and PASSWORD = '" + password + "'");
    }       

    //delete a user from the database   
    public void deleteCustomer(String email) throws SQLException{       
        //code for delete-operation   
        st.executeUpdate("DELETE FROM USERS WHERE EMAIL='" + email + "'");
    }

    public ArrayList<Customer> fetchCustomer() throws SQLException{
        String fetch = "select * from USERS order by 1";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Customer> customers = new ArrayList<>();

        while (rs.next()){
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);
            String email = rs.getString(4);
            String password = rs.getString(5);
            int phoneNumber = Integer.parseInt(rs.getString(6));
            int streetNumber = Integer.parseInt(rs.getString(7));
            String streetName = rs.getString(8);
            String streetType = rs.getString(9);
            String suburb = rs.getString(10);
            String state = rs.getString(11);
            int postcode = Integer.parseInt(rs.getString(12));
            String country = rs.getString(13);
            
            customers.add(new Customer(firstName, lastName,
                                       email, password ,phoneNumber,
                                       streetNumber, streetName, streetType,
                                       suburb, state, postcode, country));
        }
        
        return customers;
    }

    public boolean checkCustomer(String email, String password) throws SQLException{
        String fetch = "select * from USERS where EMAIL = '" + email + "' and password = '" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()){
            String customerEmail = rs.getString(4);
            String customerPass = rs.getString(5);
            if (customerEmail.equals(email) && customerPass.equals(password)){
                return true;
            }
        }
        return false;
    }
}
