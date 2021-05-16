<%-- 
    Document   : itemPage
    Created on : 12/05/2021, 9:46:06 PM
    Author     : Austin
--%>

<%@page import="iotbay.g15.model.Item"%>
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
        <div class="placeholder"></div>
        <div class="item">
            
            
            
            <%
                Item item = (Item)session.getAttribute("item");
                int itemid = item.getItemID();
                int qty = item.getProductQuantity();
                double price = item.getItemPrice();
                int serialnumber = item.getItemSerialNumber();
                String brandname = item.getItemBrand();
                String category = item.getItemCategory();
                String name = item.getItemName();
                
                String image = (String)session.getAttribute("itemImage");
              
            %>
            <div class="item-top">
                <a href="ViewCategoriesServlet">Back to Catalogue</a>
            </div>
            <div class="item-left">
                <img src="assets/items/<%= image%>" alt="Item">
            </div>
            <div class="item-right">
                <h1><%= name%></h1>
                <div class="item-inline">
                    <h2>$<%= price%></h2><p> / Unit</p>
                </div>
                <br>
                <div class="item-inline">
                    <h2>Product ID</h2><p><%= serialnumber%></p>
                </div>
                <br>
                <div class="item-inline">
                    <h2>Category</h2><p><%= category%></p>
                </div>
                <br>
                <div class="item-inline">
                    <h2>Available</h2><p><%= qty%></p>
                </div>
                
                <br/>
                
                <% if(user != null){ %>
                <p>Quantity</p>
                <form method = "post" action = 'AddToCartServlet'>
                    <input type="hidden" placeholder="Enter Item ID" name="itemID" value="<%= item.getItemID() %>">
                    <input type="hidden" placeholder="Enter Item Serial Number" name="itemSerialNumber" value="<%= item.getItemSerialNumber() %>">
                    <input type="hidden" placeholder="Enter Item Category" name="itemCategory" value="<%= item.getItemCategory() %>">
                    <input type="hidden" placeholder="Enter Item Brand" name="itemBrand" value="<%= item.getItemBrand() %>">
                    <input type="hidden" placeholder="Enter Item Name" name="itemName" value="<%= item.getItemID() %>">
                    <input type="hidden" placeholder="Enter Item Image" name="itemImage" value="<%= item.getItemImage() %>">
                    <label for="itemQuantity">Item Quantity</label>
                    <input type="text" placeholder="Enter Item Quantity" name="itemQuantity" value="1" required>
                    <button type="submit" class="btn btn-primary">Add Item to Cart</button>
                </form>
                <% }else{ %>
                <a href="login.jsp"><button class="btn btn-primary">Login to Shop</button></a>
                    <% } %>
            </div>
        </div>
    </body>
    <footer>
        <p>Copyright Not Group 14 2021</p>
    </footer>
</html>
