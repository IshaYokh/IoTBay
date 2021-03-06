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

import java.sql.*;
import java.util.ArrayList;
import iotbay.g15.model.Item;



public class ShowItemDAO {
private final Statement st;
private final Statement st1;


    public ShowItemDAO(Connection conn) throws SQLException {
        st = conn.createStatement();
        st1 = conn.createStatement();
        
        
    }
    
    // get item
    public Item getItem(int itemID) throws SQLException{
        Item item3;
        String fetch = "SELECT * from IOTBAY.ITEM WHERE ITEMID = " + itemID  ;
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
         String fetch2 = "SELECT * from IOTBAY.CATALOGUE WHERE ITEMID = "+ itemID ;
         ResultSet rs1 = st1.executeQuery(fetch2);
         rs1.next();
         String itemcat = rs.getString(3);
         String itemname = rs.getString(5);
         String itembrand = rs.getString(4);
         String itemprice = rs1.getString(5);
         String itemquantity = rs1.getString(4);
         String itemserial = rs.getString(2);
         String itemImage = rs.getString(6);
         int itemSerial = Integer.parseInt(itemserial);
         double itemPrice = Double.parseDouble(itemprice);
         int itemQuantity = Integer.parseInt(itemquantity);
         item3 = new Item(itemID, itemSerial, itemcat, itembrand, itemname, itemImage, itemPrice, itemQuantity);
         return item3;
        }
    
    
    
    return null;
    }
    
    //get Categories
    
    public ArrayList getCategories() throws SQLException{
    
    // sql distinct statement
        String fetch = "SELECT ITEMCATEGORY FROM IOTBAY.ITEM GROUP BY ITEMCATEGORY";
    //returns an array of Category strings
        ResultSet rs = st.executeQuery(fetch);
        ArrayList catList = new ArrayList();
        while(rs.next()){
            String cat = rs.getString(1);
            catList.add(cat);
        
        
        
        }
        
    
    
    
    
    return catList;
    }
    
   
    //get product list
    
    public ArrayList<Item> getProductlist(String category) throws SQLException{
        
    
    String fetch = "SELECT * from IOTBAY.ITEM WHERE ITEMCATEGORY = '" + category + "'" ;
    ResultSet rs = st.executeQuery(fetch);
    ArrayList<Item> proList = new ArrayList<Item>();
        while (rs.next()) {
         String itemcat = rs.getString(3);
         String itemname = rs.getString(5);
         String itembrand = rs.getString(4);
         String itemID = rs.getString(1);
         String itemImage = rs.getString(6);
         String fetch2 = "SELECT * from IOTBAY.CATALOGUE WHERE ITEMID = "+ itemID ;
         ResultSet rs1 = st1.executeQuery(fetch2);
         rs1.next();
         String itemprice = rs1.getString(5);
         String itemquantity = rs1.getString(4);
         String itemserial = rs.getString(2);
         int itemid = Integer.parseInt(itemID);
         int itemSerial = Integer.parseInt(itemserial);
         double itemPrice = Double.parseDouble(itemprice);
         int itemQuantity = Integer.parseInt(itemquantity);
         Item item3 = new Item(itemid, itemSerial, itemcat, itembrand, itemname, itemImage, itemPrice, itemQuantity);
         proList.add(item3);
        }
    
     return proList;
    }
    
     public String getItemImage(int itemID) throws SQLException{
        String fetch = "SELECT * from IOTBAY.ITEM WHERE ITEMID = " + itemID ;
        ResultSet rs = st.executeQuery(fetch);
        while(rs.next()){

            String itemimage = rs.getString(6);
            return itemimage;
        }
         return null;
     }
    
    public ArrayList getProductlistImage(String category) throws SQLException{
    String fetch = "SELECT * from IOTBAY.ITEM WHERE ITEMCATEGORY = '" + category + "'" ;
    ResultSet rs = st.executeQuery(fetch);
    ArrayList proListImage = new ArrayList();
        while (rs.next()) {
         String itemImage = rs.getString(6);
         proListImage.add(itemImage);
         
      
        }
    
    
    
     return proListImage;
    }
    public void AddItem3(int itemID, int itemserial,String cat, String name, String brand, String itemImage, int quantity, double price) throws SQLException{
        
        String image = "nothing";
        String fetch = "INSERT INTO IOTBAY.ITEM (ITEMID, ITEMSERIALNUMBER, ITEMCATEGORY, ITEMBRAND, ITEMNAME, ITEMIMAGE) VALUES (" +itemID+ ", " + itemserial + ", '" + cat + "', '" + brand +"', '" + name + "', '" + itemImage +"')";
        st.execute(fetch);
        
        
        //if suplier id exsists
         // get suplier if (itemID)
            //if suplier id exsists
        String fetch1 = "INSERT INTO IOTBAY.CATALOGUE VALUES (1,"+ itemID+ ",'nothin', " + quantity + ", " + price + ")";
        st1.execute(fetch1);
        

    }
    
}
