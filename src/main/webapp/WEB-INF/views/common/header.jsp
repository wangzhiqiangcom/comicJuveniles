<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/8/31
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container fixed-top">
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark  nav-top">
        <!-- Brand/logo -->
        <a class="navbar-brand" href="#">
            <img src="https://ss.im5i.com/2021/08/31/ft6Dw.jpg" alt="logo" style="width:40px;">
        </a>

        <!-- Links -->
        <ul class="navbar navbar-expand-sm bg-dark navbar-dark">
            <li class="nav-item">
                <a class="nav-link" href="toHome">
                    <i class="bi bi-house-door-fill" style="font-size: 20px; color: rgb(232, 235, 240);"></i>
                </a>
            </li>
            <span class="navbar-text">
          动漫人物志
        </span>
            <span class="blank"></span>
            <span class="blank"></span>
            <span class="blank"></span>
            <span class="blank"></span>
            <span class="blank"></span>
            <span class="blank"></span>
            <span class="blank"></span>
            <span class="navbar-text">
              <c:if test="${not empty requestScope.username}">
                  ${requestScope.username}
              </c:if>
                <c:if test="${empty requestScope.username}">
                    未登录
                </c:if>
        </span>


            <span class="blank"></span>
            <li class="nav-item">
                <a class="nav-link" href="login">登录</a>
            </li>
            <span class="blank"></span>
            <li class="nav-item">
                <a class="nav-link" href="register">注册</a>
            </li>
            <span class="blank"></span>
            <li class="nav-item">
                <a class="nav-link" href="getJuveniles">找人物</a>
            </li>
        </ul>
    </nav>

</div>