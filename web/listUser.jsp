<%-- 
    Document   : listUser
    Created on : 14/05/2021, 6:51:23 PM
    Author     : Kevin
--%>

<%@page import="java.util.List"%>
<%@page import="iotbay.g15.model.User"%>
<%@page import="iotbay.g15.model.dao.UserManagementDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
        UserManagementDAO manager = (UserManagementDAO) session.getAttribute("userManager"); 
        List<User> userData = manager.getUsers(); 
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Users</title>
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link href="/css/style.css" rel="stylesheet">
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
            <a href="admin.jsp" class="btn btn-secondary my-4">Go Back</a>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">User ID</th>
                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Email Address</th>
                        <th scope="col">Password</th>
                        <th scope="col">Phone Number</th>
                        <th scope="col">Street Number</th>
                        <th scope="col">Street Type</th>
                        <th scope="col">Street Name</th>
                        <th scope="col">Suburb</th>
                        <th scope="col">State</th>
                        <th scope="col">Postcode</th>
                        <th scope="col">Country</th>
                        <th scope="col">More</th>

                    </tr>
                </thead>
                <tbody>
                    <%for (User U : userData) {%>
                    <tr>
                        <td><%=U.getUserID()%></td>
                        <td><%=U.getFirstName()%></td>
                        <td><%=U.getLastName()%></td>
                        <td><%=U.getEmail()%></td>
                        <td><%=U.getPassword()%></td>
                        <td><%=U.getPhoneNumber()%></td>
                        <td><%=U.getStreetNumber()%></td>
                        <td><%=U.getStreetName()%></td>
                        <td><%=U.getStreetType()%></td>
                        <td><%=U.getSuburb()%></td>
                        <td><%=U.getState()%></td>
                        <td><%=U.getPostcode()%></td>
                        <td><%=U.getCountry()%></td>
                        <td>
                            <a class="btn btn-success" href="updateUser.jsp?id=<%=U.getUserID()%>">Update</a>
                            <a class="btn btn-danger" href="deleteUser.jsp?id=<%=U.getUserID()%>">Delete</a>
                            <a class="btn btn-info" href="upgradeUser.jsp?id=<%=U.getUserID()%>">Upgrade</a>
                            <a class="btn btn-primary" href="upgradeCustomer.jsp?id=<%=U.getUserID()%>">Manage Customer</a>
                            
                        </td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
            <% if (userData.size() == 0) { %>
            <div>No users found.</div>
            <%}%>
        </div>

    </body>
    <footer>
        <p>Copyright Not Group 14 2021</p>
    </footer>
</html>

