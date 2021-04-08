<%-- 
    Document   : Login
    Created on : 08/04/2021, 2:34:40 AM
    Author     : Isha Yokhanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap" rel="stylesheet">
        <title>Login</title>
    </head>
    <body>
        <div class="navbar">
            <div class="logo"><img src="assets/logo.png" /></div>
            <ul>
                <a href="index.jsp">
                    <li>Home</li>
                </a>
                <a href="#">
                    <li>Store</li>
                </a>
                <a href="#">
                    <li>About</li>
                </a>
                <a href="#">
                    <li>Contact</li>
                </a>
                <a href="#">
                    <li class="login">Sign up / Login</li>
                </a>
            </ul>
        </div>
        
        <div class="placeholder"></div>
    
        
        <div class="form-popup" id="loginForm">
            <form action="welcome.jsp" method="post" class="form-container-login">
                <h1>Login</h1>
                
                <label for="email"><b>Email</b></label>
                <input type="text" placeholder="Enter Email" name="email" required>

                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" required>
                <button type="submit" class="btn login">Login</button>
                <p>Need an account? <a href="register.jsp">&nbsp;Sign Up</a></p>
                <p>Forgot your password? <a href="#">&nbsp;Reset password</a></p>
            </form>
        </div>
        <footer>
            <p>Copyright Not Group 14 2021</p>
        </footer>
    </body>
</html>
