<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/8/21
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>用户登录</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style>
        .container-input {
            margin-top: 250px;
            /* background-color: antiquewhite; */

        }

        .errorMsg {
            color: red;
        }

        label,
        input,
        button {
            font-size: 15px;
            font-weight: 800;
            color: black;
        }

        .blank {
            height: 50px;
        }

        .btn-login {

            width: 270px;
        }

        input,
        button {
            border: 3px black solid;
            border-radius: 10px;
            background-color: transparent;
        }

        label {
            color: black;
        }

        .nav-top{
            width: 1140px;
            margin-left: -15px;
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
    <script type="text/javascript">
        $(function () {
            $("#loginBtn").click(function () {
                $.ajax({
                    url:"${APP_PATH}/loginUser",
                    data:$("#loginForm").serialize(),
                    success:function (result) {
                        var isUsernameExit = result.extend.findResult == "";
                        console.log(isUsernameExit);
                        if(isUsernameExit){
                            $(".errorMsg").text(result.extend.loginResult);
                        }else{
                            $(".errorMsg").text(result.extend.findResult);
                        }
                        var username = result.extend.username;
                        console.log(username);
                        var erro = $(".errorMsg").is(":empty");
                        if(erro){
                            $(location).attr("href","${APP_PATH}/toWelcome?username=" + username);
                        }else{
                            return false;
                        }
                    }
                });
            });
        });
    </script>
</head>

<body>
<%@include file="common/header.jsp"%>
<div class="container container-input">
    <div class="row">
        <span class="col-md-2 offset-md-5 errorMsg"></span>
    </div>
    <div class="blank"></div>
    <form id="loginForm">
        <div class="row">
            <label for="" class="col-md-1 offset-md-4">用户名：</label>
            <input id="username" name="userName" type="text" class="col-md-2" placeholder="username">
        </div>
        <div class="blank"></div>
        <div class="row">
            <label for="" class="col-md-1 offset-md-4">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
            <input id="password" name="password" type="password" class="col-md-2" placeholder="password">
        </div>
    </form>
    <div class="blank"></div>
    <div class="row">
        <div class="col-md-2 offset-md-4">
            <button id="loginBtn" type="button"
                    class="btn btn-success btn-login">登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</button>
        </div>
    </div>
</div>

<%@include file="common/footer.jsp"%>
</body>

</html>