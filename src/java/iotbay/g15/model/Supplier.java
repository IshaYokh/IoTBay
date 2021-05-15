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
public class Supplier {
    int SupplierID;
    String supplierAddress;

    public int getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(int SupplierID) {
        this.SupplierID = SupplierID;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public Supplier(int SupplierID, String supplierAddress) {
        this.SupplierID = SupplierID;
        this.supplierAddress = supplierAddress;
    }
    
}
