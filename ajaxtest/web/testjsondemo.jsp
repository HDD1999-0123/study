<%--
  Created by IntelliJ IDEA.
  User: xiaomi
  Date: 2021/3/5
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
    $(function(){
        $("#uid").blur(function(){
            //1.获得value值
            var uid = $(this).val();
            //2.发送请求
            $.post("/getuser","uid="+uid,function(rs){
                //转换成可以处理的js
                rs=eval("("+rs+")");
                //此时的rs是json格式的对象
                $("#uname").val(rs.username);
                $("#pass").val(rs.password);
                $("#money").val(rs.money);
            });
        });
    })

</script>
<body>
    uid:<input type="text" id="uid"><br>
    name:<input type="text" id="uname"><br>
    pass:<input type="text" id="pass"><br>
    money:<input type="text" id="money">
</body>
</html>
