<%--
  Created by IntelliJ IDEA.
  User: hedd
  Date: 2021/10/17
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功页面</title>
</head>
<body>
    <h1>欢迎您，${sessionScope.get("userName")}</h1>
    <a href="out">退出</a>
</body>
</html>
