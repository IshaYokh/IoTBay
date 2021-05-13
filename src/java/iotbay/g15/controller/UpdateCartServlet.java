/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.controller;

import iotbay.g15.model.Item;
import iotbay.g15.model.dao.OrderDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rebecca
 */
public class UpdateCartServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        ArrayList<Item> cart = new ArrayList<Item>();
        OrderDAO manager = (OrderDAO) session.getAttribute("manager");
        int itemID = Integer.parseInt(request.getParameter("itemID"));
        
        try{
            manager.removeFromCart(manager.getItemByID(itemID));
            cart = manager.getCart();
            session.setAttribute("cartItems", cart);
            System.out.println("bbbbbbbbbbbbb");
        }catch(SQLException ex){
            Logger.getLogger(deleteFromCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("cart.jsp").include(request, response);
        
    }
}
