package iotbay.g15.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Isha Yokhanna
 * 
 * This servlet class will be used when a customer 
 * wants to update/delete their payment info from the checkout page
 */
public class updatePaymentInfoFromCheckoutServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.setAttribute("redirectedFromCheckout", "true");
        response.sendRedirect("updatePaymentInfo.jsp");
    }
}
