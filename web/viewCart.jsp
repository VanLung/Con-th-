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
        <%--  ViewCart.html
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
        <link rel="stylesheet" href="home.css" />
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
                    <li><a href="cart.html">
                            <button id="cart">
                                <i class="fa fa-shopping-basket"
                                    aria-hidden="true"></i>
                                Giỏ Hàng
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
                            <!-- <a href="#"><img src="https://cdn.tgdd.vn/2021/10/banner/S21-830-300-830x300-1.png" alt=""></a>
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
    
        <a href=""><button class="btn btn-clear " type="back">
        <i class="fas fa-window-close" aria-hidden="true" ></i> Clear
      </button></a>
            
       <a href=""><button class="btn btn-checkout mg " type="back" >
        <i class="fas fa-shopping-cart" aria-hidden="true" ></i> Check out
      </button></a>
            
       
    
    
<table>
    
    
    <tr>
        <th>Sản Phẩm</th>
        <th>Số Lượng</th>
        <th>Thành Tiền</th>
    </tr>
    <tr>
        <td>
            <div class="cart-info">
                <img src="https://cdn.tgdd.vn/Products/Images/42/226935/samsung-galaxy-z-fold-3-silver-1-600x600.jpg" alt="">
            <div>
                <p>Samsung Galaxy Z Fold3 5G 256GB</p>
                <small>Giá: 49.490.000₫</small>
                <br>
                <a href="">Xóa</a>
            </div>
            </div>


        </td>
        <td><input type="number" value="1"></td>
        <td>49.490.000₫</td>
    </tr>
    <tr>
        <td>
            <div class="cart-info">
                <img src="https://cdn.tgdd.vn/Products/Images/42/213031/iphone-12-den-new-2-600x600.jpg" alt="">
            <div>
                <p>IPhone 12 128GB</p>
                <small>Giá: 24.490.000₫</small>
                <br>
                <a href="">Xóa</a>
            </div>
            </div>


        </td>
        <td><input type="number" value="1"></td>
        <td>24.490.000₫</td>
    </tr>
    <tr>
        <td>
            <div class="cart-info">
                <img src="https://cdn.tgdd.vn/Products/Images/42/246200/redmi-10-gray-600x600.jpg" alt="">
            <div>
                <p>Xiaomi Redmi 10(6GB/128GB)</p>
                <small>Giá: 4.690.000₫</small>
                <br>
                <a href="">Xóa</a>
            </div>
            </div>


        </td>
        <td><input type="number" value="1"></td>
        <td>4.690.000₫</td>
    </tr>
</table>


<div class="total-price">
    <table>
        <tr>
            <td>Tổng thanh toán trước thuế</td>
            <td>78.670.000₫</td>
        </tr>
        <tr>
            <td>Thuế VAT (10%)</td>
            <td>7.867.000₫</td>
        </tr>
        <tr>
            <td>Tổng thanh toán sau thuế</td>
            <td>86.537.000₫</td>
        </tr>
    </table>
</div>
<a href=""><button class="btn btn-continue" type="back">
        <i class="fa fa-arrow-left" aria-hidden="true" ></i> continue shopping
      </button></a>
    
 </div>

    </body>

</html>
        --%>
</body>
</html>
