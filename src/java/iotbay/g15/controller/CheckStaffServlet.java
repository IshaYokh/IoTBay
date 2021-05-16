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
import iotbay.g15.model.User;
import iotbay.g15.model.dao.LoginLogoutDAO;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;

public class CheckStaffServlet extends HttpServlet {
        // checks if staff is in the current session than redirects to main staff page
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int userID = user.getUserID();
        LoginLogoutDAO manager = (LoginLogoutDAO) session.getAttribute("manager");
        try {
            if(manager.checkifStaff(userID)){
                request.getRequestDispatcher("admin.jsp").forward(request, response);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckStaffServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    }
