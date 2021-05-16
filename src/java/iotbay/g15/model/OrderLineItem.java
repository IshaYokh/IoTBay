/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.model;

/**
 *
 * @author rebecca
 */
public class OrderLineItem {
    private int itemID;
    private int orderID;
    
    public OrderLineItem(int itemID, int orderID){
        this.itemID = itemID;
        this.orderID = orderID;
    }
    
    public int getItemID(){
        return itemID;
    }
    
    public void setItemID(int itemID){
        this.itemID = itemID;
    }
    
    public int getOrderID(){
        return orderID;
    }
    
    public void setOrderID(int orderID){
        this.orderID = orderID;
    }
}
