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
    private ArrayList<Item> items;
    private ArrayList<Item> cart;
    private String orderDate;
    private String orderStatus;

    public Order(int orderID, String orderDate, String orderStatus){
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.items = new ArrayList<Item>();
        this.cart = new ArrayList<Item>();
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

    public ArrayList<Item> getOrderedProducts(){
        return items;
    }
    
    public void addOrderedProduct(Item item){
        items.add(item);
    }
    
    public void setOrderedItems(ArrayList<Item> items){
        this.items = items;
    }
    
    public ArrayList<Item> getCart(){
        return cart;
    }
    
    public void addToCart(Item item){
        cart.add(item);
    }
    
    public void setCart(ArrayList<Item> items){
        this.cart = items;
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