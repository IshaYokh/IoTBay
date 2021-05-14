package iotbay.g15.model.dao;

import iotbay.g15.model.Customer;
import java.sql.*;
import java.util.HashMap;

/* 
* CustomerDAO is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class CustomerDAO {
    private Statement st;

    public CustomerDAO(Connection conn) throws SQLException {       
       st = conn.createStatement();   
    }

    //Find user by id in the database   
    public Customer findCustomer(int id) throws SQLException {       
        String fetch = "select * from ISD.CUSTOMER where ID = " + id;
        ResultSet rs = st.executeQuery(fetch);

        if (rs.next()){
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);
            String email = rs.getString(4);
            String password = rs.getString(5);
            String phoneNumber = rs.getString(6);
            String streetNumber = rs.getString(7);
            String streetName = rs.getString(8);
            String streetType = rs.getString(9);
            String suburb = rs.getString(10);
            String state = rs.getString(11);
            String postcode = rs.getString(12);
            String country = rs.getString(13);
            boolean status = rs.getBoolean(14);

            return new Customer(firstName, lastName,
                                email, password, phoneNumber,
                                streetNumber, streetName, streetType,
                                suburb, state, postcode, country, status);
        }
        
        return null;   
    }

    //Add a user-data into the database   
    public void addCustomer(String firstName, String lastName, String email, String password, String phoneNumber, String streetNumber, String streetName, String streetType, String suburb, String state, String postcode, String country) throws SQLException {                   //code for add-operation       
        st.executeUpdate("INSERT INTO ISD.Customer (firstname, lastname, " +
                                                   "email, password, phonenumber, " +
                                                   "streetnumber, streetname, streettype, " +
                                                   "suburb,state, postcode, country, status) " +
                         "VALUES ('" + firstName + "', '" + lastName + "', '" +
                                  email + "', '" + password + "', '" + phoneNumber + "', '" +
                                  streetNumber + "', '" + streetName + "', '" + streetType + "', '" +
                                  suburb + "', '" + state + "', '" + postcode + "', '" + country + "', true)");   

    }

    //update a user details in the database   
    public void updateCustomer(int id, String firstName, String lastName, String email, String phoneNumber, String streetNumber, String streetName, String streetType, String suburb, String state, String postcode, String country) throws SQLException {       
        //code for update-operation   
        st.executeUpdate("UPDATE ISD.Customer SET FIRSTNAME='" + firstName +
                                              "', LASTNAME='" + lastName +
                                              "', EMAIL='" + email +
                                              "', PHONENUMBER='" + phoneNumber +
                                              "', STREETNUMBER='" + streetNumber +
                                              "', STREETNAME='" + streetName +
                                              "', STREETTYPE='" + streetType +
                                              "', SUBURB='" + suburb +
                                              "', STATE='" + state +
                                              "', POSTCODE='" + postcode +
                                              "', COUNTRY='" + country +
                         "' WHERE ID=" + id);
    }       

    //delete a user from the database   
    public void deleteCustomer(String email) throws SQLException{       
        //code for delete-operation   
        st.executeUpdate("DELETE FROM ISD.Customer WHERE EMAIL='" + email + "'");
    }

    public HashMap<Integer, Customer> fetchCustomer() throws SQLException{
        String fetch = "select * from CUSTOMER order by 1";
        ResultSet rs = st.executeQuery(fetch);
        HashMap<Integer, Customer> customers = new HashMap<>();

        while (rs.next()){
            int id = rs.getInt(1);
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);
            String email = rs.getString(4);
            String password = rs.getString(5);
            String phoneNumber = rs.getString(6);
            String streetNumber = rs.getString(7);
            String streetName = rs.getString(8);
            String streetType = rs.getString(9);
            String suburb = rs.getString(10);
            String state = rs.getString(11);
            String postcode = rs.getString(12);
            String country = rs.getString(13);
            boolean status = rs.getBoolean(14);
            
            customers.put(id,
                          new Customer(firstName, lastName,
                                       email, password ,phoneNumber,
                                       streetNumber, streetName, streetType,
                                       suburb, state, postcode, country, status));
        }
        
        return customers;
    }

    public boolean checkCustomer(String email, String password) throws SQLException{
        String fetch = "select * from ISD.Customer where EMAIL = '" + email + "' and password= '" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()){
            String customerEmail = rs.getString(3);
            String customerPass = rs.getString(4);
            if (customerEmail.equals(email) && customerPass.equals(password)){
                return true;
            }
        }
        return false;
    }
}
