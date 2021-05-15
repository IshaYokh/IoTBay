/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.model;

/**
 *
 * @author Austin
 */
public class Item {
    int itemID;
    int itemSerialNumber;
    String itemCategory;
    String itemBrand;
    String itemName;
    double productPrice;
    int productQuantity;

    public Item(int itemID, int itemSerialNumber, String itemCategory, String itemBrand, String itemName, double productPrice, int productQuantity) {
        this.itemID = itemID;
        this.itemSerialNumber = itemSerialNumber;
        this.itemCategory = itemCategory;
        this.itemBrand = itemBrand;
        this.itemName = itemName;
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

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemBrand() {
        return itemBrand;
    }

    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

