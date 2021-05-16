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
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

public class ViewItemServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ShowItemDAO showItem = (ShowItemDAO) session.getAttribute("showItem");
        String itemID = request.getParameter("param");
        int itemid = Integer.parseInt(itemID);
        try {
            Item item = showItem.getItem(itemid);
            String itemImage = showItem.getItemImage(itemid);
            session.setAttribute("itemImage",itemImage);
            session.setAttribute("item", item);
            request.getRequestDispatcher("itemPage.jsp").include(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    
    
    
    }







}
