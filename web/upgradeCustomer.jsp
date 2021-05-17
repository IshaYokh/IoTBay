<%-- 
    Document   : upgradeCustomer
    Created on : 14/05/2021, 8:17:14 PM
    Author     : Kevin
--%>

<%@page import="iotbay.g15.model.CustomerUser"%>
<%@page import="iotbay.g15.model.Customer"%>
<%@page import="iotbay.g15.model.User"%>
<%@page import="iotbay.g15.model.dao.UserManagementDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // search that user by id
    String id = request.getParameter("id");
    UserManagementDAO manager = (UserManagementDAO) session.getAttribute("userManager");  
    User upgradeUser = manager.getUserById(Integer.parseInt(id));
    CustomerUser upgradeCustomer = manager.getCustomer(upgradeUser.getUserID());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/styleBootstrap.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet">
        <title>Upgrade Customer</title>
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
                            String msg = "Sign up / Login";
                            String path = "login.jsp";
                            User user = (User) session.getAttribute("user");

                            if (user != null) {
                                msg = "My Account";
                                path = "main.jsp";
                            }
                        %>
                <a href="LogoutServlet"><li class="login">Logout</li></a>
                <a href="admin.jsp"><li class="login">Admin Portal</li></a>
            </ul>
        </div>

        <div class="placeholder"></div>

        <div class="container">
            <a href="listUser.jsp" class="btn btn-secondary my-4">Go Back</a>
            
            <!--Upgrade specific customer by checking assigned ID, connected to UpgradeCustomerServlet-->
            <form method="post" action="UpgradeCustomerServlet?id=<%=id%>">

                <div class="d-flex">
                    <div class="mb-1 mx-2 w-100">
                        <label for="LOYALTYPOINTS" class="form-label">Set Loyalty Points</label>
                        <% if (upgradeCustomer == null) { %>
                        
                        <input name="loyaltyPoints" value="" type="text" class="form-control" id="LOYALTYPOINTS" max="50">
                        <% } else { %>

                        <input name="loyaltyPoints" value="<%=upgradeCustomer.getLoyaltyPoints()%>" type="text" class="form-control" id="LOYALTYPOINTS" max="50">
                        <%}%>

                    </div>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-success">Upgrade Customer</button>
                </div>

            </form>

        </div>
