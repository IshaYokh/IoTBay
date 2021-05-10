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
public class Staff extends User{
    private String DOB;
    private int siteAccessLevel;
    public Staff(int userID,String firstName, String lastName, String email, String password, String phoneNumber, String streetNumber, String streetName, String streetType, String suburb, String state, String postcode, String country, String DOB, int siteAccessLevel) {
        super(userID, firstName, lastName, email, password, phoneNumber, streetNumber, streetName, streetType, suburb, state, postcode, country);
        this.DOB = DOB;
        this.siteAccessLevel = siteAccessLevel;
    }
    public String getDOB() {
        return DOB;
    }

    public int getSiteAccessLevel() {
        return siteAccessLevel;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setSiteAccessLevel(int siteAccessLevel) {
        this.siteAccessLevel = siteAccessLevel;
    }
}