<%-- 
    Document   : deletePaymentInfo
    Created on : 27/04/2021, 8:28:52 AM
    Author     : Isha Yokhanna
--%>
<%@page import="iotbay.g15.model.User"%>
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
        <!-- Navbar -->
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
        
        <%
            String paymentInfoDeleted = (String)session.getAttribute("paymentInfoDeleted");
            String redirectedFromCheckout = "false";
            String pageName = "account page";
            String pageUrl = "main.jsp";
            if(paymentInfoDeleted.equals("success")){
                try{
                    redirectedFromCheckout = (String) session.getAttribute("redirectedFromCheckout");
                    if(redirectedFromCheckout.equals("true")){
                        pageName = "checkout page";
                        pageUrl = "checkout.jsp";
                    }
        %>
        
        <% }catch(NullPointerException e){}%>
        
        <div class="paymentinfo-deletion-feedback">
            <h1>Thanks <%= user.getFirstName()%>! your payment information has been deleted successfully! <a href="<%= pageUrl%>">Return to <%= pageName%></a></h1>
        </div>     
        
        <%
                session.setAttribute("userHasPaymentInfo", "false");
                session.removeAttribute("redirectedFromCheckout");
            }
        %>
    </body>