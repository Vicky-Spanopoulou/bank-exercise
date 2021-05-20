<%-- 
    Document   : secure
    Created on : 20 Μαϊ 2021, 8:34:59 μμ
    Author     : John
--%>

<%@page import="models.dto.UserData"%>
<%@page import="models.dto.UserData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <% 
            //Username: <%= request.getAttribute("user")
            
            UserData userData = new UserData();
            userData = (UserData) request.getAttribute("user"); 
            out.println("<p>Password: "+userData.getPassword()+ "</p>");
        %>    
                
    </body>
</html>
