<%-- 
    Document   : Accountdetails
    Created on : 30/04/2021, 1:50:32 PM
    Author     : kaushikdeshpande
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
            String accupdated = (String) session.getAttribute("accupdated");
            String url = "main.jsp";
            String pageName = "account page";
            String redirectedFromCheckout = "false";
        %>

        <div class="form" id="createForm">
            <form action="AccountDetailsServlet" method="post" class="form-container-register">
                
                <%
                    try{
                        redirectedFromCheckout = (String) session.getAttribute("redirectedFromCheckout");
                        if(redirectedFromCheckout.equals("true") && accupdated != null){
                            url = "checkout.jsp";
                            pageName = "checkout page";
                %>
                <div class="account-updated-feedback">
                    <h1 class="create-account-title"><%=(accupdated != null ? accupdated : "Update Account")%> <a href="<%= url%>">Return to <%= pageName%></a></h1>
                </div>
                
                <%
                        session.removeAttribute("redirectedFromCheckout"); 
                    }else{
                       
                %>
                
                <div class="update-account">
                    <h1 class="create-account-title"><%=(accupdated != null ? accupdated : "Update Account")%></h1>
                </div>
                
                <%}%>
                
                <%
                    }catch(NullPointerException e){
                %>
                
                <div class="update-account">
                    <h1 class="create-account-title"><%=(accupdated != null ? accupdated : "Update Account")%></h1>
                </div>
                    
                <%} 
                    session.removeAttribute("accupdated");
                %>
                

                <%
                    String passNoMatch = (String) session.getAttribute("passNoMatch1");
                    String emailUsed = (String) session.getAttribute("emailUsed1");
                    String postcodeErr = (String) session.getAttribute("postcodeErr1");
                    String phoneNoErr = (String) session.getAttribute("phoneNoErr1");
                    String streetNoErr = (String) session.getAttribute("streetNoErr1");
                %>
                
                <label for="fname">First Name</label>
                <input type="text" value= "<%= user.getFirstName()%>" name="fname" >

                <label for="lname">Last Name</label>
                <input type="text" value="<%= user.getLastName()%>" name="lname">

                <label for="email">Email</label>
                <input type="text" value="<%= user.getEmail()%>" name="email" >
                
                <p class="already-have-account"><%=(emailUsed!= null ? emailUsed : " ")%></p>
                <label for="pws">Password</label>
                <input type="text" value="<%= user.getPassword()%>" name="pws" >
                <p class="already-have-account"><%=(passNoMatch!= null ? passNoMatch: " ")%></p>

                <label for="number">Phone Number</label>
                <input type="text" value="<%= user.getPhoneNumber()%>" name="number" >
                
                <p class="already-have-account"><%=(phoneNoErr!= null ? phoneNoErr: " ")%></p>

                <label for="street-number">Street Number</label>
                <input type="text" value="<%= user.getStreetNumber()%>" name="street-number" >
                <p class="already-have-account"><%=(streetNoErr!= null ? streetNoErr : " ")%></p>

                <label for="street-name">Street Name</label>
                <input type="text" value="<%= user.getStreetName()%>" name="street-name" >

                <label for="street-type">Street Type</label>
                <input type="text" value="<%= user.getStreetType()%>" name="street-type" >

                <label for="suburb">Suburb</label>
                <input type="text" value="<%= user.getSuburb()%>" name="suburb" >

                <label for="state">State</label>
                <input type="text" value="<%= user.getState()%>" name="state" >

                <label for="postcode">Postcode</label>
                <input type="text" value="<%= user.getPostcode()%>" name="postcode" >
                <p class="already-have-account"><%=( postcodeErr!= null ? postcodeErr : " ")%></p>


                <label for="Country">Country</label>
                <input type="text" value="<%= user.getCountry()%>" name="country" >
                <div class="placeholder"></div>
                <button type="submit" class="btn-create">Update details</button>
                <div class="placeholder"></div>

            </form>

            <a href="AccLogsServlet">
                <button href="AccLogsServlet" type="submit" class="btn-create" > View  Account Logs</button>
            </a>

            <form action="DeleteAccServlet" method="post" class="form-container-register">

                <button href="DeleteAccServlet" type="submit" class="btn-create">Delete Account</button>

            </form>

        </div>
    </body>
</html>
