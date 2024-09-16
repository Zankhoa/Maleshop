<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entity.Orderr,java.sql.ResultSet, Entity.OrderItems, Entity.Account" %>
<!DOCTYPE html>
<html lang="zxx">
<%
    ResultSet rsOrder = (ResultSet) request.getAttribute("rsOrder");
    ResultSet rsCountOrder = (ResultSet) request.getAttribute("rsCountOrder");
     ResultSet rsTotalOrder = (ResultSet) request.getAttribute("rsTotalOrder");
    %>
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
                                 <li><a href="URLManagerProducts">Products Manager</a></li>
                                <li class="active"><a href="Bill">Bill Manager</a></li>
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
                            <h4>Bill Manager</h4>
                            <div class="breadcrumb__links">
                                <a href="homee">Home</a>
                                <a href="URLListProducts">Shop</a>
                                <span>Bill Manager</span>
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
        
       
        <!-- jQuery, Popper.js, and Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <div style="margin-top: 50px;" class="container">
             <%while(rsCountOrder.next()){%>
            <p>Total Bill: <%=rsCountOrder.getInt(1)%></p>
            <%}%>
             <%while(rsTotalOrder.next()){%>
            <p>Total price: <%=rsTotalOrder.getDouble(1)%></p>
              <%}%>
            <table class="table table-hover table-bordered">
                <thead class="thead-dark">
                   <%rsOrder.next();%>
                  
                   <tr>
                        <th scope="col">Bill ID</th>
                        <th scope="col">Customer Name</th>
                        <th scope="col">Date</th>
                        <th scope="col">Total</th>
                        <th scope="col">Status</th>
                        <th scope="col">View</th>
                    </tr>
                </thead>
                <tbody>
                    
                   <%do{%>
                        <tr>
                            <td><%=rsOrder.getInt(1)%></td>
                            <td><%=rsOrder.getString(2)%></td>
                            <td><%=rsOrder.getString(3)%></td>
                            <td><%=rsOrder.getDouble(4)%></td>   
                            <td><%=rsOrder.getString(5)%></td>
                            <td>
                                <a href="Bill?service=orderdetail&OrderID=<%=rsOrder.getInt(1)%>">
                                    <span class="icon icon_pencil"></span>
                                   </a> 
                                </td>
                                
                        </tr>
                  <%}while(rsOrder.next());%>
                     
                </tbody>
            </table>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="continue__btn">
                        <a href="URLListProducts">Return shop</a>
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
