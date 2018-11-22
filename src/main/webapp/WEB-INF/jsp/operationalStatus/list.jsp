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
    <title>运行状态监视-后台管理系统</title>
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
                        <legend>演示数据已经实现ajax，每隔一秒刷新一次</legend>
                    </fieldset>

                    <table class="layui-table" lay-even="" lay-skin="row" id="table">
                        <colgroup>
                            <col width="150">
                            <col width="150">
                            <col width="200">
                            <col>
                        </colgroup>
                        <thead>
                        <tr>
                            <th>监测项</th>
                            <th>检测数据</th>
                            <th>说明</th>
                        </tr>
                        </thead>
                        <tbody id="table-tbody">
                        </tbody>
                    </table>

                    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                        <legend>通信端口状态</legend>
                    </fieldset>
                    <div class="weadmin-block">
                        <button class="layui-btn" style="background-color: #5FB878"></button>
                        ETH1
                        <button class="layui-btn" style="background-color: #5FB878"></button>
                        ETH2
                        <button class="layui-btn" style="background-color: #5FB878"></button>
                        ETH3
                        <button class="layui-btn" style="background-color: #FF5722"></button>
                        ETH4
                        <button class="layui-btn" style="background-color: #FF5722"></button>
                        ETH5
                        <button class="layui-btn" style="background-color: #FF5722"></button>
                        ETH6
                        <button class="layui-btn" style="background-color: #c2c2c2"></button>
                        ETH7
                        <button class="layui-btn" style="background-color: #c2c2c2"></button>
                        ETH8
                        <button class="layui-btn" style="background-color: #c2c2c2"></button>
                        ETH9
                        <button class="layui-btn" style="background-color: #c2c2c2"></button>
                        ETH10
                    </div>
                    <div class="weadmin-block">
                        <button class="layui-btn" style="background-color: #5FB878"></button>
                        ETH1
                        <button class="layui-btn" style="background-color: #5FB878"></button>
                        ETH2
                        <button class="layui-btn" style="background-color: #5FB878"></button>
                        ETH3
                        <button class="layui-btn" style="background-color: #FF5722"></button>
                        ETH4
                        <button class="layui-btn" style="background-color: #FF5722"></button>
                        ETH5
                        <button class="layui-btn" style="background-color: #FF5722"></button>
                        ETH6
                        <button class="layui-btn" style="background-color: #c2c2c2"></button>
                        ETH7
                        <button class="layui-btn" style="background-color: #c2c2c2"></button>
                        ETH8
                        <button class="layui-btn" style="background-color: #c2c2c2"></button>
                        ETH9
                        <button class="layui-btn" style="background-color: #c2c2c2"></button>
                        ETH10
                    </div>
                    <table class="layui-table" id="communicationPortStatus"></table>
                    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                        <legend>系统资源使用状态</legend>
                    </fieldset>
                    <table class="layui-table" id="systemResourceUsageStatus"></table>

                    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                        <legend>应用运行状态</legend>
                    </fieldset>
                    <table class="layui-table" id="applicationRunningStatus"></table>

                    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                        <legend>设备运行状态</legend>
                    </fieldset>
                    <table class="layui-table" id="equipmentOperatingStatus"></table>
                </div>
            </div>
        </div>
        <script type="text/html" id="operateTpl">
            <a title="开启" onclick="operateTpl_open(this,'要开启设备的ID')" href="javascript:;">
                <!--<i class="layui-icon">&#xe63f;</i>-->
                开启
            </a>
        </script>
    </div>
</div>
</body>
<script src="lib/layui/layui.js" charset="utf-8"></script>
<script src="static/js/jquery.js" charset="utf-8"></script>
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

        //展示系统资源使用状态
        table.render({
            elem: '#systemResourceUsageStatus',
            cellMinWidth: 80,
            cols: [[ //标题栏
                {field: 'name', title: '监测项'}
                , {field: 'c_dev', title: '检测数据'}
                , {field: 'c_devid', title: '说明'}
            ]],
            data: [{
                "name": "CPU使用率"
                , "c_dev": "30%"
                , "c_devid": "1"
            }, {
                "name": "内存使用率"
                , "c_dev": "799/1024"
                , "c_devid": "1"
            }, {
                "name": "登陆用户"
                , "c_dev": "admin"
                , "c_devid": "1"
            }]
            , skin: 'line' //表格风格
            , even: true
            , page: true //是否显示分页
            , limits: [5, 7, 10]
            , limit: 5 //每页默认显示的数量
        });

        //展示应用运行状态
        table.render({
            elem: '#applicationRunningStatus',
            cellMinWidth: 80,
            cols: [[ //标题栏
                {field: 'name', title: '监测项'}
                , {field: 'c_dev', title: '检测数据'}
                , {field: 'c_devid', title: '说明'}
            ]],
            data: [{
                "name": "运行状态"
                , "c_dev": "运行"
                , "c_devid": "1"
            }, {
                "name": "主备状态"
                , "c_dev": "主"
                , "c_devid": "1"
            }, {
                "name": "启动时间"
                , "c_dev": "2018-10-23 13:23:07"
                , "c_devid": "1"
            }, {
                "name": "主备状态"
                , "c_dev": "主"
                , "c_devid": "1"
            }, {
                "name": "应用版本"
                , "c_dev": "V1.0"
                , "c_devid": "1"
            }, {
                "name": "工程版本"
                , "c_dev": "12"
                , "c_devid": "1"
            }, {
                "name": "授权点数"
                , "c_dev": "1000"
                , "c_devid": "1"
            }, {
                "name": "授权时间"
                , "c_dev": "2020-1-1"
                , "c_devid": ""
            }]
            , skin: 'line' //表格风格
            , even: true
            , page: true //是否显示分页
            // , limits: [5, 7, 10]
            , limit: 7 //每页默认显示的数量
        });


        //展示设备运行状态
        table.render({
            elem: '#equipmentOperatingStatus',
            cellMinWidth: 80,
            cols: [[ //标题栏
                {field: 'name', title: '设备名'}
                , {field: 'c_dev', title: '运行状态'}
                ,
                {
                    field: 'operate', title: '操作', toolbar: '#operateTpl', unresize: true
                }
            ]],
            data: [{
                "name": "设备1"
                , "c_dev": "运行"
            }, {
                "name": "设备2"
                , "c_dev": "停止"
            }, {
                "name": "设备3"
                , "c_dev": "运行"
            }, {
                "name": "设备4"
                , "c_dev": "运行"
            }, {
                "name": "设备5"
                , "c_dev": "运行"
            }, {
                "name": "设备6"
                , "c_dev": "故障"
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

        /*控制设备运行状态*/
        window.operateTpl_open = function (obj, id) {
            layer.confirm('确认要开启吗？', function (index) {
                //发异步删除数据
                // $(obj).parents("tr").remove();
                layer.msg('已开启!', {
                    icon: 1,
                    time: 1000
                });
            });
        }
    });

</script>

<script>
    window.onload = function () {
        runEvery10Sec();
    };

    var htmls = ''; //全局变量

    function runEvery10Sec() {
        setTimeout(runEvery10Sec, 1000 * 1);

        $.ajax({
            url: "./pointsConfig/queryDriver",
            type: "get",
            dataType: "json",
            async: false,//这得注意是同步
            success: function (result) {
                $("#table-tbody").html("");
                resultData = result.data;
                for (var x in resultData) {
                    htmls = "<tr>" +
                        "<td>" + resultData[x].c_dev + "</td>" +
                        "<td>" + resultData[x].f_dev + "</td>" +
                        "<td>" + resultData[x].c_devid + "</td>" +
                        "</tr>";
                    $("#table-tbody").append(htmls);
                }
            }

        });
    }

</script>
</html>