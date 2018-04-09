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
        <jsp:param name="title" value="Account"/>
    </jsp:include>
    <body>
        <div id="site">
            <jsp:include page="WEB-INF/user-topnav.jsp"/>
            <div id="primary">
                <h1>My Account</h1>
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
                    <c:forEach items="${requestScope.INFO}" var="dto">
                        <form action="MainController" method="POST">
                            <input type="hidden" name="action" value="Update Account"/>
                            <label>Username:<span class="required">*</span></label>
                            <br/>
                            <input id="username" type="text" name="txtUsername" value="${dto.username}" readonly="readonly" class="readonly"/>
                            <br/>
                            <label>Password:<span class="required">*</span></label>
                            <br/>
                            <input id="password" type="password" name="txtPassword" value="${dto.password}"/>
                            <br/>
                            <label>Confirm Password:<span class="required">*</span></label>
                            <br/>
                            <input id="confirm_password" type="password" name="txtConfirm" value="${dto.password}"/>
                            <br/>
                            <label>Email:<span class="required">*</span></label>
                            <br/>
                            <input id="email" type="text" name="txtEmail" value="${dto.email}"/>
                            <br/>
                            <label>Phone:<span class="required">*</span></label>
                            <br/>
                            <input id="phone" type="text" name="txtPhone" value="${dto.phone}"/>
                            <br/>
                            <input type="submit" onclick="return validateRegister()" value="Update"/>
                            <input type="reset" value="Reset"/>
                            <br/>
                        </form>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>
