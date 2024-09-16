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
        <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap" rel="stylesheet">

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
        <!-- Page Preloader -->

        <!-- Header Section Begin -->
        <header class="header">
            <div class="header__top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6 col-md-7">
                            <div class="header__top__left">
                                <p>Free shipping, 30-day return or refund guarantee.</p>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-5">
                            <div class="header__top__right">
                                <div class="header__top__links">
                                    <c:if test="${sessionScope.acc == null}">
                                        <a href="URLloginController?service=login">Sign in</a>
                                    </c:if>
                                    <c:if test="${sessionScope.acc != null}">
                                        <a href="URLloginController?service=logout">Logout</a>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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
                                <li><a href="URLListProducts">Shop</a></li>
                                <li class="active"><a href="URLManagerProducts">Manager Products</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </header>
        <!-- Header Section End -->

        <!-- Breadcrumb Section Begin -->
        <section class="breadcrumb-option">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="breadcrumb__text">
                            <h4>Manager Products</h4>
                            <div class="breadcrumb__links">
                                <a href="homee">Home</a>
                                <a href="URLListProducts">Shop</a>
                                <span>Update</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <div class="container mt-5">
            <h2 class="mb-4">Update Information Poducts</h2>
        <c:forEach items="${managerProducts}" var="o">
            <form action="URLManagerProducts" method="post">
               <div class="form-group">
                    <label >ProductID</label>
                    <input type="text"  name="prdoductID" value="${o.getProductID()}" class="form-control" >
                </div>
                
                <div class="form-group">
                    <label >Product Name</label>
                    <input type="text"  name="productName" value="${o.getProductName()}" class="form-control" >
                </div>
                
                <div class="form-group">
                    <label >Year</label>
                    <input type="text"  name="yearofproducts" value="${o.getYearofproducts()}" class="form-control" >
                </div>
                
                <div class="form-group">
                    <label >Image</label>
                    <input type="text"  name="img"  value="${o.getImg()}"  class="form-control" >
                </div>
                <div class="form-group">
                    <label >Price</label>
                    <input type="text"   name="price"  value="${o.getPrice()}" class="form-control">
                </div>

                <div class="form-group">
                    <label >Describe</label>
                    <input type="text"  name="describe"  value="${o.getDescribe()}" class="form-control" >
                </div>

                <div class="form-group">
                    <label >Quantity</label>
                    <input type="text" name="quantity"  value="${o.getQuantity()}" class="form-control">
                </div>

                <div class="form-group">
                    <label>CategoryID</label>
                    <select name="categoryID" >
                        <c:forEach items="${listC}" var="k">
                            <option value="${k.getCategoryID()}" ${o.getCategoryID() == k.getCategoryID() ? "selected" : ""}> ${k.getNameCategory()}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label>Brand</label>
                    <select name="brandID" >
                        <c:forEach items="${listB}" var="k">
                            <option value="${k.getBrandID()}" ${o.getBrandID() == k.getBrandID() ? "selected" : ""}>${k.getBrandName()}</option>
                        </c:forEach>
                    </select>
                </div>

                <input type="submit" name="submit" class="btn btn-primary" value="Update">
                <input type="hidden" name="service" value="update">
            </form>
                </c:forEach>
        </div>
              
        <!-- Bootstrap JS and dependencies -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        <!-- Footer Section Begin -->
        <!-- Footer Section End -->

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
