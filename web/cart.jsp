<%-- 
    Document   : cart
    Created on : 11/05/2021, 2:10:50 AM
    Author     : rebecca
--%>

<%@page import="iotbay.g15.model.Item"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="iotbay.g15.model.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% List<Item> cartData = (ArrayList) session.getAttribute("cartItems"); %>

<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap" rel="stylesheet">
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/49ea9400a6.js" crossorigin="anonymous"></script>
        <title>Order History</title>
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
        
        <%
            ArrayList orders = (ArrayList) session.getAttribute("orderList");
            if(cartData!= null){
        %>
        
        
           
        
        <div class="container border border-2 rounded">
            <div class="row border-2">
                <div class="col"></div>
                <div class="col">Item ID</div>
                <div class="col">Item Brand</div>
                <div class="col">Item Name</div>
                <div class="col">Price</div>
                <div class="col">Quantity</div>
                <div class="col"></div>
            </div>

            <% 
                double cartPrice = 0;
                for(Item I : cartData)
                    
            {  
                    cartPrice = cartPrice + I.getItemPrice();
                    String cartPriceStr = String.valueOf(cartPrice);
                    session.setAttribute("cartPrice", cartPriceStr);
                    String error = (String) session.getAttribute("error");
            %>

             <div class="row border-2">
                <div class="col"><img id="picture" class="img-thumbnail" src="assets/items/<%= I.getItemImage()%>"></div>
                <div class="col"><%= I.getItemID() %></div>
                <div class="col"><%= I.getItemBrand() %></div>
                <div class="col"><%= I.getItemName() %></div>
                <div class="col">$<%= I.getItemPrice() %></div>
                <div class="col"><form method = "get" action = 'UpdateCartServlet'>
                        <input type="hidden" id="itemIDQuantityUpdate" name="itemIDQuantityUpdate" value="<%= I.getItemID() %>">
                        <input type="text" placeholder="#" name="itemUpdateQuantity" value="<%= I.getUserQuantity() %>" <br />
                        <button type="submit" class="btn btn-success" href="/UpdateCartServlet?itemUpdateQuantity=<%=I.getItemID()%>">Update</button>
                        <a class="btn btn-danger" type="submit" href="/DeleteFromCartServlet?itemID=<%=I.getItemID()%>">Delete</a>
                    </form>
                        <% if(error != null){ %>
                        <p><%= error %></p> <% } else {}%>
                </div>
                <div class="col"></div>
            </div>
            <%
                }%>
                <div class="row">
                <div class="col"></div>
                <div class="col"></div>
                <div class="col"></div>
                <div class="col"></div>
                <div class="col">
                        <button formation="EmptyCartServlet" type="submit" class="btn btn-danger">Empty Cart</button>
                        <a href="checkout.jsp"><button formaction="AddOrderLineServlet" type="submit" class="btn btn-success">Checkout</button></a>
                </div>
            </div>
        </div>
                
                <%}else{
            %>
            <div class="position-relative">
                <div class="position-absolute top-50 start-50 translate-middle">
                    <div class="row">
                        <div class="col">
                            <h2 class="text-center">Your cart is empty.<br/>
                                <a href="ViewCategoriesServlet"><button type="button" class="btn btn-primary">Click here to shop</button></a></h2>
                        </div>
                    </diV>
                </div>
            </div>
            <%
                }
            %>
            
            
        </div>
    </div>
    </body>
</html>