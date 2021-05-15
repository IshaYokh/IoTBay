/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.controller;

import iotbay.g15.model.dao.UserManagementDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kevin
 */
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // grab the id from parameters id 
        try {
            String id = request.getParameter("id");
            HttpSession session = request.getSession();
            UserManagementDAO manager = (UserManagementDAO) session.getAttribute("userManager");
            manager.deleteUser(Integer.parseInt(id));
            // redirect back to list of users
            response.sendRedirect("listUser.jsp");
        } catch (SQLException error) {
            Logger.getLogger(DeleteUserServlet.class.getName()).log(Level.SEVERE, null, error);
        }
    }
}
