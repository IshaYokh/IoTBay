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
import java.util.ArrayList;

/**
 *
 * @author Isha Yokhanna
 * 
 * This servlet class will be used to search for specific payment based on paymentID and date
 * 
 */
public class SearchPaymentHistoryServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String paymentID = request.getParameter("paymentID");
        String paymentDate = request.getParameter("date");
        PaymentDAO paymentDBManager = (PaymentDAO)session.getAttribute("paymentDBManager");
        ArrayList<Payment> payments = new ArrayList<>();
         
        // Validation variables
        PaymentValidator paymentValidator = new PaymentValidator();
        session.setAttribute("paymentIDErr", paymentValidator.validatePaymentIDSearchInput(paymentID));
        
        
        if(paymentValidator.validatePaymentIDSearchInput(paymentID) == null){
            int pID = Integer.parseInt(paymentID);
            try{
                payments = paymentDBManager.listAllPaymentInfos(pID, paymentDate);
            }catch(SQLException ex){
                Logger.getLogger(SearchPaymentHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        session.setAttribute("payments", payments);
        request.getRequestDispatcher("searchPaymentHistory.jsp").include(request, response);
    }
}
