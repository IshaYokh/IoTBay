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
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author rebecca
 */
public class AddToCartServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<Item> cart = new ArrayList<Item>();
        String itemID = request.getParameter("itemID");
        String itemSerialNumber = request.getParameter("itemSerialNumber");
        String itemCategory = request.getParameter("itemCategory");
        String itemBrand = request.getParameter("itemBrand");
        String itemName = request.getParameter("itemName");
        String itemImage = request.getParameter("itemImage");
        String quantity = request.getParameter("itemQuantity");
        
        String currentItem = request.getParameter("currentItem");
        String itemPrice = request.getParameter("itemPrice");
        double itemprice = Double.parseDouble(itemPrice);
        OrderDAO orderDBManager = (OrderDAO) session.getAttribute("orderDBManager");
        int qty = Integer.parseInt(quantity);
        int id = Integer.parseInt(itemID);
        int serial = Integer.parseInt(itemSerialNumber);
        
        
        Item item = new Item(id, serial, itemCategory,itemBrand,itemName,itemImage);
        int uID = user.getUserID();
        
        try{
            orderDBManager.addToCart(uID, id, serial, itemCategory, itemBrand, itemName, itemImage, qty, itemprice); //adding to cart
            session.setAttribute("cartItems", cart);
            cart = orderDBManager.getCart(uID);
            session.setAttribute("cartItems", cart);
            currentItem = request.getParameter("currentItem");
            System.out.println("currentItem2 (Servlet): " + currentItem); //works
        }catch(SQLException ex){
            Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("cart.jsp").include(request, response);
        
    }
}