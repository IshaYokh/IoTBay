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
import iotbay.g15.model.RegisterUpdateValidator;
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
        //gets all the parameters from the form
        HttpSession session = request.getSession();
        LoginLogoutDAO manager = (LoginLogoutDAO) session.getAttribute("manager");
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("pws");
        String streetName = request.getParameter("street-name");
        String streetType = request.getParameter("street-type");
        String suburb = request.getParameter("suburb");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        User user = (User) session.getAttribute("user");
        String oldemail = user.getEmail();
        String oldpassword = user.getPassword();
        //validates paramters
        RegisterUpdateValidator validate = new RegisterUpdateValidator();
      
        session.setAttribute("emailUsed1",validate.validateEmail(email));
        session.setAttribute("passNoMatch1", validate.validatePassword(password));
        session.setAttribute("phoneNoErr1", validate.validatePhone(request.getParameter("number")));
        session.setAttribute("postcodeErr1", validate.validatePostCode(request.getParameter("postcode")));
        session.setAttribute("streetNoErr1", validate.validateStreetNo(request.getParameter("street-number")));
        if((validate.validateEmail(email)==null) && (validate.validatePassword(password)==null) && (validate.validatePhone(request.getParameter("number"))== null) 
            && (validate.validatePostCode(request.getParameter("postcode"))== null) &&(validate.validateStreetNo(request.getParameter("street-number"))== null)){
            int phoneNumber;
            phoneNumber = Integer.parseInt(request.getParameter("number"));
            int streetNumber = Integer.parseInt(request.getParameter("street-number"));
            int postcode = Integer.parseInt(request.getParameter("postcode"));
        
            // updates sql table and //sets session user details to new details
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
                session.setAttribute("user", user);
                //reset Error Variables
                session.setAttribute("emailUsed1", null);
                session.setAttribute("passNoMatch1", null);
                session.setAttribute("phoneNoErr1", null);
                session.setAttribute("postcodeErr1", null);
                session.setAttribute("streetNoErr1", null);
                
                session.setAttribute("accupdated", "Account has been updated");
                request.getRequestDispatcher("accountDetails.jsp").include(request, response);
            } catch (SQLException ex) {

            }
        }else{
            // returns to accountDetails page and displays any input errors that would of occured
            request.getRequestDispatcher("accountDetails.jsp").include(request, response);
        
        
        
        }

    }

}
