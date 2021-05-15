/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.model;

import java.sql.Date;

/**
 *
 * @author Kevin
 */
public class Staff {

    private String DOB;
    private int siteAccessLevel;
    private int userID;

    public Staff() {
        
    }

    public Staff(int userID, String DOB, int siteAccessLevel) {
        this.userID = userID;
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
    
    public int getUserID() {
        return userID;
    }
    
    public void setUserID() {
        this.userID = userID;
    }
}
