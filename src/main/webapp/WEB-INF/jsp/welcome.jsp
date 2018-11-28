<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 引入jstl库 -->
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
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="static/css/font.css">
    <link rel="stylesheet" href="static/css/weadmin.css">


</head>

<body>
<body class="layui-view-body">
<div class="layui-content">
    <div class="layui-row layui-col-space20">
        <div class="layui-col-sm12 layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body chart-card">
                    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                        <legend>工程管理</legend>
                    </fieldset>
                    <div class="layui-card-body">
                        <div>
                            <button class="layui-btn"
                                    onclick="WeAdminShow('保存工程到本地','./project/exportProject')">保存工程到本地
                            </button>
                            <button class="layui-btn"
                                    onclick="WeAdminShow('新建工程','./project/newProject')">新建工程
                            </button>
                            <button class="layui-btn"
                            <%--onclick="WeAdminShow('工程文件下载','./file/down?filename=1.rar')">工程文件下载--%>
                                    onclick="'./file/down?filename=1.rar'"><a href="./file/down?filename=1.rar"
                                                                              style="color: white">工程文件下载</a>
                            </button>
                            <button class="layui-btn"
                                    onclick="WeAdminShow('检查工程','./project/checkProject')">检查工程
                            </button>
                            <button class="layui-btn"
                                    onclick="WeAdminShow('打开本地工程','./project/importProjectPage')">打开本地工程
                            </button>
                            <button class="layui-btn"
                                    onclick="WeAdminShow('启动工程','./project/startProject')">启动工程
                            </button>
                            <button class="layui-btn"
                                    onclick="WeAdminShow('停止工程','./project/stopProject')">停止工程
                            </button>
                            <button class="layui-btn"
                                    onclick="WeAdminShow('重启盒子','./project/rebootBox')">重启盒子
                            </button>

                        </div>
                    </div>

                    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                        <legend>数据监视</legend>
                    </fieldset>
                    <div class="layui-card-body">
                        <div>
                            <button class="layui-btn" id="getDevicesState"
                                    onclick="WeAdminShow('设备状态','./dataMonitor/getDevicesState')">设备状态
                            </button>
                            <button class="layui-btn" onclick="WeAdminShow('实时数据','./dataMonitor/queryRealData')">
                                实时数据
                            </button>
                            <button class="layui-btn"
                                    onclick="WeAdminShow('通信数据流','./dataMonitor/queryDeviceDataStream')">
                                通信数据流
                            </button>
                            <button class="layui-btn" onclick="WeAdminShow('系统日志信息','./dataMonitor/querySystemLog')">
                                系统日志信息
                            </button>

                        </div>
                    </div>

                    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                        <legend>系统资源监视</legend>
                    </fieldset>
                    <div class="layui-card-body">
                        <div>
                            <button class="layui-btn"
                                    onclick="WeAdminShow('系统资源使用情况','./systemInformation/getSystemResourcesState')">
                                系统资源使用情况
                            </button>
                            <button class="layui-btn"
                                    onclick="WeAdminShow('嵌入式应用的运行情况','./systemInformation/getAppRunState')">
                                嵌入式应用的运行情况
                            </button>
                            <button class="layui-btn"
                                    onclick="WeAdminShow('系统网口的运行情况','./systemInformation/getNetportsState')">系统网口的运行情况
                            </button>
                            <button class="layui-btn"
                                    onclick="WeAdminShow('系统串口的运行情况','./systemInformation/getComportsState')">
                                系统串口的运行情况
                            </button>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</body>
<script type="text/javascript" src="lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
    layui.extend({
        admin: '{/}static/js/admin',
    });
    layui.use(['jquery', 'element', 'util', 'admin', 'carousel'], function () {
        var element = layui.element,
            $ = layui.jquery,
            carousel = layui.carousel,
            util = layui.util,
            admin = layui.admin;
        //建造实例
        carousel.render({
            elem: '.weadmin-shortcut'
            , width: '100%' //设置容器宽度
            , arrow: 'none' //始终显示箭头
            , trigger: 'hover'
            , autoplay: false
        });

        carousel.render({
            elem: '.weadmin-notice'
            , width: '100%' //设置容器宽度
            , arrow: 'none' //始终显示箭头
            , trigger: 'hover'
            , autoplay: true
        });

        $(function () {
            setTimeAgo(2018, 0, 1, 13, 14, 0, '#firstTime');
            setTimeAgo(2018, 2, 28, 16, 0, 0, '#lastTime');
        });

        function setTimeAgo(y, M, d, H, m, s, id) {
            var str = util.timeAgo(new Date(y, M || 0, d || 1, H || 0, m || 0, s || 0));
            $(id).html(str);
            console.log(str);
        }

        $(document).on('click', '#getDevicesState', function () {
            layer.tips('hello');
        });
    });
</script>

</html>