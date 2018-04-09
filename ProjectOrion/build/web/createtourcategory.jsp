<%-- 
    Document   : createtourcategory.jsp
    Created on : Mar 14, 2018, 11:07:47 PM
    Author     : Orion
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:if test="${sessionScope.ROLE != 'admin'}">
        <jsp:forward page="rolefiltererror.jsp"/>
    </c:if>
    <jsp:include page="/WEB-INF/head.jsp">
        <jsp:param name="title" value="New Category"/>
    </jsp:include>
    <body>
        <div id="site">
            <jsp:include page="WEB-INF/admin-topnav.jsp"/>
            <div id="primary">
                <h1>Create new tour category</h1>
                <div class="form">
                    <c:if test="${requestScope.ERROR != null}" var="check" scope="page">
                        <p id="alert-error" class="alert error">${requestScope.ERROR}</p>
                    </c:if>
                    <c:if test="${check == false}">
                        <c:if test="${not empty requestScope.CREATEDONE}">
                            <p id="alert-error" class="alert success">${requestScope.CREATEDONE}</p>
                        </c:if>
                    </c:if>
                    <p id="alert-error" class=""></p>
                    <form action="MainController" method="POST">
                        <input type="hidden" name="action" value="Create Category"/>
                        <label>ID:<span class="required">*</span></label>
                        <br/>
                        <input id="id" type="text" name="txtTourcategoryID" />
                        <br/>
                        <label>Tour Category name:<span class="required">*</span></label>
                        <br/>
                        <input id="name" type="text" name="txtTourcategoryName" />
                        <br/>
                        <input type="submit" onclick="return validateCreateTourCategory()"value="Create"/>
                        <input type="reset" value="Reset"/>
                    </form>
                </div>
            </div>
        </div>
    </body> 
</html>
