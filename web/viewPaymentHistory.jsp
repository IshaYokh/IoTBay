<%-- 
    Document   : viewPaymentHistory
    Created on : 02/05/2021, 8:28:19 PM
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

        <div class="search-payment-history-title">
            <h1>Search Payment History</h1>
        </div>
        
        <form class="search-inputs" action="#" method="POST">
            <label for="paymentID">PaymentID</label>
            <input type="text" placeholder="Enter Payment ID" name="paymentID" required>
            <label for="date">Payment Date</label>
            <input type="date" placeholder="DD/MM/YYYY" name="date" required>
            
            <div class="search-btn-container">
                <button href="" type="submit">Search</button>
            </div>
        </form>

        <!-- Payment History table -->
        <table class="payment-history-table">
            <tr class="header">
                <th>Payment ID</th>
                <th>Order ID</th>
                <th>Payment Amount</th>
                <th>Payment Details</th>
                <th>Date</th>
            </tr>
            <tr>
                <td>5465461</td>
                <td>6548545</td>
                <td>$532</td>
                <td>Mastercard 4523215235698745 Expiry Date: 03/2023</td>
                <td>20/05/2021</td>
            </tr>
            <tr>
                <td>5445151</td>
                <td>4545454</td>
                <td>$328</td>
                <td>Mastercard 4521569874512365 Expiry Date: 09/2022</td>
                <td>13/05/2021</td>
            </tr>
        </table>
    </body>
</html>
