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
    <title>系统日志-后台管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="static/css/font.css">
    <link rel="stylesheet" href="static/css/weadmin.css">
    <link rel="stylesheet" href="static/css/view.css"/>
    <link rel="stylesheet" href="static/css/layui.css">
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body class="layui-view-body">
<div class="layui-content">
    <div class="layui-row layui-col-space20">

        <div class="layui-col-sm12 layui-col-md12">
            <div class="layui-card">

                <div class="layui-card-body chart-card">

                    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                        <legend>调试控制台(测试专用)</legend>
                    </fieldset>
                    <div id="log-container"
                         style="height: 450px; overflow-y: scroll; background: #333; color: #aaa; padding: 10px;">
                        <div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="lib/layui/layui.js" charset="utf-8"></script>
<script src="static/js/jquery.js" charset="utf-8"></script>
<script>
    $(document).ready(function () {
        // 指定websocket路径
        var wsUri = 'ws://192.168.153.132:8080/ynWeb/log';
        var websocket = new WebSocket(wsUri);
        websocket.onmessage = function (event) {
            // 接收服务端的实时日志并添加到HTML页面中
            $("#log-container div").append(event.data);
            // 滚动条滚动到最低部
            $("#log-container").scrollTop($("#log-container div").height() - $("#log-container").height());
        };
    });
</script>
</html>