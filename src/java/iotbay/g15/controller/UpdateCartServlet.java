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
public class UpdateCartServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        OrderManagementValidator validator = new OrderManagementValidator();
        String itemUpdateQuantity = request.getParameter("itemUpdateQuantity"); //quantity
        String itemIDQuantityUpdate = request.getParameter("itemIDQuantityUpdate"); //itemid
        
        if(!validator.validateInteger(itemUpdateQuantity)){ //validator
            session.setAttribute("error", "Error! Enter a valid quantity!");
            request.getRequestDispatcher("cart.jsp").include(request, response);
            return;
        }
        
        int itemUpdateQuantity1 = Integer.parseInt(itemUpdateQuantity);
        int itemIDQuantityUpdate1 = Integer.parseInt(itemIDQuantityUpdate);
        
        
        ArrayList<Item> cart;
        
        OrderDAO orderDBManager = (OrderDAO) session.getAttribute("orderDBManager");
        User user = (User) session.getAttribute("user");
        
        try{
            orderDBManager.getItemByID(user.getUserID(), itemIDQuantityUpdate1);
            orderDBManager.updateItemQuantity(user.getUserID(), itemIDQuantityUpdate1, itemUpdateQuantity1);
            cart = orderDBManager.getCart(user.getUserID());
            session.setAttribute("cartItems", cart);
            
        }catch(SQLException ex){
            Logger.getLogger(UpdateCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("cart.jsp").include(request, response);
        
    }
}
