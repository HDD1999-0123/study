<%--
  Created by IntelliJ IDEA.
  User: xiaomi
  Date: 2021/3/4
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <h1>show.jsp</h1>
<table border="1" width="500px" bgcolor="aqua">
     <tr>
         <td>id</td>
         <td>name</td>
         <td>age</td>
         <td>sex</td>
     </tr>
<c:forEach items="${stulist}" var="stu">
    <tr>
        <td>${stu.stuid}</td>
        <td>${stu.stuname}</td>
        <td>${stu.age}</td>
        <td>${stu.sex==1?"男":"女"}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
