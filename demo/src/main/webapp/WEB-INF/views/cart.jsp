<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Mobile Shop</title>

	<!-- Bootstrap Core CSS -->
	<link rel="stylesheet" href="css/bootstrap.min.css"  type="text/css">

	<!-- Custom CSS -->
	<link rel="stylesheet" href="css/style.css">


	<!-- Custom Fonts -->
	<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"  type="text/css">
	<link rel="stylesheet" href="fonts/font-slider.css" type="text/css">

	<!-- jQuery and Modernizr-->
	<script src="js/jquery-2.1.1.js"></script>

	<!-- Core JavaScript Files -->
	<script src="js/bootstrap.min.js"></script>

	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
<%@include file="_common_header_nav.jsp"%>
<!--//////////////////////////////////////////////////-->
<!--///////////////////Cart Page//////////////////////-->
<!--//////////////////////////////////////////////////-->
<div id="page-content" class="single-page">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<ul class="breadcrumb">
					<li><a href="index">Home</a></li>
					<li><a href="cart">Cart</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<c:forEach items="${requestScope.productInCarts}" var="productInCart">
				<div class="product well">
					<div class="col-md-3">
						<div class="image">
							<img src="/images/${productInCart.imgUrl}" />
						</div>
					</div>
					<div class="col-md-9">
						<div class="caption">
							<div class="name"><h3><a href="/product/${productInCart.pid}">${productInCart.name}</a></h3></div>
							<div class="info">
								<ul>
									<li>品牌: <a href="/list?bid=${productInCart.brand.bid}">${productInCart.brand.name}</a></li>
									<li>ID: ${productInCart.pid}</li>
								</ul>
							</div>
							<div class="price">${productInCart.price}<span>${productInCart.originalPrice}</span></div>
							<form action="/updateQuantity">
								<label>数量: </label>
								<input class="form-inline quantity" name="quantity" type="text" value="${productInCart.quantity}">
								<input type="hidden" name="pid" value="${productInCart.pid}">
									<%--<a href="#" class="btn btn-2 ">Update</a>--%>
								<button type="submit">Update</button>
							</form>
							<hr>
							<a href="/delete?pid=${productInCart.pid}" class="btn btn-default pull-right">删除</a>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</c:forEach>

		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-8 ">
				<center><a href="#" class="btn btn-1">Continue To Shopping</a></center>
			</div>
		</div>
		<form action="/checkout">
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
					<c:forEach items="${requestScope.addresses}" var="address">
						<tr class="address-item">
							<td><input type="radio" name="aid" value="${address.aid}" <c:if test="${address.isDefault == 1}">checked</c:if>></td>
							<td>${address.name}</td>
							<td>${address.tel}</td>
							<td>${address.addr}</td>
							<td><c:if test="${address.isDefault == 1}">默认地址</c:if></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<%--价格信息--%>
			<div class="row">
				<div class="pricedetails">
					<div class="col-md-4 col-md-offset-8">
						<table>
							<h6>价格明细</h6>
							<tr>
								<td>总数量</td>
								<td>${requestScope.cartDetail.totalCount}</td>
							</tr>
							<tr style="border-top: 1px solid #333">
								<td><h5>总价</h5></td>
								<td>${requestScope.cartDetail.totalPrice}</td>
							</tr>
						</table>
						<%--<center><a href="#" class="btn btn-1">Checkout</a></center>--%>
						<button type="submit">Checkout</button>
					</div>
				</div>
			</div>
		</form>
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
