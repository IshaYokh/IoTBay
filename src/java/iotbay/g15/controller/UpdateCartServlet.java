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
        int itemUpdateQuantity = Integer.parseInt(request.getParameter("itemUpdateQuantity"));
        int itemIDQuantityUpdate = Integer.parseInt(request.getParameter("itemIDQuantityUpdate"));
        ArrayList<Item> cart;
        
        OrderDAO manager = (OrderDAO) session.getAttribute("manager");
        User user = (User) session.getAttribute("user");
        
        try{
            manager.getItemByID(user.getUserID(), itemIDQuantityUpdate);
            manager.updateItemQuantity(user.getUserID(), itemIDQuantityUpdate, itemUpdateQuantity);
            cart = manager.getCart(user.getUserID());
            session.setAttribute("cartItems", cart);
            
        }catch(SQLException ex){
            Logger.getLogger(UpdateCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("cart.jsp").include(request, response);
        
    }
}
