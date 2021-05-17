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
public class Item {
    private int itemID;
    private int itemSerialNumber;
    private String itemCategory;
    private String itemBrand;
    private String itemName;
    private String itemImage;
    private int userQuantity;
    private double itemPrice;
    private int productQuantity;
    private double productPrice;
    
    public Item(int itemID, int itemSerialNumber, String itemCategory, String itemBrand, String itemName, String itemImage){
        this.itemID = itemID;
        this.itemSerialNumber = itemSerialNumber;
        this.itemCategory = itemCategory;
        this.itemBrand = itemBrand;
        this.itemName = itemName;
        this.itemImage = itemImage;
    
    }

    public Item(int itemID, int itemSerialNumber, String itemCategory, String itemBrand, String itemName, String itemImage, double productPrice, int productQuantity) {
        this.itemID = itemID;
        this.itemSerialNumber = itemSerialNumber;
        this.itemCategory = itemCategory;
        this.itemBrand = itemBrand;
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
  
    public int getItemSerialNumber() {
        return itemSerialNumber;
    }

    public void setItemSerialNumber(int itemSerialNumber) {
        this.itemSerialNumber = itemSerialNumber;
    }
  
    public String getItemCategory() {
        return itemCategory;
    }

    public String getItemBrand() {
        return itemBrand;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }
    
    public int getUserQuantity() {
        return userQuantity;
    }

    public void setUserQuantity(int qty) {
        this.userQuantity = qty;
    }
    
    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double price) {
        this.itemPrice = price;
    }
  
    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
