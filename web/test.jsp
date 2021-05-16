<%-- 
    Document   : test
    Created on : 16/05/2021, 4:45:36 AM
    Author     : Isha Yokhanna
--%>

<%@page import="iotbay.g15.model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            Order order = new Order(1, 1, "2021-03-14", "Pending");
            session.setAttribute("cartPrice", "80.00");
            session.setAttribute("order", order);

        %>
        
        <a href="checkout.jsp"><button>Click me</button></a>
        <h1>Hello World!</h1>
    </body>
</html>
