<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Enumeration, Entity.Products" %>
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
        <!-- Page Preloder -->


        <!-- Offcanvas Menu Begin -->
        <!-- Offcanvas Menu End -->

        <!-- Header Section Begin -->
        <%@include file="header.jsp" %>
        <!-- Header Section End -->

        <!-- Breadcrumb Section Begin -->
        <section class="breadcrumb-option">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="breadcrumb__text">
                            <h4>Shopping Cart</h4>
                            <div class="breadcrumb__links">
                                <a href="homee">Home</a>
                                <a href="URLListProducts">Shop</a>
                                <span>Shopping Cart</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Shopping Cart Section Begin -->
        <div class="container">

            <table class="table table-hover table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">ProductID</th>
                        <th scope="col">Product</th>
                        <th scope="col">Product Name</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Price</th>
                        <th scope="col">Delete</th>
                        
                    </tr>
                </thead>
                <tbody>
                
                    <%
                Enumeration enu = session.getAttributeNames(); //getKeys
                while(enu.hasMoreElements()){
                    String productID = (String) enu.nextElement();
                    Products product;
                    if(!productID.equals("acc")){
                product = (Products) session.getAttribute(productID);
                    %>
                    <tr>
                        <td><%=product.getProductID()%></td>
                        <td class="product__cart__item">
                            <div class="product__cart__item__pic">
                                <img style=" width: 100px;"
                                      src="img/mauhang/<%=product.getImg()%>" alt="">
                            </div>
                        </td>

                        <td><%=product.getProductName()%></td>
                        <td>
                           <%=product.getQuantity()%>
                            
                        </td>
                        <td><%=product.getPrice()%></td>
                        <td> 
                            <a href="Cart?service=deleteCart&pid=<%=product.getProductID()%>">
                                    <span class="icon icon_trash"></span>
                                   </a>
                        </td>
                       
                    </tr>
                    <%}}%>
                </tbody>

            </table>

            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="continue__btn">
                        <a href="Cart?service=checkout">Checkout</a>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="continue__btn update__btn">
                        <a href="#"><i class="fa fa-spinner"></i> Update cart</a>
                    </div>
                </div>
            </div>
        </div>


        <!-- Footer Section Begin -->
        <%@include file="footer.jsp"%>
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



</html>