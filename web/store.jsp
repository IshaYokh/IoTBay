<%-- 
    Document   : store
    Created on : 25/04/2021, 1:20:37 PM
    Author     : Austin
--%>
<%@page import="iotbay.g15.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <link href="css/style.css" rel="stylesheet">
        <link href="css/catalouge.css" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap" rel="stylesheet">
        <title>Store</title>
        <link rel="icon" type="image/png" href="assets/favicon.png">
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
        <div class="placeholder"></div>
        <div class="catalouge-container">
            <a href="categories/networking.jsp">
                <div class="catalouge-item">
                <h1>Networking</h1>
                <img src="assets/categories/router.png" alt="Router"/>
                </div>
            </a>
            <a href="categories/sensors.jsp">
                <div class="catalouge-item">
                    <h1>Sensors</h1>
                    <img src="assets/categories/Sensor.png" alt="sensor"/>
                </div>
            </a>
            <a href="categories/mini-pc.jsp">
                <div class="catalouge-item">
                    <h1>Mini PC</h1>
                    <img src="assets/categories/mini-pc.png" alt="mini-pc"/>
                </div>
            </a>
            <a href="categories/robotics.jsp">
                <div class="catalouge-item">
                    <h1>Robotics</h1>
                    <img src="assets/categories/robotics.png" alt="robot-arm"/>
                </div>
            </a>
            <a href="categories/smart-home.jsp">
                <div class="catalouge-item">
                    <h1>Smart Home</h1>
                    <img src="assets/categories/smart-home.png" alt="smart-home"/>
                </div>
            </a>
            <a href="categories/parts.jsp">
                <div class="catalouge-item">
                    <h1>Parts</h1>
                    <img src="assets/categories/parts.png" alt="parts"/>
                </div>
            </a>
            <a href="categories/dev-boards.jsp">
                <div class="catalouge-item">
                    <h1>Development Boards</h1>
                    <img src="assets/categories/dev-board.png" alt="dev-board"/>
                </div>
            </a>
            <a href="categories/drones.jsp">
                <div class="catalouge-item">
                    <h1>Drones</h1>
                    <img src="assets/categories/drone.png" alt="drone"/>
                </div>
            </a>
            <a href="categories/deals.jsp">
                <div class="catalouge-item">
                    <h1>Special Deals</h1>
                    <img src="assets/categories/deal.png" alt="deal"/>
                </div>
            </a>
        </div>
    </body>
    <footer>
        <p>Copyright Not Group 14 2021</p>
    </footer>
</html>