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
        <jsp:param name="title" value="Manage User"/>
    </jsp:include>
    <body>
        <div id="site">
            <jsp:include page="WEB-INF/admin-topnav.jsp"/>
            <div id="primary">
                <h1>Manage User's Account</h1>
                <div class="form" style="width: 400px">
                    <form action="MainController" method="POST">
                        <input type="hidden" name="action" value="Search Username"/>
                        <label>Search:<span class="required">*</span></label>
                        <input id="search" type="text" name="txtSearch" placeholder="User name" value="${requestScope.lastSearch}"/>
                        <input type="submit" onclick="return validateSearch()" value="Search"/>
                    </form>
                    <p id="alert-error" class=""></p>
                </div>
                <div class="form" style="width: 100px">
                    <form action="MainController" method="POST">
                        <input type="hidden" name="action" value="Search Username"/>
                        <input type="hidden" name="txtSearch" value=""/>
                        <input type="submit" value="Get All User"/>
                    </form>
                </div>
                <div class="form">
                    <h1>Manage User's Order</h1>
                    <form action="MainController" method="POST">
                        <input type="hidden" name="action" value="Search Order"/>
                        <label>Search:<span class="required">*</span></label>
                        <input id="search" type="text" name="txtSearch" placeholder="User name"/>
                        <input type="submit" onclick="return validateSearch()" value="Search"/>
                    </form>
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
                                    <th>Username</th>
                                    <th>Role</th>
                                    <th>Email</th>
                                    <th>Phone</th>
                                    <th>Delete</th>
                                        <c:if test="${sessionScope.USERNAME == 'admin'}">
                                        <th>
                                            <div class="tooltip">Promote Or Demote
                                                <span class="tooltiptext">Only Username 'Admin' can see this function</span>
                                            </div></th>
                                        </c:if> 
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="dto" items="${requestScope.INFO}" varStatus="counter">
                                    <tr>
                                        <td>${dto.id}</td>
                                        <td>${dto.username}</td>
                                        <td>${dto.role}</td>
                                        <td>${dto.email}</td>
                                        <td>${dto.phone}</td>
                                        <td>
                                            <c:url value="MainController" var="delete">
                                                <c:param name="action" value="Delete User"/>
                                                <c:param name="txtUsername" value="${dto.username}"/>
                                                <c:param name="txtSearch" value="${requestScope.lastSearch}"/>
                                            </c:url>
                                            <a href="${delete}">Delete</a>
                                        </td>
                                        <c:if test="${sessionScope.USERNAME == 'admin'}">
                                            <td><div class="tooltip">
                                                    <c:url value="MainController" var="prodemote">
                                                        <c:param name="action" value="prodemote"/>
                                                        <c:param name="txtUsername" value="${dto.username}"/>
                                                        <c:param name="txtRole" value="${dto.role}"/>
                                                        <c:param name="txtSearch" value="${requestScope.lastSearch}"/>
                                                    </c:url>
                                                    <a href="${prodemote}">Promote Or Demote</a>
                                                    <span class="tooltiptext">Promote this user to admin or Demote this admin to use</span>
                                                </div>
                                            </td>
                                        </c:if> 
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div class="pagination">
                            <c:forEach begin="1" end="${requestScope.noOfPages}" varStatus="i">
                                <c:url value="MainController" var="ManageUser">
                                    <c:param name="action" value="Search Username"/>
                                    <c:param name="page" value="${i.index}"/>
                                    <c:param name="txtSearch" value="${requestScope.lastSearch}"/>
                                </c:url>
                                <c:if test="${i.index == page}" var="paging" scope="page">
                                    <a href="${ManageUser}" class="active">${i.index}</a>
                                </c:if>
                                <c:if test="${paging ==false}">
                                    <a href="${ManageUser}" class="">${i.index}</a>
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