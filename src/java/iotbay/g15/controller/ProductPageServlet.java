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

public class ProductPageServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ShowItemDAO showItem = (ShowItemDAO) session.getAttribute("showItem");
        
        //want to get caregorty name from button
        String cat = request.getParameter("param1");
        System.out.print(cat);
        try {
            ArrayList<Item> pro = new ArrayList<Item>();
            ArrayList<Item> proList = showItem.getProductlist(cat);
            ArrayList proListImages = showItem.getProductlistImage(cat);
            session.setAttribute("proListImages", proListImages);
            session.setAttribute("proList", proList);
            request.getRequestDispatcher("productsPage.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductPageServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    
    
    
    
    
    
    
    
    
    }














}
