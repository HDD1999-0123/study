<%--
  Created by IntelliJ IDEA.
  User: xiaomi
  Date: 2021/3/4
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
  $(function(){
    $("#uname").blur(function(){
      //1.获得value值
      var uname = $(this).val();
      //2.发送请求
      /* $.ajax({
         url:"/testuname",
         data:"username="+uname,
         type:"post",
         dataType:"text",
         success:function(rs){
           $("#rs").html(rs);
         }
          });
         */
      /* $.get("/testuname","username="+uname,function(rs){
           $("#rs").html(rs);
        });*/

      $.post("/testuname","username="+uname,function(rs){
        $("#rs").html(rs);
      });

    });

  })

</script>
<body>
<h1>验证用户名合法性</h1>

username:<input type="text" id="uname" ><span id="rs"></span>
</body>
</html>
