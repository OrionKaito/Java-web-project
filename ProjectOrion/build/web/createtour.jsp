<%-- 
    Document   : createtour
    Created on : Mar 11, 2018, 4:26:58 PM
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
        <jsp:param name="title" value="New tour"/>
    </jsp:include>
    <body>
        <div id="site">
            <jsp:include page="WEB-INF/admin-topnav.jsp"/>
            <div id="primary">
                <h1>Create new tour</h1>
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
                    <form action="MainController" method="POST" enctype="multipart/form-data">
                        <input type="hidden" name="action" value="Create Tour"/>
                        <label>ID:<span class="required">*</span></label>
                        <br/>
                        <input id="id" type="text" name="txtID" />
                        <br/>
                        <label>Tour name:<span class="required">*</span></label>
                        <br/>
                        <input id="tourname" type="text" name="txtTourname" />
                        <br/>
                        <label>Start:<span class="required">*</span></label>
                        <br/>
                        <input id="start" type="text" name="txtStart" />
                        <br/>
                        <label>Arrival:<span class="required">*</span></label>
                        <br/>
                        <input id="arrival" type="text" name="txtArrival" />
                        <br/>
                        <label>Max customer:<span class="required">*</span></label>
                        <br/>
                        <input id="max" type="text" name="intMax" />
                        <br/>
                        <label>Price per person:<span class="required">*</span></label>
                        <br/>
                        <input id="price" type="text" name="intPrice" />
                        <br/>
                        <label>Description:<span class="required">*</span></label>
                        <br/>
                        <textarea id="description" name="txtDescription"  rows="4" cols="60"></textarea>
                        <br/>
                        <label>Date<span class="required">*</span></label>
                        <br/>
                        <input id="date" type="date" name="txtDate">
                        <br/>
                        <label>Category<span class="required">*</span></label>
                        <br/>
                        <c:forEach var="dto" items="${requestScope.CATEGORY}">
                            <input class="padding10px" type="checkbox" name="chekCategory" value="${dto.id}"><span>${dto.name}</span><br/>
                            </c:forEach>
                        <br/>
                        <label>Image:<span class="required">*</span></label>
                        <br/>
                        <input id="image" type="file" name="image"/>
                        <br/>
                        <input type="submit" onclick="return validateCreateTour()" value="Create" />
                        <input type="reset"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
