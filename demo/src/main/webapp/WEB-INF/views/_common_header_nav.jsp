<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2018/7/12
  Time: 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Top-->
<nav id="top">
    <div class="container">
        <div class="row">
            <div class="col-xs-6">
                <select class="language">
                    <option value="English" selected>English</option>
                    <option value="France">France</option>
                    <option value="Germany">Germany</option>
                </select>
                <select class="currency">
                    <option value="USD" selected>USD</option>
                    <option value="EUR">EUR</option>
                    <option value="DDD">DDD</option>
                </select>
            </div>
            <div class="col-xs-6">
                <ul class="top-link">
                    <c:if test="${sessionScope.member == null}">
                        <li><a href="/account"><span class="glyphicon glyphicon-user"></span> My Account</a></li>
                    </c:if>
                    <c:if test="${sessionScope.member != null}">
                        <li>${sessionScope.member.name}<a href="/logout"><span class="glyphicon glyphicon-user"></span> 退出</a></li>
                        <li><a href="/order"> 我的订单</a></li>
                    </c:if>
                    <li><a href="/contact"><span class="glyphicon glyphicon-envelope"></span> Contact</a></li>
                </ul>
            </div>
        </div>
    </div>
</nav>
<!--Header-->
<header class="container" style="height: 120px;">
    <div class="row">
        <div class="col-md-4">
            <div id="logo" style="width: 200px;height: 80px;margin-top: -40px"><img src="/images/logo.png" /></div>
        </div>
        <div class="col-md-4">
            <form action="/list" class="form-search">
                <input type="text" name="keyWord" value="${param.keyWord}" class="input-medium search-query">
                <button type="submit" class="btn"><span class="glyphicon glyphicon-search"></span></button>
            </form>
        </div>
        <div class="col-md-4">
            <div id="cart"><a class="btn btn-1" href="/cart"><span class="glyphicon glyphicon-shopping-cart"></span>CART : ${requestScope.cartDetail.totalCount} ITEM</a></div>
        </div>
    </div>
</header>
<!--Navigation-->
<nav id="menu" class="navbar">
    <div class="container">
        <div class="navbar-header"><span id="heading" class="visible-xs">Categories</span>
            <button type="button" class="btn btn-navbar navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse"><i class="fa fa-bars"></i></button>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/index">首页</a></li>
                <c:forEach items="${requestScope.nav}" var="nav">
                    <li class="dropdown"><a href="/list?cid=${nav.cid}" <%--class="dropdown-toggle"--%> <%--data-toggle="dropdown"--%>>${nav.name}</a>
                        <div class="dropdown-menu">
                            <div class="dropdown-inner">
                                <ul class="list-unstyled">
                                    <c:forEach items="${nav.brands}" var="brand" varStatus="status">
                                    <li><a href="/list?cid=${nav.cid}&bid=${brand.bid}">${brand.name}</a></li>
                                    <c:if test="${status.count % 4 == 0}">
                                </ul>
                                <ul class="list-unstyled">
                                    </c:if>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </li>
                </c:forEach>
                <li><a href="/list">全部商品</a></li>
            </ul>
        </div>
    </div>
</nav>
