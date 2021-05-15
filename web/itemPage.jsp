<%-- 
    Document   : itemPage
    Created on : 12/05/2021, 9:46:06 PM
    Author     : Austin
--%>

<%@page import="iotbay.g15.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/catalogue.css" rel="stylesheet" type="text/css"/>
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
        <div class="item">
            <div class="item-top">
                <a href="productsPage.jsp">Back to Catalogue</a>
            </div>
            <div class="item-left">
                <img src="" alt="Item">
            </div>
            <div class="item-right">
                <h1>Item</h1>
                <div class="item-inline">
                    <h2>$10.00</h2><p> / Item</p>
                </div>
                <br>
                <div class="item-inline">
                    <h2>Product ID</h2><p>#</p>
                </div>
                <br>
                <div class="item-inline">
                    <h2>Category</h2><p>#</p>
                </div>
                <br>
                <div class="item-inline">
                    <h2>Available</h2><p>#</p>
                </div>
                <hr>
                <p>Quantity</p>
                <div class="number-input">
                    <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="minus"></button>
                    <input class="quantity" min="0" name="quantity" placeholder="-" type="number" min="1" max="5">
                    <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="plus"></button>
                </div>
                <br><br>
                <button class="cart" type="button" onclick="add to cart">Add To Cart 🛒</button>
            </div>
        </div>
    </body>
    <footer>
        <p>Copyright Not Group 14 2021</p>
    </footer>
</html>