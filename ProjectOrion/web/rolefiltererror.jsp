<%-- 
    Document   : rolefiltererror
    Created on : Mar 17, 2018, 10:49:43 AM
    Author     : Orion
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/WEB-INF/head.jsp">
        <jsp:param name="title" value="Authorization"/>
    </jsp:include>
    <style>
        @font-face {
            src:url("fonts/Lato-Light.ttf");
            font-family: lato-light;
        }

        body {
            background-color: #e0e0e0;
            font-family: lato-light, "Open Sans", sans-serif;
        }

        #site {
            margin-left: 15% ;
            width: 1040px;
            padding: 24px 24px 0;
            margin-bottom: 24px;
            background-color: #e0e0e0;
            position: absolute;
        }

        #primary{
            border: 1px solid #e6e6e6;
            margin: 17%;
            padding: 30px 5% 3% 3%;
            width: 55%;
            height: 90%;
            position: relative;
            float: left;
            background-color: #fff;
            box-shadow: 1px 1px 1px 1px #de4848;
        }

        .alert {
            border: 1px solid;
            border-left-width: 5px;
            font-family: lato-bold;
            padding: 5px 5px 5px 10px;
        }

        .error {
            border-color: #b85f56;
        }
    </style>
    <body>
        <div id="site">
            <div id="primary">
                <h1>Access Denied</h1>
                <p class="alert error">Your role not support this action!!!</p>
                <p class="alert error">If you has account, please login.</p>
                <a href="/ProjectOrion/login.jsp">Click here to login</a>
            </div>
        </div>
    </body> 
</html>