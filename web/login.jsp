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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" rel="stylesheet" href="CONF-INF/general.css">
        <title>Login Page</title>

    </head>
    <body>
    <center>
        <h1>LOGIN NOW!!!</h1>
        <c:set var="error" value="${requestScope.INVALID_LOGIN}"/>
        <form action="DispatchServlet" method="POST">
            <table border="0">
                <tr>
                    <td>
                        User ID 
                    </td>
                    <td>
                        <input type="text" name="txtUserID" value="" />
                    </td>
                </tr>

                <tr>
                    <td>
                        Password 
                    </td>
                    <td>
                        <input type="password" name="txtPassword" value="" /><br/>
                    </td>
                </tr>

                <c:if test="${not empty error.loginInfoNotMatch}">
                    <tr>
                        <td colspan="2" style="text-align: center">
                            <font color="red">
                            ${error.loginInfoNotMatch}
                            </font>
                        </td>
                    </tr>
                </c:if>

                <tr>
                    <td>
                        Remember User? 
                    </td>
                    <td>
                        <input type="checkbox" name="chkCookie" value="ON" />
                    </td>
                </tr>
            </table>
            <input type="submit" value="Login" name="action" class="btn"/>
            <input type="reset" value="Reset" class="btn"/>
        </form>
        <br/>
        
        <p>
            <a href="createAccount.html">Create Your Own Account now!!!</a>
        </p>
    </center>
</body>
</html>
