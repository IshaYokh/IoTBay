package iotbay.g15.model;

/**
 *
 * @author Isha Yokhanna
 */
public class Payment {
    private int paymentID;
    private String invoice;
    private String paymentMethod;
    private String paymentDate;
    private float paymentAmount;

    public Payment(int paymentID, String invoice, String paymentMethod, String paymentDate, float paymentAmount) {
        this.paymentID = paymentID;
        this.invoice = invoice;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public float getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(float paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
