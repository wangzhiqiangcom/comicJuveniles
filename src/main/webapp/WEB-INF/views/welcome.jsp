<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/8/17
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>首页</title>
    <%--将页面基础路径放在请求域中--%>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <%
        String basePath = request.getScheme()
                            + "://"
                            + request.getServerName()
                            + ":"
                            + request.getServerPort()
                            + request.getContextPath()
                            + "/";
        pageContext.setAttribute("basePath",basePath);
    %>
    <!-- <link href="static/bootstrap-4.6.0-dist/css/bootstrap.min.css" rel="stylesheet">
      <script type="text/javascript" src="static/jQuery/jquery.min.js"></script>
      <script type="text/javascript" src="static/bootstrap-4.6.0-dist/js/bootstrap.bundle.min.js"></script>
      <script type="text/javascript" src="static/bootstrap-4.6.0-dist/js/bootstrap.min.js"></script> -->

    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style>

        .swiper-container {
            margin-top: 120px;
            width: 1140px;
            height: 500px;
            overflow: hidden;
        }

        .carousel-inner img {
            width: 1140px;
            height: 500px;
        }

        .card-col {
            background-color: rgb(52,58,64);
            /* border: 1px red solid; */
            display: flex;
            justify-content: center;
        }

        .row {
            margin-right: 0px;
            margin-left: 0px;
        }

        .nav-bottom {
            display: flex;
            justify-content: center;
        }
        span.blank{
            width: 50px;
        }
    </style>

    <%--<script>--%>
        <%--$(function () {--%>
            <%--console.log("${APP_PATH}");--%>
            <%--console.log("${basePath}");--%>
        <%--});--%>
    <%--</script>--%>

</head>

<body>
<%@include file="common/header.jsp"%>

<div class="container swiper-container">
    <div id="demo" class="carousel slide" data-ride="carousel" data-interval="3000">

        <!-- 指示符 -->
        <ul class="carousel-indicators">
            <li data-target="#demo" data-slide-to="0" class="active"></li>
            <li data-target="#demo" data-slide-to="1"></li>
            <li data-target="#demo" data-slide-to="2"></li>
            <li data-target="#demo" data-slide-to="3"></li>
            <li data-target="#demo" data-slide-to="4"></li>
        </ul>

        <%--<!-- 轮播图片 -->--%>
        <div class="carousel-inner">




            <!-- 左右切换按钮 -->
            <a href="#demo" class="carousel-control-prev" data-slide="prev">
                <span class="carousel-control-prev-icon"></span>
            </a>
            <a href="#demo" class="carousel-control-next" data-slide="next">
                <span class="carousel-control-next-icon"></span>
            </a>

            <c:forEach items="${requestScope.swipers}" var="swiper">
                <c:if test="${swiper.swiperId == 1}">
                    <div class="carousel-item active"><img src="${swiper.swiperUrl}"></div>
                </c:if>
                <c:if test="${swiper.swiperId != 1}">
                    <div class="carousel-item"><img src="${swiper.swiperUrl}"></div>
                </c:if>
            </c:forEach>

        </div>
    </div>
</div>

<div class="container">
    <h4>近期热门</h4>
    <div>${requestScope.username}</div>

    <div class="row">

        <c:forEach items="${requestScope.hots}" var="hot">
            <div class="col col-md-6 card-col" style="margin-bottom: 50px">
                <div class="card" style="width:500px;height: 380px;">
                    <img class="card-img-top" src="${hot.swiperUrl}" alt="Card image"
                         style="width:500px;height: 300px;">
                    <div class="card-body">
                        <h4 class="card-title">《${hot.swiperName}》</h4>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>
</div>

<%@include file="common/footer.jsp"%>

<br><br><br>
</body>

</html>
