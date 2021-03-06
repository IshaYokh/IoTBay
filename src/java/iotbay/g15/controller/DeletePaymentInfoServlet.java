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
 * This servlet class is used to delete a customer's payment information (set as inactive)
 * 
 */
public class DeletePaymentInfoServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        PaymentInfoDAO paymentInfoDBmanager = (PaymentInfoDAO)session.getAttribute("paymentInfoDBmanager");
        PaymentInfo paymentInfo = null;
        
        try{
            paymentInfo = paymentInfoDBmanager.getPaymentInfo(user.getUserID());
            paymentInfoDBmanager.setInactive(paymentInfo.getPaymentInfoID());
            session.setAttribute("paymentInfoDeleted", "success");
        }catch(SQLException ex){
            Logger.getLogger(DeletePaymentInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.removeAttribute("paymentInfo");
        request.getRequestDispatcher("deletePaymentInfo.jsp").include(request, response);
    }
}
