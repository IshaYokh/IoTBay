<%-- 
    Document   : AddOrder
    Created on : 09/05/2021, 11:50:10 PM
    Author     : rebecca
--%>
<jsp:include page="/ConnServlet" flush="true"/>
<%@page import="iotbay.g15.model.User"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        
        
        
        <div class="order">
            
            <form method = "post" action = 'AddOrderServlet'>
                
                <label for="orderID">Order ID</label>
                <input type="text" placeholder="Enter Order ID" name="orderID" required>

                <label for="orderDate">Order Date</label>
                <input type="text" placeholder="Enter Order Date" name="orderDate" required>

                <label for="orderStatus">Order Status</label>
                <input type="text" placeholder="Enter Order Status" name="orderStatus" required>

                <button type="submit" class="btn-create">Add Order</button>
            
            </form>
        </div>
    </body>
</html>
