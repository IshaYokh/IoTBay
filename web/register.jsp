<%-- 
    Document   : register
    Created on : 08/04/2021, 1:07:00 AM
    Author     : Isha Yokhanna, Tada33
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <a href="#"><li>Contact</li></a>
                    <a href="login.jsp"><li class="login">Sign up / Login</li></a>
		</ul>
	</div>
        
        <div class="placeholder"></div>
        
        <div class="form" id="createForm">
            <form action="AddServlet" method="post" class="form-container-register">
                <h1 class="create-account-title">Create Account</h1>

                <label for="fname">First Name</label>
                <input type="text" placeholder="Enter First Name" name="fname" required>

                <label for="lname">Last Name</label>
                <input type="text" placeholder="Enter Last Name" name="lname" required>

                <label for="email">Email</label>
                <input type="text" placeholder="Enter Email" name="email" required>

                <label for="psw">Password</label>
                <input type="password" placeholder="Enter Password" name="pwd" required>

                <label for="psw">Confirm Password</label>
                <input type="password" placeholder="Confirm Password" name="pwd" required>

                <label for="number">Phone Number</label>
                <input type="text" placeholder="Enter Phone Number" name="number" required>

                <label for="street-number">Street Number</label>
                <input type="text" placeholder="Enter Street Number" name="street-number" required>

                <label for="street-name">Street Name</label>
                <input type="text" placeholder="Enter Street Name" name="street-name" required>

                <label for="street-type">Street Type</label>
                <input type="text" placeholder="Enter Street Type" name="street-type" required>

                <label for="suburb">Suburb</label>
                <input type="text" placeholder="Enter Suburb" name="suburb" required>

                <label for="state">State</label>
                <input type="text" placeholder="Enter State" name="state" required>

                <label for="postcode">Postcode</label>
                <input type="text" placeholder="Enter Postcode" name="postcode" required>

                <label for="country">Country</label>
                <input type="text" placeholder="Enter Country" name="country" required>

                <input type="hidden" name="status" value="true">
                
                <%
                    session.setAttribute("source",  request.getParameter("source"));
                %>
                <c:choose>
                    <c:when test="${source == 'customerinfo'}">
                        <input type="hidden" name="source" value="customerinfo">
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" name="source" value="register">
                    </c:otherwise>
                </c:choose>
                <%
                    session.removeAttribute("source");
                %>

                <p>By creating an account you agree to our&nbsp;<a href="#">Terms & Privacy</a></p>
                <button class="btn-create">Create Account</button>
                <div class="placeholder"></div>
                <p class="already-have-account">Already have an account?&nbsp;<a href="login.jsp">Login</a></p>
            </form>
        </div>
    </body>
</html>
