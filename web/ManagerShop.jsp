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
                                 <li><a href="Bill">Bill Manager</a></li>
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
                                <span>Manager Products</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Shopping Cart Section Begin -->
        <style>
            .product__cart__item__pic img {
                width: 50px;
                height: auto;
            }

            .product__cart__item__text h6 {
                margin: 0;
                font-size: 16px;
                font-weight: normal;
            }

            .product__cart__item__text h5 {
                margin: 0;
                font-size: 14px;
                color: #888;
            }
        </style>
        <div class="container mt-5">
            <div class="row">
                <!-- Button to Open the Modal -->
                <div class="col-lg-6">
                    <div class="col-lg-6">    
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal" > Add Product </button>
                    </div> 
               
                </div>
                <!-- Search Form Begin -->
                <div class="col-lg-6">
                    <form action="URLManagerProducts" method="post" class="form-inline float-right">
                        <input class="form-control mr-sm-2" type="text" name="name" placeholder="Search...">
                        <button  type="submit" name="submit">Search</button>
                        <input type="hidden" name="service" value="listProduct">
                    </form>
                </div>
                <!-- Search Form End -->
            </div>

            <!-- The Modal -->
            <div class="modal" id="addModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Add New Product</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <!-- Modal Body -->
                        
                        
                        <div class="modal-body">
                            <form action="URLManagerProducts" method="post"  >   
                                <div>
                                    <label >Product Name</label>
                                    <input type="text"  name="productName" class="form-control" >
                                </div>
                                
                                <div class="form-group">
                                    <label >Year</label>
                                    <input type="text"  name="yearofproducts"  class="form-control" >
                                </div>
                                
                                <div class="form-group">
                                    <label >Image</label>
                                    <input type="file"  name="img"  class="form-control" >
                                </div>
                                
                                <div class="form-group">
                                    <label >Price</label>
                                    <input type="text"   name="price" class="form-control">
                                </div>
                                
                                <div class="form-group">
                                    <label >Describe</label>
                                    <input type="text"  name="describe"  class="form-control" >
                                </div>
                                
                                <div class="form-group">
                                    <label >Quantity</label>
                                    <input type="text" name="quantity" class="form-control">
                                </div>
                                
                                <div class="form-group">
                                    <label>CategoryID</label>
                                   <select name="categoryID" >
                                        <c:forEach items="${listC}" var="o">
                                            <option value="${o.getCategoryID()}">${o.getNameCategory()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                
                                <div class="form-group">
                                    <label>Brand</label>
                                    <select name="brandID" >
                                        <c:forEach items="${listB}" var="o">
                                            <option value="${o.getBrandID()}">${o.getBrandName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                
                                <button type="submit" name="submit"  class="btn btn-primary">Add Product</button>
                                <input type="hidden" name="service" value="insert">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- jQuery, Popper.js, and Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <div style="margin-top: 50px;" class="container">
            <table class="table table-hover table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">ProductId</th>
                        <th scope="col">Product</th>
                        <th scope="col">Product Name</th>
                        <th scope="col">Price</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Year</th>
                        <th scope="col">Update</th>
                        <th scope="col">Remove</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${managerProducts}" var="o">
                        <tr>
                            <td>${o.getProductID()}</td>
                            <td class="product__cart__item">
                                <div class="d-flex align-items-center">
                                    <div class="product__cart__item__pic">
                                        <img src="img/mauhang/${o.getImg()}" alt="">
                                    </div>
                                </div>
                            </td>
                            <td>${o.getProductName()}</td>
                            <td>${o.getPrice()}$</td>
                            <td>${o.getQuantity()}</td>
                            <td>${o.getYearofproducts()}</td>
                            <td>
                                <a href="URLManagerProducts?service=update&productId=${o.getProductID()}">
                                    <span class="icon icon_pencil"></span>
                                   </a> 
                                </td>
                            <td>
                                <a href="URLManagerProducts?service=delete&prdoductID=${o.getProductID()}">
                                <span class="icon icon_trash"></span>
                                </a>
                                </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="continue__btn">
                        <a href="URLListProducts">Continue Shopping</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Shopping Cart Section End -->

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
