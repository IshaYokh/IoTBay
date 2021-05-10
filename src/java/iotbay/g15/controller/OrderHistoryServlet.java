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
import java.util.Collections;
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
        ArrayList<Order> orders = new ArrayList<Order>();
        
        String userID = request.getParameter("userID");
        DBManager manager = (DBManager) session.getAttribute("manager");
        String msg = "";
        System.out.println("ssssss");
        int user = Integer.parseInt(userID);
        
        try{
            orders = manager.findAllCustomerOrders(user);
            System.out.println("wgdsadasdadasdasdasdas");
            session.setAttribute("orderList", orders);
            System.out.println("hi:" + orders);
        }catch(SQLException ex){
            Logger.getLogger(OrderHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("uyyyy");
        }
        
        session.setAttribute("message", msg);
        session.setAttribute("orders", "hey");
        request.getRequestDispatcher("orderhistory.jsp").include(request, response);
        
    }
}
