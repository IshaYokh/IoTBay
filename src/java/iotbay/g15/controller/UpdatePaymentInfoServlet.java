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
        
        // Validation variables
        PaymentValidator paymentValidator = new PaymentValidator();
        
        session.setAttribute("streetNumberErr", paymentValidator.validateStreetNo(streetNumber));
        session.setAttribute("streetNameErr", paymentValidator.validateStreetName(streetName));
        session.setAttribute("streetTypeErr", paymentValidator.validateStreetType(streetType));
        session.setAttribute("suburbErr", paymentValidator.validateSuburb(suburb));
        session.setAttribute("stateErr", paymentValidator.validateState(state));
        session.setAttribute("postcodeErr", paymentValidator.validatePostcode(postcode));
        session.setAttribute("countryErr", paymentValidator.validateCountry(country));
        session.setAttribute("cardHolderNameErr", paymentValidator.validateCardHolderName(cardHolderName));
        session.setAttribute("cardNumberErr", paymentValidator.validateCardNumber(cardNumber));
        session.setAttribute("cardExpiryDateErr", paymentValidator.validateCardExpiryDate(cardExpiryDate));
        session.setAttribute("cardCvcErr", paymentValidator.validateCardCVC(cardCVC));
        
        session.setAttribute("paymentInfoUpdateFeedback", "fail");
        PaymentInfoDAO paymentInfoDBmanager = (PaymentInfoDAO)session.getAttribute("paymentInfoDBmanager");
        
        if((paymentValidator.validateStreetNo(streetNumber) == null) && (paymentValidator.validateStreetName(streetName) == null)
                && (paymentValidator.validateStreetType(streetType) == null) && (paymentValidator.validateSuburb(suburb) == null)
                && (paymentValidator.validateState(state) == null) && (paymentValidator.validatePostcode(postcode) == null)
                && (paymentValidator.validateCountry(country) == null) && (paymentValidator.validateCardHolderName(cardHolderName) == null)
                && (paymentValidator.validateCardNumber(cardNumber) == null) &&  (paymentValidator.validateCardExpiryDate(cardExpiryDate) == null)
                && (paymentValidator.validateCardCVC(cardCVC) == null)){
            
            int cvc = Integer.parseInt(cardCVC);
            int streetNumberInt = Integer.parseInt(streetNumber);
            int postcodeInt = Integer.parseInt(postcode);
            int cardCVCInt = Integer.parseInt(cardCVC);
            User user = (User)session.getAttribute("user");
            
            try {
                paymentInfoDBmanager.updatePaymentInfo(user.getUserID(), cardHolderName,
                        cardNumber, cardExpiryDate, cardCVCInt,
                        streetNumberInt, streetName, streetType,
                        suburb, state, postcodeInt, country);
                session.setAttribute("paymentInfoUpdateFeedback", "success");
            } catch (SQLException ex) {
                Logger.getLogger(UpdatePaymentInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        request.getRequestDispatcher("updatePaymentInfo.jsp").include(request, response);
    }
    
}
