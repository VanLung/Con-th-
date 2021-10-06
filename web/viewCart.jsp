<%-- 
    Document   : viewCart
    Created on : Apr 20, 2021, 5:08:53 PM
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
        <title>Your Cart - Mobile Store</title>
        <style>
            @media all and (max-width: 1080px){
                #result {
                    margin: 10px 0 0 0;
                    width: 100%;
                }
            }
            a {
                text-decoration: none;
                color: blue;
            }
        </style>
    </head>
    <body>
    <center>
        <a href="ShowProductServlet">Click here to go back to home page</a>

        <c:set var="cart" value="${sessionScope.CART}"/>
        <c:if test="${not empty cart}">
            <c:set var="items" value="${cart.items}"/>
            <c:if test="${not empty items}">
                <h2>Your items:</h2>
                <p></p>
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Product Name</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Total</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="entry" items="${items}" varStatus="counter">
                        <form action="DispatchServlet">
                            <center>
                                <tr>
                                    <td>
                                        ${counter.count}.
                                    </td>
                                    <td>
                                        ${entry.key.proName}
                                        <input type="hidden" name="txtProductID" value="${entry.key.ID}" />
                                    </td>
                                    <td>                                
                                        ${entry.value}
                                    </td>
                                    <td>
                                        ${entry.key.price} USD
                                    </td>
                                    <td>
                                        ${entry.key.price * entry.value} USD
                                    </td>
                                    <td>
                                        <input type="submit" value="Remove" name="action" class="btn"/>
                                    </td>
                                </tr>
                            </center>
                        </form>
                    </c:forEach>
                    <tr>
                        <td colspan="4">Grand Total</td>
                        <td colspan="2">${cart.grandTotal} USD</td>
                    </tr>
                    </tbody>
                </table>
                <form action="DispatchServlet">
                    <input type="submit" value="Check Out" name="action" class="btn"/>
                </form>
            </c:if>
        </c:if>
        <br/>
        <c:if test="${empty items}">
            <h3>No products have been added to cart.</h3>
        </c:if>

    </center>
</body>
</html>
