<%-- 
    Document   : updatePayment
    Created on : 25/04/2021, 11:42:39 PM
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
        
        
        <!-- PaymentInfo update feedback box -->
        <% 
            String userName = user.getFirstName();
            try{
                String paymentInfoAddFeedback = (String)session.getAttribute("paymentInfoAddFeedback");
                if(paymentInfoAddFeedback.equals("success")){ 
                    session.setAttribute("userHasPaymentInfo", "true");
                    session.removeAttribute("paymentInfoAddFeedback");
        %> 
            <div class="paymentinfo-feedback">
                <h1>Thanks <%= userName%>! your payment information has been updated successfully! <a href="main.jsp">Return to account page</a></h1>
            </div>
        <%
            }}
            catch(NullPointerException ex){
            }
        %>
       
        <!-- Form for new card and billing details -->
        <h1 class="card-details-title">View/Update Billing Address & Card Details</h1>
        <div class="form" id="createForm">
            <form action="AddPaymentInfoServlet" method="post" class="form-container-update-card">
              <label for="street-number">Street Number</label>
              <input type="text" placeholder="Enter Street number" name="street-number" required>
              
              <label for="street-name">Street Name</label>
              <input type="text" placeholder="Enter Street Name" name="street-name" required>
              
              <label for="street-type">Street Type</label>
              <input type="text" placeholder="Enter Street Type" name="street-type" required>
              
              <label for="suburb">Suburb</label>
              <input type="text" placeholder="Enter Suburb" name="suburb" required>
          
              <label for="state">State</label>
              <input type="text" placeholder="Enter State" name="state" required>

              <label for="postcode">Enter Postcode</label>
              <input type="text" placeholder="Enter Postcode" name="postcode" required>
              
              <label for="Country">Country</label>
              <input type="text" placeholder="Enter Country" name="country" required>
              
              <div class="placeholder"></div>
              
              <label for="card-holder-name">Card Holder Name</label>
              <input type="text" placeholder="John Citizen" name="card-holder-name" required>
                
              <label for="card-number">Card Number</label>
              <input type="text" placeholder="0000 0000 0000 0000" name="card-number" required>
              
              <label for="card-expiry-date">Expiry Date</label>
              <input type="text" placeholder="MM/YYYY" name="card-expiry-date" min="2021-05-14">
              
              <label for="card-cvc">CVC</label>
              <input type="password" placeholder="000" name="card-cvc" required>
              
              <!-- Submit or cancel buttons -->
              <div class="save-btn-container">
                <button type="submit">Save</button>
              </div>
            </form>
            <a href="main.jsp">
                <div class="cancel-btn-container">
                    <button type="submit">Cancel</button>
                </div>
            </a>
        </div>
        <div class="placeholder"></div>
    </body>
</html>