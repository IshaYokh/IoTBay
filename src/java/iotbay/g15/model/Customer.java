/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.model;

/**
 *
 * @author Kevin
 */
public class Customer {

    private int loyaltyPoints;
    private int userID;

    public Customer(int loyaltyPoints, int userID) {
        this.loyaltyPoints = loyaltyPoints;
        this.userID = userID;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID() {
        this.userID = userID;
    }
}
