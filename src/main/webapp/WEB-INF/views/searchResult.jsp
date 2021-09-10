<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/8/17
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>searchResult</title>
    <title>查询结果</title>
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

        .nav-top{
            width: 1140px;
            margin-left: -15px;
        }
        .card-col {
            background-color: #aff2fe;
            display: flex;
            justify-content: center;
            margin-bottom: 30px;
        }
        .nav-bottom {
            display: flex;
            justify-content: center;
            width: 1140px;
            margin-left: -15px;
        }
        span.blank{
            width: 50px;
        }
        
    </style>
</head>
<body>
<%@include file="common/header.jsp"%>
<div class="blank" style="height: 100px;"></div>
<div class="container">
    <div class="row">
        <c:if test="${empty requestScope.searchResult}">
            <h1>没有您搜索的结果，请查询其他关键词</h1>
        </c:if>
        <c:if test="${not empty requestScope.searchResult}">
            <c:forEach items="${requestScope.searchResult}" var="juvenile">
                <div class="col col-md-6 card-col">
                    <div class="card" style="width:400px">
                        <img class="card-img-top" src="${juvenile.portraitUrl}" alt="Card image"
                             style="width:398px; height: 225px;">
                        <div class="card-body">
                            <h4 class="card-title">${juvenile.jName}</h4>
                            <p class="card-text">出自动漫:《${juvenile.getComic().getcName()}》</p>
                            <p class="card-text">性别:${juvenile.gender}</p>
                            <p class="card-text">武器/技能:${juvenile.weapon}</p>
                            <p class="card-text">门派/宗门:${juvenile.sect}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>


    </div>
</div>
<br><br><br>
<%@include file="common/footer.jsp"%>
</body>
</html>
