package iotbay.g15.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import iotbay.g15.model.dao.*;

public class ConnServlet extends HttpServlet {
   private DBConnector db;
   private Connection conn;
   private PaymentInfoDAO paymentInfoDBmanager;
   private LoginLogoutDAO manager;
   private ShowItemDAO showItem;
   private UserManagementDAO userManager;
   private CustomerDAO customerDBManager;

   @Override //Create and instance of DBConnector for the deployment session
   public void init() {
       try {
           db = new DBConnector();
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
       }      
   }

   @Override //Add the DBConnector, DBManager, Connection instances to the session
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");       
       HttpSession session = request.getSession();
       conn = db.openConnection();       

       try {
           manager = new LoginLogoutDAO(conn);
           paymentInfoDBmanager = new PaymentInfoDAO(conn);
           showItem = new ShowItemDAO(conn);
           userManager = new UserManagementDAO(conn);
           customerDBManager = new CustomerDAO(conn);
       }
       catch (SQLException ex){
           Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
       }

       //export the DB managers to the view-session (JSPs)
       session.setAttribute("manager", manager);
       session.setAttribute("paymentInfoDBmanager", paymentInfoDBmanager);
       session.setAttribute("showItem", showItem);
       session.setAttribute("userManager", userManager);
       session.setAttribute("customerDBManager", customerDBManager);
   }

   @Override //Destroy the servlet and release the resources of the application (terminate also the db connection)
    public void destroy() {
       try {
           db.closeConnection();
       } catch (SQLException ex) {
           Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}

