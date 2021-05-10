/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.user;

import iotbay.g15.model.dao.UserManagementDAO;
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
 * @author Kevin /admin/user/delete
 */
public class DeleteUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteUser</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteUser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        session.setAttribute("deleteUserId", id);
        RequestDispatcher view = request.getRequestDispatcher("/admin/user/delete.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // grab the id from parameters (id = 1)
        try {
            String id = request.getParameter("id");
            HttpSession session = request.getSession();
            UserManagementDAO manager = (UserManagementDAO) session.getAttribute("manager");
            manager.deleteUser(Integer.parseInt(id));
            // redirect back to list of users
            response.sendRedirect("/admin/users");
        } catch (SQLException error) {
            Logger.getLogger(controller.admin.user.DeleteUser.class.getName()).log(Level.SEVERE, null, error);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
