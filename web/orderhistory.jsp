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
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/49ea9400a6.js" crossorigin="anonymous"></script>
        <title>Order History</title>
    </head>
    <body>        
        <div class="navbar">
            <div class="logo"><img src="assets/logo.png"/></div>
                <ul>
                    <a href="index.jsp"><li>Home</li></a>
                    <a href="ViewCategoriesServlet"><li>Store</li></a>
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
        
        <div class = "container border border-2 rounded">
                <div class = "row border-2">
                    <h3>Filter</h3>
                </div>
                <div class = "row border-2">
                    <form method = "post">
                        <div class ="mb-3">
                            <label for="orderID" class="form-label">Order Number</label>
                            <input type="number" class="form-control" placeholder="Enter Order Number" name="orderID" required>
                        </div>
                        <div class ="mb-3">
                            <label for="orderDate" class="form-label">Order Date</label>
                            <input type="Date" class="form-control" placeholder="Enter Order Date" name="orderDate" required>
                        </div>
                        <% String error = (String) session.getAttribute("errorFilter");
                        if(error != null){ %>
                        <p><%= error %></p> <% } else {}%>
                        
                            <button type="submit" formaction = "FilterSearchServlet" class="btn btn-primary">Search</button>
                            <button type="submit" formaction = "OrderHistoryServlet" class="btn btn-primary" formnovalidate>Reset</button>
                    </form>
                </div>
        </div>
        
        <div class="placeholder"></div>
        
            <%
                if(orderData!= null){
                    for(Order O : orderData){%>
            <div class = "container border border-2 rounded">
                <div class = "row border-2 border-bottom">
                    <div class = "col-md-auto"><p class="lead">Order Number: <%= O.getID() %></p></div>
                    <div class = "col-md-auto"><p class="lead">Order Date: <%= O.getOrderDate() %></p></div>
                    <div class = "col-md-auto"><p class="lead">Order Status: <%= O.getOrderStatus() %></p></div>
                    <!--<div class = "col-md-auto"><p class="lead">Order Total: $$$$$</p></div>-->
                </div>
                     <br/>
                    <% List<Item> itemList = (ArrayList) O.getOrderedProducts();
                       for (Item o : itemList){ %> 
                <div class = "row">
                    <div class = "col-md-auto"><img id="picture" class="img-thumbnail border-2" src="assets/items/<%= o.getItemImage() %>"/></div>
                    <div class = "col">
                        <div class = "row">
                            <div class = "col"><p class="lead"><%= o.getItemBrand() + " " +o.getItemName() %></p></div>
                        </div>
                        <div class = "row">
                            <div class = "col-md-auto"><p>Item Price: <%= o.getItemPrice() %></p></div>
                            <div class = "col-md-auto"><p>Item Quantity: <%= o.getUserQuantity() %></p></div>
                        </div>
                    </div>
                </div>
                <br/>
                    <% }
                    %>
            </div>
            <br/>
            <%
                }}
            %>
        </div>
    </body>
</html>