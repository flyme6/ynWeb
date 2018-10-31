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
                        <legend>系统日志</legend>
                    </fieldset>
                    <div class="layui-row">
                        <form class="layui-form layui-col-md12 we-search">
                            <button class="layui-btn" lay-submit="" lay-filter="sreach">导出</button>
                            <!--按过滤：-->
                            <div class="layui-inline">
                                <input type="text" name="username" placeholder="PT1" autocomplete="off"
                                       class="layui-input">
                            </div>
                            <button class="layui-btn" lay-submit="" lay-filter="sreach"><i
                                    class="layui-icon">&#xe615;</i></button>
                        </form>
                    </div>
                    <table class="layui-table" id="systemLog"></table>

                </div>
            </div>
        </div>
        <script type="text/html" id="operateTpl">
            <a title="开启" onclick="oper_open(this,'要开启设备的ID')" href="javascript:;">
                <!--<i class="layui-icon">&#xe63f;</i>-->
                开启
            </a>
        </script>
    </div>
</div>
</body>
<script src="lib/layui/layui.js" charset="utf-8"></script>
<script>
    layui.extend({
        admin: '{/}static/js/admin'
    });

    layui.use(['table', 'jquery', 'form', 'admin'], function () {
        var table = layui.table,
            $ = layui.jquery,
            form = layui.form,
            admin = layui.admin;

        form.verify({
            ip: [
                /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/
                , 'IP地址不符合规则'
            ]
        });

        //展示实时数据监视
        table.render({
            elem: '#systemLog',
            cellMinWidth: 80,
            cols: [[ //标题栏
                {field: 'name'}
                , {field: 'value'}
            ]],
            data: [{
                "name": "PT0001"
                , "value": "1.5"
            },{
                "name": "PT0001"
                , "value": "1.5"

            },{
                "name": "PT0001"
                , "value": "1.5"

            },{
                "name": "PT0001"
                , "value": "1.5"

            },{
                "name": "PT0001"
                , "value": "1.5"

            },{
                "name": "PT0001"
                , "value": "1.5"

            }]
            , skin: 'line' //表格风格
            , even: true
            , page: true //是否显示分页
            , limits: [5, 7, 10]
            , limit: 5 //每页默认显示的数量
        });

        /*
         *数据表格中form表单元素是动态插入,所以需要更新渲染下
         * http://www.layui.com/doc/modules/form.html#render
         * */
        $(function () {
            form.render();
        });
    });

</script>
</html>