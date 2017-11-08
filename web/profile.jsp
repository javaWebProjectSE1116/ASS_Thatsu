<%-- 
    Document   : profile
    Created on : Oct 30, 2017, 8:45:43 PM
    Author     : ThangViet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        <h1>Hello ${sessionScope.account.name}</h1>
        <h4>Image: <img src="getImage?id=${sessionScope.account.username}" width="100" height="100" /></h4>
        </br>
        <h4>Description: ${sessionScope.account.description}</h4>
        </br>
        <h4>Username: ${sessionScope.account.username}</h4>
        <h4>Sex: ${sessionScope.account.sex}</h4>
        <h4>Email: ${sessionScope.account.email}</h4>
        <h4>Phone Number: ${sessionScope.account.phoneNumber}</h4>
        <h4>BirthDay: ${sessionScope.account.date}</h4>
        <button onclick="window.location.href = '#'">Edit</button>
    </body>
</html>
