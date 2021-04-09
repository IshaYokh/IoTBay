<%-- 
    Document   : newjsp
    Created on : 04/04/2021, 11:08:33 AM
    Author     : kaushikdeshpande
--%>
<%@page import="iotbay.g15.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <link href="css/style.css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap" rel="stylesheet">

    </head>	
    <body>
        <div class="navbar">
            <div class="logo"><img src="assets/logo.png"/></div>
            <ul>
                <a href="index.jsp"><li>Home</li></a>
                <a href="#"><li>Store</li></a>
                <a href="#"><li>About</li></a>
                <a href="#"><li>Contact</li></a>
                <% 
                    User user = (User)session.getAttribute("user");
                    String accountName = user.getFirstName();
                %>
                <a href="main.jsp"><li class="login">My Account</li></a>
            </ul>
        </div>
        <div class="placeholder"></div>
        <div class="welcome_title">
            <span> Welcome back <%= accountName%>!</span>
	</div>
        <div class="btns-container">
            <a href="#">
                <button class="view-cart-btn">
                    View Cart
                </button>
            <a/>
            
            <br/>
            <br/>
            
            <a href="#">
                <button class="view-orders-btn">
                    View Orders
                </button>
            <a/>
            
            <br/>
            <br/>
            
            <a href="#">
                <button class="account-details-btn">
                    Account Details
                </button>
            <a/>
            
            <br/>
            <br/>
            
            <a href="#">
                <button class="support-ticket-btn">
                    Submit Support Ticket
                </button>
            <a/>
            
            <br/>
            <br/>
            
            <a href="logout.jsp">
                <button class="logout-btn">
                    Logout
                </button>
            <a/>
        </div>
    </body>
</html>