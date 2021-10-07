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
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CONF-INF/login.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" type="img/png" href="logo.png"/>
        <title>MobileStore - Điện Thoại thông minh chính hãng</title>

    </head>
    <body>
        <header>
            <div class="container">Moblie Store</div>
        </header>
        <main>
            <c:set var="error" value="${requestScope.INVALID_LOGIN}"/>
            <div class="container">
                <div class="login-form">
                    <form action="DispatchServlet" method="post">
                        <h3>Please sign in</h3>
                        <div class="input-box">
                            <i ></i>
                            <input type="text" placeholder="Username" name="txtUserID">
                        </div>
                        <div class="input-box">
                            <i ></i>
                            <input type="password" placeholder="Password" name="txtPassword">
                        </div>
                        <c:if test="${not empty error.loginInfoNotMatch}">
                            <font color="red" class="error-control">
                            ${error.loginInfoNotMatch}
                            </font>
                        </c:if>
                        <div class="btn-box">
                            <button type="submit" name="action" value="Login">
                                <i class="fas fa-user-circle">

                                </i>Login
                            </button>
                        </div>
                    </form>
                </div>
            </div>\

        </main>

    </body>
</html>