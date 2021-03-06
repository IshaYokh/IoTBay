<%-- 
    Document   : cart
    Created on : 11/05/2021, 2:10:50 AM
    Author     : rebecca
--%>

<%@page import="iotbay.g15.model.Item"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="iotbay.g15.model.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


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
        
        <form method = "post" action = 'AddToCartServlet'>
                
                <label for="itemID">Item ID</label>
                <input type="text" placeholder="Enter Item ID" name="itemID" value="1" required>
                
                <label for="itemSerialNumber">Item Serial Number</label>
                <input type="text" placeholder="Enter Item Serial Number" name="itemSerialNumber" value="1" required>
                
                <label for="itemCategory">Item Category</label>
                <input type="text" placeholder="Enter Item Category" name="itemCategory" value="1" required>
                
                <label for="itemBrand">Item Brand</label>
                <input type="text" placeholder="Enter Item Brand" name="itemBrand" value="1" required>
                
                <label for="itemName">Item Name</label>
                <input type="text" placeholder="Enter Item Name" name="itemName" value="1" required>
                
                <label for="itemImage">Item Image</label>
                <input type="text" placeholder="Enter Item Image" name="itemImage" value="1.png" required>
                
                <label for="itemQuantity">Item Quantity</label>
                <input type="text" placeholder="Enter Item Quantity" name="itemQuantity" value="1" required>

                <button type="submit" class="btn-create">Add Item to Cart</button>
            
            </form>
            
            
        </div>
    </body>
</html>