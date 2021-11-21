<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<body>

		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：教务中心-》学生管理-》更新</span>
                <span style="float:right;margin-right: 8px;font-weight: bold"></span>
            </span>
        </div>
</div>
<div class="cztable">
    <form action="update" method="post">
	<table border="1" width="100%" class="table_a">
                <input type="text" name="stuId" value="${student.stuId}" hidden/>
                <tr  width="120px;">
                    <td width="10%">学号：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="stuNo" value="${student.stuNo}" />
					</td>
                </tr>

                <tr  width="120px;">
                    <td>姓名<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="stuName" value="${student.stuName}" />
					</td>
                </tr>

                <tr>
                    <td>班级<span style="color:red">*</span>：</td>
                    <td>
                        <select name="gid">
                            <option value="1" ${student.gid==1?"checked":""}>一年级</option>
                            <option value="2" ${student.gid==2?"checked":""}>二年级</option>
                            <option value="3" ${student.gid==3?"checked":""}>三年级</option>
                            <option value="4" ${student.gid==4?"checked":""}>四年级</option>
                            <option value="5" ${student.gid==5?"checked":""}>五年级</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>性别<span style="color:red">*</span>：</td>
                    <td>
                        <input type="radio" name="sex"  value="1" ${student.sex==1?"checked":""}/>男
                        <input type="radio" name="sex" value="0" ${student.sex==0?"checked":""}/>女
                    </td>
                </tr>


				<tr>
                    <td>EMAIL：</td>
                    <td>
                        <input type="text" name="email" value="${student.email}" />
                    </td>
                </tr>

				<tr>
                    <td>联系电话：</td>
                    <td>
                        <input type="text" name="phone" value="${student.phone}" />
                    </td>
                </tr>

				<tr>
                    <td>户口所在地：</td>
                    <td>
                        <input type="text" name="registered" value="${student.registered}"  />
                    </td>
                </tr>

				<tr>
                    <td>住址：</td>
                    <td>
                        <input type="text" name="address" value="${student.address}" />
                    </td>
                </tr>
				<tr>
                    <td>政治面貌：</td>
                    <td>
                        <input type="text" name="politics" value="${student.politics}" />
                    </td>
                </tr>
				<tr>
                    <td>身份证号：</td>
                    <td>
                        <input type="text" name="idNumber" value="${student.idNumber}" />
                    </td>
                </tr>

				<tr>
                    <td>专业：</td>
                    <td>
                        <input type="text" name="profession" value="${student.profession}" />
                    </td>
                </tr>


				<tr>
                    <td>简介<span style="color:red">*</span>：</td>
                    <td>
                        <textarea name="introduction">${student.introduction}</textarea>
                    </td>
                </tr>
				<tr>
					<td colspan=2 align="center">
						<input type="submit" value="保存">
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
