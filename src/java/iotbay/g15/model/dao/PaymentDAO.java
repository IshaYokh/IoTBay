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
    public void insertPayment(int paymentID, int orderID, int paymentInfoID, String paymentDate, double paymentAmount) throws SQLException{
        java.sql.Date paymentD = java.sql.Date.valueOf(paymentDate);
        
        String sql = "INSERT INTO iotbay.Payment (PaymentID, OrderID, PaymentInfoID, PaymentDate, PaymentAmount)"
                + " VALUES (" + paymentID + ", " + orderID + ", " + paymentInfoID + ", " + paymentD + ", " + paymentAmount + ")";
        
        st.executeUpdate(sql);
    }
    
    // Returns a list of all payment instances from the database
    public List<Payment> listAllPaymentInfos() throws SQLException{
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM Payment";
        ResultSet resultSet = st.executeQuery(sql);
        
        while(resultSet.next()){
            int paymentID = resultSet.getInt("PaymentID");
            int orderID = resultSet.getInt("OrderID");
            int paymentInfoID = resultSet.getInt("PaymentInfoID");
            String paymentDate = resultSet.getDate("PaymentDate").toString();
            double paymentAmount = resultSet.getDouble("PaymentAmount");
            
            Payment payment = new Payment(paymentID, orderID, paymentInfoID, paymentDate, paymentAmount);
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
     public void updatePayment(int paymentID, int orderID, int paymentInfoID, String paymentDate, double paymentAmount) throws SQLException{
          String sql = "UPDATE iotbay.Payment SET PaymentDate = '" + paymentDate + "', PaymentAmount = " + paymentAmount;
          sql += "WHERE PaymentID = " + paymentID;
          
          st.executeUpdate(sql);
     }
     
     // Returns an instances of Payment from the database based on the PaymentID
     public Payment getPayment(int paymentID) throws SQLException{
        Payment payment = null;
        String sql = "SELECT * FROM iotbay.Payment WHERE paymentID = " + paymentID;
        
        ResultSet resultSet = st.executeQuery(sql);
        
        if(resultSet.next()){
            paymentID = resultSet.getInt("PaymentID");
            int orderID = resultSet.getInt("OrderID");
            int paymentInfoID = resultSet.getInt("PaymentInfoID");
            String paymentDate = resultSet.getDate("PaymentDate").toString();
            double paymentAmount = resultSet.getDouble("PaymentAmount");
            
            payment = new Payment(paymentID, orderID, paymentInfoID, paymentDate, paymentAmount);
        }
        
        return payment;
     }
}
