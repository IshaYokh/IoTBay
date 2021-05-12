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
import java.util.Random;
import iotbay.g15.model.dao.*;
import iotbay.g15.model.*;

/**
 *
 * @author Isha Yokhanna
 */
public class AddPaymentInfoServlet extends HttpServlet{
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
        
        Random random = new Random();
        int paymentInfoID = random.nextInt(9999);
        
        // Getting the DAO instances from the session and creating model objects based on the data returned from the JSP view
        PaymentInfoDAO paymentInfoDBmanager = (PaymentInfoDAO)session.getAttribute("paymentInfoDBmanager");
        PaymentInfo paymentInfo = new PaymentInfo(paymentInfoID, user.getID(), cardNumber, cardExpiryDate, cardCVCInt, cardHolderName,
            streetNumberInt, streetName, streetType, suburb, state, postcodeInt, country, 500.00, true);
        
        // Storing new data in the database
        try{
            paymentInfoDBmanager.insertPaymentInfo(paymentInfo.getPaymentInfoID(), paymentInfo.getUserID(), paymentInfo.getCardHolderName(),
                    paymentInfo.getCardNumber(), paymentInfo.getCardExpiryDate(), paymentInfo.getCardCVC(),
                    paymentInfo.getStreetNumber(), paymentInfo.getStreetName(), paymentInfo.getStreetType(),
                    paymentInfo.getSuburb(), paymentInfo.getState(), paymentInfo.getPostcode(), paymentInfo.getCountry(),
                    500.00, "true");
        }
        catch (SQLException ex){
            Logger.getLogger(AddPaymentInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Storing feedback message of data insertion and redirecting the web page
        session.setAttribute("paymentInfoAddFeedback", "success");
        request.getRequestDispatcher("addPaymentInfo.jsp").include(request, response);
    }
}
