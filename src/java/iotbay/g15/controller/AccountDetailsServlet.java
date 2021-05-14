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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import iotbay.g15.model.User;
import iotbay.g15.model.dao.LoginLogoutDAO;

public class AccountDetailsServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        LoginLogoutDAO manager = (LoginLogoutDAO) session.getAttribute("manager");
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String email = request.getParameter("email");
        int phoneNumber = Integer.parseInt(request.getParameter("number"));
        String password = request.getParameter("pws");
        int streetNumber = Integer.parseInt(request.getParameter("street-number"));
        String streetName = request.getParameter("street-name");
        String streetType = request.getParameter("street-type");
        String suburb = request.getParameter("suburb");
        String state = request.getParameter("state");
        int postcode = Integer.parseInt(request.getParameter("postcode"));
        String country = request.getParameter("country");
        User user = (User) session.getAttribute("user");
        String oldemail = user.getEmail();
        String oldpassword = user.getPassword();

        try {
            int userID = manager.getUserID(oldemail, oldpassword);
            manager.editUser(firstName, lastName, password, phoneNumber, streetNumber, streetName, streetType, suburb, state, postcode, country, email, userID);

            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            user.setStreetNumber(streetNumber);
            user.setStreetName(streetName);
            user.setStreetType(streetType);
            user.setSuburb(suburb);
            user.setState(state);
            user.setPostcode(postcode);
            user.setCountry(country);
            session.setAttribute("accupdated", "Account has been updated");
            request.getRequestDispatcher("accountDetails.jsp").include(request, response);
        } catch (SQLException ex) {

        }

    }

}
