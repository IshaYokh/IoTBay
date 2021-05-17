<%-- 
    Document   : processPayment
    Created on : 15/05/2021, 9:43:02 PM
    Author     : Isha Yokhanna
--%>

<%@page import="iotbay.g15.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                            User user = (User) session.getAttribute("user");
                            session.setAttribute("checkoutActive", "true");

                            if (user != null) {
                                msg = "My Account";
                                path = "main.jsp";
                            }
                        %>
                <a href="<%= path%>"><li class="login"><%= msg%></li></a>
            </ul>
        </div>
        <div class="placeholder"></div>
        
        <!-- Successful or Unsuccessful payment message -->
        <div class="payment-feedback">
            <% String paymentResult = (String)session.getAttribute("paymentSuccessful"); 
               if(paymentResult.equals("true")){
                   session.removeAttribute("checkoutActive");
                   session.setAttribute("isPaid", "true");
            %>
            <div class="successful-payment">
                <h1><i class="fas fa-check-circle"></i>&nbsp;Thanks <%= user.getFirstName()%>! your payment has been successfully received! 
                    <a href="searchPaymentHistory.jsp">click here to check your payment history</a> or you can check your order history from the main page</h1>
            </div>
            <%}else{%>
            <div class="unsuccessful-payment">
                <h1><i class="fas fa-exclamation-triangle"></i>&nbsp;Your payment has been declined! please check your balance on your existing payment information 
                    or add a new one. <a href="checkout.jsp">go back go checkout</a></h1>
            </div>
            <%}%>
        </div>
    </body>
</html>
