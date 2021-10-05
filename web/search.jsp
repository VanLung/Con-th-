<%-- 
    Document   : search
    Created on : Apr 18, 2021, 7:20:20 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="CONF-INF/general.css">
        <title>Search Page</title>
        <style>
            @media all and (max-width: 1080px){
                table {
                    margin: 10px 0 0 0;
                    width: 100%;
                }
            }
        </style>
    </head>
    <body>

        <c:set var="user" value="${sessionScope.LOGIN_USER}"/>
        <c:set var="AD" value="AD"/>
        <form action="DispatchServlet">
            <p id="Welcome">
                Welcome, ${user.fullName}.
                <input type="submit" value="Logout" name="action" class="btn"/>
            </p>
        </form>
        <c:if test="${user.roleID eq AD}">
            <a href="CreateNewProduct.html">Click here to add flower</a>
        </c:if>
        <c:if test="${user.roleID eq 'GSS'}">
            <a href="ShowFlowerServlet">Flower Shop</a>  
        </c:if>

        <form action="DispatchServlet" id="Search">
            Search Value <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" />
            <input type="submit" value="Search" name="action" class="btn"/>
        </form> <br/>

        <!--Print Out the Value Delete or Update function-->
        <c:set var="delInfo" value="${requestScope.DELETE_INFO}"/>
        <c:if test="${not empty delInfo}">
            <p id="Notice">
                [product:${delInfo}] has been deleted.
            </p>
        </c:if>
        <c:if test="${empty delInfo}">
            <c:set var="updInfo" value="${requestScope.UPDATE_INFO}"/>
            <c:set var="errors" value="${requestScope.UPDATE_ERROR}"/>
            <%--<c:set var="Product_ID" value="${requestScope.UPDATE_PRODUCTID}"/>--%>
            <c:if test="${not empty updInfo and empty errors.updateQuantityError
                          and empty errors.updatePriceError and empty errors.updateCategoryIDError
                          }">
                  <p id="Notice">
                      [product:"${updInfo}"]: has been updated.
                  </p>
            </c:if>
            <!--Print Out the error -->
            <c:if test="${(not empty errors.updateQuantityError)}">
                <p id="Notice">
                    [product:"${updInfo}"]: ${errors.updateQuantityError}
                </p>
            </c:if>

            <c:if test="${(not empty errors.updatePriceError)}">
                <p id="Notice">
                    [product:"${updInfo}"]: ${errors.updatePriceError}
                </p>
            </c:if>

            <c:if test="${(not empty errors.updateCategoryIDError)}">
                <p id="Notice">
                    [product:"${updInfo}"]: ${errors.updateCategoryIDError}
                </p>
            </c:if>
        </c:if>

        <c:set var="searchValue" value="${param.txtSearchValue}" />
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCH_PRODUCT}"/>
            <c:if test="${not empty result}">
                <table border="1" style="border: white">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Product ID</th>
                            <th>Product Name</th>
                            <th>quantity</th>
                            <th>price</th>
                            <th>category ID</th>
                                <c:if test="${user.roleID eq AD}">
                                <th>Delete</th>
                                <th>Update</th>
                                </c:if>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                        <form action="DispatchServlet">
                            <tr>
                                <td class="number">
                                    ${counter.count}.
                                </td>
                                <td>
                                    ${dto.productID}
                                    <input type="hidden" name="txtProductID" value="${dto.productID}" />
                                </td>
                                <td>
                                    ${dto.productName}
                                    <input type="hidden" name="txtProductName" value="${dto.productName}" />
                                </td>
                                <td>                                   
                                    <input type="text" name="txtQuantity" value="${dto.quantity}" 
                                           maxlength="4" size="1"/>          
                                </td>
                                <td>
                                    <input type="text" name="txtPrice" value="${dto.price}" 
                                           maxlength="4" size="1"/>                                    
                                </td>
                                <td>
                                    <input type="text" name="txtCategoryID" value="${dto.catagoryID}" />                                   
                                </td>
                                <c:if test="${user.roleID eq AD}">
                                    <td class="button">
                                        <c:url var="deleteLink" value="DispatchServlet">
                                            <c:param name="action" value="Delete"/>
                                            <c:param name="productID" value="${dto.productID}"/>
                                            <c:param name="lastsearchValue" value="${searchValue}"/>
                                        </c:url>
                                        <a href="${deleteLink}">Delete</a>
                                    </td>
                                    <td class="button">
                                        <input type="submit" value="Update" name="action" class="btn"/>
                                        <input type="hidden" name="lastSearchValue" value="${searchValue}" />
                                    </td>
                                </c:if>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
    </c:if>
    <c:if test="${empty searchValue}">
        <h2>No record found !!!</h2>
    </c:if>
</body>
</html>
