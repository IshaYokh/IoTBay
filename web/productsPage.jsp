<%-- 
    Document   : networking
    Created on : 25/04/2021, 8:28:10 PM
    Author     : Austin
--%>
<%@page import="iotbay.g15.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
        <link href="../css/catalouge.css" rel="stylesheet" type="text/css"/>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap" rel="stylesheet">
        <title>Store</title>
        <link rel="icon" type="image/png" href="../assets/favicon.png">
    </head>
    <body>
        <div class="navbar">
            <div class="logo"><img src="../assets/logo.png"/></div>
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
        <div class="placeholder"></div>
        <div class="catalouge-container">
            <a href="">
                <div class="catalouge-item">
                <h1>Item</h1>
                <img src="" alt=""/>
                </div>
            </a>
            <a href="">
                <div class="catalouge-item">
                <h1>Item</h1>
                <img src="" alt=""/>
                </div>
            </a>
            <a href="">
                <div class="catalouge-item">
                <h1>Item</h1>
                <img src="" alt=""/>
                </div>
            </a>
        </div>
    </body>
    <footer>
        <p>Copyright Not Group 14 2021</p>
    </footer>
</html>