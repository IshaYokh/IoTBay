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

public class StaffregisterServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("psw");
        String password1 = request.getParameter("psw1");
        String phoneNumber = request.getParameter("number");
        String streetNumber = request.getParameter("street-number");
        String streetName = request.getParameter("street-name");
        String streetType = request.getParameter("street-type");
        String suburb = request.getParameter("suburb");
        String state = request.getParameter("state");
        String postcode = request.getParameter("postcode");
        String country = request.getParameter("country");
        String dob = request.getParameter("dob");
        LoginLogoutDAO manager = (LoginLogoutDAO) session.getAttribute("manager");
        if (password.equals(password1)) {
            try {
                if (manager.checkUserEmail(email)) { //email has not been used

                    manager.addUser(firstName, lastName, password, phoneNumber, streetNumber, streetName, streetType, suburb, state, postcode, country, email);
                    //getUserID
                    int userID = manager.getUserID(email, password);
                    User user = new User(firstName, lastName, email, password, phoneNumber, streetNumber, streetName, streetType, suburb, state, postcode, country, userID);
                    //manager.addCustomer(userID);
                    int userI = manager.getUserID(email, password);
                    manager.addStaff(userI, dob);
                    manager.addlogsregister(userI);
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("admin/admin.jsp").include(request, response);
                } else {
                    session.setAttribute("emailUsed", "Email has already been used please sign in");
                    request.getRequestDispatcher("staffregister.jsp").include(request, response);

                }
            } catch (SQLException ex) {
                //Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                ex.getMessage();
            }
        } else {
            session.setAttribute("passNoMatch", "Passwords do not Match");
            request.getRequestDispatcher("staffregister.jsp").include(request, response);
        }
    }

}