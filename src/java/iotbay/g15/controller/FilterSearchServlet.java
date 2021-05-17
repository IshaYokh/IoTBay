/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.controller;

import iotbay.g15.model.Order;
import iotbay.g15.model.User;
import iotbay.g15.model.dao.OrderDAO;
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
public class FilterSearchServlet extends HttpServlet{
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        OrderManagementValidator validator = new OrderManagementValidator(); //validator
        ArrayList<Order> orders = new ArrayList<Order>();
        User user = (User) session.getAttribute("user");
        String orderID = request.getParameter("orderID");
        String orderDate = request.getParameter("orderDate"); //params
        
        
        OrderDAO orderDBManager = (OrderDAO) session.getAttribute("orderDBManager");
        int order = Integer.parseInt(orderID);
        
        try{
            orders = orderDBManager.findAllCustomerOrdersFiltered(user.getUserID(), order, orderDate); //find all orders but filtered
            session.setAttribute("orderList", orders);
        }catch(SQLException ex){
            Logger.getLogger(OrderHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("orderhistory.jsp").include(request, response);
        
    }
}
