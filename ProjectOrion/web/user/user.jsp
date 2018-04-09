<%-- 
    Document   : user
    Created on : Mar 4, 2018, 12:55:21 PM
    Author     : Orion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/WEB-INF/head.jsp">
        <jsp:param name="title" value="Manage User"/>
    </jsp:include>
    <body>
        <h1>Hello  ${sessionScope.USERNAME}!</h1>
    </body>
</html>
