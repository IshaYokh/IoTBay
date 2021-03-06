package iotbay.g15.model.dao;

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
    public void insertPaymentInfo(int userID, String cardHolderName, String cardNumber, String cardExpiryDate, int cardCVC,
            int streetNumber, String streetName, String streetType, String suburb, String state, int postcode, String country, double credit, String active)
            throws SQLException{
        String sql = "INSERT INTO iotbay.PaymentInfo (UserID, CardholderName, CardNumber, CardExpiryDate, CardCVC,"
                + "StreetNumber, StreetName, StreetType, Suburb, State, Postcode, Country, Credit, Active)"
                + " VALUES ("+userID+",'"+cardHolderName+"', '"+cardNumber+"', '"+cardExpiryDate+"', "+cardCVC+", "
                + streetNumber + ", '" + streetName + "', '" + streetType + "', '" + suburb + "', '" + state + "', " + postcode + ", '"
                + country + "', " + credit + ", '" + active + "')";
        
        st.executeUpdate(sql);
    }
    
    // Returns a list of all PaymentInfo instances from the database
    public ArrayList<PaymentInfo> listAllPaymentInfos(int userID) throws SQLException{
        ArrayList<PaymentInfo> paymentInfos = new ArrayList<>();
        String sql = "SELECT * FROM iotbay.PaymentInfo WHERE UserID = " + userID;
        ResultSet resultSet = st.executeQuery(sql);
        
        while(resultSet.next()){
            int paymentInfoID = resultSet.getInt("PaymentInfoID");
            userID = resultSet.getInt("UserID");
            String cardholderName = resultSet.getString("CardholderName");
            String cardNumber = resultSet.getString("CardNumber");
            String cardExpiryDate = resultSet.getString("CardExpiryDate");
            int cardCVC = resultSet.getInt("CardCVC");
            int streetNumber = resultSet.getInt("StreetNumber");
            String streetName = resultSet.getString("StreetName");
            String streetType = resultSet.getString("StreetType");
            String suburb = resultSet.getString("Suburb");
            String state = resultSet.getString("State");
            int postcode = resultSet.getInt("Postcode");
            String country = resultSet.getString("Country");
            double credit = resultSet.getDouble("Credit");
            String active = resultSet.getString("Active");
            
            boolean activeStatus = false;
            if(active.equals("true")) activeStatus = true;
            
            PaymentInfo paymentInfo = new PaymentInfo(paymentInfoID, userID, cardNumber, cardExpiryDate, cardCVC, cardholderName,
            streetNumber, streetName, streetType, suburb, state, postcode, country, credit, activeStatus);
            paymentInfos.add(paymentInfo);
        }
        
        return paymentInfos;
    }
    
    // Deletes from database
    public void deletePaymentInfo(int paymentInfoID) throws SQLException{
        String sql = "DELETE FROM PaymentInfo WHERE PaymentInfoID = " + paymentInfoID;
        st.executeUpdate(sql);
    }
    
    // Updates a specified instances of PaymentInfo in the database
    public void updatePaymentInfo(int userID, String cardHolderName, String cardNumber, String cardExpiryDate, int cardCVC,
            int streetNumber, String streetName, String streetType, String suburb, String state, int postcode, String country) throws SQLException{
        String sql = "UPDATE iotbay.PaymentInfo SET CardHolderName = '"+cardHolderName+"', "
                + "CardNumber = '"+cardNumber+"', CardExpiryDate = '"+cardExpiryDate+"', CardCVC = "+cardCVC+", StreetNumber = " + streetNumber
                + ", StreetName = '" + streetName + "', StreetType = '" + streetType + "', Suburb = '" + suburb + "', State = '" + state +"'"
                + ", Postcode  = " + postcode + ", Country = '" + country + "'";
        sql += "WHERE UserID = " + userID + " AND Active = 'true'";

        st.executeUpdate(sql);
    }
    
    // Updates a specified instances of PaymentInfo in the database
    public void updatePaymentInfoCredit(int userID, double newCredit) throws SQLException{
        String sql = "UPDATE iotbay.PaymentInfo SET Credit = " + newCredit;
        sql += "WHERE UserID = " + userID + " AND Active = 'true'";

        st.executeUpdate(sql);
    }
    
    // Returns an instances of PaymentInfo from the database based on the paymentInfoID
    public PaymentInfo getPaymentInfo(int userID) throws SQLException{
        PaymentInfo paymentInfo = null;
        String sql = "SELECT * FROM iotbay.PaymentInfo WHERE userID = " + userID + " AND Active = 'true'";
        
        ResultSet resultSet = st.executeQuery(sql);
        
        if(resultSet.next()){
            int paymentInfoID = resultSet.getInt("PaymentInfoID");
            userID = resultSet.getInt("UserID");
            String cardholderName = resultSet.getString("CardholderName");
            String cardNumber = resultSet.getString("CardNumber");
            String cardExpiryDate = resultSet.getString("CardExpiryDate");
            int cardCVC = resultSet.getInt("CardCVC");
            int streetNumber = resultSet.getInt("StreetNumber");
            String streetName = resultSet.getString("StreetName");
            String streetType = resultSet.getString("StreetType");
            String suburb = resultSet.getString("Suburb");
            String state = resultSet.getString("State");
            int postcode = resultSet.getInt("Postcode");
            String country = resultSet.getString("Country");
            double credit = resultSet.getDouble("credit");
            String active = resultSet.getString("Active");
            
            boolean activeStatus = false;
            if(active.equals("true")) activeStatus = true;
            
            paymentInfo = new PaymentInfo(paymentInfoID, userID, cardNumber, cardExpiryDate, cardCVC, cardholderName,
            streetNumber, streetName, streetType, suburb, state, postcode, country, credit, activeStatus);
        }
        
        return paymentInfo;
    }
    
    // Checks if payment card info exist in the database
    public boolean hasPaymentInfo(String cardNumber, int userID) throws SQLException{
        String sql = "SELECT * FROM PaymentInfo WHERE CardNumber = '" + cardNumber + "' AND Active = 'true'";
        ResultSet resultSet = st.executeQuery(sql);
        
        int i = 0;
        while(resultSet.next()){
            int uID = resultSet.getInt("userID");
            
            if(uID == userID)
                i++;
        }

        if(i > 0)
            return true;

        return false;
    }
    
    // Sets payment info as inactive in the database
    public void setInactive(int paymentInfoID) throws SQLException{
        String sql = "UPDATE iotbay.PaymentInfo SET Active = 'false' WHERE PaymentInfoID = " + paymentInfoID;
        st.executeUpdate(sql);
    }
    
    // Confirms if a user has payment info in the database
    public String hasUser(int userID) throws SQLException{
        String sql = "SELECT * FROM PaymentInfo WHERE UserID = " + userID + " AND Active = 'true'";
        ResultSet resultSet = st.executeQuery(sql);

        int i = 0;
        while(resultSet.next())
            i++;

        if(i > 0)
            return "true";

        return "false";
    }
}
