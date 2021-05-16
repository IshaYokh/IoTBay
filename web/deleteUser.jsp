<%-- 
    Document   : deleteUser
    Created on : 14/05/2021, 7:05:35 PM
    Author     : Kevin
--%>

<%@page import="iotbay.g15.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%   
    String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete User</title>
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
                <a href="LogoutServlet"><li class="login">Logout</li></a>
                <a href="admin.jsp"><li class="login">Admin Portal</li></a>
            </ul>
        </div> 
        <div class="placeholder"></div>

        <div class="container">
            <div class="card p-4">
                <h2>Please confirm</h2>
                <p>Are you sure you want to delete this user</p>

                <form method="POST" action="DeleteUserServlet?id=<%=id%>" class="d-flex">
                    <button type="submit" class="btn btn-danger mx-2">Delete</button>
                    <a class="btn btn-info mx-2" href="listUser.jsp">Cancel</a>  
                </form>

            </div>

        </div>
    </body>
</html>

