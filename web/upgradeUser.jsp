<%-- 
    Document   : upgradeUser
    Created on : 14/05/2021, 7:22:32 PM
    Author     : Kevin
--%>

<%@page import="iotbay.g15.model.Staff"%>
<%@page import="iotbay.g15.model.dao.UserManagementDAO"%>
<%@page import="iotbay.g15.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
    UserManagementDAO manager = (UserManagementDAO) session.getAttribute("userManager");
    // search that user by id
    User upgradeUser = manager.getUserById(Integer.parseInt(id));
    Staff upgradeStaff = manager.getStaff(upgradeUser.getUserID());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link href="/css/style.css" rel="stylesheet">
        <title>Upgrade User</title>
    </head>
    <body>
        <div class="navbar">
            <div class="logo"><img src="/assets/logo.png"/></div>
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
            <a href="listUser.jsp" class="btn btn-secondary my-4">Go Back</a>
            <form method="post" action="UpgradeUserServlet?id=<%=id%>">

                <div class="d-flex">
                    <div class="mb-1 mx-2 w-100">
                        <label for="STAFFACCESSLEVEL" class="form-label">Staff Access Level</label>
                        <% if (upgradeStaff == null) { %>
                        
                        <input name="staffAccessLevel" value="" type="text" class="form-control" id="STAFFACCESSLEVEL" max="50">
                        <% } else { %>

                        <input name="staffAccessLevel" value="<%=upgradeStaff.getSiteAccessLevel()%>" type="text" class="form-control" id="STAFFACCESSLEVEL" max="50">
                        <%}%>

                    </div>
                    <div class="mb-1 mx-2 w-100">
                        <label for="DOB" class="form-label">Date of Birth</label>
                        
                        
                        <% if (upgradeStaff == null) { %>
                        
                        <input name="dob" value="" type="text" class="form-control" id="DOB" max="50">
                        <% } else { %>

                        <input name="dob" value="<%=upgradeStaff.getDOB()%>" type="text" class="form-control" id="DOB" max="50">
                        <%}%>
                    </div> 
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-success">Upgrade User</button>
                </div>

            </form>

        </div>

    </body>
</html>