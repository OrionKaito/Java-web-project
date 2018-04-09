<%-- 
    Document   : manageuser
    Created on : Mar 17, 2018, 10:38:49 AM
    Author     : Orion
--%>

<%@page import="sample.dto.CartObj"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/WEB-INF/head.jsp">
        <jsp:param name="title" value="Manage Tour"/>
    </jsp:include>
    <body>
        <div id="site">
            <jsp:include page="WEB-INF/user-topnav.jsp"/>
            <c:if test="${sessionScope.USERNAME != null}">
                <c:if test="${not empty sessionScope.USERNAME}" var="check" scope="page">
                    <h1>${sessionScope.USERNAME}'s cart</h1>
                </c:if>
                <c:if test="${check == false}">
                    <h1>Guess's cart</h1>
                </c:if>
            </c:if> 
            <div id="result">
                <c:if test="${requestScope.INFO != null}">
                    <c:if test="${not empty requestScope.INFO}" var="check" scope="page">
                        <table class="table-result">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.INFO}" var="dto" >
                                    <tr>
                                        <td>${dto.id}</td>
                                        <td>${dto.tourname}</td>
                                        <td>${dto.price}</td>
                                        <td>${dto.quantity +1}</td>
                                        <td>
                                            <c:url value="MainController" var="delete">
                                                <c:param name="action" value="Delete cart"/>
                                                <c:param name="txtID" value="${dto.id}"/>
                                            </c:url>
                                            <a href="${delete}">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            <c:if test="${check == false}">
                            <p class="alert notfound">You not shopping yet</p>
                        </c:if>
                    </c:if> 
                    </tbody>
                </table>
            </div>
        </div>
    </body> 
</html>