<%-- 
    Document   : viewPaymentInfo
    Created on : 27/04/2021, 9:58:54 AM
    Author     : Isha Yokhanna
--%>

<%@page import="iotbay.g15.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/49ea9400a6.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <!-- Navbar -->
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
        <!-- Billing address section -->
        <div class="billingaddress-details">
            <h3 class="billing-address-title">Billing Address</h3>
            <h5>Address Line 1</h5>
            <h5>Address Line 2</h5>
            <h5>Suburb</h5>
            <h5>State</h5>
            <h5>Postcode</h5>
        </div>
        
        <!-- Card details section -->
        <div class="card-details">
            <h3 class="card-details-title">Card Details</h3>
            <h5>Card Number</h5>
            <h5>Expiry Date</h5>
            <h5>CVC</h5>
        </div> 
    </body>
</html>
