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
    <title>通信报文监视-后台管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="static/css/font.css">
    <link rel="stylesheet" href="static/css/weadmin.css">
    <link rel="stylesheet" href="static/css/view.css"/>
    <link rel="stylesheet" href="static/css/layui.css">
    <script src="static/js/jquery.js"></script>
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
                        <legend align="top">通信报文监视</legend>
                    </fieldset>
                    <div class="layui-row we-search">
                        按设备过滤：
                        <div class="layui-inline ">
                            <select id="deviceList"></select>
                        </div>
                        <button class="layui-btn layui-btn-sm" id="exportButton" style="margin-left: 10px">导出</button>
                    </div>
                    <div id="communicationMessageBroder" style="background: #333; color: #aaa;">
                        <table id="communicationMessage" cellspacing="0" align="center"
                               style="margin-top: 10px; margin-left: 10px">
                            <tr><td>获取不到数据，请检查ynService是否启动</td></tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
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

        $(function () {
            form.render();
        });
    });
</script>

<script>
    var msgList = new Array();
    var dataPos = 0;
    var ITEMLIMIT = 100;

    $(window).load(function () {
        loadDeviceList();
        updateData();

        $("#exportButton").click(exportData);
        $("#deviceList").change(onChanged);
    });

    function loadDeviceList() {
        $.ajax({
            url: "./pointsConfig/queryDriver",
            type: "get",
            dataType: "json",
            async: true,//这得注意是异步
            success: function (result) {
                var resultData = result.data;
                console.info(resultData + "sad");
                var devListCtl = $("#deviceList");

                devListCtl.html("");
                for (var i in resultData) {
                    devListCtl.append("<option>" + resultData[i].c_dev + "</option>");
                }
            }
        });
    };

    function updateData() {
        $.ajax({
            url: "./communicationMessage/getDeviceDataFrames",
            data: {devName: $("#deviceList").val(), dataPos: dataPos, itemLimit: ITEMLIMIT},
            type: "get",
            dataType: "json",
            async: true,//这得注意是异步

            success: function (result) {
                var msgListCtl = $("#communicationMessage");
                var resultData = result.data;
                dataPos = resultData.dataPos;
                if (isNaN(dataPos))
                    dataPos = 0;

                for (var i in resultData.dataFrames) {
                    msgList.unshift(resultData.dataFrames[i]);
                    if (msgList.length > ITEMLIMIT)
                        msgList.pop();
                }

                msgListCtl.html("<tr><td>" + msgList.join("</td></tr><tr><td>") + "</td></tr>");
            },

            complete: function () {
                setTimeout(updateData, 2000);
            }
        });
    };

    function exportData() {
        var str = "";
        for (var i in msgList) {
            str += msgList[i] + '\n';
        }

        var url = 'data:text/txt;charset=utf-8,\ufeff' + encodeURIComponent(str);
        var link = document.createElement("a");
        link.href = url;
        link.download = $("#deviceList").val() + ".txt";
        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);
    };

    function onChanged() {
        msgList = new Array();
        dataPos = 0;
        $("#communicationMessage").html("");
    }
</script>
</html>