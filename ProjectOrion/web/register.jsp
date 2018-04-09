<%-- 
    Document   : Register
    Created on : Mar 10, 2018, 5:16:15 PM
    Author     : Orion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/WEB-INF/head.jsp">
        <jsp:param name="title" value="Register"/>
    </jsp:include>
    <body>
        <div id="site">
            <div id="primary">
                <h1>Register</h1>
                <div class="form">
                    <c:if test="${requestScope.ERROR != null}" var="check" scope="page">
                        <p id="alert-error" class="alert error">${requestScope.ERROR}</p>
                    </c:if>
                    <p id="alert-error" class=""></p>
                    <form action="MainController" method="POST">
                        <label>Username:<span class="required">*</span></label>
                        <br/>
                        <input id="username" type="text" name="txtUsername"/>
                        <br/>
                        <label>Password:<span class="required">*</span></label>
                        <br/>
                        <input id="password" type="password" name="txtPassword"/>
                        <br/>
                        <label>Confirm Password:<span class="required">*</span></label>
                        <br/>
                        <input id="confirm_password" type="password" name="txtConfirm" />
                        <br/>
                        <label>Email:<span class="required">*</span></label>
                        <br/>
                        <input id="email" type="text" name="txtEmail"/>
                        <br/>
                        <label>Phone:<span class="required">*</span></label>
                        <br/>
                        <input id="phone" type="text" name="txtPhone"/>
                        <br/>
                        <input type="submit" onclick="return validateRegister()" name="action" value="Register"/>
                        <input type="reset" value="Reset"/>
                        <br/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
