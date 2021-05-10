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
public class Customer extends User{
    private int loyaltyPoints;
    public Customer(int userID, String firstName, String lastName, String email, String password, String phoneNumber, String streetNumber, String streetName, String streetType, String suburb, String state, String postcode, String country, int loyaltyPoints) {
        super(userID, firstName, lastName, email, password, phoneNumber, streetNumber, streetName, streetType, suburb, state, postcode, country);
        this.loyaltyPoints = loyaltyPoints;
    }
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }
    
    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}
