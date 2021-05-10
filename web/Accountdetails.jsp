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
                <a href="#"><li>Store</li></a>
                <a href="#"><li>About</li></a>
                <a href="#"><li>Contact</li></a>
                <% 
                    User user = (User)session.getAttribute("user");
                    String accountName = user.getFirstName();
                %>
                <a href="main.jsp"><li class="login">My Account</li></a>
            </ul>
        </div>
                
        <div class="placeholder"></div>
        <%
        String accupdated = (String) session.getAttribute("accupdated");
        
        %>
        
        <div class="form" id="createForm">
            <form action="AccountdetailServlet" method="post" class="form-container-register">
              <h1 class="create-account-title"><%=(accupdated != null ? accupdated : "Update Account")%></h1>
              
              <label for="fname">First Name</label>
              <input type="text" value= "<%= user.getFirstName() %>" name="fname" >
              
              <label for="lname">Last Name</label>
              <input type="text" value="<%= user.getLastName() %>" name="lname">
              
              <label for="email">Email</label>
              <input type="text" value="<%= user.getEmail() %>" name="email" >
              
              <label for="pws">Password</label>
              <input type="text" value="<%= user.getPassword() %>" name="pws" >
          
              <label for="number">Phone Number</label>
              <input type="text" value="<%= user.getPhoneNumber() %>" name="number" >

              <label for="street-number">Street Number</label>
              <input type="text" value="<%= user.getStreetNumber() %>" name="street-number" >

              <label for="street-name">Street Name</label>
              <input type="text" value="<%= user.getStreetName() %>" name="street-name" >

              <label for="street-type">Street Type</label>
              <input type="text" value="<%= user.getStreetType() %>" name="street-type" >

              <label for="suburb">Suburb</label>
              <input type="text" value="<%= user.getSuburb() %>" name="suburb" >

              <label for="state">State</label>
              <input type="text" value="<%= user.getState() %>" name="state" >

              <label for="postcode">Postcode</label>
              <input type="text" value="<%= user.getPostcode() %>" name="postcode" >

              <label for="Country">Country</label>
              <input type="text" value="<%= user.getCountry() %>" name="country" >
              <div class="placeholder"></div>
              <button href="editaccdetails.jsp" type="submit" class="btn-create">Update details</button>
              <div class="placeholder"></div>
              
            </form>
              
            
            
              
                <a href="AcclogsServlet">
               <button href="AcclogsServlet" type="submit" class="btn-create" > View  Account Logs</button>
                </a>
            
              <form action="deleteaccServlet" method="post" class="form-container-register">
                
                <button href="deleteaccServlet" type="submit" class="btn-create">Delete Account</button>
    
            </form>
             
              
              
        </div>
    </body>
</html>