<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>我的订单 - Mobile Shop</title>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Mobile Shop</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="/css/style.css">


    <!-- Custom Fonts -->
    <link rel="stylesheet" href="/font-awesome/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="/fonts/font-slider.css" type="text/css">

    <!-- jQuery and Modernizr-->
    <script src="/js/jquery-2.1.1.js"></script>

    <!-- Core JavaScript Files -->
    <script src="/js/bootstrap.min.js"></script>
    <style type="text/css">
        .order-item{
            border: 1px #cccccc solid;
            margin-bottom: 20px;
        }
        .item-header{
            background: #f5f5f5;
            height: 36px;
        }
        .item-header span{
            line-height: 36px;
            padding-left: 30px;
        }
    </style>
</head>
<body>
<%@ include file="_common_header_nav.jsp" %>
<div id="page-content" class="single-page">
    <div class="container">
        <div class="row">
            <div id="sidebar" class="col-md-2">
                <div class="widget wid-categories">
                    <div class="heading"><h4>个人中心</h4></div>
                    <div class="content">
                        <ul>
                            <li><a href="/profile">个人资料</a></li>
                            <li><a href="/address">收货地址</a></li>
                            <li><a href="/order">我的订单</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-10">
                <h3>订单列表</h3>
                <div class="row">
                    <c:forEach items="${requestScope.orderItems}" var="orderItem">
                        <div class="order-item">
                            <div class="item-header">
                                <span>下单时间：${orderItem.createTime}</span>
                                <span>订单号：${orderItem.id}</span>
                            </div>
                            <table class="table" style="margin-bottom: 0">
                                <tbody>
                                <c:forEach items="${orderItem.products}" var="product" varStatus="status">
                                    <tr>
                                        <td style="width: 70px">
                                                <%--<img class="img-thumbnail" style="padding: 2px" src="${product.imgUrl}?imageView2/1/w/50/h/50/q/75|imageslim" alt="">--%>
                                            <img class="img-thumbnail" style="padding: 2px" src="/images/${product.imgUrl}" alt="">
                                        </td>
                                        <td style="width: 420px"><a href="/product/${product.pid}">${product.name}</a></td>
                                        <td>${product.quantity}</td>
                                        <td>${product.price}</td>
                                        <c:if test="${status.count == 1}">
                                            <td style="vertical-align: middle;border-left: 1px #ddd solid" rowspan="${fn:length(orderItem.products)}">${orderItem.address.name} <br>${orderItem.address.tel}
                                                <br>${orderItem.address.addr}</td>
                                            <td style="vertical-align: middle;border-left: 1px #ddd solid" rowspan="${fn:length(orderItem.products)}">总金额：<br>${orderItem.totalPrice} </td>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<footer>
    <div class="container">
        <div class="wrap-footer">
            <div class="row">
                <div class="col-md-3 col-footer footer-1">
                    <img src="/images/logofooter.png" />
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                </div>
                <div class="col-md-3 col-footer footer-2">
                    <div class="heading"><h4>Customer Service</h4></div>
                    <ul>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Delivery Information</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Terms & Conditions</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
                </div>
                <div class="col-md-3 col-footer footer-3">
                    <div class="heading"><h4>My Account</h4></div>
                    <ul>
                        <li><a href="#">My Account</a></li>
                        <li><a href="#">Brands</a></li>
                        <li><a href="#">Gift Vouchers</a></li>
                        <li><a href="#">Specials</a></li>
                        <li><a href="#">Site Map</a></li>
                    </ul>
                </div>
                <div class="col-md-3 col-footer footer-4">
                    <div class="heading"><h4>Contact Us</h4></div>
                    <ul>
                        <li><span class="glyphicon glyphicon-home"></span>California, United States 3000009</li>
                        <li><span class="glyphicon glyphicon-earphone"></span>+91 8866888111</li>
                        <li><span class="glyphicon glyphicon-envelope"></span>infor@yoursite.com</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="copyright">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://www.cssmoban.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
                </div>
                <div class="col-md-6">
                    <div class="pull-right">
                        <ul>
                            <li><img src="/images/visa-curved-32px.png" /></li>
                            <li><img src="/images/paypal-curved-32px.png" /></li>
                            <li><img src="/images/discover-curved-32px.png" /></li>
                            <li><img src="/images/maestro-curved-32px.png" /></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
</body>
</html>
