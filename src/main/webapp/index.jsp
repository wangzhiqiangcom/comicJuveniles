<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/8/17
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--将页面基础路径放在请求域中--%>
<%
    pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<jsp:forward page="/getSwipers"></jsp:forward>
<html>

<head>
    <title>首页</title>
</head>

<body>

</body>

</html>
