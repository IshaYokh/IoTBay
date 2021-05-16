<%-- 
    Document   : addPaymentInfo
    Created on : 27/04/2021, 10:25:43 AM
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
        
        
        <!-- PaymentInfo addition feedback box -->
        <% 
            String userName = user.getFirstName();
            String url = "main.jsp";
            String pageName = "account page";
            String cancelButtonUrl = "main.jsp";
            try{
                String paymentInfoAddFeedback = (String)session.getAttribute("paymentInfoAddFeedback");
                
                try{
                        String redirectedFromCheckout = (String)session.getAttribute("redirectedFromCheckout");
                        if(redirectedFromCheckout.equals("true")){
                            cancelButtonUrl = "checkout.jsp";
                        }
                    }catch(NullPointerException ex){
                    }
                
                if(paymentInfoAddFeedback.equals("success")){ 
                    session.setAttribute("userHasPaymentInfo", "true");
                    session.removeAttribute("paymentInfoAddFeedback");
                    
                    try{
                        String redirectedFromCheckout = (String)session.getAttribute("redirectedFromCheckout");
                        if(redirectedFromCheckout.equals("true")){
                            url = "checkout.jsp";
                            pageName = "checkout page";
                            cancelButtonUrl = "checkout.jsp";
                        }
                    }catch(NullPointerException ex){
                    }
        %> 
            <div class="paymentinfo-feedback">
                <h1>Thanks <%= userName%>! your payment information has been added successfully! <a href="<%= url%>">Return to <%= pageName%></a></h1>
            </div>
        <%
            }else if(paymentInfoAddFeedback.equals("alreadyExists")){
        %>
            
        <div class="paymentinfo-fail-feedback">
            <h1><i class="fas fa-exclamation-triangle"></i>&nbsp;Payment Information already exist</h1>
        </div>
        
        <%}else if(paymentInfoAddFeedback.equals("fail")){%>
        
        <div class="paymentinfo-fail-feedback">
            <h1><i class="fas fa-exclamation-triangle"></i>&nbsp;Something went wrong! please check the text inputs for feedback</h1>
        </div>
        
        
        <%
            
            }
                session.removeAttribute(paymentInfoAddFeedback);
                session.removeAttribute("redirectedFromCheckout");
            }
            catch(NullPointerException ex){
            }
        %>
            
        <%
            // Error validation variables
            String streetNumberErr = (String)session.getAttribute("streetNumberErr");
            String streetNameErr = (String)session.getAttribute("streetNameErr");
            String streetTypeErr = (String)session.getAttribute("streetTypeErr");
            String suburbErr = (String)session.getAttribute("suburbErr");
            String stateErr = (String)session.getAttribute("stateErr");
            String postcodeErr = (String)session.getAttribute("postcodeErr");
            String countryErr = (String)session.getAttribute("countryErr");
            String cardHolderNameErr = (String)session.getAttribute("cardHolderNameErr");
            String cardNumberErr = (String)session.getAttribute("cardNumberErr");
            String cardExpiryDateErr = (String)session.getAttribute("cardExpiryDateErr");
            String cardCvcErr = (String)session.getAttribute("cardCvcErr");
        %>
       
        <!-- Form for new card and billing details -->
        <h1 class="card-details-title">Add Billing Address & Card Details</h1>
        <div class="form" id="createForm">
            <form action="AddPaymentInfoServlet" method="post" class="form-container-update-card">
              <label for="street-number">Street Number</label>
              <input type="text" placeholder="<%=(streetNumberErr != null ? streetNumberErr : "Enter Street Number")%>" name="street-number" required>
              
              <label for="street-name">Street Name</label>
              <input type="text" placeholder="<%=(streetNameErr != null ? streetNameErr : "Enter Street Name")%>" name="street-name" required>
              
              <label for="street-type">Street Type</label>
              <input type="text" placeholder="<%=(streetTypeErr != null ? streetTypeErr : "Enter Street Type")%>" name="street-type" required>
              
              <label for="suburb">Suburb</label>
              <input type="text" placeholder="<%=(suburbErr != null ? suburbErr : "Enter Suburb")%>" name="suburb" required>
          
              <label for="state">State</label>
              <input type="text" placeholder="<%=(stateErr != null ? stateErr : "Enter State")%>" name="state" required>

              <label for="postcode">Enter Postcode</label>
              <input type="text" placeholder="<%=(postcodeErr != null ? postcodeErr : "Enter Postcode")%>" name="postcode" required>
              
              <label for="Country">Country</label>
              <input type="text" placeholder="<%=(countryErr != null ? countryErr : "Enter Country")%>" name="country" required>
              
              <div class="placeholder"></div>
              
              <h1>Payment methods allowed: <i class="fab fa-cc-mastercard"></i> &nbsp;Mastercard</h1>
              
              <label for="card-holder-name">Card Holder Name</label>
              <input type="text" placeholder="<%=(cardHolderNameErr != null ? cardHolderNameErr : "John Citizen")%>" name="card-holder-name" required>
                
              <label for="card-number">Card Number</label>
              <input type="text" placeholder="<%=(cardNumberErr != null ? cardNumberErr : "0000 0000 0000 0000")%>" name="card-number" required>
              
              <label for="card-expiry-date">Expiry Date</label>
              <input type="text" placeholder="<%=(cardExpiryDateErr != null ? cardExpiryDateErr : "MM/YYYY")%>" name="card-expiry-date" required>
              
              <label for="card-cvc">CVC</label>
              <input type="password" placeholder="<%=(cardCvcErr != null ? cardCvcErr : "000")%>" name="card-cvc" required>
              
              <!-- Submit or cancel buttons -->
              <div class="save-btn-container">
                <button type="submit">Save</button>
              </div>
            </form>
            <a href="<%= cancelButtonUrl%>">
                <div class="cancel-btn-container">
                    <button type="submit">Cancel</button>
                </div>
            </a>
        </div>
        <div class="placeholder"></div>
    </body>
</html>