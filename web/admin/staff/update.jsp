<%@page import="iotbay.g15.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String id = (String) session.getAttribute("updateUserId");
    User updateUser = (User) session.getAttribute("updateUser");
    System.out.println(updateUser.getUserID());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link href="../../css/style.css" rel="stylesheet">
        <title>Update User</title>
    </head>
    <body>
        <div class="navbar">
            <div class="logo"><img src="../../assets/logo.png"/></div>
            <ul>
                <a href="#"><li>Home</li></a>
                <a href="#"><li>Store</li></a>
                <a href="#"><li>About</li></a>
                <a href="#"><li>Contact</li></a>
                        <%
                            String msg = "Sign up / Login";
                            String path = "login.jsp";
                            User user = (User) session.getAttribute("user");

                            if (user != null) {
                                msg = "My Account";
                                path = "main.jsp";
                            }
                        %>
                <a href="<%= path%>"><li class="login"><%= msg%></li></a>
            </ul>
        </div>

        <div class="placeholder"></div>

        <div class="container">
            <a href="/admin/hub" class="btn btn-secondary my-4">Go Back</a>
            <form method="post" action="/admin/user/update?id=<%=id%>">

                <div class="d-flex">
                    <div class="mb-1 mx-2 w-100">
                        <label for="FIRSTNAME" class="form-label">First Name</label>
                        <input name="firstName" value="<%= updateUser.getFirstName()%>" type="text" class="form-control" id="FIRSTNAME" max="50">
                    </div>
                    <div class="mb-1 mx-2 w-100">
                        <label for="LASTNAME" class="form-label">Last Name</label>
                        <input name="lastName" value="<%= updateUser.getLastName()%>" type="text" class="form-control" id="LASTNAME" max="50">
                    </div> 
                </div>

                <div class="d-flex">
                    <div class="mb-1 mx-2 w-100">
                        <label for="EMAIL" class="form-label">Email Address</label>
                        <input name="email" type="text" value="<%= updateUser.getEmail()%>" class="form-control" id="EMAIL" max="50">
                    </div>
                    <div class="mb-1 mx-2 w-100">
                        <label for="PHONENUMBER" class="form-label">Phone Number</label>
                        <input name="phoneNumber" value="<%= updateUser.getPhoneNumber()%>" type="text" class="form-control" id="PHONENUMBER">
                    </div>

                </div>
                <div class="mb-3 mx-2 w-100">
                    <label for="PASSWORD" class="form-label">Password</label>
                    <input name="password" type="text" value="<%= updateUser.getPassword()%>" class="form-control" id="PASSWORD" max="20">
                </div> 

                <div class="d-flex">
                    <div class="mb-1 mx-2 w-100">
                        <label for="STREETNUMBER" class="form-label">Street Number</label>
                        <input value="<%= updateUser.getStreetNumber()%>" name="streetNumber" type="text" class="form-control" id="STREETNUMBER">
                    </div>
                    <div class="mb-1 mx-2 w-100">
                        <label for="STREETNAME" class="form-label">Street Name</label>
                        <input value="<%= updateUser.getStreetName()%>" name="streetName" type="text" class="form-control" id="STREETNAME" max="50">
                    </div>
                    <div class="mb-1 mx-2 w-100">
                        <label for="STREETTYPE" class="form-label">Street Type</label>
                        <input value="<%= updateUser.getStreetType()%>" name="streetType" type="text" class="form-control" id="STREETTYPE" max="12">
                    </div>
                </div>



                <div class="d-flex">
                    <div class="mb-1 mx-2 w-100">
                        <label for="SUBURB" class="form-label">Suburb</label>
                        <input value="<%= updateUser.getSuburb()%>" name="suburb" type="text" class="form-control" id="SUBURB" max="50">
                    </div>
                    <div class="mb-1 mx-2 w-100">
                        <label for="STATE" class="form-label">State</label>
                        <input value="<%= updateUser.getState()%>" name="state" type="text" class="form-control" id="STATE" max="3">
                    </div>
                </div>

                <div class="d-flex">

                    <div class="mb-1 mx-2 w-100">
                        <label for="POSTCODE" class="form-label">Postcode</label>
                        <input name="postcode" value="<%= updateUser.getPostcode()%>"  type="text" class="form-control" id="POSTCODE" max="3">
                    </div>  
                    <div class="mb-1 mx-2 w-100">
                        <label for="COUNTRY" class="form-label">Country</label>
                        <input name="country"  value="<%= updateUser.getCountry()%>" type="text" class="form-control" id="COUNTRY" max="50">
                    </div>    
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-success">Update User</button>
                </div>

            </form>

        </div>

    </body>
</html>
