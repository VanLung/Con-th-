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
            
            /*
            <!DOCTYPE html>
<html>
<head>
    <title>Mobile Store</title>
    <link rel="stylesheet" href="Addproduct.css">
    <link rel="shortcut icon" type="img/png" href="logo.png"/>
    <title>MobileStore - Điện Thoại thông minh chính hãng</title>
</head>
<body>
	<header> 
            <a>
                <button type="button" class="btn btn-primary btn-block"><i class="fas fa-user-circle"></i>Logout</button></a>
        <p>Products</p> <br /> 
        <h1> Add products</h1>
    </header>
    <nav>
    <h2> Add new product </h2>
    <form name="addForm"  method="POST">
        <div class="container"> 
            <div class="row">
                <div class="col-25">
                    <label>Product Name</label>
                </div>
                <div class="col-75">
                    <input type="text" name="productname" required>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="country">Unit Price</label>
                </div>
                <div class="col-75">
                    <input type="text" name="unitprice" required>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label>Units in Stock</label>
                </div>
                <div class="col-75">
                    <input type="number" name="unitinstock" required> 
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label>Description</label>
                </div>
                <div class="col-75">
                    <textarea id="subject" name="description" 
                    style="height:50px"></textarea> 
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label>Manufacturer</label>
                </div>
                <div class="col-75">
                    <input type="text" name="manufacturer"> 
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label>Category</label>
                </div>
                <div class="col-75">
                    <input type="text" name="category"> 
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label>Condition</label>
                </div>
                <div class="col-75">
                    <input type="radio" name="condition" value="New"> New
                    <input type="radio" name="condition" value="Old"> Old
                    <input type="radio" name="condition" value="Refurbished"> Refurbished
                </div>
            </div>
            <div class="row">
                <div class="col-60">
                    <label>Products Image File</label>
                    <input type="file" name="productImageFile"> 
                </div>
                
            </div>
            <div class="row">
                <button type="submit">Add product</button>
            </div>     
        </div> 
    </form>
    </nav> 
</body> 
</html>

    </body>
    

</html>

