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
        <link type="text/css" rel="stylesheet" href="CONF-INF/home.css">
        <title>MobileStore - Điện Thoại thông minh chính hãng</title>
        <link rel="shortcut icon" type="image/png" href="CONF-INF/img/logo.png" />

        <!-- Bootstrap -->
        <link
            href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
            rel="stylesheet"
            integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
            crossorigin="anonymous">

        <!-- CSS -->
        <link rel="stylesheet" href="product.css" />
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
              />

    </head>

    <body>

        <div class="header">
            <!-- header -->

            <header>
                <img
                    src="https://cdn.tgdd.vn/2021/09/banner/t10-1200-44-1200x44.png"
                    alt="" />
            </header>

            <nav class="menu-bar-content">
                <ul>
                    <li><a href="#">Smart phone<i class="fa fa-sort-down"
                                                  style="font-size:16px;margin-left: 5px;"></i></a>
                        <div class="menu-dienthoai">
                            <ul>
                                <li><a href="#">IPHONE</a></li>
                                <li><a href="#">SAMSUNG</a></li>
                                <li><a href="#">OPPO</a></li>
                                <li><a href="#">VIVO</a></li>
                                <li><a href="#">XIAOMI</a></li>
                                <li><a href="#">REALME</a></li>
                                <li><a href="#">VSMART</a></li>
                                <li><a href="#">ONEPLUS</a></li>
                                <li><a href="#">NOKIA</a></li>
                                <li><a href="#">MOBELL</a></li>
                                <li><a href="#">ITEL</a></li>
                                <li><a href="#">MASSTELL</a></li>
                                <li><a href="#">ENERGINER</a></li>

                            </ul>
                        </div>
                    </li>
                    <li><a href="#">Accessories<i class="fa fa-sort-down"
                                                  style="font-size:16px;margin-left: 5px;"></i></a>
                        <div class="menu-phukien">
                            <ul>
                                <li><a href="#">Rechargeable Backup Battery</a></li>
                                <li><a href="#">Charger Cables</a></li>
                                <li><a href="#">Screen Protector</a></li>
                                <li><a href="#">Phone Cases</a></li>
                                <li><a href="#">Selfie Stick </a></li>
                                <li><a href="#">Telephone Case</a></li>
                                <li><a href="#">Phone Holder</a></li>
                                <li><a href="#"> Waterproof Phone Pouch</a></li>
                                <li><a href="#">Earphones</a></li>
                            </ul>
                        </div>

                    </li>
                    <li><a href="#">Used machines</a></li>
                    <li class="search-box">
                        <form>
                            <input type="text" name="search" placeholder="Type to search..." />
                            <button type="submit"><i class="fa fa-search"
                                                     aria-hidden="true"></i></button>
                        </form>
                    </li>
                    <li><a href="viewCartServlet">
                            <button id="cart">
                                <i class="fa fa-shopping-basket"
                                   aria-hidden="true"></i>
                                Cart
                            </button>
                        </a>
                    </li>
                    <li><a href="login.jsp">
                            <button id="cart">
                                <i class="fas fa-user-circle" aria-hidden="true"></i>
                                Login
                            </button>
                        </a>
                    </li>

                </ul>
            </nav>
        </div>

        <%-- Slider --%>

        <section class="slider">
            <div class="container">
                <div class="slider-contain">
                    <div class="slider-contain-left">
                        <div class="slider-contain-left-top">
                            <a href="#"><img
                                    src="https://cdn.tgdd.vn/2021/09/banner/830-300-830x300-6.png"
                                    alt=""></a>
                            
                            <div class="slider-contain-left-top-btn">
                                <i class="fas fa-chevron-left"></i>
                                <i class="fas fa-chevron-right"></i>
                            </div>
                        </div>
                        <div class="slider-contain-left-bottom">
                            <li class="active">Donate Millions of Love Give 2000 Tons of Rice</li>
                            <li>Galaxy S21 Series 5G Discount Up to 9 Million</li>
                            <li>Pre-order Vivo X7 Pro Get 3 Million </li>
                            <li>Reno6Z | Reno6Z 5G Price From 9,490,000 VND </li>
                            <li>Shop Accessories Up to 50% Off </li>
                        </div>
                    </div>
                    <div class="slider-contain-right">
                        <li>
                            <a href=""><img
                                    src="https://cdn.tgdd.vn/2021/09/banner/laptopdesk(3)-340x340.jpg"
                                    alt=""></a>
                        </li>
                        <li>
                            <a href=""><img
                                    src="https://cdn.tgdd.vn/2021/10/banner/laptopdesk(7)-340x340-1.jpg"
                                    alt=""></a>
                        </li>
                        <li>
                            <a href=""><img
                                    src="https://cdn.tgdd.vn/2021/10/banner/laptopdesk-340x340.jpg"
                                    alt=""></a>
                        </li>
                        <li>
                            <a href=""><img
                                    src="https://cdn.tgdd.vn/2021/10/banner/die%CC%A3%CC%82nthoaidesk-340x340.jpg"
                                    alt=""></a>
                        </li>
                    </div>
                </div>
            </div>
        </section>


        <%-- Content --%>

    <center>


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
        <c:if test="${empty result}" >
            <h3 id="Empty-List">No product available</h3>
        </c:if>
    </center>


</body>
</html>
