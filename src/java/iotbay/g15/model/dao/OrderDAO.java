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
public class OrderDAO {
    private Statement st;
    private Statement st1;
    private Statement st2;
    private ArrayList<Item> cart = new ArrayList<Item>();
    
    public OrderDAO(Connection conn) throws SQLException{
        st = conn.createStatement();
        st1 = conn.createStatement();
        st2 = conn.createStatement();
    }
    
    
    //read user's order history
    public ArrayList<Order> findAllCustomerOrders(int userID) throws SQLException{
        int count = 0;
        ArrayList<Order> orderList = new ArrayList<Order>();
        String fetch = "SELECT * FROM ORDERS WHERE USERID = " + userID;
        System.out.println(userID);
        ResultSet rs = st.executeQuery(fetch);
        System.out.println(rs);
        
        while(rs.next()){
            String orderID = rs.getString(1);
            String orderDate = rs.getString(4);
            String orderStatus = rs.getString(5);
            orderList.add(new Order(Integer.parseInt(orderID), orderDate, orderStatus));
            Order o = orderList.get(count++);
            String fetch1 = "SELECT * FROM ORDERLINE WHERE ORDERID =" + o.getID();
            ResultSet rs1 = st1.executeQuery(fetch1);
            
            while(rs1.next()){
               int itemID = Integer.parseInt(rs1.getString(1));
               String fetch2 = "SELECT * FROM ITEM WHERE ITEMID =" + itemID;
               ResultSet rs2 = st2.executeQuery(fetch2);
               
               while(rs2.next()){
                   int itemSerialNumber = Integer.parseInt(rs2.getString(2));
                   String itemCategory = rs2.getString(3);
                   String itemBrand = rs2.getString(4);
                   String itemName = rs2.getString(5);
                   String itemImage = rs2.getString(6);
                   
                   o.addOrderedProduct(new Item(itemID, itemSerialNumber, itemCategory, itemBrand, itemName, itemImage));
               }
            }
        }
    return orderList;
    }
    
    
    
    //adds row for order to db
    public void addOrder(int orderID, String orderDate, String orderStatus) throws SQLException{
        st.executeUpdate("INSERT INTO ORDERS (ORDERID, ORDERDATE, ORDERSTATUS) VALUES(" + orderID + ", '" + orderDate + "', '" + orderStatus + "')");
    }
    
    public void addToCart(Item item) throws SQLException{
        cart.add(item);
        System.out.println("cart size: " + cart.size());
    }
    
    public ArrayList<Item> getCart() throws SQLException{
        return cart;
    }
   
}
