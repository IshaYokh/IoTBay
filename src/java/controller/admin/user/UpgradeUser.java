/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.user;

import iotbay.g15.model.User;
import iotbay.g15.model.dao.DBManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kevin
 */
public class UpgradeUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateUser</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateUser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            System.out.println("UPDATEUSER---------->");
            String id = request.getParameter("id");
            HttpSession session = request.getSession();
            session.setAttribute("updateUserId", id);
            DBManager manager = (DBManager) session.getAttribute("manager");
            System.out.println("MANAGER---------->");
            // search that user by id
            User toBeUpdatedUser = manager.getUserById(Integer.parseInt(id));
            System.out.println(toBeUpdatedUser.getFirstName());
            session.setAttribute("updateUser", toBeUpdatedUser);

            RequestDispatcher view = request.getRequestDispatcher("/admin/user/update.jsp");
            view.forward(request, response);
            System.out.println("LINE70---------->");
        } catch (SQLException error) {
            Logger.getLogger(controller.admin.user.UpdateUser.class.getName()).log(Level.SEVERE, null, error);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");

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

        try {
            manager.updateUser(userId, firstName, lastName, email, password,
                    phoneNumber, streetNumber, streetName, streetType,
                    suburb, state, postcode, country);
            response.sendRedirect("/admin/users");
        } catch (SQLException error) {
            Logger.getLogger(controller.admin.user.UpdateUser.class.getName()).log(Level.SEVERE, null, error);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}