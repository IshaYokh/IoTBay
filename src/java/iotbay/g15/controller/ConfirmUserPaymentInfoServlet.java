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
 * This servlet class runs when main.jsp is launched and it stores data in the session
 * that validate if the user has payment info records in the database or not
 */
public class ConfirmUserPaymentInfoServlet extends HttpServlet{ 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        String userHasPaymentInfo = "false";
        User user = (User)session.getAttribute("user");

        PaymentInfoDAO paymentInfoDBmanager = (PaymentInfoDAO)session.getAttribute("paymentInfoDBmanager");

        try{
            userHasPaymentInfo = paymentInfoDBmanager.hasUser(user.getUserID());
        }catch(SQLException ex){
            Logger.getLogger(ConfirmUserPaymentInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("userHasPaymentInfo", userHasPaymentInfo);
    }
}