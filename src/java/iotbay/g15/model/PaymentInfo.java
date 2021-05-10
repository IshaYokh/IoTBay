package iotbay.g15.model;

import java.io.Serializable;

/**
 *
 * @author Isha Yokhanna
 */
public class PaymentInfo implements Serializable{
    private int paymentInfoID;
    private int userID;
    private int cardNumber;
    private String cardExpiryDate;
    private int cardCVC;
    private String cardHolderName;

    public PaymentInfo(int paymentInfoID, int userID, int cardNumber, String cardExpiryDate, int cardCVC, String cardHolderName) {
        this.paymentInfoID = paymentInfoID;
        this.userID = userID;
        this.cardNumber = cardNumber;
        this.cardExpiryDate = cardExpiryDate;
        this.cardCVC = cardCVC;
        this.cardHolderName = cardHolderName;
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

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
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
}
