/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.controller;

import iotbay.g15.model.CustomerUser;
import iotbay.g15.model.Staff;
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
public class UpgradeCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        HttpSession session = request.getSession();
        UserManagementDAO manager = (UserManagementDAO) session.getAttribute("userManager");
        
        //get information if customer already exist
        try {
            int userID = Integer.parseInt(request.getParameter("id"));
            int loyaltyPoints = Integer.parseInt(request.getParameter("loyaltyPoints"));
            CustomerUser customer = manager.getCustomer(userID);

            //check if customer already exist
            if (customer == null) {
                manager.addCustomer(userID, loyaltyPoints);
            } else {
                manager.upgradeCustomer(userID, loyaltyPoints);
            }
            response.sendRedirect("listUser.jsp");
        } catch (SQLException error) {
            Logger.getLogger(UpgradeCustomerServlet.class.getName()).log(Level.SEVERE, null, error);
        }
    }
}
