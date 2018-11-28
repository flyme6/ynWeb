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
                        <legend>网口端口状态</legend>
                    </fieldset>
                    <div class="weadmin-block" id="NetportsState">
                        <button class="layui-btn" style="background-color: #5FB878; ">TH1</button>
                        <button class="layui-btn" style="background-color: #FD482C; ">TH2</button>
                        <button class="layui-btn" style="background-color: #B2B2B2;">TH3</button>
                    </div>
                    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                        <legend>串口端口状态</legend>
                    </fieldset>
                    <div class="weadmin-block" id="ComportsState">
                    </div>

                    <table class="layui-table" id="communicationPortStatus"></table>
                    <%--<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">--%>
                    <%--<legend>系统网口状态</legend>--%>
                    <%--</fieldset>--%>
                    <%--&lt;%&ndash;<table class="layui-table" id="NetportsState"></table>&ndash;%&gt;--%>
                    <%--<table class="layui-table" lay-even="" lay-skin="row" id="NetportsState">--%>
                    <%--<colgroup>--%>
                    <%--<col width="150">--%>
                    <%--<col width="150">--%>
                    <%--<col>--%>
                    <%--</colgroup>--%>
                    <%--<thead>--%>
                    <%--<tr>--%>
                    <%--<th>网口名称</th>--%>
                    <%--<th>网口状态</th>--%>
                    <%--</tr>--%>
                    <%--</thead>--%>
                    <%--<tbody id="table-tbody-NetportsState">--%>
                    <%--</tbody>--%>
                    <%--</table>--%>

                    <%--<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">--%>
                    <%--<legend>系统串口状态</legend>--%>
                    <%--</fieldset>--%>
                    <%--&lt;%&ndash;<table class="layui-table" id="ComportsState"></table>&ndash;%&gt;--%>

                    <%--<table class="layui-table" lay-even="" lay-skin="row" id="ComportsState">--%>
                    <%--<colgroup>--%>
                    <%--<col width="150">--%>
                    <%--<col width="150">--%>
                    <%--<col>--%>
                    <%--</colgroup>--%>
                    <%--<thead>--%>
                    <%--<tr>--%>
                    <%--<th>串口名称</th>--%>
                    <%--<th>串口状态</th>--%>
                    <%--</tr>--%>
                    <%--</thead>--%>
                    <%--<tbody id="table-tbody-ComportsState">--%>
                    <%--</tbody>--%>
                    <%--</table>--%>


                    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                        <legend>系统资源使用状态</legend>
                    </fieldset>

                    <table class="layui-table" lay-even="" lay-skin="row" id="systemResourceUsageStatus">
                        <colgroup>
                            <col width="150">
                            <col width="150">
                            <col>
                        </colgroup>
                        <thead>
                        <tr>
                            <th>监测项</th>
                            <th>检测数据</th>
                            <%--<th>说明</th>--%>
                        </tr>
                        </thead>
                        <tbody id="table-tbody-systemResourceUsageStatus">
                        </tbody>
                    </table>

                    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                        <legend>应用运行状态</legend>
                    </fieldset>
                    <table class="layui-table" lay-even="" lay-skin="row" id="applicationRunningStatus">
                        <colgroup>
                            <col width="150">
                            <col width="150">
                            <col>
                        </colgroup>
                        <thead>
                        <tr>
                            <th>监测项</th>
                            <th>检测数据</th>
                        </tr>
                        </thead>
                        <tbody id="table-tbody-applicationRunningStatus">
                        </tbody>
                    </table>


                    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                        <legend>设备运行状态</legend>
                    </fieldset>

                    <table class="layui-table" lay-even="" lay-skin="row" id="equipmentOperatingStatus">
                        <colgroup>
                            <col width="150">
                            <col width="150">
                            <col width="150">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>设备名</th>
                            <th>运行状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="table-tbody-equipmentOperatingStatus">
                        </tbody>
                    </table>

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

        // //展示系统网口
        // table.render({
        //     elem: '#NetportsState'
        //     , url: './systemInformation/getNetportsState'
        //     , cellMinWidth: 80
        //     , cols: [[ //标题栏
        //         {field: 'devName', title: '网口名称'}
        //         , {field: 'devState', title: '网口状态'}
        //     ]]
        //     , skin: 'line' //表格风格
        //     , even: true
        //     , page: true //是否显示分页
        //     , limits: [5, 7, 10]
        //     , limit: 5 //每页默认显示的数量
        // });

        //展示系统串口
        // table.render({
        //     elem: '#ComportsState'
        //     , url: './systemInformation/getComportsState'
        //     , cellMinWidth: 80
        //     , cols: [[ //标题栏
        //         {field: 'devName', title: '串口名称'}
        //         , {field: 'devState', title: '串口状态'}
        //     ]]
        //     , skin: 'line' //表格风格
        //     , even: true
        //     , page: true //是否显示分页
        //     , limits: [5, 7, 10]
        //     , limit: 5 //每页默认显示的数量
        // });


        //展示系统资源使用状态
        // table.render({
        //     elem: '#systemResourceUsageStatus'
        //     , url: './systemInformation/getSystemResourcesState'
        //     , cellMinWidth: 80
        //     , cols: [[ //标题栏
        //         {field: 'name', title: '监测项'}
        //         , {field: 'val', title: '检测数据'}
        //         , {field: 'c_devid', title: '说明'}
        //     ]],
        //     data: [{
        //         "c_devid": "1"
        //     }, {
        //
        //         "c_devid": "1"
        //     }, {
        //         "c_devid": "1"
        //     }]
        //     , skin: 'line' //表格风格
        //     , even: true
        //     , page: true //是否显示分页
        //     , limits: [5, 7, 10]
        //     , limit: 5 //每页默认显示的数量
        // });

        //展示应用运行状态
        // table.render({
        //     elem: '#applicationRunningStatus'
        //     , url: './systemInformation/getAppRunState'
        //     , cellMinWidth: 80
        //     , cols: [[ //标题栏
        //         {field: 'name', title: '监测项'}
        //         , {field: 'val', title: '检测数据'}
        //
        //     ]]
        //     , skin: 'line' //表格风格
        //     , even: true
        //     , page: true //是否显示分页
        //     // , limits: [5, 7, 10]
        //     , limit: 7 //每页默认显示的数量
        // });


        //展示设备运行状态
        // table.render({
        //     elem: '#equipmentOperatingStatus'
        //     , url: './dataMonitor/getDevicesState'
        //     , cellMinWidth: 80
        //     , cols: [[ //标题栏
        //         {field: 'devName', title: '设备名'}
        //         , {field: 'devState', title: '运行状态'}
        //         ,
        //         {
        //             field: 'operate', title: '操作', toolbar: '#operateTpl', unresize: true
        //         }
        //     ]]
        //     , skin: 'line' //表格风格
        //     , even: true
        //     , page: true //是否显示分页
        //     , limits: [5, 7, 10]
        //     , limit: 5 //每页默认显示的数量
        // });

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
            url: "./systemInformation/getSystemResourcesState",
            type: "get",
            dataType: "json",
            async: true,//这得注意是异步
            success: function (result) {
                $("#table-tbody-systemResourceUsageStatus").html("");
                resultData = result.data;
                for (var x in resultData) {
                    htmls = "<tr>" +
                        "<td>" + resultData[x].name + "</td>" +
                        "<td>" + resultData[x].val + "</td>" +
                        "</tr>";
                    $("#table-tbody-systemResourceUsageStatus").append(htmls);
                }
            }

        });

        $.ajax({
            url: "./systemInformation/getAppRunState",
            type: "get",
            dataType: "json",
            async: true,//这得注意是异步
            success: function (result) {
                $("#table-tbody-applicationRunningStatus").html("");
                resultData = result.data;
                for (var x in resultData) {
                    htmls = "<tr>" +
                        "<td>" + resultData[x].name + "</td>" +
                        "<td>" + resultData[x].val + "</td>" +
                        "</tr>";
                    $("#table-tbody-applicationRunningStatus").append(htmls);
                }
            }

        });


        $.ajax({
            url: "./dataMonitor/getDevicesState",
            type: "get",
            dataType: "json",
            async: true,//这得注意是异步
            success: function (result) {
                $("#table-tbody-equipmentOperatingStatus").html("");
                resultData = result.data;
                for (var x in resultData) {
                    htmls = "<tr>" +
                        "<td>" + resultData[x].devName + "</td>" +
                        "<td>" + resultData[x].devState + "</td>" +
                        "<td><button class=\"layui-btn layui-btn-sm\" onclick=\"operateTpl_open(this,'要开启设备的ID')\" href=\"javascript:;\">开启</button></td>" +
                        "</tr>";
                    $("#table-tbody-equipmentOperatingStatus").append(htmls);
                }
            }

        });
        //
        // $.ajax({
        //     url: "./systemInformation/getNetportsState",
        //     type: "get",
        //     dataType: "json",
        //     async: true,//这得注意是异步
        //     success: function (result) {
        //         $("#NetportsState").html("");
        //         resultData = result.data;
        //         for (var x in resultData) {
        //             htmls = "<button class=\"layui-btn\" style=\"background-color: #5FB878; height: 17px\"></button>   " + resultData[x].devName + "状态：" + resultData[x].devState;
        //             if (x % 6 == 0) {
        //                 htmls = "<HR SIZE=10>";
        //             }
        //             $("#NetportsState").append(htmls);
        //         }
        //     }
        //
        // });

        $.ajax({
            url: "./systemInformation/getComportsState",
            type: "get",
            dataType: "json",
            async: true,//这得注意是异步
            success: function (result) {
                $("#ComportsState").html("");
                resultData = result.data;
                for (var x in resultData) {
                    // htmls = "<button class=\"layui-btn\" style=\"background-color: #5FB878; height: 17px\"></button>   " + resultData[x].devName + "状态：" + resultData[x].devState;
                    htmls = "<button class=\"layui-btn\" style=\"background-color:" + resultData[x].devState + "; height: 17px\"></button>   " + resultData[x].devName;
                    if (x % 7 == 0) {
                        htmls = "<HR SIZE=10>";
                    }
                    $("#ComportsState").append(htmls);
                }
            }

        });
    }


</script>
</html>