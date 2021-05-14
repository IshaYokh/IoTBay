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
 * This servlet class will be used to view payment history list for a user
 * 
 */
public class ViewPaymentHistoryServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        PaymentDAO paymentDBManager = (PaymentDAO)session.getAttribute("paymentDBManager");
        PaymentInfoDAO paymentInfoDBManager = (PaymentInfoDAO)session.getAttribute("paymentInfoDBManager");
        ArrayList<Payment> payments = new ArrayList<>();
        ArrayList<PaymentInfo> paymentInfos = new ArrayList<>();
        
        try{
            payments = paymentDBManager.listAllPaymentInfos(user.getID());
            paymentInfos = paymentInfoDBManager.listAllPaymentInfos(user.getID());
        }catch(SQLException ex){
            Logger.getLogger(ViewPaymentHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("payments", payments);
        session.setAttribute("paymentInfos", paymentInfos);
        request.getRequestDispatcher("searchPaymentHistory.jsp").include(request, response);
    }
}
