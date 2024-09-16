<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Admin Dashboard</title>

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
    <%@include file="header.jsp" %>

    <!-- Header Section Begin -->
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
                        <li class="active"><a href="homee">Home</a></li>
                        <li><a href="URLListProducts">Shop</a></li>
                        <c:if test="${sessionScope.acc != null && sessionScope.acc.isAdmin == 1 }">
                            <li><a href="ManagerShop.jsp">Manager Products</a></li>
                        </c:if>
                        <c:if test="${ sessionScope.acc.isAdmin == 0 }">
                            <li><a href="./shopping-cart.html">Shopping Cart</a></li>
                            <li><a href="./checkout.html">Check Out</a></li>
                            <li><a href="./contact.html">Contacts</a></li>
                        </c:if>
                        <li><a href="./contact.html">Contacts</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
    <section class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__text">
                        <h4>Shop</h4>
                        <div class="breadcrumb__links">
                            <a href="./index.html">Home</a>
                            <span>Shop</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Header Section End -->

    <!-- Dashboard Overview Section Begin -->
    <section class="dashboard-overview spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="overview-item">
                        <h4>Total Users</h4>
                        <h2>1,234</h2>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="overview-item">
                        <h4>Total Products</h4>
                        <h2>567</h2>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="overview-item">
                        <h4>Total Orders</h4>
                        <h2>890</h2>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="overview-item">
                        <h4>Total Revenue</h4>
                        <h2>$12,345</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Dashboard Overview Section End -->

    <!-- Chart Section Begin -->
    <section class="chart-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-12 mb-4">
                    <h3>Sales Distribution</h3>
                    <canvas id="salesPieChart"></canvas>
                </div>
                <div class="col-lg-6 col-md-12 mb-4">
                    <h3>Category Distribution</h3>
                    <canvas id="categoryPieChart"></canvas>
                </div>
                <div class="col-lg-12">
                    <h3>Monthly Sales Data</h3>
                    <canvas id="salesChart"></canvas>
                </div>
            </div>
        </div>
    </section>
    <!-- Chart Section End -->

    <!-- Top Products Section Begin -->
    <section class="top-products spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h3>Top Products</h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Rank</th>
                                <th>Product</th>
                                <th>Sales</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>Product A</td>
                                <td>500</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Product B</td>
                                <td>450</td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>Product C</td>
                                <td>400</td>
                            </tr>
                            <tr>
                                <td>4</td>
                                <td>Product D</td>
                                <td>350</td>
                            </tr>
                            <tr>
                                <td>5</td>
                                <td>Product E</td>
                                <td>300</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
    <!-- Top Products Section End -->

    <!-- Footer Section Begin -->
    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="footer__copyright__text">
                        <p>Copyright © 2024 All rights reserved | This template is made with <i class="fa fa-heart-o"
                                aria-hidden="true"></i> by <a href="#" target="_blank">Your Company</a></p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
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
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
        // Bar Chart
        const ctxBar = document.getElementById('salesChart').getContext('2d');
        const salesChart = new Chart(ctxBar, {
            type: 'bar',
            data: {
                labels: ['January', 'February', 'March', 'April', 'May', 'June'],
                datasets: [{
                    label: 'Sales',
                    data: [1200, 1900, 3000, 5000, 2400, 3200],
                    backgroundColor: 'rgba(54, 162, 235, 0.2)',
                    borderColor: 'rgba(54, 162, 235, 1)',
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });

        // Pie Chart for Sales Distribution
        const ctxPie = document.getElementById('salesPieChart').getContext('2d');
        const salesPieChart = new Chart(ctxPie, {
            type: 'pie',
            data: {
                labels: ['Electronics', 'Fashion', 'Home & Kitchen', 'Books', 'Other'],
                datasets: [{
                    label: 'Sales Distribution',
                    data: [3000, 5000, 2000, 1500, 800],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        display: true,
                        position: 'top'
                    }
                }
            }
        });

        // Additional Pie Chart for Category Distribution
        const ctxCategoryPie = document.getElementById('categoryPieChart').getContext('2d');
        const categoryPieChart = new Chart(ctxCategoryPie, {
            type: 'pie',
            data: {
                labels: ['Category A', 'Category B', 'Category C', 'Category D'],
                datasets: [{
                    label: 'Category Distribution',
                    data: [4000, 3000, 2000, 1000],
                    backgroundColor: [
                        'rgba(255, 159, 64, 0.2)',
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(75, 192, 192, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 159, 64, 1)',
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(75, 192, 192, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        display: true,
                        position: 'top'
                    }
                }
            }
        });
    </script>
</body>

</html>
