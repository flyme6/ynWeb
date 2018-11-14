<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>欢迎页面-后台管理系统</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
	</head>

	<body>
		<div class="weadmin-body">
			<blockquote class="layui-elem-quote">出现异常，请联系管理员！</blockquote>
			</div>
		</div>
	</body>
</html>