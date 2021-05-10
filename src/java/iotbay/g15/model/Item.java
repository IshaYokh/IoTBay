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
    
    public Item(int itemID, int itemSerialNumber, String itemCategory, String itemBrand, String itemName, String itemImage){
        this.itemID = itemID;
        this.itemSerialNumber = itemSerialNumber;
        this.itemCategory = itemCategory;
        this.itemBrand = itemBrand;
        this.itemName = itemName;
        this.itemImage = itemImage;
    }

    public int getItemID() {
        return itemID;
    }

    public int getItemSerialNumber() {
        return itemSerialNumber;
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

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setItemSerialNumber(int itemSerialNumber) {
        this.itemSerialNumber = itemSerialNumber;
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
    
}
