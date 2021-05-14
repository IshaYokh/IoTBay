<%-- 
    Document   : customerinfo
    Created on : Apr 24, 2021, 8:28:13 PM
    Author     : Tada33
--%>

<%@ page import="iotbay.g15.model.*, iotbay.g15.model.dao.*, java.util.ArrayList" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <link href="css/style.css" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/49ea9400a6.js" crossorigin="anonymous" type="text/javascript"></script>	
        <title>Customer Information</title>
    </head>
    <body>
        <div class="navbar">
            <div class="logo"><img src="assets/logo.png"/></div>
            <ul>
                <a href="index.jsp"><li>Home</li></a>
                <a href="#"><li>Store</li></a>
                <a href="#"><li>About</li></a>
                <a href="#"><li>Contact</li></a>
                <a href="login.jsp"><li class="login">Sign up / Login</li></a>
            </ul> 
        </div>
        <div class="placeholder"></div>
        <div class="placeholder"></div>
        <div class="placeholder"></div>
        
        <div>
            <form action="register.jsp">
                <input type="hidden" name="source" value="customerinfo">
                <button class="btn1">Create New Customer</button>
            </form>
            <table class="tbl1">
                <caption class="welcome_title">Customer Information</caption>
                <tr class="thead">
                    <td>First Name</td>
                    <td>Last Name</td>
                    <td>Email</td>
                    <td>Phone Number</td>
                    <td>Street Number</td>
                    <td>Street Name</td>
                    <td>Street Type</td>
                    <td>Suburb</td>
                    <td>State</td>
                    <td>Postcode</td>
                    <td>Country</td>
                    <td>Status</td>
                    <td>Edit</td>
                    <td>Delete</td>
                </tr>
                <%
                    CustomerDAO cd = (CustomerDAO)session.getAttribute("manager");
                    ArrayList<Customer> customers = cd.fetchCustomer();
                %>
                <c:forEach items="<%=customers%>" var="item">
                    <tr class="last">
                        <td><p>${item.getFirstName()}</p></td>
                        <td><p>${item.getLastName()}</p></td>
                        <td><p>${item.getEmail()}</p></td>
                        <td><p>${item.getPhoneNumber()}</p></td>
                        <td><p>${item.getStreetNumber()}</p></td>
                        <td><p>${item.getStreetName()}</p></td>
                        <td><p>${item.getStreetType()}</p></td>
                        <td><p>${item.getSuburb()}</p></td>
                        <td><p>${item.getState()}</p></td>
                        <td><p>${item.getPostcode()}</p></td>
                        <td><p>${item.getCountry()}</p></td>
                        <td><p>${item.getStatus()}</p></td>
                        <td>
                            <form action="updatecustomer.jsp">
                                <input type="hidden" name="email" value="${item.getEmail()}">
                                <input type="hidden" name="password" value="${item.getPassword()}">
                                <button>edit</button>
                            </form>
                        </td>
                        <td>
                            <form action="DeleteServlet" method="post">
                                <input type="hidden" name="email" value="${item.getEmail()}">
                                <button>delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
