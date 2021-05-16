/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.model;
import java.sql.*;

/**
 *
 * @author rebecca
 */
public class Invoice {
    private int invoiceID;
    private Payment payment;
    private Timestamp issueDate;
    
    public Invoice(int invoiceID, Payment payment, Timestamp issueDate){
        this.invoiceID = invoiceID;
        this.payment = payment;
        this.issueDate = issueDate;
    }
    
    public int getInvoiceID(){
        return invoiceID;
    }
    
    public void setInvoiceID(int invoiceID){
        this.invoiceID = invoiceID;
    }
    
    public Payment getPayment(){
        return payment;
    }
    
    public void setPayment(){
        this.payment = payment;
    }
    
    public Timestamp getIssueDate(){
        return issueDate;
    }
    
    public void setIssueDate(){
        this.issueDate = issueDate;
    }
}
