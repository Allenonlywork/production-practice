<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>订单结算页 - Mobile Shop</title>
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
        .address-item{
            cursor: pointer;
        }
    </style>

</head>

<body>
<%@ include file="_common_header_nav.jsp" %>
<!--//////////////////////////////////////////////////-->
<!--///////////////////Contact Page///////////////////-->
<!--//////////////////////////////////////////////////-->
<div id="page-content" class="single-page">
    <div class="container">
        <h5>填写并提交订单信息</h5>
        <div class="row">
            <table class="table table-striped table-hover">
                <caption class="text-left">确认收货地址</caption>
                <thead>
                <tr>
                    <th></th>
                    <th>收件人</th>
                    <th>电话</th>
                    <th>详细地址</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr class="address-item">
                    <td><input type="radio" name="address" value="1" checked></td>
                    <td>XXXXX</td>
                    <td>534789694624</td>
                    <td>XXXXXXXXXXXXXXXXXXXXXXXXXXX</td>
                    <td>默认地址</td>
                </tr>
                <tr class="address-item">
                    <td><input type="radio" name="address" value="2" checked></td>
                    <td>XXXXX</td>
                    <td>534789694624</td>
                    <td>XXXXXXXXXXXXXXXXXXXXXXXXXXX</td>
                    <td></td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="row">
            <table class="table table-striped table-hover">
                <caption class="text-left">确认订单信息</caption>
                <thead>
                <tr>
                    <th colspan="2">商品信息</th>
                    <th>类型</th>
                    <th>品牌</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>小计</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td style="width: 70px"><img class="img-thumbnail" style="padding: 2px" src="/images/5a0bbcc9N73ee46d2.jpg" alt=""></td>
                    <td style="width: 420px">XXXXXXXXXXXXXXXXXXXXXX</td>
                    <td>XXXXXX</td>
                    <td>XXXXXX</td>
                    <td>￥XXX</td>
                    <td>2</td>
                    <td>￥XXXX</td>
                </tr>
                <tr>
                    <td style="width: 70px"><img class="img-thumbnail" style="padding: 2px" src="/images/59ffd41dN90ac91a2.jpg" alt=""></td>
                    <td style="width: 420px">XXXXXXXXXXXXXXXXXXXXXX</td>
                    <td>XXXXXX</td>
                    <td>XXXXXX</td>
                    <td>￥XXX</td>
                    <td>2</td>
                    <td>￥XXXX</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="row pull-right">
            <p class="text-right">3件商品 需付款：<span style="font-size: 42px;font-weight: bold">￥35444</span></p>
            <p id="address" class="text-right help-block " style="font-size: 14px">寄送至：XXXXXXXXXXXXX，收货人：XXXXXXXX XXXXXXXXXX</p>
            <a href="javascript:void(0)" id="submit-order" class="btn btn-1 pull-right">提交订单</a>
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
