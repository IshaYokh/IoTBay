package iotbay.g15.model;

import java.io.Serializable;

/**
 *
 * @author Isha Yokhanna
 */
public class Payment implements Serializable{
    private int paymentID;
    private int orderID;
    private int paymentInfoID;
    private int userID;
    private String invoice;
    private String paymentDate;
    private double paymentAmount;

    public Payment(int paymentID, int orderID, int paymentInfoID, int userID, String paymentDate, double paymentAmount) {
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.paymentInfoID = paymentInfoID;
        this.userID = userID;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }    
    
    public int getOrderID() {
        return this.orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
    public int getPaymentInfoID(){
        return this.paymentInfoID;
    }
    
    public void setPaymentInfoID(int paymentInfoID){
        this.paymentInfoID = paymentInfoID;
    }
    
    public int getUserID(){
        return this.userID;
    }
    
    public void setUserID(int userID){
        this.userID = userID;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
