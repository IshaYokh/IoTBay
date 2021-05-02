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
public class Staff extends User {

    private String DOB;
    private int siteAccessLevel;

    public Staff() {
        super();
    }

    public Staff(String DOB, int siteAccessLevel) {
        super();
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
