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
    <title>编辑-采集设备配置-ABCIP采集-后台管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../../static/css/font.css">
    <link rel="stylesheet" href="../../static/css/weadmin.css">
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="weadmin-body">
    <form class="layui-form" action="goEdit" method="post">
        <div class="layui-form-item">
            <label for="L_name" class="layui-form-label">
                <span class="we-red">*</span>设备名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_name" name="name" lay-verify="required|nikename"
                       autocomplete="off"
                       class="layui-input" readonly>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_weight" class="layui-form-label">
                <span class="we-red">*</span>权重
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_weight" name="weight" lay-verify="required|nikename" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_main_ip" class="layui-form-label">
                <span class="we-red">*</span>主IP
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_main_ip" name="mainIp" lay-verify="required|ip" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_back_ip" class="layui-form-label">
                备IP
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_back_ip" name="backIp" lay-verify="back_ip" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_port" class="layui-form-label">
                <span class="we-red">*</span>端口号
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_port" name="port" lay-verify="required|nikename" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_clct_interval" class="layui-form-label">
                采集周期
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_clct_interval" name="clctInterval" lay-verify="number"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_clct_timeout" class="layui-form-label">
                采集超时
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_clct_timeout" name="clctTimeout" lay-verify="number"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_cmd_timeout" class="layui-form-label">
                命令超时
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_cmd_timeout" name="cmdTimeout" lay-verify="number" autocomplete="off"
                       class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                提示信息
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_package_len" class="layui-form-label">
                包长度
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_package_len" name="packageLen" lay-verify="number" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_package_len" class="layui-form-label">
                路由地址
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_route" name="route" lay-verify="" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_cmdCacheSize" class="layui-form-label">
                命令队列大小
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_cmdCacheSize" name="cmdCacheSize" lay-verify="number" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_active" class="layui-form-label">
                激活
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_active" name="active" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
            </label>
            <button class="layui-btn" id="L_repass" lay-filter="edit" lay-submit="">确定</button>
            <!--<input type="text" name="dataId" id="dataId" value=""/>-->
        </div>
    </form>
</div>
<script src="../../lib/layui/layui.js" charset="utf-8"></script>
<script>
    var aa = window.parent.aa;
    layui.extend({
        admin: '{/}../../static/js/admin'
    });

    layui.use(['form', 'jquery', 'admin', 'layer'], function () {
        var form = layui.form,
            $ = layui.jquery,
            admin = layui.admin,
            layer = layui.layer;

        //自定义验证规则
        form.verify({
            nikename: function (value) {
                if (value.length < 1) {
                    return '不能为空';
                }
            },
            back_ip: function (value) {
                var reg = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
                if (value.length > 0) {
                    if (!reg.test(value)) {
                        return "请检查IP地址";
                    }
                }
            },
            ip: [
                /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/
                , '请检查IP地址是否输入正确？'
            ],
        });
        //页面初始化加载
        $(function () {
            setTimeout(function () {
                frameVal();
            }, 100);
        });

        function frameVal() {
            var dataId = $('input[name="dataId"]').val();
            console.log(dataId);
            var index = parent.layer.getFrameIndex(window.name);

            var name = aa.data.name;
            var weight = aa.data.weight;
            var main_ip = aa.data.main_ip;
            var back_ip = aa.data.back_ip;
            var port = aa.data.port;
            var clct_interval = aa.data.clct_interval;
            var clct_timeout = aa.data.clct_timeout;
            var cmd_timeout = aa.data.cmd_timeout;
            var package_len = aa.data.package_len;
            var route = aa.data.route;
            var cmd_cache_size = aa.data.cmd_cache_size;
            var active = aa.data.active;

            $('input[name="name"]').val(name);
            $('input[name="weight"]').val(weight);
            $('input[name="mainIp"]').val(main_ip);
            $('input[name="backIp"]').val(back_ip);
            $('input[name="port"]').val(port);
            $('input[name="clctInterval"]').val(clct_interval);
            $('input[name="clctTimeout"]').val(clct_timeout);
            $('input[name="cmdTimeout"]').val(cmd_timeout);
            $('input[name="packageLen"]').val(package_len);
            $('input[name="route"]').val(route);
            $('input[name="cmdCacheSize"]').val(cmd_cache_size);
            $('input[name="active"]').val(active);

            form.render();
        }

        form.on('submit(edit)', function (data) {
            var index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});
            $.ajax({
                url: data.form.action,
                type: data.form.method,
                data: $(data.form).serialize(),
                dataType: "json",
                success: function (info) {
                    console.log(info);
                    console.log(info.code);
                    if (info.code === 201) {
                        setTimeout(function () {
                            top.layer.close(index);
                            top.layer.msg(info.msg);
                            layer.closeAll("iframe");
                            //刷新父页面
                            parent.location.reload();
                        }, 1000);
                    }
                },
                error: function (info) {
                    if (info.code === 200) {
                        setTimeout(function () {
                            top.layer.close(index);
                            top.layer.msg("用户添加成功！");
                            layer.closeAll("iframe");
                            //刷新父页面
                            parent.location.reload();
                        }, 1000);
                    }
                }
            });
            return false;
        });

    });
</script>
</body>

</html>