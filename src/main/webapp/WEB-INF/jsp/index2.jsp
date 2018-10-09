<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path+ "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="assets/css/layui.css">
    <link rel="stylesheet" href="assets/css/admin.css">
    <link rel="icon" href="/favicon.ico">
    <title>管理后台</title>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header custom-header">

        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item slide-sidebar" lay-unselect>
                <a href="javascript:;" class="icon-font"><i class="ai ai-menufold"></i></a>
            </li>
        </ul>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">BieJun</a>
                <dl class="layui-nav-child">
                    <dd><a href="">帮助中心</a></dd>
                    <dd><a href="login.jsp">退出</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="layui-side custom-admin">
        <div class="layui-side-scroll">

            <div class="custom-logo">
                <img src="assets/images/logo.png" alt=""/>
                <h1>管理后台</h1>
            </div>
            <ul id="Nav" class="layui-nav layui-nav-tree">
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon">&#xe609;</i>
                        <em>主页</em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=basePath %>console">控制台</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon">&#xe857;</i>
                        <em>站点列表</em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="<%=basePath %>sitelist">首站</a>
                        </dd>
                    </dl>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="<%=basePath %>sitelist">处理厂</a>
                        </dd>
                    </dl>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="<%=basePath %>sitelist">末站</a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon">&#xe857;</i>
                        <em>YNTOOL系统配置页面</em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="<%=basePath %>systemConfiguration">系统配置</a>
                        </dd>
                        <dd>
                            <a href="<%=basePath %>systemControl">系统控制</a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon">&#xe612;</i>
                        <em>YNVIEW实时监视页面</em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=basePath %>equipManage">设备管理</a></dd>
                        <dd><a href="<%=basePath %>dataMonitoring">数据监视</a></dd>
                        <dd><a href="<%=basePath %>systemInfo">系统信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon">&#xe612;</i>
                        <em>用户管理</em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=basePath %>users">用户列表</a></dd>
                        <dd><a href="<%=basePath %>useradd">新增用户</a></dd>
                        <!--<dd><a href="views/operaterule.jsp">权限配置</a></dd>-->
                    </dl>
                </li>
            </ul>

        </div>
    </div>

    <div class="layui-body">
        <div class="layui-tab app-container" lay-allowClose="true" lay-filter="tabs">
            <ul id="appTabs" class="layui-tab-title custom-tab"></ul>
            <div id="appTabPage" class="layui-tab-content"></div>
        </div>
    </div>

    <div class="layui-footer">
        <p>© 2018 flyme：<a href="http://www.flyme/" target="_blank">flyme</a></p>
    </div>

    <div class="mobile-mask"></div>
</div>
<script src="assets/layui.js"></script>
<script src="assets/js/index.js" data-main="login"></script>
<script src="assets/js/home.js" data-main="home"></script>
</body>
</html>