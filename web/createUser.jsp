<%-- 
    Document   : createUser
    Created on : 14/05/2021, 6:36:09 PM
    Author     : Kevin
--%>

<%@page import="iotbay.g15.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  // validation 
    String firstNameError = (String)session.getAttribute("firstNameError");
    String lastNameError = (String)session.getAttribute("lastNameError");
    String emailError = (String)session.getAttribute("emailError");
    String phoneError = (String)session.getAttribute("phoneError");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet">
        <title>Create User</title>
    </head>
    <body>
        <div class="navbar">
            <div class="logo"><img src="assets/logo.png"/></div>
            <ul>
                <a href="#"><li>Home</li></a>
                <a href="#"><li>Store</li></a>
                <a href="#"><li>About</li></a>
                <a href="#"><li>Contact</li></a>
                <a href="LogoutServlet"><li class="login">Logout</li></a>
                <a href="admin.jsp"><li class="login">Admin Portal</li></a>
            </ul>
        </div>

        <div class="placeholder"></div>

        <div class="container">
            <a href="admin.jsp" class="btn btn-secondary my-4">Go Back</a

            <!--Form to create a user, connected to CreateUserServlet-->

            <form method="POST" action="CreateUserServlet">

                <div class="d-flex">
                    <div class="mb-1 mx-2 w-100">

                        <p class="already-have-account"><%=(firstNameError != null ? firstNameError : " ")%></p>

                        <label for="FIRSTNAME" class="form-label">First Name</label>
                        <input name="firstName" type="text" class="form-control" id="FIRSTNAME" max="50">
                    </div>
                    <div class="mb-1 mx-2 w-100">

                        <p class="already-have-account"><%=(lastNameError != null ? lastNameError : " ")%></p>

                        <label for="LASTNAME" class="form-label">Last Name</label>
                        <input name="lastName" type="text" class="form-control" id="LASTNAME" max="50">
                    </div>
                </div>

                <div class="d-flex">
                    <div class="mb-1 mx-2 w-100">
                        
                        <p class="already-have-account"><%=(emailError != null ? emailError : "")%> </p>
                        
                        <label for="EMAIL" class="form-label">Email Address</label>
                        <input name="email" type="text" class="form-control" id="EMAIL" max="50">
                    </div>
                    <div class="mb-1 mx-2 w-100">
                        
                        <p class="already-have-account"><%=(phoneError != null ? phoneError : "")%> </p>
                        
                        <label for="PHONENUMBER" class="form-label">Phone Number</label>
                        <input name="phoneNumber" type="text" class="form-control" id="PHONENUMBER">
                    </div>

                </div>
                <div class="mb-3 mx-2 w-100">
                    <label for="PASSWORD" class="form-label">Password</label>
                    <input name="password" type="text" class="form-control" id="PASSWORD" max="20">
                </div> 



                <div class="d-flex">
                    <div class="mb-1 mx-2 w-100">
                        <label for="STREETNUMBER" class="form-label">Street Number</label>
                        <input name="streetNumber" type="text" class="form-control" id="STREETNUMBER">
                    </div>
                    <div class="mb-1 mx-2 w-100">
                        <label for="STREETNAME" class="form-label">Street Name</label>
                        <input name="streetName" type="text" class="form-control" id="STREETNAME" max="50">
                    </div>
                    <div class="mb-1 mx-2 w-100">
                        <label for="STREETTYPE" class="form-label">Street Type</label>
                        <input name="streetType" type="text" class="form-control" id="STREETTYPE" max="12">
                    </div>
                </div>

                <div class="d-flex">
                    <div class="mb-1 mx-2 w-100">
                        <label for="SUBURB" class="form-label">Suburb</label>
                        <input name="suburb" type="text" class="form-control" id="SUBURB" max="50">
                    </div>
                    <div class="mb-1 mx-2 w-100">
                        <label for="STATE" class="form-label">State</label>
                        <input name="state" type="text" class="form-control" id="STATE" max="3">
                    </div>
                </div>

                <div class="d-flex">

                    <div class="mb-1 mx-2 w-100">
                        <label for="POSTCODE" class="form-label">Postcode</label>
                        <input name="postcode" type="text" class="form-control" id="POSTCODE" max="3">
                    </div>
                    <div class="mb-1 mx-2 w-100">
                        <label for="COUNTRY" class="form-label">Country</label>
                        <input name="country" type="text" class="form-control" id="COUNTRY" max="50">
                    </div>    
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-success">Create User</button>
                </div>

            </form>

        </div>

    </body>
</html>
