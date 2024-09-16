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
    <!-- Header Section Begin -->
    <%@include file="header.jsp" %>
    <!-- Header Section End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__text">
                        <h4>Check Out</h4>
                        <div class="breadcrumb__links">
                            <a href="homee">Home</a>
                            
                            <span>Check Out</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
            <div class="checkout__form">
                <form action="Cart" method="post">
                    <div class="row">
                        <div class="col-lg-6 col-md-6">
                            
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Full Name<span>*</span></p>
                                        <input type="text" readonly="" value="${acc.getFullname()}">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Phone<span>*</span></p>
                                        <input type="text" readonly="" value="${acc.getPhone()}">
                                    </div>
                                </div>
                            </div>
                            <div class="checkout__input">
                                <p>Email<span>*</span></p>
                                <input type="text" readonly="" value="${acc.getEmail()}">
                            </div>   
                           
                        </div>
                        
                        
                        <div class="col-lg-6 col-md-6">                    
                         <div class="container">
                            
                
                    
                    <div class="checkout__order">
                        <h4 class="order__title">Order</h4>
                        <div class="checkout__order__products">Product</div>
                                     <%
                                         double total = 0;
                Enumeration enu = session.getAttributeNames(); //getKeys
                while(enu.hasMoreElements()){
                    String productID = (String) enu.nextElement();
                    Products product;
                    if(!productID.equals("acc")){
                product = (Products) session.getAttribute(productID);
                    %>
                    
                        <ul class="checkout__total__products">
                            <li><%=product.getProductName()%> - Quantity: <%=product.getQuantity()%> -  Price: <%=product.getPrice()%></li>
                            <li>Total: <%=product.getQuantity() * product.getPrice() %></li>
                            <%total += product.getQuantity() * product.getPrice();%>
                        </ul>
                             <%}}%>
                        <ul class="checkout__total__all">
                            <li>Total: <%=total%></li>
                        </ul>
                       
                            <button type="submit" name="submit" class="site-btn" >PLACE ORDER</button>
                            <input type="hidden" name="service" value="checkout">
                      
                    </div>
                   
                </div>
        </div>
                        </div>
                </form>
                    </div>
            </div>
    </section>
    <!-- Checkout Section End -->

    <!-- Footer Section Begin -->
    
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