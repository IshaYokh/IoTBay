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
    private String cardCVC;
    private String cardHolderName;
    private String streetNumber;
    private String streetName;
    private String streetType;
    private String suburb;
    private String state;
    private String postcode;
    private String country;

    public PaymentInfo(int paymentInfoID, int userID, String cardNumber, String cardExpiryDate, String cardCVC, String cardHolderName,
            String streetNumber, String streetName, String streetType, String suburb, String state, String postcode, String country) {
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

    public String getCardCVC() {
        return cardCVC;
    }

    public void setCardCvc(String cardCVC) {
        this.cardCVC = cardCVC;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
    
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
