<%-- 
    Document   : manageuser
    Created on : Mar 17, 2018, 10:38:49 AM
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
        <jsp:param name="title" value="Manage Tour"/>
    </jsp:include>
    <body>
        <div id="site">
            <jsp:include page="WEB-INF/admin-topnav.jsp"/>
            <div id="primary">
                <h1>Manage Tour</h1>
                <div class="form" style="width: 400px">
                    <form action="MainController" method="POST">
                        <input type="hidden" name="action" value="Search Tour"/>
                        <label>Search:<span class="required">*</span></label>
                        <input id="search" type="text" name="txtSearch" placeholder="Tour id" value="${requestScope.lastSearch}"/>
                        <input type="submit" onclick="return validateSearch()" value="Search"/>
                    </form>
                    <p id="alert-error" class=""></p>
                </div>
                <div class="form" style="width: 100px">
                    <form action="MainController" method="POST">
                        <input type="hidden" name="action" value="Search Tour"/>
                        <input type="hidden" name="txtSearch" value=""/>
                        <input type="submit" value="Get All Tour"/>
                    </form>
                </div>
                <div class="form">
                    <c:if test="${requestScope.ERROR != null}" var="check" scope="page">
                        <p id="alert-error" class="alert error">${requestScope.ERROR}</p>
                    </c:if>
                    <c:if test="${check == false}">
                        <c:if test="${not empty requestScope.ActionDone}">
                            <p id="alert-error" class="alert success">${requestScope.ActionDone}</p>
                        </c:if>
                    </c:if>
                    <p id="alert-error" class=""></p>
                </div>
            </div>
            <div id="result">
                <c:if test="${requestScope.INFO != null}">
                    <c:if test="${not empty requestScope.INFO}" var="check" scope="page">
                        <table class="table-result">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Price</th>
                                        <%--<th>Description</th>--%>
                                    <th>Start</th>
                                    <th>Arrival</th>
                                    <th>Max Customer</th>
                                    <th>Date</th>
                                    <th>Image</th>'
                                    <th>Delete</th>
                                    <th>Update</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="dto" items="${requestScope.INFO}" varStatus="counter">
                                    <tr>
                                        <td>${dto.id}</td>
                                        <td>${dto.tourname}</td>
                                        <td>${dto.price}</td>
                                        <%--<td>${dto.description}</td>--%>
                                        <td>${dto.start}</td>
                                        <td>${dto.arrival}</td>
                                        <td>${dto.maxCustomer}</td>
                                        <td>${dto.date}</td>
                                        <td><img src="images/${dto.filename}" width="40px" height="40px"/></td>
                                        <td>
                                            <c:url value="MainController" var="delete">
                                                <c:param name="action" value="Delete Tour"/>
                                                <c:param name="txtID" value="${dto.id}"/>
                                                <c:param name="txtSearch" value="${requestScope.lastSearch}"/>
                                            </c:url>
                                            <a href="${delete}">Delete</a>
                                        </td>
                                        <td>
                                            <c:url value="MainController" var="Edit">
                                                <c:param name="action" value="Edit Tour"/>
                                                <c:param name="txtID" value="${dto.id}"/>
                                                <c:param name="txtSearch" value="${requestScope.lastSearch}"/>
                                            </c:url>
                                            <a href="${Edit}">Edit</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div class="pagination">
                            <c:forEach begin="1" end="${requestScope.noOfPages}" varStatus="i">
                                <c:url value="MainController" var="ManageTour">
                                    <c:param name="action" value="Search Tour"/>
                                    <c:param name="page" value="${i.index}"/>
                                    <c:param name="txtSearch" value="${requestScope.lastSearch}"/>
                                </c:url>
                                <c:if test="${i.index == page}" var="paging" scope="page">
                                    <a href="${ManageTour}" class="active">${i.index}</a>
                                </c:if>
                                <c:if test="${paging ==false}">
                                    <a href="${ManageTour}" class="">${i.index}</a>
                                </c:if>
                            </c:forEach>
                        </div>
                    </c:if>
                    <c:if test="${check == false}">
                        <p class="alert notfound">No record found</p>
                    </c:if>
                </c:if>
            </div>
        </div>
    </body> 
</html>