package iotbay.g15.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    private String dbUrl;
    private String dbUsername;
    private String dbPassword;
    private Connection conn;
    
    protected void BookDAO(String dbUrl, String dbUsername, String dbPassword){
        this.dbUrl = dbUrl;
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
    }
    
    protected void connect() throws SQLException{
        if(conn == null || conn.isClosed()){
            try{
                Class.forName("com.mysql.jdbc.Driver");
            } catch(ClassNotFoundException e){
                throw new SQLException(e);
            }
            
            conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        }
    }
    
    protected void disconnect() throws SQLException{
        if(conn != null && !conn.isClosed()){
            conn.close();
        }
    }
    
    public boolean insertPaymentInfo(PaymentInfo paymentInfo) throws SQLException{
        String sql = "INSERT INTO PaymentInfo "
                + "(PaymentInfoID, UserID, CardholderName, CardNumber, CardExpiryDate, CardCVC) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        connect();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, paymentInfo.getPaymentInfoID());
        statement.setInt(2, paymentInfo.getUserID());
        statement.setString(3, paymentInfo.getCardHolderName());
        statement.setInt(4, paymentInfo.getCardNumber());
        statement.setString(5, paymentInfo.getCardExpiryDate());
        statement.setInt(6, paymentInfo.getCardCVC());
        
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    public List<PaymentInfo> listAllPaymentInfos() throws SQLException{
        List<PaymentInfo> paymentInfos = new ArrayList<>();
        String sql = "SELECT * FROM PaymentInfo";
        connect();
        
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
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
        
        resultSet.close();
        statement.close();
        disconnect();
        
        return paymentInfos; 
    }
    
    public boolean deletePaymentInfo(PaymentInfo paymentInfo) throws SQLException{
        String sql = "DELETE FROM PaymentInfo WHERE PaymentInfoID = ?";
        connect();
        
        PreparedStatement statement = conn.prepareCall(sql);
        statement.setInt(1, paymentInfo.getPaymentInfoID());
        
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        
        return rowDeleted;
    }
    
    public boolean updatePaymentInfo(PaymentInfo paymentInfo) throws SQLException{
        String sql = "UPDATE PaymentInfo SET PaymentInfoID = ?, UserID = ?, CardHolderName = ?, "
                + "CardNumber = ?, CardExpiryDate = ?, CardCVC = ?";
        sql += "WHERE PaymentInfoID = ?";
        connect();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, paymentInfo.getPaymentInfoID());
        statement.setInt(2, paymentInfo.getUserID());
        statement.setString(3, paymentInfo.getCardHolderName());
        statement.setInt(4, paymentInfo.getCardNumber());
        statement.setString(5, paymentInfo.getCardExpiryDate());
        statement.setInt(6, paymentInfo.getCardCVC());
        
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        
        return rowUpdated;
    }
    
    public PaymentInfo getPaymentInfo(int paymentInfoID) throws SQLException{
        PaymentInfo paymentInfo = null;
        String sql = "SELECT * FROM PaymentInfo WHERE PaymentInfoID = ?";
        connect();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, paymentInfoID);
        
        ResultSet resultSet = statement.executeQuery();
        
        if(resultSet.next()){
            paymentInfoID = resultSet.getInt("PaymentInfoID");
            int userID = resultSet.getInt("UserID");
            String cardholderName = resultSet.getString("CardholderName");
            int cardNumber = resultSet.getInt("CardNumber");
            String cardExpiryDate = resultSet.getString("CardExpiryDate");
            int cardCVC = resultSet.getInt("CardCVC");
            
            paymentInfo = new PaymentInfo(paymentInfoID, userID, cardNumber, cardExpiryDate, cardCVC, cardholderName);
        }
        
        resultSet.close();
        statement.close();
        disconnect();
        
        return paymentInfo;
    }
}
