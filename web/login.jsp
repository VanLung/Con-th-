<%-- 
    Document   : login
    Created on : Apr 21, 2021, 5:02:42 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CONF-INF/login.css">
    </head>

    <body>
        <header>
            <h2>Mobile Store</h2> 
        </header>

        <div class="login-form">
            <div class="form-title">
                <p>
                    Please sign in
                </p>
            </div>
            <c:set var="error" value="${requestScope.INVALID_LOGIN}"/>
            <form action="DispatchServlet">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="User name" name="txtUserID">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Password" name="txtPassword">
                </div>

                <c:if test="${not empty error.loginInfoNotMatch}">
                    <font color="red" class="error-control">
                    ${error.loginInfoNotMatch}
                    </font>
                </c:if>

                <button type="submit" class="btn btn-login" name="action" value="Login">
                    Login
                </button>
            </form>
        </div>
    </body>
</html>