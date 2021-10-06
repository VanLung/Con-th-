<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CONF-INF/addProduct.css">
    </head>

    <body>
        <header>
            <h1>Products</h1> 
            <p>Add products</p>
            <form action="DispatchServlet">
                <button class="btn btn-logout" type="submit" name="action" value="Logout">
                    Logout
                </button>
            </form>
        </header>

        <div class="add-form">
            <div class="form-title">
                <p>
                    Add new product
                </p>
            </div>
            <c:set var="errors" value="${requestScope.ERROR_ADD_PRODUCT}"/>
            <form action="DispatchServlet">
                <div class="form-group">
                    <label class="pName"> Product Name</label>
                    <input type="text" class="form-control" value="" name="proName">
                </div>

                <c:if test="${not empty errors.proNameLengthErr}">
                    <font color="red">
                    ${errors.proNameLengthErr} 
                    </font>
                </c:if>

                <div class="form-group">
                    <label class="price"> Unit Price</label>
                    <input type="text" class="form-control" value="" name="price">
                </div>

                <c:if test="${not empty errors.priceFormatErr}">
                    <font color="red">
                    ${errors.priceFormatErr}
                    </font>
                </c:if>

                <div class="form-group">
                    <label class="stock"> Units In Stock</label>
                    <input type="number" class="form-control" value="" name="stock">
                </div>

                <c:if test="${not empty errors.stockFormatErr}">
                    <font color="red">
                    ${errors.stockFormatErr}
                    </font>
                </c:if>

                <div class="form-group">
                    <label class="description"> Description</label>
                    <textarea class="form-control" value="" name="description"></textarea>
                </div>

                <c:if test="${not empty errors.descriptionLengthErr}">
                    <font color="red">
                    ${errors.descriptionLengthErr}
                    </font>
                </c:if>

                <div class="form-group">
                    <label class="manufacturer"> Manufacturer</label>
                    <input type="text" class="form-control" value="" name="manufacturer">
                </div>

                <c:if test="${not empty errors.manufacturerLengthErr}">
                    <font color="red">
                    ${errors.manufacturerLengthErr}
                    </font>
                </c:if>

                <div class="form-group">
                    <label class="category"> Category</label>
                    <input type="text" class="form-control" value="" name="category">
                </div>

                <c:if test="${not empty errors.categoryLengthErr}">
                    <font color="red" class="error-control">
                    ${errors.categoryLengthErr}
                    </font>
                </c:if>

                <div class="form-group-radio">
                    <label class="condition"> Condition</label>

                    <label class="radio">
                        New 
                        <input type="radio" class="form-control-radio" value="1" name="condition" checked> 
                    </label>

                    <label class="radio">
                        Old 
                        <input type="radio" class="form-control-radio" value="0" name="condition"> 
                    </label>

                    <label class="radio">
                        Refurbished <input type="radio" class="form-control-radio" value="2" name="condition">
                    </label>
                </div>

                <div class="form-group">
                    <label class="condition"> Product image file</label>
                    <input type="text" class="form-control" value="" name="imgLink" value="">
                </div>

                <c:if test="${not empty errors.imgLengthErr}">
                    <font color="red">
                    ${errors.imgLengthErr}
                    </font>
                </c:if>

                <button class="btn btn-add" type="submit" name="action" value="Add">
                    Add Product
                </button>
            </form>
        </div>
    </body>

</html>