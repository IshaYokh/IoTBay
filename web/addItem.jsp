<%-- 
    Document   : addItem
    Created on : 09/05/2021, 9:06:12 PM
    Author     : Austin
--%>
<%@page import="iotbay.g15.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet">
        <link href="css/catalogue.css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap" rel="stylesheet">
        <title>Add Item</title>
        <link rel="icon" type="image/png" href="assets/favicon.png">
    </head>
    <body>
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
                    <a href="LogoutServlet"><li class="login">Logout</li></a>
                    <a href="admin.jsp"><li class="login">Admin Portal</li></a>
		</ul>
	</div>
	<div class="placeholder"></div>
        <div class="placeholder"></div>
        <div class="catalogue-addItem">
            <h1>Add Item</h1>
            <form action="AddItemServlet" method="post">
                <label for="itemID">itemID</label>
                <input type="text" id="itemID" name="itemID">
                
                <label for="itemSerialNumber">itemSerialNumber</label>
                <input type="text" id="itemSerialNumber" name="itemSerialNumber">
                
                <label for="itemCategory">itemCategory</label>
                <input type="text" id="itemCategory" name="itemCategory">
                
                <label for="itemBrand">itemBrand</label>
                <input type="text" id="itemBrand" name="itemBrand">
                
                <label for="itemName">itemName</label>
                <input type="text" id="itemName" name="itemName">
                
                <label for="productPrice">productPrice</label>
                <input type="text" id="productPrice" name="productPrice">
                
                <label for="productQuantity">productQuantity</label>
                <input type="text" id="productQuantity" name="productQuantity">
                
                <input type="submit" value="Submit">
            </form>
        </div>
        <footer>
            <p>Copyright Not Group 14 2021</p>
        </footer>
    </body>
</html>