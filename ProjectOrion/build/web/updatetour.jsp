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
        <jsp:param name="title" value="Update tour"/>
    </jsp:include>
    <body>
        <div id="site">
            <jsp:include page="WEB-INF/admin-topnav.jsp"/>
            <div id="primary">
                <h1>Update tour</h1>
                <div class="form">
                    <c:if test="${requestScope.ERROR != null}" var="check" scope="page">
                        <p id="alert-error" class="alert error">${requestScope.ERROR}</p>
                    </c:if>
                    <c:if test="${check == false}">
                        <c:if test="${not empty requestScope.CREATEDONE}">
                            <p id="alert-error" class="alert success">${requestScope.ActionDONE}</p>
                        </c:if>
                    </c:if>
                    <p id="alert-error" class=""></p>
                    <form action="MainController" method="POST" enctype="multipart/form-data">
                        <c:forEach items="${requestScope.INFO}" var="dto">
                            <input type="hidden" name="txtFilepath" value="${dto.filepath}"/>
                            <input type="hidden" name="txtFilename" value="${dto.filename}"/>
                            <input type="hidden" name="txtSearch" value="${requestScope.lastSearch}"/>
                            <input type="hidden" name="action" value="Update Tour"/>
                            <label>ID:<span class="required">*</span></label>
                            <br/>
                            <input id="id" type="text" name="txtID" value="${dto.id}" readonly="readonly" class="readonly"/>
                            <br/>
                            <label>Tour name:<span class="required">*</span></label>
                            <br/>
                            <input id="tourname" type="text" name="txtTourname" value="${dto.tourname}"/>
                            <br/>
                            <label>Start:<span class="required">*</span></label>
                            <br/>
                            <input id="start" type="text" name="txtStart"value="${dto.start}" />
                            <br/>
                            <label>Arrival:<span class="required">*</span></label>
                            <br/>
                            <input id="arrival" type="text" name="txtArrival" value="${dto.arrival}"/>
                            <br/>
                            <label>Max customer:<span class="required">*</span></label>
                            <br/>
                            <input id="max" type="text" name="intMax" value="${dto.maxCustomer}"/>
                            <br/>
                            <label>Price per person:<span class="required">*</span></label>
                            <br/>
                            <input id="price" type="text" name="intPrice" value="${dto.price}"/>
                            <br/>
                            <label>Description:<span class="required">*</span></label>
                            <br/>
                            <textarea id="description" name="txtDescription"  rows="4" cols="60">${dto.description}</textarea>
                            <br/>
                            <label>Date<span class="required" >*</span></label>
                            <br/>
                            <input id="date" type="date" name="txtDate" value="${dto.date}" >
                            <br/>
                            <label>Category<span class="required">*</span></label>
                            <br/>
                            <c:forEach var="catedto" items="${requestScope.CATEGORY}">
                                <c:forEach var="tvtDTO" items="${requestScope.TVTINFO}">
                                    <c:if test="${catedto.id == tvtDTO.tourcategoryid}" var="check" scope="page">
                                        <input class="padding10px" type="checkbox" name="chekCategory" value="${catedto.id}" checked><span>${catedto.name}</span><br/>
                                    </c:if>
                                </c:forEach>
                                <c:if test="${check == false}">
                                    <input class="padding10px" type="checkbox" name="chekCategory" value="${catedto.id}" ><span>${catedto.name}</span><br/>
                                    </c:if>
                                </c:forEach>
                            <br/>
                            <img src="images/${dto.filename}" class="images"/>
                            <label>Image:<span class="required">*</span></label>
                            <br/>
                            <input id="image" type="file" name="image"/>
                            <br/>
                            <input type="submit" onclick="return validateUpdateTour()" value="Update" />
                            <input type="reset"/>
                        </c:forEach>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
