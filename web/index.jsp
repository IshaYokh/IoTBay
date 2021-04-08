<%-- 
    Document   : Index
    Created on : 06/04/2021, 00:00:00 AM
    Author     : Rebecca Gong
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
	<div class="mainpicture">
            <div class="buttons">
                <h1>View our collection:</h1>
                <a href="#"><div class="shopButton"><h2>Shop Now</h2></div></a>
            </div>
	</div>
	<div class="smallerPictures">
            <div class="pic1">
                <div class="buttonsSmall">
                    <h2>Software</h2>
                    <a href="#"><div class="shopButtonSmall"><h3>Shop Now</h3></div></a>
		</div>
            </div>
            <div class="pic2">
                <div class="buttonsSmall">
                    <h2>Smart Devices</h2>
                    <a href="#"><div class="shopButtonSmall"><h3>Shop Now</h3></div></a>
		</div>
            </div>
            <div class="pic3">
                <div class="buttonsSmall">
                    <h2>Cloud Systems</h2>
                    <a href="#"><div class="shopButtonSmall"><h3>Shop Now</h3></div></a>
		</div>
            </div>
            <div class="pic4">
                <div class="buttonsSmall">
                    <h2>Data Transfer Systems</h2>
                    <a href="#"><div class="shopButtonSmall"><h3>Shop Now</h3></div></a>
		</div>
            </div>
            <div class="pic5">
                <!--empty div-->
            </div>
	</div>
    </body>
    <footer>
        <p>Copyright Not Group 14 2021</p>
    </footer>
</html>
