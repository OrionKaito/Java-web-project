<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/WEB-INF/head.jsp">
        <jsp:param name="title" value="Admin Page"/>
    </jsp:include>
    <body>
        <div id="site">
            <jsp:include page="WEB-INF/admin-topnav.jsp"/>
            <div id="primary">
                <div class="form">
                    <p>Hello  ${sessionScope.USERNAME}!</p>
                </div>
            </div>
        </div>
    </body>
</html>