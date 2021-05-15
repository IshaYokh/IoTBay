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
import iotbay.g15.model.dao.LoginLogoutDAO;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;

public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        LoginLogoutDAO manager = (LoginLogoutDAO) session.getAttribute("manager");
        String email = request.getParameter("email");
        String password = request.getParameter("psw");
        
        
        try {
            // check if user login details for User exsists 
            if (manager.checkUser(email, password)) {
                //getUser();
                User user1 = manager.getUser(email, password);
                int userID = manager.getUserID(email, password);
                //check if user ID is in staff
                if(manager.checkifStaff(userID)){
                    manager.addlogslogin(userID);
                session.setAttribute("user", user1);
                    request.getRequestDispatcher("Admin.jsp").include(request, response);
                
                
                }
                else{
                    manager.addlogslogin(userID);
                    session.setAttribute("user", user1);
                    request.getRequestDispatcher("main.jsp").include(request, response);
                }

            } else {
                //else throws Incorrect Email or Password
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
