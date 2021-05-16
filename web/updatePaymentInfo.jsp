<%-- 
    Document   : updatePayment
    Created on : 25/04/2021, 11:42:39 PM
    Author     : Isha Yokhanna
--%>

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
        <jsp:include page="/ViewPaymentInfoServlet"/>
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
            String url = "main.jsp";
            String pageName = "account page";
            String cancelButtonUrl = "main.jsp";
            try{
                String paymentInfoUpdateFeedback = (String)session.getAttribute("paymentInfoUpdateFeedback");
                
                try{
                        String redirectedFromCheckout = (String)session.getAttribute("redirectedFromCheckout");
                        if(redirectedFromCheckout.equals("true")){
                            cancelButtonUrl = "checkout.jsp";
                        }
                    }catch(NullPointerException ex){
                    }
                
                if(paymentInfoUpdateFeedback.equals("success")){ 
                    session.setAttribute("userHasPaymentInfo", "true");
                    session.removeAttribute("paymentInfoUpdateFeedback");
                    
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
                <h1>Thanks <%= userName%>! your payment information has been updated successfully! <a href="<%= url%>">Return to <%= pageName%></a></h1>
            </div>
        
        <%      }else if(paymentInfoUpdateFeedback.equals("fail")){%>
        
        <div class="paymentinfo-fail-feedback">
            <h1><i class="fas fa-exclamation-triangle"></i>&nbsp;Something went wrong! please check the text inputs for feedback</h1>
        </div>
        
        <%
            }
                session.removeAttribute("redirectedFromCheckout");
                session.removeAttribute("paymentInfoUpdateFeedback");
            }
            catch(NullPointerException ex){
            }
        %>
       
        <% 
            // Grabbing customer payment info details
            PaymentInfo paymentInfo = (PaymentInfo)session.getAttribute("paymentInfo");
            
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
        <h1 class="card-details-title">View/Update/Delete Billing Address & Card Details</h1>
        <div class="form" id="createForm">
            <form action="UpdatePaymentInfoServlet" method="post" class="form-container-update-card">
              <label for="street-number">Street Number</label>
              <input type="text" value="<%=(streetNumberErr != null ? streetNumberErr : paymentInfo.getStreetNumber())%>" name="street-number" required>

              <label for="street-name">Street Name</label>
              <input type="text" value="<%=(streetNameErr != null ? streetNameErr : paymentInfo.getStreetName())%>" name="street-name" required>
              
              <label for="street-type">Street Type</label>
              <input type="text" value="<%=(streetTypeErr != null ? streetTypeErr : paymentInfo.getStreetType())%>" name="street-type" required>
              
              <label for="suburb">Suburb</label>
              <input type="text" value="<%=(suburbErr != null ? suburbErr : paymentInfo.getSuburb())%>" name="suburb" required>
          
              <label for="state">State</label>
              <input type="text" value="<%=(stateErr != null ? stateErr : paymentInfo.getState())%>" name="state" required>

              <label for="postcode">Enter Postcode</label>
              <input type="text" value="<%=(postcodeErr != null ? postcodeErr : paymentInfo.getPostcode())%>" name="postcode" required>
              
              <label for="Country">Country</label>
              <input type="text" value="<%=(countryErr != null ? countryErr : paymentInfo.getCountry())%>" name="country" required>
              
              <div class="placeholder"></div>
              
              <label for="card-holder-name">Card Holder Name</label>
              <input type="text" value="<%=(cardHolderNameErr != null ? cardHolderNameErr : paymentInfo.getCardHolderName())%>" name="card-holder-name" required>
                
              <label for="card-number">Card Number</label>
              <input type="text" value="<%=(cardNumberErr != null ? cardNumberErr : paymentInfo.getCardNumber())%>" name="card-number" required>
              
              <label for="card-expiry-date">Expiry Date</label>
              <input type="text" value="<%=(cardExpiryDateErr != null ? cardExpiryDateErr : paymentInfo.getCardExpiryDate())%>" name="card-expiry-date">
              
              <label for="card-cvc">CVC</label>
              <input type="password" value="<%=(cardCvcErr != null ? cardCvcErr : paymentInfo.getCardCVC())%>" name="card-cvc" required>

              <!-- Submit, Delete or cancel buttons -->
              <div class="save-btn-container">
                <button type="submit">Save</button>
              </div>
            </form>
            <a href="DeletePaymentInfoServlet">
                <div class="delete-btn-container">
                    <button type="submit">Delete</button>
                </div>
            </a>
            <a href="<%= cancelButtonUrl%>">
                <div class="cancel-btn-container">
                    <button type="submit">Cancel</button>
                </div>
            </a>
        </div>
        <div class="placeholder"></div>
    </body>
</html>