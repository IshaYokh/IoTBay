package iotbay.g15.controller;

import iotbay.g15.model.Item;
import iotbay.g15.model.User;
import iotbay.g15.model.dao.OrderDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author rebecca
 */
public class AddToCartServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<Item> cart = new ArrayList<Item>();
        Item item = (Item) session.getAttribute("item");
        //int itemQty;
        int itemID = item.getItemID();
        int itemSerialNumber = item.getItemSerialNumber();
        String itemCategory = item.getItemCategory();
        String itemBrand = item.getItemBrand();
        String itemName = item.getItemName();
        String itemImage = item.getItemImage();
        String itemQuantity = request.getParameter("itemQuantity");
        int quantity = Integer.parseInt(itemQuantity);
        double itemPrice = item.getItemPrice();
        
        String currentItem = request.getParameter("currentItem");
        System.out.println("currentItem (Servlet): " + currentItem);
        //int currentItemInt = Integer.parseInt(currentItem);
        
        OrderDAO orderDBManager = (OrderDAO) session.getAttribute("orderDBManager");
        
        
        try{
            orderDBManager.addToCart(user.getUserID(), itemID, itemSerialNumber, itemCategory, itemBrand, itemName, itemImage, quantity, itemPrice);
            session.setAttribute("cartItems", cart);
            cart = orderDBManager.getCart(user.getUserID());
            session.setAttribute("cartItems", cart);
            System.out.println("cart3: " + cart);
            session.setAttribute("cartItems", cart);
            currentItem = request.getParameter("currentItem");
            System.out.println("currentItem2 (Servlet): " + currentItem);
        }catch(SQLException ex){
            Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("cart.jsp").include(request, response);
        
    }
}