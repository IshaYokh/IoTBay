/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import iotbay.g15.model.Item;
import iotbay.g15.model.dao.LoginLogoutDAO;
import iotbay.g15.model.dao.ShowItemDAO;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

public class AddItemServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ShowItemDAO showItem = (ShowItemDAO) session.getAttribute("showItem");
        String itemID  = request.getParameter("itemID");
        String itemSerial = request.getParameter("itemSerialNumber");
        String itemCategory = request.getParameter("itemCategory");
        String itemBrand = request.getParameter("itemBrand");
        String itemName = request.getParameter("itemName");
        String itemImage = request.getParameter("itemImage");
        String productPrice = request.getParameter("productPrice");
        String productQuantity = request.getParameter("productQuantity");
        int itemid = Integer.parseInt(itemID);
        int itemserial = Integer.parseInt(itemSerial);
        double itemPrice = Double.parseDouble(productPrice);
        int itemQuantity = Integer.parseInt(productQuantity);
        
        try {
            showItem.AddItem3(itemid, itemserial, itemCategory, itemName, itemBrand, itemImage, itemQuantity, itemPrice);
            request.getRequestDispatcher("addItem.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
    
    
    }




}