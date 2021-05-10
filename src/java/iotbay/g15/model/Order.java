/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author rebecca
 */
public class Order implements Serializable{
    private int orderID;
    private Customer customer;
    private ArrayList<OrderLineItem> items;
    private String orderDate;
    private String orderStatus;

    public Order(int orderID, String orderDate, String orderStatus){
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public int getID() {
        return orderID;
    }
    
    public void setID(int ID) {
        this.orderID = ID;
    }

    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public ArrayList<OrderLineItem> getOrderedProducts(){
        return items;
    }
    
    public void setOrderedItems(ArrayList<OrderLineItem> items){
        this.items = items;
    }

    public String getOrderDate(){
        return orderDate;
    }
    
    public void setOrderDate(String orderDate){
        this.orderDate = orderDate;
    }

    public String getOrderStatus(){
        return orderStatus;
    }
    public void setOrderStatus(String status){
        this.orderStatus = status;
    }

}