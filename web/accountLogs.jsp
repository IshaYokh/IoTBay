<%-- 
    Document   : AccountLogs
    Created on : 10/05/2021, 12:42:21 AM
    Author     : kaushikdeshpande
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="iotbay.g15.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
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
                <a href="ViewCategoriesServlet"><li>Store</li></a>
                <a href="#"><li>About</li></a>
                <a href="#"><li>Contact</li></a>
                        <%
                            User user = (User) session.getAttribute("user");
                            String accountName = user.getFirstName();
                        %>
                <a href="main.jsp"><li class="login">My Account</li></a>
            </ul>
        </div>
        <%
            ArrayList logs = (ArrayList) session.getAttribute("logs");
            ArrayList tlogs = (ArrayList) session.getAttribute("tlogs");
        %>
        <div class="table-wrapper-scroll-y my-custom-scrollbar">
            <table class="table table-bordered table-striped mb-0 log-table">
                <thead>
                    <tr>
                        <th>Action</th>
                        <th> Date and Time </th>

                    </tr>
                </thead>
                <tbody>
                    <%
                        for (int i = 0; i < logs.size(); i++) {
                    %>
                    <tr>
                        <td><%= logs.get(i)%></td>
                        <td> <%= tlogs.get(i)%></td>

                    </tr>
                    <%
                        }
                    %>
            </table>
        </div>
    </body>
</html>
