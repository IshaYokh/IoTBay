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
public class UpdateUserServlet extends HttpServlet {
    
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserManagementDAO manager = (UserManagementDAO) session.getAttribute("userManager");

        //get all previous attributes from SQL
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
        int streetNumber = Integer.parseInt(request.getParameter("streetNumber"));
        String streetName = request.getParameter("streetName");
        String streetType = request.getParameter("streetType");
        String suburb = request.getParameter("suburb");
        String state = request.getParameter("state");
        int postcode = Integer.parseInt(request.getParameter("postcode"));
        String country = request.getParameter("country");
        int userId = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");
        session.setAttribute("status", status);

        //update all attributes
        try {
            manager.updateUser(userId, firstName, lastName, email, password,
                    phoneNumber, streetNumber, streetName, streetType,
                    suburb, state, postcode, country);
            response.sendRedirect("listUser.jsp");
        } catch (SQLException error) {
            Logger.getLogger(UpdateUserServlet.class.getName()).log(Level.SEVERE, null, error);
        }
    }
}
