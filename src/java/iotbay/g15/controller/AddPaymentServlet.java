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
import java.time.LocalDate;

/**
 *
 * @author Isha Yokhanna
 */
public class AddPaymentServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        Order order = (Order)session.getAttribute("order"); //Uncomment when merged with "Order-Management" branch
        User user = (User)session.getAttribute("user");
        LocalDate paymentDate = LocalDate.now();
        String cartPrice = (String)session.getAttribute("cartPrice");
        double paymentAmount = Double.parseDouble(cartPrice) + 5.00;
        
        PaymentDAO paymentDBManager = (PaymentDAO)session.getAttribute("paymentDBManager");
        PaymentInfoDAO paymentInfoDBManager = (PaymentInfoDAO)session.getAttribute("paymentInfoDBmanager");
        //OrderDAO orderDBManager = (OrderDAO)session.getAttribute("orderDBManager"); //Uncomment when merged with "Order-Management" branch
        PaymentInfo paymentInfo = null;
        
        String paymentSuccessful = "false";
        String redirectedFromCheckout = (String)session.getAttribute("redirectedFromCheckout");
        
        // Validate credit
        try{
            paymentInfo = paymentInfoDBManager.getPaymentInfo(user.getID());
            if(paymentInfo.getUserID() == user.getID()){
                try{
                    if(paymentInfo.getCredit() >= paymentAmount && redirectedFromCheckout.equals("true")){
                        // Deduct payment from credit and create payment in database if payment is successful
                        paymentDBManager.insertPayment(order.getOrderID(), paymentInfo.getPaymentInfoID(), user.getID(), paymentDate.toString(), paymentAmount); //Uncomment when merged with "Order-Management" branch
                        paymentInfoDBManager.updatePaymentInfoCredit(user.getID(), paymentInfo.getCredit() - paymentAmount);
                        //orderDBManager.updateOrderStatus(order.getOrderID(), "Processed");
                        paymentSuccessful = "true";
                    }
                }catch(NullPointerException ex){}
                }
        }catch(SQLException ex){
            Logger.getLogger(AddPaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Set session variable and redirect to processPayment page
        session.setAttribute("paymentSuccessful", paymentSuccessful);
        session.removeAttribute("redirectedFromCheckout");
        request.getRequestDispatcher("processPayment.jsp").include(request, response);
    }
}
