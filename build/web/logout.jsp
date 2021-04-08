<%-- 
    Document   : logout
    Created on : 09/04/2021, 2:50:09 AM
    Author     : Isha Yokhanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%
            session.invalidate(); 
            response.sendRedirect("index.jsp");
        %>
    </body>
</html>
