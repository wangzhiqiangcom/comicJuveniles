<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/8/17
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>list</title>
    <%--将页面基础路径放在请求域中--%>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
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
        .card-col {
            background-color: rgba(243, 235, 235, 0.2);
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
            border-left: 1px rgb(52,58,64) solid;
            border-right: 1px rgb(52,58,64) solid;
        }
        .card:hover{
            box-shadow: rgb(173, 170, 170) 10px 10px 30px 1px;

        }
        span.blank{
            width: 400px;
        }
        div.blank{
            height: 20px;
        }
        .nav-bottom {
            display: flex;
            justify-content: center;
            width: 1140px;
            margin-left: -15px;
        }
        #errorMsg{
            color: red;
        }
    </style>
    <script type="text/javascript">
        var totalRecord,currentPage;
        $(function () {
            $(".page-num").click(function () {
                to_page(this.text);
            });

            $(".page-fist").click(function () {
                to_page(1);
            });

            $(".page-last").click(function () {
                to_page(${requestScope.pageInfo.pages});
            });

            $(".page-previous").click(function () {
                to_page(${requestScope.pageInfo.pageNum - 1});
            });

            $(".page-next").click(function () {
                to_page(${requestScope.pageInfo.pageNum + 1});
            });

            //模糊搜索的功能
            $("#searchBtn").click(function () {
                var text = $("#searchText").val();
                $(location).attr("href","${APP_PATH}/searchJuveniles?text=" + text);
            });

            //打开模态框，获取动漫名称下拉单选框
            $("#openModalBtn").click(function () {
                $("#jName,#weapon,#sect,#portraitUrl").val("");
                $("#errorMsg").empty();
                    $.ajax({
                        url:"${APP_PATH}/getComics",
                        type:"GET",
                        success:function (result) {
                            $("#comic").empty();
                            console.log(result);
                            $.each(result.extend.comics, function (index,comic) {
                                var optionEle = $("<option></option>").append(comic.cName).attr("value",comic.comicId);
                                optionEle.appendTo("#comic");
                            });

                        }
                    });
            });

            //校验表单内容是否合理#jName,#weapon,#sect,#portraitUrl
            checkForm();

            //保存人物信息
            $("#saveBtn").click(function () {
                clickCheckForm();
                var checkResult = $("#errorMsg").is(":empty");
                // console.log($("#errorMsg").is(":empty"));
                // console.log(checkResult)
                if(checkResult){
                    $.ajax({
                        url:"${APP_PATH}/saveJuvenile",
                        type:"POST",
                        data:$("#insertJuvenile").serialize(),
                        success:function (result) {
                            var srlz = $("#insertJuvenile").serialize();
                            console.log(srlz);
                            console.log(result);
                            $("#myModal").modal('hide');
                            to_page(9999);
                        }
                    });
                }else{
                    return false;
                }

            });

            //单个删除
            $(".delSingleBtn").click(function () {
                var id = $(this).parents(".card-body").children(".juvenileId").val();
                var jName = $(this).parents(".card-body").children("h4").text();
                var currentPage = $(this).parents(".card-body").children(".currentPage").val();
                console.log(id);
                if(confirm("你确认删除【" + jName + "】吗？")){
                    $.ajax({
                        url:"${APP_PATH}/delJuvenile?id=" + id,
                        type:"DELETE",
                        success:function (result) {
                            // console.log(result);
                            to_page(currentPage);
                            alert(result.extend.delSingleResult);
                        }
                    });
                }else{
                    alert("删除失败！");
                }
            });

            //批量删除
            $("#delAllBtn").click(function () {
                var checked = $(".delAllInput:checked");
                if(checked.length == 0){
                    alert("您还没有选择要删除的人物！");
                }else{
                    var ids = "";
                    // console.log(checked);
                    var jNames = "";
                    var currentPage = $(".card-body").children(".currentPage").val();
                    // alert(currentPage);
                    $.each(checked,function (index,ch) {
                        if(index != checked.length-1 && checked.length != 1){
                            jNames += $(this).parents(".card-body").children("h4").text() + "、";
                            ids += $(this).parents(".card-body").children(".juvenileId").val() + "-";
                        }else{
                            jNames += $(this).parents(".card-body").children("h4").text();
                            ids += $(this).parents(".card-body").children(".juvenileId").val();
                        }

                        // console.log(index + "--->" + ch + "id");
                    });
                    // console.log(jNames);
                    // console.log(ids);
                    if(confirm("你确定要删除【" + jNames + "】吗？")){
                        $.ajax({
                            url:"${APP_PATH}/delMoreJuvenile?ids=" + ids,
                            type:"DELETE",
                            success:function (result) {
                                alert(result.extend.delMoreJuvenile);
                                to_page(currentPage);
                            }
                        });
                    }
                }
            });


            //更新人物信息(显示人物原先信息)
            var juvenileId;
            var updatePage;
            $(".editBtn").click(function () {
                updatePage = $(this).parents(".card-body").children(".currentPage").val();

                $.ajax({
                    url:"${APP_PATH}/getComics",
                    type:"GET",
                    success:function (result) {
                        $("#comic").empty();
                        console.log(result);
                        $.each(result.extend.comics, function (index,comic) {
                            var optionEle = $("<option></option>").append(comic.cName).attr("value",comic.comicId);

                            optionEle.appendTo(".updateSelect");
                        });

                    }
                });

                juvenileId = $(this).parents(".card-body").children(".juvenileId").val();
                console.log("该人物id = " + juvenileId);
                //根据id获取员工信息显示在表中
                $.ajax({
                    url:"${APP_PATH}/getOneJuvenile?id=" + juvenileId,
                    type:"GET",
                    success:function (result) {
                        $("#updateForm #jName").val(result.extend.juvenile.jName);
                        $("#updateForm #gender").val(result.extend.juvenile.gender);
                        $("#updateForm #weapon").val(result.extend.juvenile.weapon);
                        $("#updateForm #sect").val(result.extend.juvenile.sect);
                        $("#updateForm #portraitUrl").val(result.extend.juvenile.portraitUrl);
                        $("#updateForm #comic").val(result.extend.juvenile.cId);
                    }
                });

            });

            //点击更新，更新人物信息，返回当前页
            $("#updateBtn").click(function () {

                checkForm();
                $.ajax({
                    url:"${APP_PATH}/updateJuvenile?juvenileId=" + juvenileId,
                    data:$("#updateForm").serialize(),
                    type:"PUT",
                    success:function (result) {
                        var newJuvenile = $("#updateForm").serialize();
                        console.log(newJuvenile);
                        alert(result.extend.updateResult);
                        console.log(result);
                        $("#updateBox").modal('hide');
                        to_page(updatePage);
                    }
                });
            });


        });
        

        //函数：点击页码跳到相应的页面
        function to_page(pn) {
            $(location).attr("href","${APP_PATH}/getJuveniles?pn=" + pn);

        }

        //函数，校验表单内容是否合理
        function checkForm() {
            checkjName();
            checkWeapon();
            checkSect();
            checkPortraitUrl();
            function checkjName() {
                $("#jName").change(function () {
                    var jName = $("#jName").val();
                    var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{1,5})/;
                    if (!regName.test(jName)) {
                        show_validate_msg("姓名可以是2-5位中文或者6-16位英文和数字的组合！");
                        return false;
                    } else {
                        show_validate_msg("");
                    }
                });
            }

            function checkWeapon() {
                $("#weapon").change(function () {
                    var weapon = $("#weapon").val();
                    var regWeaponAndSect = /(^[a-zA-Z0-9_-]{3,16}$)|(^[\u2E80-\u9FFF]{1,10})/;
                    if (!regWeaponAndSect.test(weapon)) {
                        //应该清空这个元素之前的样式
                        show_validate_msg("武器/技能有点离谱喔！");

                        return false;
                    } else {
                        checkjName();
                    }
                });
            }

            function checkSect() {
                $("#sect").change(function () {
                    var sect = $("#sect").val();
                    var regWeaponAndSect = /(^[a-zA-Z0-9_-]{3,16}$)|(^[\u2E80-\u9FFF]{2,10})/;
                    if (!regWeaponAndSect.test(sect)) {
                        //应该清空这个元素之前的样式
                        show_validate_msg("宗门/门派离了大谱！");

                        return false;
                    } else {
                        checkSect();
                    }
                });
            }

            function checkPortraitUrl() {
                $("#portraitUrl").change(function () {
                    //检验图片地址是否合法
                    var portraitUrl = $("#portraitUrl").val();
                    var regPortraitUrl = /^https:\/\/.*?\/.*?\.jpg|jpeg|webapp/i;
                    if(!regPortraitUrl.test(portraitUrl)){
                        show_validate_msg("图片地址或格式好像有问题~");
                        return false;
                    }else{
                        checkSect();
                    }
                    return true;
                });
            }


        }

        //点击保存时再校验一遍人物信息
        function clickCheckForm() {
            clickCheckjName();
            clickCheckWeapon();
            clickCheckSect();
            clickCheckPortraitUrl();

            function clickCheckjName() {
                var jName = $("#jName").val();
                var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{1,5})/;
                if (!regName.test(jName)) {
                    show_validate_msg("姓名可以是2-5位中文或者6-16位英文和数字的组合！");
                    return false;
                } else {
                    show_validate_msg("");
                }
            }

            function clickCheckWeapon() {
                var weapon = $("#weapon").val();
                var regWeaponAndSect = /(^[a-zA-Z0-9_-]{3,16}$)|(^[\u2E80-\u9FFF]{1,10})/;
                if (!regWeaponAndSect.test(weapon)) {
                    //应该清空这个元素之前的样式
                    show_validate_msg("武器/技能有点离谱喔！");

                    return false;
                } else {
                    clickCheckjName();
                }
            }

            function clickCheckSect() {
                var sect = $("#sect").val();
                var regWeaponAndSect = /(^[a-zA-Z0-9_-]{3,16}$)|(^[\u2E80-\u9FFF]{2,10})/;
                if (!regWeaponAndSect.test(sect)) {
                    //应该清空这个元素之前的样式
                    show_validate_msg("宗门/门派离了大谱！");

                    return false;
                } else {
                    clickCheckWeapon();
                }
            }

            function clickCheckPortraitUrl() {
                //检验图片地址是否合法
                var portraitUrl = $("#portraitUrl").val();
                var regPortraitUrl = /^https:\/\/.*?\/.*?\.jpg|jpeg|webapp/i;
                if(!regPortraitUrl.test(portraitUrl)){
                    show_validate_msg("图片地址或格式好像有问题~");
                    return false;
                }else{
                    clickCheckSect();
                }

            }


        }


        //函数显示检验信息
        function show_validate_msg(error) {
            $("#errorMsg").text(error);
        }





    </script>
</head>

<body>


<div class="container fixed-top" style="background-color: rgb(52,58,64); display: flex;justify-content: center;">
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark " style="width: 1140px;">
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
          在此看你喜欢的人物信息&nbsp;&nbsp;&nbsp;&nbsp;
        </span>
            <!-- 按钮：用于打开模态框,添加juvenile -->
            <button id="openModalBtn" type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#myModal">
                <i class="bi bi-plus-circle" style="font-size: 20px; color: rgb(232, 235, 240);"></i>
            </button>
            <span class="blank"></span>
            <button id="delAllBtn" type="button" class="btn btn-danger btn-sm">
                <i class="bi bi-trash-fill" style="font-size: 20px; color: rgb(232, 235, 240);"></i>
            </button>
            <div class="row">
                <input id="searchText" class="form-control col-md-7 offset-md-2" type="text" placeholder="Search">
                <button class="btn btn-success col-md-3" type="button" id="searchBtn">Search</button>
            </div>
        </ul>
    </nav>

</div>
<div class="blank" style="height: 100px;"></div>
<div class="container">
    <div class="row">
        <c:forEach items="${requestScope.pageInfo.getList()}" var="juvenile">
            <div class="col col-md-6 card-col">
                <div class="card" style="width:400px">
                    <img class="card-img-top" src="${juvenile.getPortraitUrl()}" alt="Card image"
                         style="width:398px; height: 225px;">
                    <div class="card-body">
                        <input class="juvenileId" type="hidden" name="id"  value="${juvenile.getJuvenileId()}" />
                        <input class="currentPage" type="hidden" name="pageNum" value="${requestScope.pageInfo.pageNum}" />
                        <input class="delAllInput" type="checkbox" style="float: right;" />
                        <h4 class="card-title">${juvenile.getjName()}</h4>
                        <p class="card-text">出自动漫:《${juvenile.getComic().getcName()}》</p>
                        <p class="card-text">性别:${juvenile.getGender()}</p>
                        <p class="card-text">武器/技能:${juvenile.getWeapon()}</p>
                        <p class="card-text">门派/宗门:${juvenile.getSect()}</p>
                        <button type="button" class="btn btn-success bi-pencil-fill editBtn" data-toggle="modal" data-target="#updateBox" style="font-size: 15px; color: rgb(232, 235, 240);">&nbsp;编辑</button>
                        <button type="button" class="btn btn-danger bi-trash-fill delSingleBtn" style="font-size: 15px; color: rgb(232, 235, 240);">&nbsp;删除</button>
                    </div>
                </div>
            </div>
        </c:forEach>


    </div>
</div>

<!-- 分页条 -->
<div class="container">
    <ul class="pagination">
        <span>共【${requestScope.pageInfo.getPages()}】页【${requestScope.pageInfo.getTotal()}】条</span>

        <span class="blank"></span>

        <c:if test="${requestScope.pageInfo.pageNum != 1}">
            <li class="page-item"><a class="page-link  page-fist" href="#">首页</a></li>
        </c:if>

        <c:if test="${requestScope.pageInfo.hasPreviousPage==true}">
            <li class="page-item"><a class="page-link page-previous" href="#">Previous</a></li>
        </c:if>
        <c:if test="${requestScope.pageInfo.hasPreviousPage==false}">
            <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
        </c:if>

        <c:forEach items="${requestScope.pageInfo.navigatepageNums}" var="navigatepageNum">
            <c:if test="${requestScope.pageInfo.pageNum==navigatepageNum}">
                <li class="page-item active"><a class="page-link  page-num" href="#">${navigatepageNum}</a></li>
            </c:if>
            <c:if test="${requestScope.pageInfo.pageNum!=navigatepageNum}">
                <li class="page-item"><a class="page-link  page-num" href="#">${navigatepageNum}</a></li>
            </c:if>
        </c:forEach>

        <c:if test="${requestScope.pageInfo.hasNextPage==true}">
            <li class="page-item"><a class="page-link page-next" href="#">Next</a></li>
        </c:if>
        <c:if test="${requestScope.pageInfo.hasNextPage==false}">
            <li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
        </c:if>

        <c:if test="${requestScope.pageInfo.pageNum != requestScope.pageInfo.pages}">
            <li class="page-item"><a class="page-link  page-last" href="#">末页</a></li>
        </c:if>

    </ul>

</div>

<div class="container">
    <!-- 增加人物模态框 -->
    <div class="modal fade" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- 增加人物模态框头部 -->
                <div class="modal-header">
                    <h4 class="modal-title">添加人物</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- 增加人物模态框主体 -->
                <div class="modal-body">
                    <form id="insertJuvenile">
                        <%--错误信息--%>
                        <div id="errorMsg"></div>
                        姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" id="jName" name="jName"/><br><br>
                        性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：
                        <select id="gender" name="gender">
                            <option>男</option>
                            <option>女</option>
                        </select><br><br>
                        武器/技能：<input type="text" id="weapon"  name="weapon" /><br><br>
                        门派/宗门：<input type="text" id="sect"  name="sect" /><br><br>
                        图&nbsp;&nbsp;片&nbsp;&nbsp;url：<input type="text" id="portraitUrl" name="portraitUrl" /><br><br>

                        <label for="comic">所属动漫：</label>
                        <select class="form-control" id="comic" name="cId">

                        </select><br><br>

                    </form>

            </div>

                <!-- 模态框底部 -->
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success" id="saveBtn">保存</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                </div>

            </div>
        </div>
    </div>

    <%--更新人物模态框--%>
    <div class="modal fade" id="updateBox">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- 更新人物模态框头部 -->
                <div class="modal-header">
                    <h4 class="modal-title">编辑人物</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- 更新人物模态框主体 -->
                <div class="modal-body">
                    <form id="updateForm">
                        <%--错误信息--%>
                        <div id="updateErrorMsg"></div>
                        姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" id="jName" name="jName"/><br><br>
                        性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：
                        <select id="gender" name="gender">
                            <option>男</option>
                            <option>女</option>
                        </select><br><br>
                        武器/技能：<input type="text" id="weapon"  name="weapon" /><br><br>
                        门派/宗门：<input type="text" id="sect"  name="sect" /><br><br>
                        图&nbsp;&nbsp;片&nbsp;&nbsp;url：<input type="text" id="portraitUrl" name="portraitUrl" /><br><br>

                        <label for="comic">所属动漫：</label>
                        <select class="form-control updateSelect" id="comic" name="cId">

                        </select><br><br>

                    </form>

                </div>

                <!-- 模态框底部 -->
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success" id="updateBtn" data-toggle="modal" data-target="#updateBox">更新</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                </div>

            </div>
        </div>
    </div>


</div>




<br><br><br><br>
<%@include file="common/footer.jsp"%>
</body>

</html>
