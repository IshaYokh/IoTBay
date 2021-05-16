<%-- 
    Document   : updatecustomer
    Created on : May 14, 2021, 12:38:31 PM
    Author     : tada33
--%>

<%@ page import="iotbay.g15.model.*, iotbay.g15.model.dao.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <div class="navbar">
            <div class="logo"><img src="assets/logo.png"/></div>
                <ul>
                    <a href="index.jsp"><li>Home</li></a>
                    <a href="#"><li>Store</li></a>
                    <a href="#"><li>About</li></a>
                    <a href="LogoutServlet"><li class="login">Logout</li></a>
                    <a href="admin.jsp"><li class="login">Admin Portal</li></a>
		</ul>
	</div>
        <div class="placeholder"></div>
        <div class="placeholder"></div>
        <div class="placeholder"></div>
        
        <%
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            CustomerDAO cd = (CustomerDAO)session.getAttribute("manager");
            Customer c = cd.findCustomer(email, password);
        %>
        <form action="UpdateCustomerServlet" method="post">
            <h1 class="create-account-title">Update Account</h1>
            <table>
                <tr><td>First Name: </td><td><input type="text" name="fname" value="<%=c.getFirstName()%>"></td></tr>
                <tr><td>Last Name: </td><td><input type="text" name="lname" value="<%=c.getLastName()%>"></td></tr>
                <tr style="display: none;"><td></td><td><input type="text" name="email" value="<%=c.getEmail()%>"></td></tr>
                <tr style="display: none;"><td></td><td><input type="text" name="password" value="<%=c.getPassword()%>"></td></tr>
                <tr><td>Phone Number: </td><td><input type="text" name="number" value="<%=c.getPhoneNumber()%>"></td></tr>
                <tr><td>Street Number: </td><td><input type="text" name="street-number" value="<%=c.getStreetNumber()%>"></td></tr>
                <tr><td>Street Name: </td><td><input type="text" name="street-name" value="<%=c.getStreetName()%>"></td></tr>
                <tr><td>Street Type: </td><td><input type="text" name="street-type" value="<%=c.getStreetType()%>"></td></tr>
                <tr><td>Suburb: </td><td><input type="text" name="suburb" value="<%=c.getSuburb()%>"></td></tr>
                <tr><td>State: </td><td><input type="text" name="state" value="<%=c.getState()%>"></td></tr>
                <tr><td>Postcode: </td><td><input type="text" name="postcode" value="<%=c.getPostcode()%>"></td></tr>
                <tr><td>Country: </td><td><input type="text" name="country" value="<%=c.getCountry()%>"></td></tr>
                <tr><td></td><td><button>update</button></td></tr>
            </table>
        </form>
    </body>
</html>
