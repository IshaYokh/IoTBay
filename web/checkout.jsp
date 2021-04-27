<%-- 
    Document   : checkout
    Created on : 25/04/2021, 11:41:15 PM
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
        
        <!-- Order summary section -->
        <h1 class="checkout-header">Checkout</h1>
        <div class="back-to-cart">
            <button href="" type="submit"><--- Go back to cart</button>
        </div>
        <div class="order-summary">
            <h3 class="ordersummary-header">Order summary</h3>
            <h5>Order subtotal</h5>
            <h5>Postage</h5>
            <h4>Order total</h4>
        </div>
        
        <!-- Shipping details section -->
        <div class="shipping-details">
            <h3 class="shippingdetails-header">Shipping details</h3>
            <h5>Shipping address &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 77 jackson streeet</h5>
            <button href="" type="submit" class="update-shipping">Update Shipping Details</button>
            <button href="" type="submit" class="delete-shipping">Delete Shipping Details</button>
        </div>
        
        <!-- Payment details section -->
        <div class="payment-details">
            <h3 class="paymentdetails-header">Payment details</h3>
            <h5>Payment method &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Mastercard ending with 4789</h5>
            <h5>Billing address &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 77 jackson streeet</h5>
            <button href="" type="submit" class="view-payment">View Payment Details</button>
            <a href="updatePaymentInfo.jsp">
                <button class="updatepayment-btn">
                    Update Payment Details
                </button>
            <a/>
            <button href="" type="submit" class="delete-payment">Delete Payment Details</button>
        </div>
        
        <!-- Pay button -->
        <div class="pay-btn">
            <button href="" type="submit" class="pay-btn">
                <i class="fas fa-lock"></i> &nbsp;Proceed with payment
            </button>
        </div>
    </body>
</html>