package iotbay.g15.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import iotbay.g15.model.dao.*;
import iotbay.g15.model.*;


/**
 *
 * @author Isha Yokhanna
 * 
 * This servlet class is used to retrieve the customer's payment information
 * and display them on the view
 * 
 */
public class ViewPaymentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        PaymentInfo paymentInfo = null;
        PaymentInfoDAO paymentInfoDBmanager = (PaymentInfoDAO)session.getAttribute("paymentInfoDBmanager");
        
        try{
            paymentInfo = paymentInfoDBmanager.getPaymentInfo(user.getID());
        }catch(SQLException ex){
            Logger.getLogger(ViewPaymentInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("paymentInfo", paymentInfo);
    }
    
}