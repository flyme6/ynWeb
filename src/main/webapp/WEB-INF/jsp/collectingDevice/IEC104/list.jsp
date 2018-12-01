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
    <title>采集设备配置-IEC104采集-后台管理系统</title>
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
                        <legend>IEC104采集</legend>
                    </fieldset>
                    <div class="weadmin-block">
                        <button class="layui-btn" onclick="WeAdminShow('添加IEC104采集配置','./IEC104/add',500,600)"><i
                                class="layui-icon"></i>添加
                        </button>
                        <!--<span class="fr" style="line-height:40px">共有数据：88 条</span>-->
                    </div>
                    <table class="layui-table" id="ABCIPCollect" lay-filter="modbusTCP"></table>
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
<script src="../lib/layui/layui.js" charset="utf-8"></script>
<script>
    var aa;
    layui.extend({
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
            url: '../collectingDevice/IEC104/query',//数据接口
            cellMinWidth: 80,
            cols: [[ //标题栏
                {field: 'name', title: '设备名称'}
                , {field: 'weight', title: '权重'}
                , {field: 'main_ip', title: '主IP'}
                , {field: 'back_ip', title: '备IP'}
                , {field: 'port', title: '端口号'}
                , {field: 's_init', title: '发送初始序号'}
                , {field: 'r_init', title: '接收初始序号'}
                , {field: 'r_cache_size', title: '允许接收未确认帧数'}
                , {field: 's_cache_size', title: '允许发送未确认帧数'}
                , {field: 'pub_addr_size', title: '公共地址长度'}
                , {field: 'reason_size', title: '传输原因长度'}
                , {field: 'info_addr_size', title: '信息地址长度'}
                , {field: 'timer0', title: '定时器0'}
                , {field: 'timer1', title: '定时器1'}
                , {field: 'timer2', title: '定时器2'}
                , {field: 'timer3', title: '定时器3'}
                , {field: 'cmd_cache_size', title: '命令队列大小'}
                , {field: 'active', title: '激活'}
                , {
                    field: 'operate', title: '操作', toolbar: '#operateTpl', unresize: true, fixed: 'right'
                }
            ]]
            , skin: 'line' //表格风格
            , even: true
            , size: 'sm'
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

        table.on('tool(modbusTCP)', function (obj) {
            // var data = obj.data;//获得当前行数据
            // console.log("ceshi");
            // console.log(data);
            var id = $(this).parent('div').parent('td').parent('tr').attr('data-index');
            var layEvent = obj.event; //获得 lay-event 对应的值
            if (layEvent === 'edit') {
                aa = obj;
                console.info(aa);
                WeAdminEdit('编辑', './IEC104/edit', id, 600, 400)
            } else if (layEvent === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    //向服务端发送删除指令
                    $.ajax({
                        url: "IEC104/goDel",
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

    });

</script>
</html>