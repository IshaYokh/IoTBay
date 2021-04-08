<%-- 
    Document   : newjsp
    Created on : 04/04/2021, 11:08:33 AM
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
		
    </head>	
    <body>
        <% 
            String firstName = request.getParameter("fname");
            String lastName = request.getParameter("lname");
            String email = request.getParameter("email");
            String password = request.getParameter("psw");
            String phoneNumber = request.getParameter("number");
            String streetNumber = request.getParameter("street-number");
            String streetName = request.getParameter("street-name");
            String streetType = request.getParameter("street-type");
            String suburb = request.getParameter("suburb");
            String state = request.getParameter("state");
            String postcode = request.getParameter("postcode");
            String country = request.getParameter("country");
        %>
        
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
	<div class="welcome_title">
            <span> Welcome <%= firstName%></span>

	</div>
	<div class="welcome_email">
            <span> Email: <%= email%></span>
	
        </div>
	<div >
            <button type="button" onclick="alert('Hello world!')">
                <svg class="Box_2" viewBox="0 0 473 129">
                    <path id="Box_2" d="M 22 0 L 451 0 C 463.1502685546875 0 473 9.849735260009766 473 22 L 473 107 C 473 119.1502685546875 463.1502685546875 129 451 129 L 22 129 C 9.849735260009766 129 0 119.1502685546875 0 107 L 0 22 C 0 9.849735260009766 9.849735260009766 0 22 0 Z">
                    </path>
		</svg>
		<div id="Return_to_Shopping_">
                    <span>Return to Shopping </span>
		</div>
            </button>

	<button type="button" onclick="alert('Hello world!')">
            <svg class="Box_3" viewBox="0 0 473 129">
                <path id="Box_3" d="M 22 0 L 451 0 C 463.1502685546875 0 473 9.849735260009766 473 22 L 473 107 C 473 119.1502685546875 463.1502685546875 129 451 129 L 22 129 C 9.849735260009766 129 0 119.1502685546875 0 107 L 0 22 C 0 9.849735260009766 9.849735260009766 0 22 0 Z">
		</path>
            </svg>
            <div id="View_Account">
                <span>View Account</span>
            </div>			
	</button>
	</div>
		
	<footer>
            <p>Copyright Not Group 14 2021</p>
	</footer>
        
        <%
            User user = new User(firstName, lastName, email, password, phoneNumber, streetNumber, streetName, streetType, suburb, state, postcode, country);
            session.setAttribute("user", user);
        %>
        
    </body>
</html>
