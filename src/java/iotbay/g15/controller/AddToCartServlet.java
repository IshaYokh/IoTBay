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
        
        ArrayList<Item> cart = new ArrayList<Item>();
        String itemID = request.getParameter("itemID");
        String itemSerialNumber = request.getParameter("itemSerialNumber");
        String itemCategory = request.getParameter("itemCategory");
        String itemBrand = request.getParameter("itemBrand");
        String itemName = request.getParameter("itemName");
        String itemImage = request.getParameter("itemImage");
        //String quantity = request.getParameter("itemQty");
        
        OrderDAO manager = (OrderDAO) session.getAttribute("manager");
        int qty = 2;
        
        int id = Integer.parseInt(itemID);
        int serial = Integer.parseInt(itemSerialNumber);
        
        String msg = "";
        System.out.println("ssssss");
        
        System.out.println("oooooooooooooooo");
        
        
        try{
            for(int i=0; i<qty; i++){
             cart = manager.addToCart(new Item(id, serial, itemCategory, itemBrand, itemName, itemImage));
            }
            session.setAttribute("cartItems", cart);
            //session.setAttribute("cart", manager.getCart());
        }catch(SQLException ex){
            Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("cart.jsp").include(request, response);
        
    }
}