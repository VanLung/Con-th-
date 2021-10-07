<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <title>MobileStore - Điện Thoại thông minh chính hãng</title>

        <!-- Bootstrap -->
        <link
            href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
            rel="stylesheet"
            integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
            crossorigin="anonymous">

        <!-- CSS -->
        <link rel="stylesheet" href="CONF-INF/home.css" />
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
              />
        <!-- <link rel="stylesheet" href="reponsive.css" /> -->

        <!-- Logo in title -->
        <link rel="shortcut icon" type="image/png" href="logo.png" />
        <!-- JS -->
        <script src="myscript.js" async></script>


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
                    <li><a href="#">Điện thoại<i class="fa fa-sort-down"
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
                    <li><a href="#">Phụ kiện<i class="fa fa-sort-down"
                                               style="font-size:16px;margin-left: 5px;"></i></a>
                        <div class="menu-phukien">
                            <ul>
                                <li><a href="#">Pin sạc dự phòng</a></li>
                                <li><a href="#">Sạc,cáp</a></li>
                                <li><a href="#">Miếng dán màn hình</a></li>
                                <li><a href="#">Ốp lưng điện thoại</a></li>
                                <li><a href="#">Gậy tự sướng</a></li>
                                <li><a href="#">Giá đỡ điện thoại</a></li>
                                <li><a href="#">Đế, móc điện thoại</a></li>
                                <li><a href="#">Túi chóng nước</a></li>
                                <li><a href="#">Tai nghe</a></li>
                            </ul>
                        </div>

                    </li>
                    <li><a href="#">Máy cũ giá rẻ</a></li>
                    <li>
                        <form>
                            <input type="text" name="search" placeholder="Tìm kiếm sản phẩm..." />
                            <button type="submit"><i class="fa fa-search"
                                                     aria-hidden="true"></i></button>
                        </form>
                    </li>
                    <li><a href="viewCart.jsp">
                            <button id="cart">
                                <i class="fa fa-shopping-basket"
                                   aria-hidden="true"></i>
                                Cart
                            </button>
                        </a></li>

                </ul>
            </nav>
        </div>

        <!-- Slider -->
        <section class="slider">
            <div class="container">
                <div class="slider-contain">
                    <div class="slider-contain-left">
                        <div class="slider-contain-left-top">
                            <a href="#"><img
                                    src="https://cdn.tgdd.vn/2021/09/banner/830-300-830x300-6.png"
                                    alt=""></a>
                            <!--                             <a href="#"><img src="https://cdn.tgdd.vn/2021/10/banner/S21-830-300-830x300-1.png" alt=""></a>
                                                    <a href="#"><img src="https://cdn.tgdd.vn/2021/09/banner/830-300-830x300-13.png" alt=""></a>
                                                    <a href="#"><img src="https://cdn.tgdd.vn/2021/09/banner/reno6cb-830-300-830x300.png" alt=""></a>
                                                    <a href="#"><img src="https://cdn.tgdd.vn/2021/09/banner/pk-t10-830-300-830x300.png" alt=""></a> -->
                            <div class="slider-contain-left-top-btn">
                                <i class="fas fa-chevron-left"></i>
                                <i class="fas fa-chevron-right"></i>
                            </div>
                        </div>
                        <div class="slider-contain-left-bottom">
                            <li class="active">Góp Triệu Yêu Thương Trao 2000 Tấn Gạo</li>
                            <li>Galaxy S21 Series 5G Giảm Đến 9 Triệu</li>
                            <li>Đặt trước Vivo X7 Pro Tặng Ngay 3 Triệu</li>
                            <li>Reno6Z | Reno6Z 5G Giá Từ 9.490.000đ</li>
                            <li>Sắm Phụ Kiện Giảm Tối Đa Đến 50%</li>
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


        <div class="panner2">
            <img src="https://cdn.tgdd.vn/2021/10/banner/1200-60-1200x60.png"
                 alt="">
        </div>

        <div class="small-container cart-page">

            <c:set var="cart" value="${sessionScope.CART}"/>
            <c:if test="${not empty cart}">
                <c:set var="items" value="${cart.items}"/>
                <c:if test="${not empty items}">
                    <a href="ClearCartServlet">
                        <button class="btn btn-clear mg1 " type="back">
                            <i class="fas fa-window-close" aria-hidden="true" ></i> Clear
                        </button>
                    </a>

                    <table>
                        <tr>
                            <th>Product</th>
                            <th>Quantity</th>
                            <th>Subtotal</th>
                        </tr>
                        <c:forEach items="${items}" var="entry">
                            <form action="DispatchServlet" method="POST">
                                <tr>
                                    <td>
                                        <div class="cart-info">
                                            <img src="${entry.key.imgLink}" alt="">
                                            <div>
                                                <p>            
                                                    ${entry.key.proName}
                                                    <input type="hidden" name="txtProductID" value="${entry.key.ID}" />
                                                </p>
                                                <small>Price: ${entry.key.price} USD</small>
                                                <br>
                                                <input type="submit" value="Remove" name="action" class="btn btn-remove-cart" />
                                            </div>
                                        </div>
                                    </td>
                                    <td>${entry.value}</td>
                                    <td>${entry.key.price * entry.value} USD</td>
                                </tr>
                            </form>
                        </c:forEach>
                    </table>
                    <div class="total-price">
                        <table>
                            <tr>
                                <td>Subtotal</td>
                                <td>${cart.grandTotal} USD</td>
                            </tr>
                            <tr>
                                <td>VAT (10%)</td>
                                <td>${cart.grandTotal * 0.1} USD</td>
                            </tr>
                            <tr>
                                <td>Totals Amount: </td>
                                <td>${cart.grandTotal + (cart.grandTotal * 0.1)} USD</td>
                            </tr>
                        </table>
                    </div>

                    <a href=""><button class="btn btn-checkout mg " type="back" >
                            <i class="fas fa-shopping-cart" aria-hidden="true" ></i> Check out
                        </button></a>
                    </c:if>
                </c:if>
            <a href="">
                <button class="btn btn-continue " type="back">
                    <i class="fa fa-arrow-left" aria-hidden="true" ></i> continue shopping
                </button>
            </a>
        </div>
    </body>
</html>
