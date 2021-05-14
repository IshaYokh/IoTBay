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
        ResultSet rs = st.executeQuery(fetch);
        
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
    
    //add to cart
    public void addToCart(int userID, int itemID, int serialNumber, String itemCategory, String itemBrand, String itemName, String itemImage, int itemQty) throws SQLException{
        String fetch = "SELECT * FROM CART WHERE ITEMID = " + itemID + " AND USERID = " + userID;
        ResultSet rs = st.executeQuery(fetch);
        int i = 0;
        while(rs.next()){
            i++;
        }
        if(i > 0){
            st.executeUpdate("UPDATE CART SET ITEMQTY = " + itemQty + " WHERE ITEMID = " + itemID + " AND USERID = " + userID);
            }else{
            st.executeUpdate("INSERT INTO CART (USERID, ITEMID, ITEMSERIALNUMBER, ITEMCATEGORY, ITEMBRAND, ITEMNAME, ITEMIMAGE, ITEMQTY) VALUES (" + userID + ", " + itemID + ", " + serialNumber + ", '" + itemCategory + "', '" + itemBrand + "', '" + itemName + "', '" + itemImage + "', " + itemQty + ")");
        
        }
    }
    
    public ArrayList<Item> getCart(int user) throws SQLException{
        ArrayList<Item> cart = new ArrayList<Item>();
        String fetch = "SELECT * FROM CART WHERE USERID = " + user;
        ResultSet rs = st.executeQuery(fetch);
            while(rs.next()){
                String itemID = rs.getString(2);
                String itemSerialNumber = rs.getString(3);
                String itemCategory = rs.getString(4);
                String itemBrand = rs.getString(5);
                String itemName = rs.getString(6);
                String itemImage = rs.getString(7);
                String itemQty = rs.getString(8);
                double itemPrice = rs.getDouble(9);
                int iID = Integer.parseInt(itemID);
                int iSN = Integer.parseInt(itemSerialNumber);
                int qty = Integer.parseInt(itemQty);
                Item item = new Item(iID, iSN, itemCategory, itemBrand, itemName, itemImage);
                item.setUserQuantity(qty);
                double subtotal = (itemPrice * qty);
                item.setItemPrice(subtotal);
                cart.add(item);
            }
        return cart;
    }
    
    public int getQuantityInCart(int user, int item) throws SQLException{
        String fetch = "SELECT ITEMQTY FROM CART WHERE USERID = " + user + " AND ITEMID = " + item;
        ResultSet rs = st.executeQuery(fetch);
        int count = 0;
            while(rs.next()){
                String itemQty = rs.getString("ITEMQTY");
                count = Integer.parseInt(itemQty);
            }
        return count;
    }
    
    public Item getItemByID(int userID, int item) throws SQLException{
        for(Item i : this.getCart(userID)){
            if(i.getItemID() == item){
                return i;
            }
        }
        return null;
    }
    
    /**public int getItemPrice(int itemid)throws SQLException{
        String fetch = "SELECT ITEMPRICE FROM CATALOGUE WHERE ITEMID = " + itemid;
        ResultSet rs = st.executeQuery(fetch);
        int price = 0;
            while(rs.next()){
                String itemPrice = rs.getString("itemPrice");
                price = Integer.parseInt(itemPrice);
            }
        return price;
    }**/
    
    public void updateItemQuantity(int user, int item, int itemQty) throws SQLException{
        st.executeUpdate("UPDATE CART SET ITEMQTY = " + itemQty + " WHERE ITEMID = " + item + " AND USERID = " + user);
    }
    
    public void removeFromCart(int user, int item) throws SQLException{
        String fetch = "DELETE FROM CART WHERE USERID = " + user + " AND ITEMID = " + item;
        try{
            st.executeUpdate(fetch);
        }catch(SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void emptyCart(int user) throws SQLException{
        String fetch = "DELETE FROM CART WHERE USERID = " + user;
        try{
            st.executeUpdate(fetch);
        }catch(SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}