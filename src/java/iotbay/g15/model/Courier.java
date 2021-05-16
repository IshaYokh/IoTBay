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
public class Courier {
    private int courierID;
    private String courierAddress;
    
    public Courier(int courierID){
        this.courierID = courierID;
    }
    
    public int getCourierID(){
        return courierID;
    }
    
    public void setCourierID(int courierID){
        this.courierID = courierID;
    }
    
    public String getCourierAddress(){
        return courierAddress;
    }
    
    public void setCourierAddress(String courierAddress){
        this.courierAddress = courierAddress;
    }
}
