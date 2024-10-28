<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Male_Fashion Template">
        <meta name="keywords" content="Male_Fashion, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Male-Fashion | Template</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
              rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
    </head>

    <body>

        <!-- Offcanvas Menu End -->

        <!-- Header Section Begin -->
        <%@include file="header.jsp" %>
        <!-- Header Section End -->
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-3">
                    <div class="header__logo">
                        <a href="./index.html"><img src="img/logo.png" alt=""></a>
                    </div>
                </div>

                <div class="col-lg-6 col-md-6">    

                    <nav class="header__menu mobile-menu">
                        <ul>

                            <li><a href="homee">Home</a></li>

                            <li class="active"><a href="URLListProducts">Shop</a></li>

                            <c:if test="${sessionScope.acc != null && sessionScope.acc.isAdmin == 1 }"> 
                                <li><a href="URLManagerProducts">Manager Products</a></li>
                                <li><a href="Bill">Bill Manager</a></li>
                                </c:if>

                            <c:if test="${ sessionScope.acc.isAdmin == 0  }"> 
                                <li><a href="Cart">Shopping Cart</a></li>
                                <li><a href="checkout.jsp">Check Out</a></li>
                                </c:if>                    

                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Breadcrumb Section Begin -->
        <section class="breadcrumb-option">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="breadcrumb__text">
                            <h4>Shop</h4>
                            <div class="breadcrumb__links">
                                <a href="homee">Home</a>
                                <span>Shop</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Shop Section Begin -->
        <section class="shop spad">
            <div class="container">

                <div class="row"> 
                    <div class="col-lg-3">

                        <div class="shop__sidebar">

                            <div class="shop__sidebar__search">
                                <form action="URLListProducts" method="post">
                                    <input type="text" name="name" placeholder="Search...">
                                    <input type="submit" name="submit" value="Search">
                                    <input type="hidden" name="service" value="listProducts">
                                </form>     
                            </div>


                            <div class="shop__sidebar__accordion">
                                <div class="card">
                                    <div class="card-heading">
                                        <a data-toggle="collapse" data-target="#collapseOne">Categories</a>
                                    </div>
                                    <div id="collapseOne" class="collapse show" data-parent="#accordionExample">
                                        <div class="card-body">
                                            <div class="shop__sidebar__categories">
                                                <ul class="nice-scroll">
                                                    <c:forEach items="${listC}" var="o">

                                                        <li><a href="shop?CategoryID=${o.getCategoryID()}">${o.getNameCategory()}</a></li>

                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                                <div class="card">
                                    <div class="card-heading">
                                        <a data-toggle="collapse" data-target="#collapseOne">Brand</a>
                                    </div>
                                    <div id="collapseOne" class="collapse show" data-parent="#accordionExample">
                                        <div class="card-body">
                                            <div class="shop__sidebar__categories">
                                                <ul class="nice-scroll">
                                                    <c:forEach items="${listB}" var="o">
                                                        <li><a href="Brand?brandID=${o.brandID}">${o.brandName}</a></li>
                                                        </c:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>








                            </div>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="shop__product__option">
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="shop__product__option__left">

                                    </div>
                                </div>

                            </div>
                        </div>



                        <div class="row">
                            <c:forEach items="${proo}" var="o">
                                <div class="col-lg-4 col-md-6 col-sm-6">
                                    <div class="product__item">
                                        <div style="height: 245px" class="product__item__pic set-bg" data-setbg="img/mauhang/${o.img}">
                                        </div>
                                        <div class="product__item__text">
                                            <h6>${o.productName}</h6>
                                            <a href= "productsDetails?productID=${o.productID}" class="add-cart">Buy</a>                     
                                            <h5>${o.price}$</h5>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>

                        </div>


                    </div>
                </div>
            </div>
        </section>
        <!-- Shop Section End -->

        <!-- Footer Section Begin -->
        <%@include file="footer.jsp" %>
        <!-- Footer Section End -->

        <!-- Search Begin -->
        <div class="search-model">
            <div class="h-100 d-flex align-items-center justify-content-center">
                <div class="search-close-switch">+</div>
                <form class="search-model-form">
                    <input type="text" id="search-input" placeholder="Search here.....">
                </form>
            </div>
        </div>
        <!-- Search End -->

        <!-- Js Plugins -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery.nicescroll.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/jquery.countdown.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>
    </body>

</html>
