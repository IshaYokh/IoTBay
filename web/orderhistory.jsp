<%-- 
    Document   : orderhistory
    Created on : 03/05/2021, 10:54:36 PM
    Author     : rebecca
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="iotbay.g15.model.User"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/49ea9400a6.js" crossorigin="anonymous"></script>
        <title>Order History</title>
    </head>
    <body>
        <%
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/iotbay","iotbay", "iotbay");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Orders");
            while (rs.next()) {
                String orderID = rs.getString("OrderID");
                out.println(orderID);
                String userID = rs.getString("userID");
                out.println(userID);
                String courierID = rs.getString("courierID");
                out.println(courierID);
                String orderDate = rs.getString("orderDate");
                out.println(orderDate);
                String orderStatus = rs.getString("orderStatus");
                out.println(orderStatus);
            }
        %>
        
        <div class="navbar">
            <div class="logo"><img src="assets/logo.png"/></div>
                <ul>
                    <a href="#"><li>Home</li></a>
                    <a href="#"><li>Store</li></a>
                    <a href="#"><li>About</li></a>
                    <a href="#"><li>Contact</li></a>
                    <% 
                        String msg = "Sign up / Login";
                        String path = "login.jsp";
                        User user = (User)session.getAttribute("user");
                        
                        if(user != null){
                            msg = "My Account";
                            path = "main.jsp";
                        }
                    %>
                    <a href="<%= path%>"><li class="login"><%= msg%></li></a>
		</ul>
	</div>
	<div class="placeholder"></div>
        
        <div class="search">
            <h1>Search order number</h1>
            <div class="search-inputs">
                <input type="text" placeholder="Enter Order ID" name="OrderID">
                <button href="#" type="subtmit">Search</button>
            </div>
        </div>
        
        <div class="order">
            <table>
                <tr>
                    <th>Order ID</th>
                    <th>User ID</th>
                    <th>Courier ID</th>
                    <th>Order Date</th>
                    <th>Order Status</th>
                </tr>
                <tr>
                    <td><%
                            
                        %></td>
                </tr>
                
            </table>
        </div>
    </body>
</html>
