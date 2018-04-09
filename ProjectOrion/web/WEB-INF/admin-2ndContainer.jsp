<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="secondary">
    <div class="s2container">
        <a href="ProcessCreateTourController">Create new tour</a>
        <br/>
        <a href="createtourcategory.jsp" >Create new tour Category</a>
        <br/>
        <c:url value="MainController" var="ManageUser">
            <c:param name="action" value="Search Username"/>
            <c:param name="txtSearch" value=""/>
        </c:url>
        <a href="${ManageUser}">Manage User</a>
        <br/>
        <c:url value="MainController" var="ManageTour">
            <c:param name="action" value="Search Tour"/>
            <c:param name="txtSearch" value=""/>
        </c:url>
        <a href="${ManageTour}">Manage Tour</a>
    </div>
</div>