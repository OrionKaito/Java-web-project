<%-- 
    Document   : manageuser
    Created on : Mar 17, 2018, 10:38:49 AM
    Author     : Orion
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/WEB-INF/head.jsp">
        <jsp:param name="title" value="Home"/>
    </jsp:include>
    <body>
        <div id="site" style="padding: 0px">
            <jsp:include page="WEB-INF/user-topnav.jsp"/>
            <div id="header">
                <div id="goi">
                    <div class="background-image">
                        <img src="images/travel-wallpaper-2.jpg" id="images" />
                    </div>
                    <div id="otren">
                        <h1>Search Tour</h1>
                        <form action="MainController" method="POST">
                            <input type="hidden" name="action" value="Find Tour"/>
                            <input id="search" type="text" name="txtSearch" placeholder="Tour name" value="${requestScope.lastSearch}"/>
                            <input type="submit" onclick="return validateSearch()" value="Search"/>
                        </form>
                        <form action="MainController" method="POST">
                            <input type="hidden" name="action" value="Find Tour"/>
                            <input type="hidden" name="txtSearch" value=""/>
                            <input type="submit" value="Get All Tour"/>
                        </form>
                        <div class="error">
                            <p id="alert-error" class=""></p>
                        </div>
                    </div>
                </div>
            </div>
            <div id="result">
                <c:if test="${requestScope.INFO != null}">
                    <c:if test="${not empty requestScope.INFO}" var="check" scope="page">
                        <table class="table-result">
                            <c:forEach items="${requestScope.INFO}" var="dto">
                                <div id="goiResult">
                                    <div class="container">
                                        <div class="images">
                                            <img src="images/${dto.filename}" id="images"/></div>
                                        <div class="info">
                                            <p>Name:${dto.tourname}</p>
                                            <br/>
                                            <p>Price:${dto.price}</p><br/>
                                        </div>
                                    </div>
                                </div>
                                <form action="MainController" method="POST">
                                    <input type="hidden" name="txtID" value="${dto.id}"/>
                                    <input type="hidden" name="txtName" value="${dto.tourname}"/>
                                    <input type="hidden" name="txtPrice" value="${dto.price}"/>
                                    <input type="submit" name="action" value="Add to cart"/>
                                </form>
                            </c:forEach>
                            <div class="pagination">
                                <c:forEach begin="1" end="${requestScope.noOfPages}" varStatus="i">
                                    <c:url value="MainController" var="Home">
                                        <c:param name="action" value="Find Tour"/>
                                        <c:param name="page" value="${i.index}"/>
                                        <c:param name="txtSearch" value="${requestScope.lastSearch}"/>
                                    </c:url>
                                    <c:if test="${i.index == page}" var="paging" scope="page">
                                        <a href="${Home}" class="active">${i.index}</a>
                                    </c:if>
                                    <c:if test="${paging ==false}">
                                        <a href="${Home}" class="">${i.index}</a>
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