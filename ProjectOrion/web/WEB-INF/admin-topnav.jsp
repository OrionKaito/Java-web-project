<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.ROLE != 'admin'}">
    <jsp:forward page="rolefiltererror.jsp"/>
</c:if>
<nav id="top-nav">
    <div class="logo"><a href="home.jsp"><img src="images/logo.png" alt="logo" id="images"/></a></div>
    <ul class="main-nav" style="margin-left: 100px;">
        <li class="li abc">
            <a href="createtour.jsp">Create tour</a>
        </li>
        <li class="li abc">
            <c:url value="MainController" var="LogOut">
                <c:param name="action" value="Log out"/>
            </c:url>
            <a href="${LogOut}">Log out</a>
        </li>
        <li class="li abc">
            <a href="createtourcategory.jsp" >Create new tour Category</a>
        </li>
        <li class="li abc">
            <c:url value="MainController" var="ManageUser">
                <c:param name="action" value="Search Username"/>
                <c:param name="txtSearch" value=""/>
            </c:url>
            <a href="${ManageUser}">Manage User</a>
        </li>
        <li class="li abc">
            <c:url value="MainController" var="ManageTour">
                <c:param name="action" value="Search Tour"/>
                <c:param name="txtSearch" value=""/>
            </c:url>
            <a href="${ManageTour}">Manage Tour</a>
        </li>
    </ul>
</nav>
