<%-- 
    Document   : admin
    Created on : 14/05/2021, 7:08:12 PM
    Author     : Kevin
--%>

<%@page import="iotbay.g15.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap" rel="stylesheet">
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>

        <div class="navbar">
            <div class="logo"><img src="assets/logo.png"/></div>
                <ul>
                    <a href="#"><li>Home</li></a>
                    <a href="#"><li>Store</li></a>
                    <a href="#"><li>About</li></a>
                    <a href="#"><li>Contact</li></a>
                    <% 
                        String msg = "Sign up / Login";
                        String path = "login.jsp";
                        User user = (User)session.getAttribute("user");
                        
                        if(user != null){
                            msg = "My Account";
                            path = "main.jsp";
                        }
                    %>
                    <a href="<%= path%>"><li class="login"><%= msg%></li></a>
		</ul>
	</div>
        <div class="placeholder"></div>
        <div class="placeholder"></div>

        <div class="d-flex align-items-center">
            <div class="card mx-4" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Users</h5>
                    <p class="card-text">Primary users of IoTBay</p>
                    <a href="createUser.jsp" class="btn btn-primary m-2">Create</a>
                    <a href="listUser.jsp" class="btn btn-light m-2">See all</a>
                </div>
            </div>
            <div class="card mx-4" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Customer</h5>
                    <p class="card-text">Customers of IoTBay</p>
                    <a href="#" class="btn btn-primary  m-2">Austin Create Item</a>
                </div>
            </div> 
        </div>
    </body>
</html>

