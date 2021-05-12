<%-- 
    Document   : orderhistory
    Created on : 03/05/2021, 10:54:36 PM
    Author     : rebecca
--%>
<%@page import="iotbay.g15.model.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% List<Order> orderData = (ArrayList) session.getAttribute("orderList"); %>

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
        
        <form method = "post" action = 'OrderHistoryServlet'>
                
                <label for="userID">User ID</label>
                <input type="text" placeholder="Enter User ID" name="userID" required>

                <button type="submit" class="btn-create">Insert User</button>
            
            </form>
        
        <form method = "post" action = 'OrderHistoryServlet'>
                
                <label for="orderID">Order Number</label>
                <input type="text" placeholder="Enter Order Number" name="orderID">
                
                <label for="orderDate">Order Date</label>
                <input type="Date" placeholder="Enter Order Date" name="orderDate">

                <button type="submit" class="btn-create">Search</button>
            
            </form>
        

        <table border="1">
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Order Date</th>
                    <th>Order Status</th>
                </tr>    
            </thead>
            <tbody>

            <%
                if(orderData!= null){
                    for(Order O : orderData){%>

            <tr>
                <td><%= O.getID() %></td>
                <td><%= O.getOrderDate() %></td>
                <td><%= O.getOrderStatus() %></td>
            </tr>

            <%
                }}
            %>
            </table>
        
            <%
                if(orderData!= null){
                    for(Order O : orderData){%>
            <div>
                <p><%= O.getID() %></p>
                <p><%= O.getOrderDate() %></p>
                <p><%= O.getOrderStatus() %></p>
                
                <% List<Item> itemList = (ArrayList) O.getOrderedProducts();
                    for (Item o : itemList){ %> 
                <p><%= o.getItemName() %></p>
                <img src="assets/items/<%= o.getItemImage() %>"
                <% }
                %>
                
                
                
            </div>
            <%
                }}
            %>
        </div>
    </body>
</html>