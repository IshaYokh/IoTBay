<%-- 
    Document   : customerinfo
    Created on : Apr 24, 2021, 8:28:13 PM
    Author     : Tada33
--%>

<%@ page import="iotbay.g15.model.*, iotbay.g15.model.dao.*, java.util.HashMap" %>
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
        <%
            CustomerDAO cd = (CustomerDAO)session.getAttribute("manager");
            HashMap<Integer, Customer> customers = cd.fetchCustomer();
            
//            session.setAttribute("customerEdit", 0);
//            if (request.getParameter("editCustomer") != null) {
//                session.setAttribute("customerEdit", request.getParameter("editCustomer"));
//            }
            
//            if (request.getParameter("deleteCustomer") != null) {
//                st.executeUpdate("DELETE FROM Customer WHERE id = " + request.getParameter("deleteCustomer"));
//            }
        %>
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
            <table class="tbl1">
                <caption class="welcome_title">Customer Information</caption>
                <input type="search" name="search" placeholder="key word">
                <input type="submit" name="submit" value="search">
                <button href="createnewcustomer.jsp" type="submit" class="btn1">Create New Customer</button>
                <%--<a href="createnewcustomer.jsp" class="btn1"><li>Create New Customer</a> --%>       
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
                </tr>
                <c:forEach items="<%=customers%>" var="item">
                    <tr class="last">
                        <c:choose>
                            <c:when test="1 eq 0">
                                
                            </c:when>
                            <c:otherwise>
                                <td><p>${item.value.getFirstName()}</p></td>
                                <td><p>${item.value.getLastName()}</p></td>
                                <td><p>${item.value.getEmail()}</p></td>
                                <td><p>${item.value.getPhoneNumber()}</p></td>
                                <td><p>${item.value.getStreetNumber()}</p></td>
                                <td><p>${item.value.getStreetName()}</p></td>
                                <td><p>${item.value.getStreetType()}</p></td>
                                <td><p>${item.value.getSuburb()}</p></td>
                                <td><p>${item.value.getState()}</p></td>
                                <td><p>${item.value.getPostcode()}</p></td>
                                <td><p>${item.value.getCountry()}</p></td>
                                <td><p>${item.value.getStatus()}</p></td>
                                <td>
                                    <form onsubmit="setTimeout(function () {window.location.reload();}, 3)">
                                        <input type="submit" value="edit">
                                        <input type="hidden" name="editCustomer" value="${item.key}">
                                    </form>
                                </td>
                                <td>
                                    <form action="DeleteServlet" method="post">
                                        <input type="hidden" name="email" value="${item.value.getEmail()}">
                                        <button>delete</button>
                                    </form>
                                </td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
