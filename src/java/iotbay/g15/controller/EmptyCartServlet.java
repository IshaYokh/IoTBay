/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.controller;

import iotbay.g15.model.Item;
import iotbay.g15.model.User;
import iotbay.g15.model.dao.OrderDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class EmptyCartServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        List<Item> cartData = (ArrayList) session.getAttribute("cartItems");
        ArrayList<Item> cart;
        OrderDAO orderDBManager = (OrderDAO) session.getAttribute("orderDBManager");
        User user = (User) session.getAttribute("user");
        try{
            orderDBManager.emptyCart(user.getUserID());
            cart = orderDBManager.getCart(user.getUserID());
            session.setAttribute("cartItems", cart);
            session.setAttribute("cartPrice", 0);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteFromCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("cart.jsp").include(request, response);
        
    }
}