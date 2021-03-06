<%-- 
    Document   : newjsp
    Created on : 04/04/2021, 11:08:33 AM
    Author     : IshaYokh/kaushikdeshpande/Tada33
--%>
<%@page import="iotbay.g15.model.User"%>
<%@page import="iotbay.g15.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="CheckStaffServlet"/>
<!doctype html>
<html lang="en">
    <head>
        <link href="css/style.css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/49ea9400a6.js" crossorigin="anonymous"></script>
    </head>	
    <body>
        <jsp:include page="/ConfirmUserPaymentInfoServlet"/>
        <jsp:include page="/ViewPaymentInfoServlet"/>
        <div class="navbar">
            <div class="logo"><img src="assets/logo.png"/></div>
            <ul>
                <a href="index.jsp"><li>Home</li></a>
                <a href="ViewCategoriesServlet"><li>Store</li></a>
                <a href="#"><li>About</li></a>
                <a href="#"><li>Contact</li></a>

                <%
                    User user = (User) session.getAttribute("user");
                    String accountName = user.getFirstName();
                %>
                <a href="main.jsp"><li class="login">My Account</li></a>
            </ul>
        </div>
        <div class="placeholder"></div>
        
        <% 
            String checkoutActive = "false";
            try{
                checkoutActive = (String)session.getAttribute("checkoutActive");
                if(checkoutActive.equals("true")){
        %>
                
        <div class="unprocessed-paymentInfo-feedback">
            <h1><i class="fas fa-exclamation-triangle"></i> You still have unprocessed payment in checkout
                <a href="checkout.jsp">click here to return to checkout</a></h1>
        </div>
        
        <%
                }}catch(NullPointerException e){
        %>
        
        <div class="placeholder"></div>
        <div class="placeholder"></div>
        
        <% } %>
        
        <div class="welcome_title">
            <span> Welcome back <%= accountName%>!</span>
	</div>
        <div class="btns-container">
            <a href="cart.jsp">
                <button class="view-cart-btn">
                    <i class="fas fa-shopping-cart"></i> &nbsp;View Cart
                </button>
            <a/>
            
            <br/>
            <br/>
            
            <a href="#">
                <form method = "post" action = 'OrderHistoryServlet'>
                    <button class="view-orders-btn">
                        <i class="fas fa-money-check"></i> &nbsp;View Orders
                    </button>
                </form>
            <a/>
            
            <br/>
            <br/>
            
            <%
                // checking if a user has payment info records to decide wether to display add or edit payment info
                
                try{
                    String userHasPaymentInfo = (String)session.getAttribute("userHasPaymentInfo");
                    if(userHasPaymentInfo.equals("false")){
            %>
            
            <a href="addPaymentInfo.jsp">
                <button class="add-paymentinfo-btn">
                    <i class="far fa-credit-card"></i> &nbsp;Add Payment Information
                </button>
            <a/>

            <% 
                }else{
            %>

            <a href="updatePaymentInfo.jsp">
                <button class="add-paymentinfo-btn">
                    <i class="far fa-credit-card"></i> &nbsp;View/Update/Delete Payment Information
                </button>
            <a/>

            <% 
                }}catch(NullPointerException ex){
            %>
            
            <a href="addPaymentInfo.jsp">
                <button class="add-paymentinfo-btn">
                    <i class="far fa-credit-card"></i> &nbsp;Add Payment Information
                </button>
            <a/>
            
            <% } %>
            
            <br/>
            <br/>
            
            <a href="accountDetails.jsp">
                <button class="account-details-btn">
                    <i class="fas fa-user-circle"></i> &nbsp;Account Details
                </button>
            <a/>
            
            <br/>
            <br/>
            
            <a href="searchPaymentHistory.jsp">
                <button class="search-payment-history-btn">
                    <i class="fas fa-history"></i> &nbsp;Search Payment History
                </button>
            <a/>
            
            <br/>
            <br/>
            
            <a href="#">
                <button class="support-ticket-btn">
                    <i class="fas fa-question-circle"></i> &nbsp;Submit Support Ticket
                </button>
            <a/>
            
            <br/>
            <br/>
            
            <a href="LogoutServlet">
                <button class="logout-btn">
                    <i class="fas fa-sign-out-alt"></i> &nbsp;Logout
                </button>
            <a/>
        </div>
    </body>
</html>