/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.model.dao;
import iotbay.g15.model.*;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author rebecca
 */
public class DBManager {
    private Statement st;
    
    public DBManager(Connection conn) throws SQLException{
        st = conn.createStatement();
    }
    
    
    //read user's order history
    public ArrayList<Order> findAllCustomerOrders(int userID) throws SQLException{
        ArrayList<Order> orderList = new ArrayList<Order>();
        String fetch = "SELECT * FROM ORDERS WHERE USERID = " + userID;
        System.out.println(userID);
        ResultSet rs = st.executeQuery(fetch);
        System.out.println(rs);
        String orderDate = "";
        
        while(rs.next()){
            String orderID = rs.getString(1);
            orderDate = rs.getString(4);
            String orderStatus = rs.getString(5);
            orderList.add(new Order(Integer.parseInt(orderID),orderDate, orderStatus));
        }
    return orderList;
    }
    
    
    //adds row for order to db
    public void addOrder(int orderID, String orderDate, String orderStatus) throws SQLException{
        st.executeUpdate("INSERT INTO ORDERS (ORDERID, ORDERDATE, ORDERSTATUS) VALUES(" + orderID + ", '" + orderDate + "', '" + orderStatus + "')");
    }
    
}
