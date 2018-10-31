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
    <title>转发设备配置-Modbus透传转发-后台管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../static/css/font.css">
    <link rel="stylesheet" href="../static/css/weadmin.css">
    <link rel="stylesheet" href="../static/css/view.css"/>
    <link rel="stylesheet" href="../static/css/layui.css">
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
                        <legend>ModbusRTU转发</legend>
                    </fieldset>
                    <div class="weadmin-block">
                        <button class="layui-btn" onclick="WeAdminShow('添加Modbus透传配置','./modbusRTU/add',500,600)"><i
                                class="layui-icon"></i>添加
                        </button>
                        <!--<span class="fr" style="line-height:40px">共有数据：88 条</span>-->
                    </div>
                    <table class="layui-table" id="ABCIPCollect"></table>
                </div>
            </div>
        </div>
        <script type="text/html" id="operateTpl">
            <a title="编辑" onclick="WeAdminEdit('编辑','./modbusRTU/edit', 2, 600, 400)" href="javascript:;">
                <i class="layui-icon">&#xe642;</i>
            </a>
            <a title="删除" onclick="modbusRTU_del(this,'要删除的id')" href="javascript:;">
                <i class="layui-icon">&#xe640;</i>
            </a>
        </script>
    </div>
</div>
</body>
<script src="../lib/layui/layui.js" charset="utf-8"></script>
<script>layui.extend({
    admin: '{/}../static/js/admin'
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

    //展示IP配置数据
    table.render({
        elem: '#ABCIPCollect',
        cellMinWidth: 80,
        cols: [[ //标题栏
            {field: 'equipmentName', title: '设备名称'}
            , {field: 'Weights', title: '权重'}
            , {field: 'primaryIp', title: '主IP'}
            , {field: 'backupIP', title: '备IP'}
            , {field: 'portNumber', title: '端口号'}
            , {field: 'acquisitionCycle', title: '采集周期'}
            , {field: 'acquisitionTimeout', title: '采集超时'}
            , {field: 'commandTimeout', title: '命令超时'}
            , {field: 'allowedFailures', title: '允许失败次数'}
            , {field: 'packetLength', title: '包长度'}
            ,{
                field: 'operate', title: '操作', toolbar: '#operateTpl', unresize: true
            }
        ]],
        data: [{
            "equipmentName": "DEV1"
            , "Weights": "60"
            , "primaryIp": "192.168.1.1"
            , "backupIP": "192.168.1.1"
            , "portNumber": "502"
            , "acquisitionCycle": "1000"
            , "acquisitionTimeout": "2000"
            , "commandTimeout": "4000"
            , "allowedFailures": "3"
            , "packetLength": "256"
        },{
            "equipmentName": "DEV1"
            , "Weights": "60"
            , "primaryIp": "192.168.1.1"
            , "backupIP": "192.168.1.1"
            , "portNumber": "502"
            , "acquisitionCycle": "1000"
            , "acquisitionTimeout": "2000"
            , "commandTimeout": "4000"
            , "allowedFailures": "3"
            , "packetLength": "256"
        },{
            "equipmentName": "DEV1"
            , "Weights": "60"
            , "primaryIp": "192.168.1.1"
            , "backupIP": "192.168.1.1"
            , "portNumber": "502"
            , "acquisitionCycle": "1000"
            , "acquisitionTimeout": "2000"
            , "commandTimeout": "4000"
            , "allowedFailures": "3"
            , "packetLength": "256"
        },{
            "equipmentName": "DEV1"
            , "Weights": "60"
            , "primaryIp": "192.168.1.1"
            , "backupIP": "192.168.1.1"
            , "portNumber": "502"
            , "acquisitionCycle": "1000"
            , "acquisitionTimeout": "2000"
            , "commandTimeout": "4000"
            , "allowedFailures": "3"
            , "packetLength": "256"
        },{
            "equipmentName": "DEV1"
            , "Weights": "60"
            , "primaryIp": "192.168.1.1"
            , "backupIP": "192.168.1.1"
            , "portNumber": "502"
            , "acquisitionCycle": "1000"
            , "acquisitionTimeout": "2000"
            , "commandTimeout": "4000"
            , "allowedFailures": "3"
            , "packetLength": "256"
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


    /*modbus诱传-删除*/
    window.modbusRTU_del = function (obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已删除!', {
                icon: 1,
                time: 1000
            });
        });
    }
});
</script>
</html>