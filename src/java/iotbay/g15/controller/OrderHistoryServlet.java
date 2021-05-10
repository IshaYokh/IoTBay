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
import java.util.ArrayList;
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
public class OrderHistoryServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        ArrayList<Order> orders = (ArrayList<Order>) session.getAttribute("order");
        
        String userID = request.getParameter("userID");
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        try{
            orders = manager.findAllCustomerOrders(1);
        }catch(SQLException ex){
            Logger.getLogger(OrderHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("msg", "does this work");
        request.getRequestDispatcher("orderhistory.jsp").include(request, response);
        
    }
}
