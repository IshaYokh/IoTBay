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
import javax.servlet.RequestDispatcher;

public class LoginServlet extends HttpServlet {
    
   @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        HttpSession session = request.getSession();
        DBManager manager = (DBManager)session.getAttribute("manager");
        String email = request.getParameter("email");
        String password = request.getParameter("psw");
       try {
           if(manager.checkUser(email, password)){
               //getUser();
               User user1 = manager.getUser(email, password);
               session.setAttribute("user", user1);
               request.getRequestDispatcher("main.jsp").include(request, response);
               
               
               
               
               
               
           }else{
               
               session.setAttribute("incorrectpass", "Incorrect Email or Password");
               request.getRequestDispatcher("login.jsp").include(request, response);
               
               
               
               
           }
           //if email and password are correct
           //grab sql info
           //set the sql info as a user object in session
           
           //request.getRequestDispatcher("main.jsp").include(request, response);
           //else
           // return Incorrect Email or password prompt
           // session.setAttribute("incorrectpass", "Incorrect Email or Password");
       } catch (SQLException ex) {
           Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    }
    
}
