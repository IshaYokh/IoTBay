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
 * This servlet class is used to update the customer's payment
 * information
 * 
 */
public class UpdatePaymentInfoServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        
        String streetNumber = request.getParameter("street-number");
        String streetName = request.getParameter("street-name");
        String streetType = request.getParameter("street-type");
        String suburb = request.getParameter("suburb");
        String state = request.getParameter("state");
        String postcode = request.getParameter("postcode");
        String country = request.getParameter("country");
        String cardHolderName = request.getParameter("card-holder-name");
        String cardNumber = request.getParameter("card-number");
        String cardExpiryDate = request.getParameter("card-expiry-date");
        String cardCVC = request.getParameter("card-cvc");
        
        int streetNumberInt = Integer.parseInt(streetNumber);
        int postcodeInt = Integer.parseInt(postcode);
        int cardCVCInt = Integer.parseInt(cardCVC);
        
        User user = (User)session.getAttribute("user");
        
        PaymentInfoDAO paymentInfoDBmanager = (PaymentInfoDAO)session.getAttribute("paymentInfoDBmanager");
        
        try{
            paymentInfoDBmanager.updatePaymentInfo(user.getID(), cardHolderName,
                    cardNumber, cardExpiryDate, cardCVCInt,
                    streetNumberInt, streetName, streetType,
                    suburb, state, postcodeInt, country);
        }

        catch (SQLException ex){
            Logger.getLogger(UpdatePaymentInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("paymentInfoUpdateFeedback", "success");
        response.sendRedirect("ViewPaymentInfoServlet");
    }
    
}
