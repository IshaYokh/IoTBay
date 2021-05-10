/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.controller;

/**
 *
 * @author kaushikdeshpande
 */
import java.io.IOException;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import iotbay.g15.model.User;
import iotbay.g15.model.dao.DBManager;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;


public class AcclogsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    DBManager manager = (DBManager)session.getAttribute("manager");
   
    User user = (User)session.getAttribute("user");
    String email = user.getEmail();
    String password = user.getPassword();
        try {
            int userID = manager.getUserID(email, password);
            ArrayList logs = manager.getLogs(userID);
            ArrayList tlogs = manager.getTLogs(userID);
             session.setAttribute("logs", logs);
             session.setAttribute("tlogs", tlogs);
            request.getRequestDispatcher("AccountLogs.jsp").include(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(AcclogsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }



}
