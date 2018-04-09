<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav id="top-nav">
    <div class="logo"><a href="home.jsp"><img src="images/logo.png" alt="logo" id="images"/></a></div>
    <ul class="main-nav">
        <li class="li abc">
            <c:url value="MainController" var="EditAccount">
                <c:param name="action" value="Edit Account"/>
                <c:param name="txtUsername" value="${sessionScope.USERNAME}"/>
            </c:url>
        <li class="li abc">
            <c:if test="${sessionScope.ROLE eq 'admin'}">
                <a href="admin.jsp">Admin Page</a>
            </c:if>
        </li>
        <li class="li abc">
            <a href="${EditAccount}">My Account</a>
        </li>
        <li class="li abc">
            <c:url value="MainController" var="ViewCart">
                <c:param name="action" value="View Cart"/>
            </c:url>
            <a href="${ViewCart}">Cart</a>
        </li>
        <c:if test="${sessionScope.USERNAME != null}" var="login" scope="page">
            <c:if test="${not empty sessionScope.USERNAME}" >
                <li class="li button">
                    <c:url value="MainController" var="LogOut">
                        <c:param name="action" value="Log out"/>
                    </c:url>
                    <a href="${LogOut}">Log out</a>
                </li>
            </c:if>
        </c:if>
        <c:if test="${login == false}">
            <li class="li button">
                <a href="register.jsp"> Sign up</a>
            </li>
            <li class="li button">
                <a href="login.jsp">Login</a>
            </li>
        </c:if>
    </ul>
</nav>
