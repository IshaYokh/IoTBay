<%-- 
    Document   : checkout
    Created on : 25/04/2021, 11:41:15 PM
    Author     : Isha Yokhanna
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="iotbay.g15.model.User"%>
<%@page import="iotbay.g15.model.PaymentInfo"%>
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
                    <a href="index.jsp"><li>Home</li></a>
                    <a href="ViewCategoriesServlet"><li>Store</li></a>
                    <a href="#"><li>About</li></a>
                    <a href="#"><li>Contact</li></a>
                    <%
                        String msg = "Sign up / Login";
                        String path = "login.jsp";
                        User user = (User)session.getAttribute("user");
                        session.setAttribute("checkoutActive", "true");
                        
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
            <a href="cart.jsp">
                <button type="submit"><i class="fas fa-arrow-left"></i> &nbsp;Go back to cart</button>
            </a>
        </div>
           
        <div class="table-container">
            
            <h3 class="ordersummary-header">Order summary</h3>
            <div class="order-border">
                <table border="1" class="order-table">
                    <tbody>
                        <tr>
                            <td><span class="bold">Order Subtotal:</span></td>
                            <% String orderSubtotal = (String)session.getAttribute("cartPrice"); %>
                            <td class="right">$<%= orderSubtotal%></td>
                        </tr>

                        <tr>
                            <td><span class="bold">Shipping Cost:</span></td>
                            <td class="right">$5.00</td>
                        </tr>     

                        <tr>
                            <td><span class="bold">Order Total:</span></td>
                            <% DecimalFormat decimalFormat = new DecimalFormat("0.00"); %>
                            <td class="right">$<%= decimalFormat.format(Double.parseDouble(orderSubtotal) + 5.00)%></td>
                        </tr>       
                    </table>
            </div>

            
            <h3 class="shippingdetails-header">Shipping details</h3>
            <div class="shipping-border">
                <!-- Shipping details section -->
                 <table border="1" class="shipping-table">
                    <tbody>
                        <tr>
                            <td><span class="bold">Shipping Address:</span></td>
                            <%
                                String Address = user.getStreetNumber() + " " + user.getStreetName() + " " +
                                user.getStreetType() + " " + user.getSuburb() + " " + user.getState() + " " + user.getPostcode()
                                + " " + user.getCountry();
                            %>
                            <td class="right"><%= Address%></td>
                        </tr>     
                 </table>
                <div class="box-buttons">
                    <a href="updateAccDetailsFromCheckoutServlet">
                        <button type="submit" class="update-shipping">Update/Delete Shipping Details</button>
                    </a>
                </div>
             </div>
            
            <h3 class="paymentdetails-header">Payment details</h3>
            <div class="payment-border">
                <!-- Payment details section -->
                
                <%
                    PaymentInfo paymentInfo = null;
                    String cardLastFourDigits = "";
                    boolean paymentInfoExists = false;
                    try{
                        paymentInfo = (PaymentInfo)session.getAttribute("paymentInfo");
                        cardLastFourDigits = paymentInfo.getCardNumber().substring(paymentInfo.getCardNumber().length() - 4);
                        paymentInfoExists = true;
                        
                        String streetNumber = Integer.toString(paymentInfo.getStreetNumber());
                        String postcode = Integer.toString(paymentInfo.getPostcode());
                        String billingAddress = streetNumber + " " + paymentInfo.getStreetName() + " " +
                                paymentInfo.getStreetType() + " " + paymentInfo.getSuburb() + " " + paymentInfo.getState() + " " + postcode
                                + " " + paymentInfo.getCountry();
                %>
                
                <table border="1" class="payment-table">
                    <tbody>
                        <tr>
                            <td><span class="bold">Payment Method:</span></td>
                            <td class="right">Master card ending with <%= cardLastFourDigits%></td>
                        </tr>

                        <tr>
                            <td><span class="bold">Billing Address:</span></td>
                            <td class="right"><%= billingAddress%></td>
                        </tr>
                </table>
                        
                <%}catch(NullPointerException e){}%>

                <%if(!paymentInfoExists) {%>
                <div class="no-paymentInfo-feedback">
                    <h1><i class="fas fa-exclamation-triangle"></i> You don't have any payment information <a href="addPaymentInfoFromCheckoutServlet">click here to add payment details</a></h1>
                </div>
                <%}else{%>
                <div class="box-buttons">
                    <a href="updatePaymentInfoFromCheckoutServlet">
                        <button type="submit" class="delete-payment">Update/Delete Payment Details</button>
                    </a>
                </div>
            </div>
        </div>
        
        <!-- Pay button -->
        <div class="pay-btn">
            <% session.setAttribute("redirectedFromCheckout", "true"); %>
            <form method="post" action="AddPaymentServlet">
                <button type="submit" class="pay-btn">
                    <i class="fas fa-lock"></i> &nbsp;Proceed with payment
                </button>
            </form>
            <%}%>
        </div>
    </body>
</html>