package iotbay.g15.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import iotbay.g15.model.Payment;

/**
 *
 * @author Isha Yokhanna
 */
public class PaymentDAO {
    private Statement st;
    
    public PaymentDAO(Connection conn) throws SQLException{
        st = conn.createStatement();
    }
    
    // Inserts a payment object in the database
    public void insertPayment(int paymentID, int orderID, int paymentInfoID, int userID, String paymentDate, double paymentAmount) throws SQLException{
        java.sql.Date paymentD = java.sql.Date.valueOf(paymentDate);
        
        String sql = "INSERT INTO iotbay.Payment (PaymentID, OrderID, PaymentInfoID, UserID, PaymentDate, PaymentAmount)"
                + " VALUES (" + paymentID + ", " + orderID + ", " + paymentInfoID + ", " + userID + ", " + paymentD + ", " + paymentAmount + ")";
        
        st.executeUpdate(sql);
    }
    
    // Returns a list of all payment instances from the database based on userID
    public ArrayList<Payment> listAllPaymentInfos(int userID) throws SQLException{
        ArrayList<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM iotbay.Payment WHERE UserID = " + userID;
        ResultSet resultSet = st.executeQuery(sql);
        
        while(resultSet.next()){
            int paymentID = resultSet.getInt("PaymentID");
            int orderID = resultSet.getInt("OrderID");
            int paymentInfoID = resultSet.getInt("PaymentInfoID");
            userID = resultSet.getInt("UserID");
            String paymentDate = resultSet.getDate("PaymentDate").toString();
            double paymentAmount = resultSet.getDouble("PaymentAmount");

            Payment payment = new Payment(paymentID, orderID, paymentInfoID, userID, paymentDate, paymentAmount);
            payments.add(payment);
        }
        
        return payments;
    }
    
    // Returns a list of all payment instances from the database based on paymentID and date
    public ArrayList<Payment> listAllPaymentInfos(int paymentID, String paymentDate) throws SQLException{
        ArrayList<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM iotbay.Payment WHERE PaymentID = " + paymentID + " AND PaymentDate = '" + paymentDate + "'";
        ResultSet resultSet = st.executeQuery(sql);
        
        while(resultSet.next()){
            paymentID = resultSet.getInt("PaymentID");
            int orderID = resultSet.getInt("OrderID");
            int paymentInfoID = resultSet.getInt("PaymentInfoID");
            int userID = resultSet.getInt("UserID");
            paymentDate = resultSet.getDate("PaymentDate").toString();
            double paymentAmount = resultSet.getDouble("PaymentAmount");

            Payment payment = new Payment(paymentID, orderID, paymentInfoID, userID, paymentDate, paymentAmount);
            payments.add(payment);
        }
        
        return payments;
    }
    
    // Deletes payment from database
    public void deletePayment(int paymentID) throws SQLException{
        String sql = "DELETE FROM iotbay.Payment WHERE paymentID = " + paymentID;
        st.executeUpdate(sql);
    }
    
    // Updates a specified instances of Payment in the database
     public void updatePayment(int paymentID, String paymentDate, double paymentAmount) throws SQLException{
          String sql = "UPDATE iotbay.Payment SET PaymentDate = '" + paymentDate + "', PaymentAmount = " + paymentAmount;
          sql += "WHERE PaymentID = " + paymentID;
          
          st.executeUpdate(sql);
     }
     
     // Returns an instances of Payment from the database based on the PaymentID
     public Payment getPayment(int paymentID, String paymentDate) throws SQLException{
        Payment payment = null;
        java.sql.Date paymentDt = java.sql.Date.valueOf(paymentDate);
        String sql = "SELECT * FROM iotbay.Payment WHERE paymentID = " + paymentID + " AND PaymentDate = '" + paymentDt + "'";
        
        ResultSet resultSet = st.executeQuery(sql);
        
        if(resultSet.next()){
            paymentID = resultSet.getInt("PaymentID");
            int orderID = resultSet.getInt("OrderID");
            int paymentInfoID = resultSet.getInt("PaymentInfoID");
            int userID = resultSet.getInt("UserID");
            String paymentD = resultSet.getDate("PaymentDate").toString();
            double paymentAmount = resultSet.getDouble("PaymentAmount");
            
            payment = new Payment(paymentID, orderID, paymentInfoID, userID, paymentD, paymentAmount);
        }
        
        return payment;
     }
}
