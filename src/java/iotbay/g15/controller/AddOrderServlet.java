/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.controller;
import iotbay.g15.model.Order;
import iotbay.g15.model.dao.DBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rebecca
 */
public class AddOrderServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String orderID = request.getParameter("orderID");
        //String userID = request.getParameter("userID");
        //String courierID = request.getParameter("courierID");
        String orderDate = request.getParameter("orderDate");
        String orderStatus = request.getParameter("orderStatus");
        
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        Order order = new Order(Integer.parseInt(orderID), orderDate, orderStatus);
        
        try{
            manager.addOrder(Integer.parseInt(orderID), "10/01/2000", orderStatus);
        }catch(SQLException ex){
            Logger.getLogger(AddOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //response.getWriter().println("lol");
        //session.setAttribute("orderInstance", "Order has been successfully added!");
        //request.getRequestDispatcher("index.jsp").include(request, response);
        response.sendRedirect("addOrder.jsp");
    }
}
