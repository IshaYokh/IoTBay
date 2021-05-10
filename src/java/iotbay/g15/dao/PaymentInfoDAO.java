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
    public void insertPaymentInfo(int paymentInfoID, int userID, String cardHolderName, String cardNumber, String cardExpiryDate, String cardCVC,
            String streetNumber, String streetName, String streetType, String suburb, String state, String postcode, String country) throws SQLException{
        String sql = "INSERT INTO iotbay.PaymentInfo (PaymentInfoID, UserID, CardholderName, CardNumber, CardExpiryDate, CardCVC,"
                + "StreetNumber, StreetName, StreetType, Suburb, State, Postcode, Country)"
                + "VALUES ("+paymentInfoID+","+userID+",'"+cardHolderName+"', '"+cardNumber+"', '"+cardExpiryDate+"', '"+cardCVC+"', '"
                + streetNumber + "', '" + streetName + "', '" + streetType + "', '" + suburb + "', '" + state + "', '" + postcode + "', '"
                + country +"');";
       
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
            String cardNumber = resultSet.getString("CardNumber");
            String cardExpiryDate = resultSet.getString("CardExpiryDate");
            String cardCVC = resultSet.getString("CardCVC");
            String streetNumber = resultSet.getString("StreetNumber");
            String streetName = resultSet.getString("StreetName");
            String streetType = resultSet.getString("StreetType");
            String suburb = resultSet.getString("Suburb");
            String state = resultSet.getString("State");
            String postcode = resultSet.getString("Postcode");
            String country = resultSet.getString("Country");
            
            PaymentInfo paymentInfo = new PaymentInfo(paymentInfoID, userID, cardNumber, cardExpiryDate, cardCVC, cardholderName,
            streetNumber, streetName, streetType, suburb, state, postcode, country);
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
    public void updatePaymentInfo(int paymentInfoID, int userID, String cardHolderName, int cardNumber, String cardExpiryDate, int cardCVC,
            String streetNumber, String streetName, String streetType, String suburb, String state, String postcode, String country) throws SQLException{
        String sql = "UPDATE PaymentInfo SET PaymentInfoID = "+paymentInfoID+", UserID = "+userID+", CardHolderName = '"+cardHolderName+"', "
                + "CardNumber = '"+cardNumber+"', CardExpiryDate = '"+cardExpiryDate+"', CardCVC = '"+cardCVC+"', StreetNumber = '" + streetNumber
                + "', StreetName = '" + streetName + "', StreetType = '" + streetType + "', Suburb = '" + suburb + "', State = '" + state +"'"
                + ", Postcode  = '" + postcode + "', Country = " + country + "';";
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
            String cardNumber = resultSet.getString("CardNumber");
            String cardExpiryDate = resultSet.getString("CardExpiryDate");
            String cardCVC = resultSet.getString("CardCVC");
            String streetNumber = resultSet.getString("StreetNumber");
            String streetName = resultSet.getString("StreetName");
            String streetType = resultSet.getString("StreetType");
            String suburb = resultSet.getString("Suburb");
            String state = resultSet.getString("State");
            String postcode = resultSet.getString("Postcode");
            String country = resultSet.getString("Country");
            
            paymentInfo = new PaymentInfo(paymentInfoID, userID, cardNumber, cardExpiryDate, cardCVC, cardholderName,
            streetNumber, streetName, streetType, suburb, state, postcode, country);
        }

        return paymentInfo;
    }
}
