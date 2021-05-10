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
        String fetch1 = "SELECT * FROM ORDERS WHERE USERID = " + userID;
        System.out.println(userID);
        ResultSet rs1 = st.executeQuery(fetch1);
        System.out.println(rs1);
        
        while(rs1.next()){
            ArrayList<OrderLineItem> items = new ArrayList<OrderLineItem>();
            String orderID = rs1.getString(1);
            //String customerID = rs1.getString(2);
            //String courierID = rs1.getString(3);
            String orderDate = rs1.getString(4);
            String orderStatus = rs1.getString(5);
            
            //String fetch2 = "SELECT * FROM ORDERLINE WHERE ORDERID = " + orderID;
            //ResultSet rs2 = st.executeQuery(fetch2);
            
            //while(rs2.next()){
            //    String itemID = rs2.getString(1);
            //    items.add(new OrderLineItem(Integer.parseInt(itemID), Integer.parseInt(orderID)));
            //}
        orderList.add(new Order(Integer.parseInt(orderID),orderDate, orderStatus));
        return orderList;
        }
    return null;
    }
    
    
    //adds row for order to db
    public void addOrder(int orderID, String orderDate, String orderStatus) throws SQLException{
        st.executeUpdate("INSERT INTO ORDERS (ORDERID, ORDERDATE, ORDERSTATUS) VALUES(" + orderID + ", '" + orderDate + "', '" + orderStatus + "')");
    }
    
}
