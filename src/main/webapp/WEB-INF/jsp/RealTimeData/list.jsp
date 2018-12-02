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
    <title>实时数据监视-后台管理系统</title>
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
                        <legend>实时数据监视</legend>
                    </fieldset>
                    <div class="layui-row" data-type="userReload">

                        <div class="layui-form layui-col-md12 we-search Table">

                            采集设备名称：
                            <div class="layui-inline">
                                <select name="cdev" id="cdev" lay-filter="cdev" style="width: 10px">
                                    <option value="请选择"></option>
                                </select>
                            </div>
                            &nbsp;&nbsp;&nbsp;转发设备名称：
                            <div class="layui-inline">
                                <select name="fdev" id="fdev" lay-filter="fdev">
                                    <option value="请选择"></option>
                                </select>
                            </div>
                            &nbsp;&nbsp;
                            <div class="layui-inline">
                                <input class="layui-input" name="name" id="name" autocomplete="off"
                                       placeholder="请输入点名称">
                            </div>
                            &nbsp;&nbsp;
                            <button class="layui-btn" data-type="search">搜索</button>
                            <button class="layui-btn" data-type="export" id="exportAll">导出</button>
                        </div>
                    </div>
                    <table class="layui-table" id="realtimeData"></table>

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

    var tableIns;

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
        var _cur_page;
        var _cur_limit;
        //展示实时数据监视
        tableIns = table.render({
            elem: '#realtimeData',
            url: './dataMonitor/searchRealData',
            cellMinWidth: 80,
            cols: [[ //标题栏
                {field: 'name', title: '点名'}
                , {field: 'v', title: '值'}
                , {field: 't', title: '时间'}
                , {field: 'q', title: '质量'}
                , {field: 'r', title: '描述'}
            ]]
            , id: 'TableReload'
            , skin: 'line' //表格风格
            , even: true
            // , size: 'sm'
            , page: true //是否显示分页
            , limits: [10, 30, 50]
            , limit: 10 //每页默认显示的数量
            , done: function (res, curr, limit) {
                _cur_page = curr;
                _cur_limit = limit;
            }
        });


        $('#exportAll').on('click', function () {
            $.ajax({
                url: "./dataMonitor/searchRealData?page=1&limit=10",
                type: "get",
                dataType: "json",
                success: function(res) {
                    console.info(res)
                    if(res.code==200){
                        table.exportFile(['名字','电话','所属区域', '来源'], res.data, 'xls');
                    }
                }
            });
        });

        /*
         *数据表格中form表单元素是动态插入,所以需要更新渲染下
         * http://www.layui.com/doc/modules/form.html#render
         * */
        $(function () {
            form.render();

            // setInterval(table, 1000);

            function table() {
                tableIns.reload({
                    // url: './dataMonitor/queryRealData',
                    page: {
                        curr: _cur_page//重新从第 1 页开始

                    }
                });
            }
        });

        var resultData;

        var htmls = '<option value="">请选择</option>'; //全局变量
        var htmls2 = '<option value="">请选择</option>'; //全局变量
        $.ajax({
            url: "./pointsConfig/queryDriver",
            type: "get",
            dataType: "json",
            // contentType: "application/json",
            async: false,//这得注意是同步
            success: function (result) {
                resultData = result.data;
                for (var x in resultData) {
                    htmls += '<option value = "' + resultData[x].c_dev + '">' + resultData[x].c_dev + '</option>';
                    htmls2 += '<option value = "' + resultData[x].f_dev + '">' + resultData[x].f_dev + '</option>'
                }
                $("#cdev").html(htmls);
                $("#fdev").html(htmls2);
            }
        });
        form.render('select');//需要渲染一下

        var $ = layui.$, active = {
            search: function () {
                var name = $('#name');
                var cdev = $('#cdev');
                var fdev = $('#fdev');

                table.reload('TableReload', {
                    where: {
                        name: name.val(),
                        cdev: cdev.val(),
                        fdev: fdev.val(),
                    }
                });
            },
            export: function () {

            }
        };

        $('.Table .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });

</script>

<script>


</script>
</html>