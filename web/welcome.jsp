<%-- 
    Document   : newjsp
    Created on : 04/04/2021, 11:08:33 AM
    Author     : IshaYokh/kaushikdeshpande/Tada33
--%>

<%@page import="iotbay.g15.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <link href="css/style.css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap" rel="stylesheet">
	<script src="https://kit.fontawesome.com/49ea9400a6.js" crossorigin="anonymous"></script>	
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
                    Customer c = (Customer)session.getAttribute("customer");
                    String firstName = c.getFirstName();
                    String msg = "Sign up / Login";
                    String path = "login.jsp";
                    String fname1 = user.getFirstName();
                    if(user != null){
                        msg = "My Account";
                        path = "main.jsp";
                    }
                %>
                <a href="<%= path%>"><li class="login"><%= msg%></li></a>
            </ul>
        </div>
        <div class="placeholder"></div>
	<div class="welcome_title">
            <span> Welcome <%= fname1%>!</span>
	</div>
        <div class="btns-container">
            <a href="index.jsp">
                <button class="cont-shopping-btn">
                    <i class="fas fa-user-circle"></i> &nbsp;Continue Shopping
                </button>
            </a>
            <br/>
            <br/>
            <a href="main.jsp">
                <button class="view-account-btn">
                    <i class="fas fa-shopping-cart"></i> &nbsp;View Account
                </button>
            <a/>
        </div>
    </body>
</html>
