package iotbay.g15.model;

/**
 *
 * @author Isha Yokhanna
 */
public class PaymentInfo {
    private int paymentInfoID;
    private int cardNumber;
    private String expiryDate;
    private int cvc;
    private String cardHolderName;

    public PaymentInfo(int paymentInfoID, int cardNumber, String expiryDate, int cvc, String cardHolderName) {
        this.paymentInfoID = paymentInfoID;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvc = cvc;
        this.cardHolderName = cardHolderName;
    }

    public int getPaymentInfoID() {
        return paymentInfoID;
    }

    public void setPaymentInfoID(int paymentInfoID) {
        this.paymentInfoID = paymentInfoID;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
}
