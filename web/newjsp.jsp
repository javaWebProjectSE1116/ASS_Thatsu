<%-- 
    Document   : newjsp
    Created on : Oct 16, 2017, 12:54:31 PM
    Author     : ThangViet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String a  = request.getParameter("check");
            String username =(String)request.getSession().getAttribute("username");
            response.getWriter().print(""+ a);
            response.getWriter().print("<br/>");
            response.getWriter().print("Hello "+ username);
        %>
        <h1></h1>
    </body>
</html>
