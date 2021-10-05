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
        <title>View Cart Page</title>
        <style>
            @media all and (max-width: 1080px){
                #result {
                    margin: 10px 0 0 0;
                    width: 100%;
                }
            }
            * {
                font-family: cursive;
            }
            a {
                text-decoration: none;
                color: blue;
            }
        </style>
    </head>
    <body>
    <center>
        <h2>Here your product</h2>

        <c:set var="errors" value="${requestScope.EDIT_QUANERR}"/>
        <c:set var="updInfo" value="${requestScope.EDIT_QUANTITY_INFO}"/>
        <c:if test="${not empty errors.editQuantityError}">
            <p id="Notice">
                [product:"${updInfo}"]: ${errors.editQuantityError}
            </p>
        </c:if>

        <c:set var="result" value="${requestScope.LOAD_VIEWCART}"/>
        <c:if test="${not empty result}">
            <a href="ShowFlowerServlet">Click here to go back to flower shop page</a>
            <p></p>
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>product ID</th>
                        <th>product Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="entry" items="${result}" varStatus="counter">
                    <form action="DispatchServlet">
                        <center>
                            <tr>
                                <td>
                                    ${counter.count}.
                                </td>
                                <td>
                                    ${entry.productID}
                                    <input type="hidden" name="productID" value="${entry.productID}" />
                                </td>
                                <td>
                                    ${entry.productName}
                                    <input type="hidden" name="productName" value="${entry.productName}" />
                                </td>
                                <td>                                
                                    <input type="text" name="productQuantity" value="${entry.quantity}" 
                                           maxlength="4" size="1"/>
                                </td>
                                <td>
                                    ${entry.price}
                                </td>
                                <td>
                                    ${entry.price * entry.quantity}
                                </td>
                                <td>
                                    <input type="submit" value="Edit View Cart" name="action" class="btn"/>
                                </td>
                                <td>
                                    <input type="submit" value="Remove From Cart" name="action" class="btn"/>
                                </td>
                            </tr>
                        </center>
                    </form>
                </c:forEach>
                </tbody>
            </table>
        </c:if> <br/>
        <form action="DispatchServlet">
            <input type="submit" value="Check Out" name="action" class="btn"/>
        </form>
        <c:if test="${empty result}">
            <h3>Currently there are no product in the cart</h3>
            <p>
                Back to the <a href="ShowFlowerServlet">Flower Shop</a>.
            </p>
        </c:if>
    </center>
</body>
</html>
