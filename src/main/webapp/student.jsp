<!-- 
charset是该页面的编码格式，pageEncoding是jsp文件本身的编码
如果 pageEncoding属性存在，那么JSP页面的字符编码方式就由pageEncoding决定，
否则就由contentType属性中的 charset决定，
如果charset也不存在，JSP页面的字符编码方式就采用默认的ISO-8859-1
 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isErrorPage="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title>学生</title>
<script type="text/javascript" src="statics/jquery.min.js"></script>
<script type="text/javascript" src="statics/student.js">
	
</script>
</head>
<body>

<h1>学生列表</h1>
<table id="stuTable">
</table>

<p>修改学生</p>
<p>输入被修改的学生studentId：<input id="no_update" type="text"><button id="get_be_update_btn">提交</button></p>
<input id="u_studentId" type="hidden"/>
<table>
	<!-- 通过<form:errors path="paramName">可以显示数据校验中的该参数的出错信息，需要使用form:form表单 -->
	<tr><td>姓名：</td><td><input id="name" type="text"/></td></tr>
		<tr><td>班级：</td><td><input id="className" type="text"/></td></tr>
		<tr><td>学号：</td><td><input id="no" type="text"/></td></tr>
		<tr><td>年级：</td><td><input id="grade" type="text"/></td></tr>
		<tr><td>性别：</td><td>男<input id="male" type="radio" name="u_sex" value="true" checked/>&nbsp;
								女：<input id="female" type="radio" name="u_sex" value="false"/>
							</td></tr>
		<tr><td colspan="2"><button id="put_btn">提交</button></td></tr>
</table>

<form action="student" method="post">
	<table>
		<thead align="center">添加学生</thead>
		<tr><td>姓名：</td><td><input type="text" name="name"/></td></tr>
		<tr><td>班级：</td><td><input type="text" name="className"/></td></tr>
		<tr><td>学号：</td><td><input type="text" name="no"/></td></tr>
		<tr><td>年级：</td><td><input type="text" name="grade"/></td></tr>
		<tr><td>性别：</td><td>男<input type="radio" name="sex" value="true" checked/>&nbsp;
								女：<input type="radio" name="sex" value="false"/>
							</td></tr>
		<tr><td colspan="2"><input type="submit"/></td></tr>
	</table>
</form>
<p>删除学生学号：<input id="del_id" name="id" type="text"/><input id="del_btn" type="submit"/></p>
<!-- 
${pageContextScope.key}  页面参数域
${requestScope.key}		 请求参数域
${sessionScope.key}		 会话参数域
${applicationScope.key}	 服务器参数域
 -->
</body>
</html>