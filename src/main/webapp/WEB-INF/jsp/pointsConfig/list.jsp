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
    <title>点表配置-后台管理系统</title>
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
                        <legend>点表配置</legend>
                    </fieldset>
                    <div class="layui-row">
                        <div class="layui-form layui-col-md12 we-search demoTable">
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
                            <button class="layui-btn" data-type="reload">搜索</button>
                        </div>
                    </div>
                    <div class="weadmin-block">
                        <button class="layui-btn" onclick="WeAdminShow('添加点表配置','./pointsConfig/add',600,400)"><i
                                class="layui-icon"></i>添加
                        </button>
                    </div>
                    <table class="layui-table" id="points" lay-filter="modbusTCP"></table>
                </div>
            </div>
        </div>
        <script type="text/html" id="operateTpl">
            <a title="编辑" lay-event="edit" href="javascript:"><i class="layui-icon">&#xe642;</i></a>
            <a title="删除" lay-event="del" href="javascript:"><i class="layui-icon">&#xe640;</i></a>
        </script>
    </div>
</div>
</body>
<script src="lib/layui/layui.js" charset="utf-8"></script>
<script>
    var aa;
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
                console.info(resultData + "resultData");
                for (var x in resultData) {
                    htmls += '<option value = "' + resultData[x].c_dev + '">' + resultData[x].c_dev + '</option>';
                    htmls2 += '<option value = "' + resultData[x].f_dev + '">' + resultData[x].f_dev + '</option>'
                }
                $("#cdev").html(htmls);
                $("#fdev").html(htmls2);
            }
        });
        form.render('select');//需要渲染一下

        //方法级渲染
        table.render({
            elem: '#points'
            , url: './pointsConfig/Search'
            , cols: [[ //标题栏
                {field: 'name', title: '点名', width: 170}
                , {field: 'desc', title: '点描述'}
                , {field: 'c_dev', title: '采集设备名', width: 120}
                , {field: 'c_devid', title: '采集设备IP', width: 120}
                , {field: 'c_inaddr', title: '采集地址'}
                , {field: 'c_intype', title: '采集点类型'}
                , {field: 'f_dev', title: '转发设备名', width: 170}
                , {field: 'f_devid', title: '转发设备ID'}
                , {field: 'f_inaddr', title: '转发地址'}
                , {field: 'f_intype', title: '转发点类型'}
                , {
                    field: 'operate', title: '操作', toolbar: '#operateTpl', unresize: true
                }
            ]]
            , id: 'TableReload'
            , skin: 'line' //表格风格
            , even: true
            , size: 'sm'
            , page: true //是否显示分页
            , limits: [10, 30, 50]
            , limit: 10 //每页默认显示的数量
            // , height: 600
        });

        var $ = layui.$, active = {
            reload: function () {
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
            }
        };

        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        table.on('tool(modbusTCP)', function (obj) {
            // var data = obj.data;//获得当前行数据
            // console.log("ceshi");
            // console.log(data);
            var id = $(this).parent('div').parent('td').parent('tr').attr('data-index');
            var layEvent = obj.event; //获得 lay-event 对应的值
            if (layEvent === 'edit') {
                aa = obj;
                console.info(aa);
                WeAdminEdit('编辑', './pointsConfig/edit', id, 600, 400)
            } else if (layEvent === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    //向服务端发送删除指令
                    $.ajax({
                        url: "pointsConfig/goDel",
                        data: "name=" + obj.data.name,
                        type: "GET",
                        dataType: "json",
                        success: function (msg) {
                            obj.del(); //删除对应行（tr）的DOM结构
                            layer.close(index);
                        },
                        error: function (error) {
                            alert(error + "出现异常");
                        }
                    });
                });
            }
            console.log(id);

        });


        /*
         *数据表格中form表单元素是动态插入,所以需要更新渲染下
         * http://www.layui.com/doc/modules/form.html#render
         * */
        $(function () {
            form.render();
        });

        /*ABCIP-删除*/
        window.pointsConfig_del = function (obj, id) {
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