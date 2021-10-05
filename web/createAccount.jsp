<%-- 
    Document   : createAccount
    Created on : Apr 19, 2021, 9:58:14 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link type="text/css" rel="stylesheet" href="CONF-INF/general.css">
        <style>
            * {
                font-family: cursive;
            }
            a {
                text-decoration: none;
                color: blue;
            }
            h1 {
                width: 100%;
                height: 50px;
                float: left;
            }
            table {
                width: 60%;
                float: left;
                margin-left: 30%;
                margin-right: 30%;
                text-align: left;
            }

        </style>
    </head>

    <body>
    <center>
        <h1>CREATE YOUR OWN ACCOUNT NOW!!!</h1>
        <br/>
        <form action="DispatchServlet" method="POST">
            <c:set var="errors" value="${requestScope.CREATE_ERROR}"/>
            <table border="0">
                <tr>
                    <td>
                        Username*
                    </td>
                    <td>
                        <input type="text" name="txtUsername" 
                               value="${param.txtUsername}"/> (6-30 chars)
                    </td>
                </tr>
                <c:if test="${not empty errors.usernameLengthErr}">
                    <tr>
                        <td colspan="2">
                            <font color="red">
                            ${errors.usernameLengthErr}
                            </font>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td>
                        Password*
                    </td>
                    <td>
                        <input type="password" name="txtPassword" 
                               value=""/> (6-20 chars)
                    </td>
                </tr>
                <c:if test="${not empty errors.passwordLengthErr}">
                    <tr>
                        <td colspan="2">
                            <font color="red">
                            ${errors.passwordLengthErr}
                            </font>
                        </td>
                    </tr>    
                </c:if>
                <tr>
                    <td>
                        Confirm Pass*
                    </td>
                    <td>
                        <input type="password" name="txtConfirm" value=""/>
                    </td>
                </tr>
                <c:if test="${not empty errors.confirmNotMatch}">
                    <tr>
                        <td colspan="2">
                            <font color="red">
                            ${errors.confirmNotMatch}
                            </font>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td>
                        Full Name*
                    </td>
                    <td>
                        <input type="text" name="txtFullname" 
                               value="${param.txtFullname}"/>(2-50 chars)
                    </td>
                </tr>
                <c:if test="${not empty errors.fullnameLengthErr}">
                    <tr>
                        <td colspan="2">
                            <font color="red">
                            ${errors.fullnameLengthErr}
                            </font>
                        </td>
                    </tr>
                </c:if>
            </table>
            <br/>
            <input type="submit" value="Create New Account" name="action" class="btn"/>
            <input type="reset" value="Reset" class="btn"/>
        </form>
        <br/>
        <c:if test="${not empty errors.usernameIsExisted}">
            <font color="red">
            ${errors.usernameIsExisted}
            </font><br/>
        </c:if>
    </center>
</body>
</html>

