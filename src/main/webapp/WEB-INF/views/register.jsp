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

        //?????????????????????????????????
        function checkRegister() {
            checkUsername();
            checkPassword();
            checkEmail();
            function checkUsername() {
                $("#username").change(function () {
                    var username = $("#username").val();
                    var regUsername = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
                    if(!regUsername.test(username)){
                        show_validate_msg("??????????????????2-5???????????????6-16?????????????????????????????????");
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
                        show_validate_msg("???????????????6-12???????????????????????????");
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
                        show_validate_msg("????????????????????????");
                        return false;
                    }else{
                        checkPassword();
                    }
                });
            }

        }


        //???????????????????????????????????????
        function clickCheckForm() {

            clickCheckUsername();
            clickCheckPasswod();
            clickCheckEmail();
            function clickCheckUsername() {
                var username = $("#username").val();
                var regUsername = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
                if(!regUsername.test(username)){
                    show_validate_msg("??????????????????2-5???????????????6-16?????????????????????????????????");
                    return false;
                }else{
                    show_validate_msg("");
                }
            }

            function clickCheckPasswod() {
                var password = $("#password").val();
                var regPassword = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/;
                if(!regPassword.test(password)){
                    show_validate_msg("???????????????6-12???????????????????????????");
                    return false;
                }else{
                    clickCheckUsername();
                }
            }

            function clickCheckEmail() {
                var email = $("#email").val();
                var regEmail = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
                if(!regEmail.test(email)){
                    show_validate_msg("????????????????????????");
                    return false;
                }else{
                    clickCheckPasswod();
                }
            }
        }

        //????????????????????????
        function show_validate_msg(error) {
            $(".errorMsg").text(error);
        }

        //??????????????????????????????????????????
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

        //??????????????????????????????????????????????????????
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
            <label for="" class="col-md-1 offset-md-4">????????????</label>
            <input id="username" name="userName" type="text" class="col-md-2" placeholder="username">
        </div>
        <div class="blank"></div>
        <div class="row">
            <label for="" class="col-md-1 offset-md-4">???&nbsp;&nbsp;&nbsp;&nbsp;??????</label>
            <input id="password" name="password" type="password" class="col-md-2" placeholder="password">
        </div>
        <div class="blank"></div>

        <div class="row">
            <label for="" class="col-md-1 offset-md-4">???&nbsp;&nbsp;&nbsp;&nbsp;??????</label>
            <select id="gender" name="gender">
                <option>???</option>
                <option>???</option>
            </select>
        </div>
        <div class="blank"></div>
        <div class="row">
            <label for="" class="col-md-1 offset-md-4">???&nbsp;&nbsp;&nbsp;&nbsp;??????</label>
            <input id="email" name="email" type="text" class="col-md-2" placeholder="email">
        </div>
        <div class="blank"> </div>
        <%--<div class="row">--%>
            <%--<label for="" class="col-md-1 offset-md-4">????????????</label>--%>
            <%--<input id="code" type="text" class="col-md-1" placeholder="code">--%>
            <%--<img src="" alt="">--%>
        <%--</div>--%>
        <%--<div class="blank"></div>--%>
        <%--<div class="row">--%>
            <%--<label for="" class="col-md-2 offset-md-4">??????????????????</label>--%>
            <%--<input id="emailCode" type="text" class="emailCode" placeholder="emailCode">--%>
        <%--</div>--%>
        <%--<div class="blank"></div>--%>
        <div class="row">
            <div class="col-md-2 offset-md-4">
                <button id="registerBtn" type="button" class="btn btn-success registerBtn">???&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;???</button>
            </div>
        </div>
    </form>
</div>

<%@include file="common/footer.jsp"%>
</body>

</html>
