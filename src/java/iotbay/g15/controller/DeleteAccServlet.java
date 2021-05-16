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

public class DeleteAccServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        LoginLogoutDAO manager = (LoginLogoutDAO) session.getAttribute("manager");

        User user = (User) session.getAttribute("user");
        String email = user.getEmail();
        String password = user.getPassword();
        try {
            int userID = manager.getUserID(email, password);
            manager.deleteCustomer(userID);
            manager.deleteUser(userID);

        } catch (SQLException ex) {
            Logger.getLogger(DeleteAccServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.invalidate();
        response.sendRedirect("index.jsp");

    }
}
