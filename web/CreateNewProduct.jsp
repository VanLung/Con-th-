<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Mobile Store</title>
        <link rel="stylesheet" href="CONF-INF/addProduct.css">
        <link rel="shortcut icon" type="img/png" href="logo.png"/>
        <title>MobileStore - Điện Thoại thông minh chính hãng</title>
    </head>
    <body>
        <header> 
            <form action="DispatchServlet">
                <a>
                    <button type="submit" class="btn btn-primary btn-block" name="action" value="Logout">
                        <i class="fas fa-user-circle"></i>
                        Logout
                    </button>
                </a>
            </form>

            <p>Products</p> <br /> 
            <h1> Add products</h1>
        </header>
        <nav>
            <h2> Add new product </h2>
            <c:set var="errors" value="${requestScope.ERROR_ADD_PRODUCT}"/>
            <form action="DispatchServlet"  method="POST">
                <div class="container"> 
                    <div class="row">
                        <div class="col-25">
                            <label>Product Name</label>
                        </div>
                        <div class="col-75">
                            <input type="text" name="proName" value="" required>
                        </div>
                    </div>

                    <c:if test="${not empty errors.proNameLengthErr}">
                        <font color="red">
                        ${errors.proNameLengthErr} 
                        </font>
                    </c:if>

                    <div class="row">
                        <div class="col-25">
                            <label for="country">Unit Price</label>
                        </div>
                        <div class="col-75">
                            <input type="number" name="price" value="" required>
                        </div>
                    </div>

                    <c:if test="${not empty errors.priceFormatErr}">
                        <font color="red">
                        ${errors.priceFormatErr}
                        </font>
                    </c:if>

                    <div class="row">
                        <div class="col-25">
                            <label>Units in Stock</label>
                        </div>
                        <div class="col-75">
                            <input type="number" name="stock" value="" required> 
                        </div>
                    </div>

                    <c:if test="${not empty errors.stockFormatErr}">
                        <font color="red">
                        ${errors.stockFormatErr}
                        </font>
                    </c:if>

                    <div class="row">
                        <div class="col-25">
                            <label>Description</label>
                        </div>
                        <div class="col-75">
                            <textarea id="subject" name="description"
                                      style="height:50px"></textarea> 
                        </div>
                    </div>

                    <c:if test="${not empty errors.descriptionLengthErr}">
                        <font color="red">
                        ${errors.descriptionLengthErr}
                        </font>
                    </c:if>

                    <div class="row">
                        <div class="col-25">
                            <label>Manufacturer</label>
                        </div>
                        <div class="col-75">
                            <input type="text" name="manufacturer" value=""> 
                        </div>
                    </div>

                    <c:if test="${not empty errors.manufacturerLengthErr}">
                        <font color="red">
                        ${errors.manufacturerLengthErr}
                        </font>
                    </c:if>

                    <div class="row">
                        <div class="col-25">
                            <label>Category</label>
                        </div>
                        <div class="col-75">
                            <input type="text" name="category" value=""> 
                        </div>
                    </div>

                    <c:if test="${not empty errors.categoryLengthErr}">
                        <font color="red" class="error-control">
                        ${errors.categoryLengthErr}
                        </font>
                    </c:if>

                    <div class="row">
                        <div class="col-25">
                            <label>Condition</label>
                        </div>
                        <div class="col-75">
                            <input type="radio" name="condition" value="1"> New
                            <input type="radio" name="condition" value="0"> Old
                            <input type="radio" name="condition" value="2"> Refurbished
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-60">
                            <label>Products Image File</label>
                            <input type="text" name="imgLink" value=""> 
                        </div>
                    </div>

                    <c:if test="${not empty errors.imgLengthErr}">
                        <font color="red">
                        ${errors.imgLengthErr}
                        </font>
                    </c:if>

                    <div class="row">
                        <button type="submit" name="action" value="Add">Add product</button>
                    </div>     
                </div> 
            </form>
        </nav> 
    </body>
</html>

