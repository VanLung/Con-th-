<%-- 
    Document   : FlowerShop
    Created on : Apr 19, 2021, 8:54:48 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="CONF-INF/general.css">
        <title>Flower Shop Page</title>
    </head>
    <body>
    <center>
        <a href="viewCartServlet">Click here to view your cart</a><br/>
        <a href="search.jsp">Go back to search page</a>

        <h2>Welcome, please choose product</h2>
        <c:if test="${not empty param.addStatus}">
            <p id="Notice">
                ${param.productAdded} is in your Cart now!!!
            </p>
        </c:if>

        <c:set var="errors" value="${requestScope.QUANERR}"/>
        <c:set var="updInfo" value="${requestScope.QUANTITY_INFO}"/>
        <c:if test="${not empty errors.enterQuantityError}">
            <p id="Notice">
                [product:"${updInfo}"]: ${errors.enterQuantityError}
            </p>
        </c:if>

        <c:set var="result" value="${requestScope.LOAD_FLOWER}"/>
        <c:if test="${not empty result}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Category ID</th>
                        <th>Cart</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${result}" varStatus="counter">
                    <form action="AddFlowerServlet">
                        <tr>
                            <td class="number">
                                ${counter.count}.
                            </td>
                            <td>
                                ${dto.productID}             
                            </td>
                            <td>
                                ${dto.productName}
                                <input type="hidden" name="pName" value="${dto.productName}" />
                            </td>
                            <td class="number">                                
                                <input type="text" name="pQuantity" value="1" style="border: none"
                                       maxlength="4" size="1"/> 

                            </td>
                            <td class="number">
                                ${dto.price}
                            </td>
                            <td>
                                ${dto.catagoryID}
                            </td>
                            <td class="button">
                                <input type="hidden" name="pID" value="${dto.productID}" />
                                <input type="hidden" name="pQuantity" value="${dto.quantity}" />
                                <input type="submit" value="Add" name="action" class="btn"/>
                            </td>
                        </tr>
                    </form>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty result}">
            <h3>No product available</h3>
        </c:if>
    </center>
</body>
</html>
