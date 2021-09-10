<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/8/21
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style>

        .container-input{
            margin-top: 100px;
            /* background-color: antiquewhite; */

        }
        .errorMsg{
            color: red;
        }
        label,input,button{
            font-size: 15px;
            font-weight: 800;
            color: black;
        }
        div.blank{
            height: 30px;
        }
        .btn-login{

            width: 270px;
        }
        input,button{
            border: 3px black solid;
            border-radius: 10px;
            background-color: transparent;
        }

        label{
            color: black;
        }
        .emailcode{
            margin-left: -70px;
            width: 100px;
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
            checkUsernameIsExit();
            checkRegister();

            $("#registerBtn").click(function () {
                // var checkResult = false;
                checkRegister();
                // clickCheckUsernameIsExit();
                var checkResult = $(".errorMsg").is(":empty");
                if(checkResult){
                    $.ajax({
                        url:"${APP_PATH}/insertUser",
                        type:"post",
                        data:$("#registerForm").serialize(),
                        success:function (result) {
                            checkResult = false;
                            alert(result.extend.registerResult);
                            $(location).attr("href","${APP_PATH}/login");

                        }
                    });
                }
            });

        });

        //函数：前端验证注册信息
        function checkRegister() {
            checkUsername();
            checkPassword();
            checkEmail();
            function checkUsername() {
                $("#username").change(function () {
                    var username = $("#username").val();
                    var regUsername = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
                    if(!regUsername.test(username)){
                        show_validate_msg("用户名必须是2-5位中文或者6-16位英文和数字的组合！！");
                        return false;
                    }else{
                        show_validate_msg("");
                    }
                });
            }

            function checkPassword() {
                $("#password").change(function () {
                    var password = $("#password").val();
                    var regPassword = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/;
                    if(!regPassword.test(password)){
                        show_validate_msg("密码必须是6-12为数字和字母组合！");
                        return false;
                    }else{
                        checkUsername();
                    }
                });
            }


            function checkEmail() {
                $("#email").change(function () {
                    var email = $("#email").val();
                    var regEmail = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
                    if(!regEmail.test(email)){
                        show_validate_msg("邮箱格式不正确！");
                        return false;
                    }else{
                        checkPassword();
                    }
                });
            }

        }


        //函数：点击注册再次校验表单
        function clickCheckForm() {

            clickCheckUsername();
            clickCheckPasswod();
            clickCheckEmail();
            function clickCheckUsername() {
                var username = $("#username").val();
                var regUsername = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
                if(!regUsername.test(username)){
                    show_validate_msg("用户名必须是2-5位中文或者6-16位英文和数字的组合！！");
                    return false;
                }else{
                    show_validate_msg("");
                }
            }

            function clickCheckPasswod() {
                var password = $("#password").val();
                var regPassword = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/;
                if(!regPassword.test(password)){
                    show_validate_msg("密码必须是6-12为数字和字母组合！");
                    return false;
                }else{
                    clickCheckUsername();
                }
            }

            function clickCheckEmail() {
                var email = $("#email").val();
                var regEmail = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
                if(!regEmail.test(email)){
                    show_validate_msg("邮箱格式不正确！");
                    return false;
                }else{
                    clickCheckPasswod();
                }
            }
        }

        //函数显示检验信息
        function show_validate_msg(error) {
            $(".errorMsg").text(error);
        }

        //函数：查询用户名是否已经存在
        function checkUsernameIsExit() {
            $("#username").blur(function () {
                $.ajax({
                    url:"${APP_PATH}/checkUsername",
                    data:"username=" + $("#username").val(),
                    success:function (result) {
                        console.log(result);
                        show_validate_msg(result.extend.selectResult);
                        // checkRegister();
                    }
                })

            });
        }

        //函数：点击注册再次校验用户名是否重复
        function clickCheckUsernameIsExit() {
            $.ajax({
                url:"${APP_PATH}/checkUsername",
                data:"username=" + $("#username").val(),
                success:function (result) {
                    console.log(result);
                    show_validate_msg(result.extend.selectResult);
                    // checkRegister();
                }
            })
        }

    </script>
</head>

<body>
<%@include file="common/header.jsp"%>
<div class="container container-input">
    <div class="row">
        <span class="col-md-2 offset-md-5 errorMsg"></span>
    </div>
    <div class="blank"></div>
    <form id="registerForm">
        <div class="row">
            <label for="" class="col-md-1 offset-md-4">用户名：</label>
            <input id="username" name="userName" type="text" class="col-md-2" placeholder="username">
        </div>
        <div class="blank"></div>
        <div class="row">
            <label for="" class="col-md-1 offset-md-4">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
            <input id="password" name="password" type="password" class="col-md-2" placeholder="password">
        </div>
        <div class="blank"></div>

        <div class="row">
            <label for="" class="col-md-1 offset-md-4">性&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
            <select id="gender" name="gender">
                <option>男</option>
                <option>女</option>
            </select>
        </div>
        <div class="blank"></div>
        <div class="row">
            <label for="" class="col-md-1 offset-md-4">邮&nbsp;&nbsp;&nbsp;&nbsp;箱：</label>
            <input id="email" name="email" type="text" class="col-md-2" placeholder="email">
        </div>
        <div class="blank"> </div>
        <%--<div class="row">--%>
            <%--<label for="" class="col-md-1 offset-md-4">验证码：</label>--%>
            <%--<input id="code" type="text" class="col-md-1" placeholder="code">--%>
            <%--<img src="" alt="">--%>
        <%--</div>--%>
        <%--<div class="blank"></div>--%>
        <%--<div class="row">--%>
            <%--<label for="" class="col-md-2 offset-md-4">邮箱验证码：</label>--%>
            <%--<input id="emailCode" type="text" class="emailCode" placeholder="emailCode">--%>
        <%--</div>--%>
        <%--<div class="blank"></div>--%>
        <div class="row">
            <div class="col-md-2 offset-md-4">
                <button id="registerBtn" type="button" class="btn btn-success registerBtn">注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;册</button>
            </div>
        </div>
    </form>
</div>

<%@include file="common/footer.jsp"%>
</body>

</html>
