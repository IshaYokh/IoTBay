<%-- 
    Document   : viewPaymentHistory
    Created on : 02/05/2021, 8:28:19 PM
    Author     : Isha Yokhanna
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="iotbay.g15.model.PaymentInfo"%>
<%@page import="iotbay.g15.model.Payment"%>
<%@page import="java.util.ArrayList"%>
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
        <jsp:include page="/ViewPaymentHistoryServlet"/>
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
            // Validation variables
            String paymentIDErr = (String)session.getAttribute("paymentIDErr");
            boolean showEmptyCartMsg = true;
        %>

        <div class="search-payment-history-title">
            <h1>Search Payment History</h1>
        </div>
        
        <form class="search-inputs" action="SearchPaymentHistoryServlet" method="POST">
            <label for="paymentID">PaymentID</label>
            <input type="text" placeholder="Enter Payment ID" name="paymentID" required>
            <label for="date">Payment Date</label>
            <input type="date" placeholder="DD/MM/YYYY" name="date" required>
            
            <div class="search-btn-container">
                <button type="submit">Search</button>
            </div>
        </form>

        <!-- Payment History table -->
        <%
            ArrayList<Payment> payments = (ArrayList<Payment>)session.getAttribute("payments");
            ArrayList<PaymentInfo> paymentInfos = (ArrayList<PaymentInfo>)session.getAttribute("paymentInfos");
        %>
        <table class="payment-history-table">
            <tr class="header">
                <th>Payment ID</th>
                <th>Order ID</th>
                <th>Payment Amount</th>
                <th>Payment Details</th>
                <th>Date</th>
            </tr>
            
            <%
                if(paymentIDErr != null){
                    showEmptyCartMsg = false;
            %>
                <h1 class="empty-msg">Please enter a valid payment ID</h1>
            <%
                }    
                if(payments.size() == 0 && showEmptyCartMsg){%>
                    <h1 class="empty-msg">Your payment history is empty!</h1>
            
            <%  }else{
                try{
                    for(Payment payment : payments){
                        for(PaymentInfo paymentInfo : paymentInfos){    
            %>
            <tr>
                <td><%= payment.getPaymentID()%></td>
                <td><%= payment.getOrderID()%></td>
                <%DecimalFormat decimalFormat = new DecimalFormat("0.00");%>
                <td>$<%= decimalFormat.format(payment.getPaymentAmount())%></td>
                
                <% if(paymentInfo.getPaymentInfoID() == payment.getPaymentInfoID()){ 
                   String paymentDate = payment.getPaymentDate().substring(8,10) + "/" + payment.getPaymentDate().substring(5,7)
                           + "/" + payment.getPaymentDate().substring(0,4);
                %>
                <td><b>Mastercard number:</b> <%= paymentInfo.getCardNumber()%> <br><b>Expiry Date:</b>
                    <%= paymentInfo.getCardExpiryDate()%> <br><b>CVC:</b> <%= paymentInfo.getCardCVC()%></td>
                <%%>
                
                <td><%= paymentDate%></td>
            </tr>
            
            <%}}}}catch(NullPointerException e){}}
            
                session.removeAttribute("payments");
            %>
        </table>
    </body>
</html>
