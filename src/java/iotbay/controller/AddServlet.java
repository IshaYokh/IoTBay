/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import iotbay.g15.model.*;
import iotbay.g15.model.dao.CustomerDAO;
import java.io.IOException;

/**
 *
 * @author tada33
 */
public class AddServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {       
                
        HttpSession session = request.getSession();
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("pwd");
        int phoneNumber = Integer.parseInt(request.getParameter("number"));
        int streetNumber = Integer.parseInt(request.getParameter("street-number"));
        String streetName = request.getParameter("street-name");
        String streetType = request.getParameter("street-type");
        String suburb = request.getParameter("suburb");
        String state = request.getParameter("state");
        int postcode = Integer.parseInt(request.getParameter("postcode"));
        String country = request.getParameter("country");
        String source = request.getParameter("source");
        Customer customer = new Customer(firstName, lastName,
                                         email, password, phoneNumber,
                                         streetNumber, streetName, streetType,
                                         suburb, state, postcode, country);
        CustomerDAO manager = (CustomerDAO)session.getAttribute("manager");
         
        try {       
            session.setAttribute("customer", customer);
            manager.addCustomer(firstName, lastName, email, password, phoneNumber, streetNumber, streetName, streetType, suburb, state, postcode, country);
            session.setAttribute("added", "add was successful");
        } catch (SQLException ex) {  
            Logger.getLogger(AddServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (source.equals("register")) {
            request.getRequestDispatcher("welcome.jsp").include(request, response);
        } else {
            request.getRequestDispatcher("customerinfo.jsp").include(request, response);
        }
    }
}
 