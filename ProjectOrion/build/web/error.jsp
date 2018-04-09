<%-- 
    Document   : error
    Created on : Mar 4, 2018, 12:38:28 PM
    Author     : Orion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <p class="alert error">Some error has occur !!! ${requestScope.ERROR}</p>
    </body>
</html>
