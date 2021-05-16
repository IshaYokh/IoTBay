/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.g15.controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import iotbay.g15.model.dao.CustomerDAO;
import java.io.IOException;

/**
 *
 * @author tada33
 */
public class DeleteCustomerServlet extends HttpServlet {

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
        String email = request.getParameter("email");
        CustomerDAO manager = (CustomerDAO)session.getAttribute("customerDBManager");
         
        try {       
            manager.deleteCustomer(email);
            session.setAttribute("deleted", "delete was successful");
        } catch (SQLException ex) {  
            Logger.getLogger(DeleteCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("customerinfo.jsp");
    }
}
 