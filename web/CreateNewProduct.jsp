<%-- 
    Document   : CreateNewProduct
    Created on : Apr 18, 2021, 9:12:08 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="CONF-INF/general.css">
        <title>Create Product Page</title>
        <style>
            * {
                font-family: cursive;
            }
            a {
                text-decoration: none;
                color: blue;
            }
            table {
                width: 60%;
                float: left;
                margin-left: 30%;
                text-align: left;
            }
        </style>
    </head>
    <body>    
    <center>
        <h2>Create New Product</h2>
        <form action="DispatchServlet">
            <table border="0">
                <c:set var="errors" value="${requestScope.INSERT_ERROR}"/>
                <tr>
                    <td>
                        Product ID 
                    </td>
                    <td>
                        <input type="number" name="txtProductID" value="${param.txtProductID}" />(1-4)
                    </td>
                </tr>    
                <c:if test="${not empty errors.productIDLengthError}">
                    <tr>
                        <td colspan="2">
                            <font color="red">
                            ${errors.productIDLengthError} 
                            </font>
                        </td>
                    </tr>
                </c:if>

                <tr>
                    <td>
                        Product Name
                    </td>
                    <td>
                        <input type="text" name="txtProductName" value="" />(4-10)
                    </td>
                </tr>    
                <c:if test="${not empty errors.productNameLengthError}">
                    <tr>
                        <td colspan="2">
                            <font color="red">
                            ${errors.productNameLengthError} 
                            </font>
                        </td>
                    </tr>
                </c:if>

                <tr>
                    <td>
                        Quantity
                    </td>
                    <td colspan="2">
                        <input type="text" name="txtQuantity">(1-1000)
                    </td>
                </tr>
                <c:if test="${not empty errors.quantitySizeError}">
                    <tr>
                        <td colspan="2"> 
                            <font color="red">
                            ${errors.quantitySizeError} <br/>
                            </font>
                        </td>
                    </tr>
                </c:if>

                <tr>
                    <td>
                        Price
                    </td>
                    <td>
                        <input type="text" name="txtPrice" value="" />(1-1000)
                    </td>
                </tr>
                <c:if test="${not empty errors.priceSizeError}">
                    <tr colspan="2">
                        <td>
                            <font color="red">
                            ${errors.priceSizeError} <br/>
                            </font>
                        </td>
                    </tr>
                </c:if>

                <tr>
                    <td>
                        Category ID
                    </td>
                    <td>
                        <input type="text" name="txtCategoryID" value="" />(r1,y1,b1)<br/>
                    </td>
                </tr>
                <c:if test="${not empty errors.categoryIDLengthError}">
                    <tr>
                        <td colspan="2">
                            <font color="red">
                            ${errors.categoryIDLengthError} <br/>
                            </font>
                        </td>
                    </tr>
                </c:if>
            </table> <br/>

            <input type="submit" value="Insert" name="action" class="btn"/>
            <input type="reset" value="Reset" class="btn"/>
        </form>

        <c:if test="${not empty errors.productIDisExisted}">
            <font color="red">
            ${errors.productIDisExisted} <br/>
            </font>
        </c:if> <br/>

        <c:if test="${not empty errors.productNameisExisted}">
            <font color="red">
            ${errors.productNameisExisted} <br/>
            </font>
        </c:if> <br/>
        
        <a href="search.jsp">Click here to go back to search page</a>
    </center>
</body>
</html>
