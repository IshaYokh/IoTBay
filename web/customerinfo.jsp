<%-- 
    Document   : customerinfo
    Created on : Apr 24, 2021, 8:28:13 PM
    Author     : Tada33
--%>

<%@ page import="java.sql.*, java.util.HashMap, java.util.List, java.util.ArrayList" %>
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
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/IoTBayDB", "ISD", "admin");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Customer");
            List<HashMap<String, String>> customerList = new ArrayList<HashMap<String, String>>();
            while (rs.next()) {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put("id", rs.getString("id"));
                row.put("firstName", rs.getString("firstName"));
                row.put("lastName", rs.getString("lastName"));
                row.put("email", rs.getString("email"));
                row.put("password", rs.getString("password"));
                row.put("phoneNumber", rs.getString("phoneNumber"));
                row.put("streetNumber", rs.getString("streetNumber"));
                row.put("streetName", rs.getString("streetName"));
                row.put("streetType", rs.getString("streetType"));
                row.put("suburb", rs.getString("suburb"));
                row.put("state", rs.getString("state"));
                row.put("postcode", rs.getString("postcode"));
                row.put("country", rs.getString("country"));
                customerList.add(row);
            }
            request.setAttribute("customerList", customerList);
            request.getRequestDispatcher("customerinfo.jsp");
            
            if (request.getParameter("deleteCustomer") != null) {
                System.out.println("asdf");
                System.out.println(request.getParameter("deleteCustomer"));
                st.executeUpdate("DELETE FROM Customer WHERE id = " + request.getParameter("deleteCustomer"));
            }
            
            conn.close();
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
        <div>
            <table border="2" width="100%">
                <caption>Customer Information</caption>
                <tr>
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
                </tr>
                <c:forEach items="${customerList}" var="item">
                    <tr>
                        <td>${item["firstName"]}</td>
                        <td>${item["lastName"]}</td>
                        <td>${item["email"]}</td>
                        <td>${item["phoneNumber"]}</td>
                        <td>${item["streetNumber"]}</td>
                        <td>${item["streetName"]}</td>
                        <td>${item["streetType"]}</td>
                        <td>${item["suburb"]}</td>
                        <td>${item["state"]}</td>
                        <td>${item["postcode"]}</td>
                        <td>${item["country"]}</td>
                        <td>
                            <button type="button">edit</button>
                        </td>
                        <td>
                            <form action="" onsubmit="setTimeout(function () {window.location.reload();}, 3)">
                                <input type="submit" value="delete">
                                <input type="hidden" name="deleteCustomer" value="${item['id']}">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
