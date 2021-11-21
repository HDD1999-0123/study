﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title>
	<link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../../Style/ks.css" rel="stylesheet" type="text/css" />
	<link href="../../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../../Script/Common.js" type="text/javascript"></script>
    <script src="../../Script/Data.js" type="text/javascript"></script>


</head>
<script type="text/javascript">
    $(function(){
        $("#stuno").blur(function(){
            //1.获得value值
            var stuno = $(this).val();
            //2.发送请求
            $.post("/Educational/student/verify","stuno="+stuno,function(rs){
                //转换成可以处理的js
                rs=eval("("+rs+")");
                if(!rs.result){
                    $("#stunoSpan").html("学号重复!").css("color","red");
                }
            });
        });
    })

</script>
<body>

		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：教务中心-》学生管理-》新增</span>
                <span style="float:right;margin-right: 8px;font-weight: bold"></span>
            </span>
        </div>
</div>
<div class="cztable">
    <form action="add" method="post">
	<table border="1" width="100%" class="table_a">
                <tr  width="120px;">
                    <td width="10%">学号：<span style="color:red">*</span>：</td>
                    <td>
						<input id="stuno" type="text"  name="stuNo" value="" />
					</td>
                    <span id="stunoSpan"></span>
                </tr>

                <tr  width="120px;">
                    <td>姓名<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="stuName" value="" />
					</td>
                </tr>

                <tr>
                    <td>班级<span style="color:red">*</span>：</td>
                    <td>
                        <select name="gid">
                        	<option value="1">一年级</option>
                            <option value="2">二年级</option>
                            <option value="3">三年级</option>
                            <option value="4">四年级</option>
                            <option value="5">五年级</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>性别<span style="color:red">*</span>：</td>
                    <td>
                        <input type="radio" name="sex" value="1" />男 <input type="radio" name="sex" value="0"/>女
                    </td>
                </tr>


				<tr>
                    <td>EMAIL：</td>
                    <td>
                        <input type="text" name="email" value="" />
                    </td>
                </tr>

				<tr>
                    <td>联系电话：</td>
                    <td>
                        <input type="text" name="phone" value="" />
                    </td>
                </tr>

				<tr>
                    <td>户口所在地：</td>
                    <td>
                        <input type="text" name="registered" value=""  />
                    </td>
                </tr>

				<tr>
                    <td>住址：</td>
                    <td>
                        <input type="text" name="address" value="" />
                    </td>
                </tr>
				<tr>
                    <td>政治面貌：</td>
                    <td>
                        <input type="text" name="politics" value="" />
                    </td>
                </tr>
				<tr>
                    <td>身份证号：</td>
                    <td>
                        <input type="text" name="idNumber" value="" />
                    </td>
                </tr>

				<tr>
                    <td>专业：</td>
                    <td>
                        <input type="text" name="profession" value="" />
                    </td>
                </tr>


				<tr>
                    <td>简介<span style="color:red">*</span>：</td>
                    <td>
                        <textarea name="introduction"></textarea>
                    </td>
                </tr>
				<tr>
					<td colspan=2 align="center">
						<input type="submit" value="添加" />
					</td>
				</tr>
			</table>
	</form>
</div>

            </div>
        </div>
    </div>
</body>
</html>
