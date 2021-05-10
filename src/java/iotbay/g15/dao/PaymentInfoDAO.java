package iotbay.g15.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import iotbay.g15.model.PaymentInfo;

/**
 *
 * @author Isha Yokhanna
 */
public class PaymentInfoDAO {
    private Statement st;
    
    public PaymentInfoDAO(Connection conn) throws SQLException{
        st = conn.createStatement();
    }
    
    // Inserts a PaymentInfo object in the database
    public void insertPaymentInfo(int paymentInfoID, int userID, String cardHolderName, int cardNumber, String cardExpiryDate, int cardCVC) throws SQLException{
        String sql = "INSERT INTO iotbay.PaymentInfo (PaymentInfoID, UserID, CardholderName, CardNumber, CardExpiryDate, CardCVC) "
                + "VALUES ("+paymentInfoID+","+userID+",'"+cardHolderName+"', "+cardNumber+", '"+cardExpiryDate+"', "+cardCVC+")";
       
        st.executeUpdate(sql);
    }
    
    // Returns a list of all PaymentInfo instances from the database
    public List<PaymentInfo> listAllPaymentInfos() throws SQLException{
        List<PaymentInfo> paymentInfos = new ArrayList<>();
        String sql = "SELECT * FROM PaymentInfo";
        ResultSet resultSet = st.executeQuery(sql);
        
        while(resultSet.next()){
            int paymentInfoID = resultSet.getInt("PaymentInfoID");
            int userID = resultSet.getInt("UserID");
            String cardholderName = resultSet.getString("CardholderName");
            int cardNumber = resultSet.getInt("CardNumber");
            String cardExpiryDate = resultSet.getString("CardExpiryDate");
            int cardCVC = resultSet.getInt("CardCVC");
            
            PaymentInfo paymentInfo = new PaymentInfo(paymentInfoID, userID, cardNumber, cardExpiryDate, cardCVC, cardholderName);
            paymentInfos.add(paymentInfo);
        }
     
        return paymentInfos; 
    }
    
    // Deletes from database
    public void deletePaymentInfo(int paymentInfoID) throws SQLException{
        String sql = "DELETE FROM PaymentInfo WHERE PaymentInfoID = "+paymentInfoID;
        st.executeUpdate(sql);
    }
    
    // Updates a specified instances of PaymentInfo in the database
    public void updatePaymentInfo(int paymentInfoID, int userID, String cardHolderName, int cardNumber, String cardExpiryDate, int cardCVC) throws SQLException{
        String sql = "UPDATE PaymentInfo SET PaymentInfoID = "+paymentInfoID+", UserID = "+userID+", CardHolderName = '"+cardHolderName+"', "
                + "CardNumber = "+cardNumber+", CardExpiryDate = '"+cardExpiryDate+"', CardCVC = "+cardCVC;
        sql += "WHERE PaymentInfoID = "+paymentInfoID;

        st.executeUpdate(sql);
    }
    
    // Returns an instances of PaymentInfo from the database based on the paymentInfoID
    public PaymentInfo getPaymentInfo(int paymentInfoID) throws SQLException{
        PaymentInfo paymentInfo = null;
        String sql = "SELECT * FROM PaymentInfo WHERE PaymentInfoID = ?";
        
        ResultSet resultSet = st.executeQuery(sql);
        
        if(resultSet.next()){
            paymentInfoID = resultSet.getInt("PaymentInfoID");
            int userID = resultSet.getInt("UserID");
            String cardholderName = resultSet.getString("CardholderName");
            int cardNumber = resultSet.getInt("CardNumber");
            String cardExpiryDate = resultSet.getString("CardExpiryDate");
            int cardCVC = resultSet.getInt("CardCVC");
            
            paymentInfo = new PaymentInfo(paymentInfoID, userID, cardNumber, cardExpiryDate, cardCVC, cardholderName);
        }

        return paymentInfo;
    }
}
