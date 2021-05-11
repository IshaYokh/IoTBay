package iotbay.g15.model;

import java.io.Serializable;

/**
 *
 * @author Isha Yokhanna
 */
public class PaymentInfo implements Serializable{
    private int paymentInfoID;
    private int userID;
    private String cardNumber;
    private String cardExpiryDate;
    private int cardCVC;
    private String cardHolderName;
    private int streetNumber;
    private String streetName;
    private String streetType;
    private String suburb;
    private String state;
    private int postcode;
    private String country;
    private double credit;
    private boolean active;

    public PaymentInfo(int paymentInfoID, int userID, String cardNumber, String cardExpiryDate, int cardCVC, String cardHolderName,
            int streetNumber, String streetName, String streetType, String suburb, String state, int postcode, String country, double credit,
            boolean active) {
        this.paymentInfoID = paymentInfoID;
        this.userID = userID;
        this.cardNumber = cardNumber;
        this.cardExpiryDate = cardExpiryDate;
        this.cardCVC = cardCVC;
        this.cardHolderName = cardHolderName;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.streetType = streetType;
        this.suburb = suburb;
        this.state = state;
        this.postcode = postcode;
        this.country = country;
        this.credit = credit;
        this.active = active;
    }

    public int getPaymentInfoID() {
        return paymentInfoID;
    }
    
    public void setPaymentInfoID(int paymentInfoID) {
        this.paymentInfoID = paymentInfoID;
    }
    
    public int getUserID(){
        return userID;
    }
    
    public void setUserID(int userID){
        this.userID = userID;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public int getCardCVC() {
        return cardCVC;
    }

    public void setCardCvc(int cardCVC) {
        this.cardCVC = cardCVC;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
    
    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public double getCredit(){
        return this.credit;
    }
    
    public void setCredit(double credit){
        this.credit = credit;
    }
    
    public boolean isActive(){
        return this.active;
    }
    
    public void setActive(boolean val){
        this.active = val;
    }
}
