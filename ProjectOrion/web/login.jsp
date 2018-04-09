<%-- 
    Document   : index
    Created on : Mar 8, 2018, 10:09:34 AM
    Author     : Orion
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/WEB-INF/head.jsp">
        <jsp:param name="title" value="Login Page"/>
    </jsp:include>
    <body>
        <div id="site">
            <div id="primary">
                <h1>My Account</h1>
                <div class="form" >
                    <h2>Login</h2>
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

                        <label>Username:<span class="required">*</span></label>
                        <br/>
                        <input id="username" type="text" name="txtUsername" />
                        <%--${requestScope.validator.usernameErr}--%>
                        <br/>
                        <label>Password:<span class="required">*</span></label>
                        <br/>
                        <input id="password" type="password" name="txtPassword" />
                        <%--${requestScope.validator.passwordErr}--%>
                        <br/>
                        <input type="submit" onclick="return validateLogin()" name="action" value="Login"/>
                        <input type="reset" value="Reset"/>
                        <br/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>