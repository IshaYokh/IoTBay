<%-- 
    Document   : staffregister
    Created on : 10/05/2021, 7:01:11 PM
    Author     : kaushikdeshpande
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    
        <div class="navbar">
            <div class="logo"><img src="assets/logo.png"/></div>
                <ul>
                    <a href="index.jsp"><li>Home</li></a>
                    <a href="ViewCategoriesServlet"><li>Store</li></a>
                    <a href="#"><li>About</li></a>
                    <a href="#"><li>Contact</li></a>
                    <a href="login.jsp"><li class="login">Sign up / Login</li></a>
		</ul>
	</div>
        
        <div class="placeholder"></div>
        <%
        String passNoMatch = (String) session.getAttribute("passNoMatch");
        String emailUsed = (String) session.getAttribute("emailUsed");
        String postcodeErr = (String) session.getAttribute("postcodeErr");
        String phoneNoErr = (String) session.getAttribute("phoneNoErr");
        String streetNoErr = (String) session.getAttribute("streetNoErr");
        %>
        <div class="form" id="createForm">
            <form action="StaffRegisterServlet" method="POST" class="form-container-register">
              <h1 class="create-account-title">Create Staff Account</h1>
              
              <label for="fname">First Name</label>
              <input type="text" placeholder="Enter First Name" name="fname" required>
              
              <label for="lname">Last Name</label>
              <input type="text" placeholder="Enter Last Name" name="lname" required>
              
              <label for="email">Email</label>
              <input type="text" name="email" placeholder="<%=(emailUsed != null ? emailUsed : "Enter Email")%>" required>
          
              <label for="psw">Password</label>
              <input type="password" placeholder="<%=(passNoMatch != null ? "Enter Correct Password " : "Enter Password")%>" name="psw" required>
              
              <label for="psw">Confirm Password</label>
              <input type="password" placeholder="Confirm Password" name="psw1" required>
              <p class="already-have-account"><%=(passNoMatch != null ? passNoMatch : " ")%>

              <label for="number">Phone Number</label>
              <input type="text" placeholder="<%=(phoneNoErr != null ? phoneNoErr : "Enter Phone Number")%>" name="number" required>
              
              <label for="dob">Date of Birth</label>
              <input type="date" placeholder="Enter Date of birth" name="dob" required>
              <br>
              <br>
              <label for="street-number">Street Number</label>
              <input type="text" placeholder="<%=streetNoErr != null ? streetNoErr : "Enter Street Number"%>" name="street-number" required>

              <label for="street-name">Street Name</label>
              <input type="text" placeholder="Enter Street Name" name="street-name" required>

              <label for="street-type">Street Type</label>
              <input type="text" placeholder="Enter Street Type" name="street-type" required>

              <label for="suburb">Suburb</label>
              <input type="text" placeholder="Enter Suburb" name="suburb" required>

              <label for="state">State</label>
              <input type="text" placeholder="Enter State" name="state" required>

              <label for="postcode">Postcode</label>
              <input type="text" placeholder="<%=postcodeErr != null ? postcodeErr : "Enter Postcode"%>" name="postcode" required>

              <label for="Country">Country</label>
              <input type="text" placeholder="Enter Country" name="country" required>
                
              <p>By creating an account you agree to our&nbsp;<a href="#">Terms & Privacy</a></p>
              <button type="submit" class="btn-create">Create Account</button>
              <div class="placeholder"></div>
              <p class="already-have-account">Already have an account?&nbsp;<a href="login.jsp">Login</a></p>
            </form>
        </div>
    
</html>