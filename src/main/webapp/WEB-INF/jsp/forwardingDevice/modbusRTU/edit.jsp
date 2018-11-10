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
    <title>编辑-转发设备配置-Modbus透传转发-后台管理系统</title>
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
            <label for="L_equipmentName" class="layui-form-label">
                <span class="we-red">*</span>设备名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_equipmentName" name="name" lay-verify="required|nikename"
                       autocomplete="off"
                       class="layui-input" readonly>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_Weights" class="layui-form-label">
                <span class="we-red">*</span>端口号
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_Weights" name="port" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_primaryIp" class="layui-form-label">
                命令超时
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_primaryIp" name="cmdTimeout" lay-verify="" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_backupIP" class="layui-form-label">
                转发空地址
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_backupIP" name="allowEmptyAddr" lay-verify="" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_portNumber" class="layui-form-label">
                16位数据字节序
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_portNumber" name="byteOrder16" lay-verify="" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_acquisitionCycle" class="layui-form-label">
                32位数据字节序
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_acquisitionCycle" name="byteOrder32" lay-verify=""
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_acquisitionTimeout" class="layui-form-label">
                64位数据字节序
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_acquisitionTimeout" name="byteOrder64" lay-verify=""
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_commandTimeout" class="layui-form-label">
                命令队列大小
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_commandTimeout" name="cmdCacheSize" autocomplete="off"
                       class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                6到16个字符
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_active" class="layui-form-label">
                激活
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_active" name="active" autocomplete="off" class="layui-input">
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
            ]
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
            var port = aa.data.port;
            var cmd_timeout = aa.data.cmd_timeout;
            var allow_empty_addr = aa.data.allow_empty_addr;
            var byte_order16 = aa.data.byte_order16;
            var byte_order32 = aa.data.byte_order32;
            var byte_order64 = aa.data.byte_order64;
            var cmd_cache_size = aa.data.cmd_cache_size;
            var active = aa.data.active;


            $('input[name="name"]').val(name);
            $('input[name="port"]').val(port);
            $('input[name="cmdTimeout"]').val(cmd_timeout);
            $('input[name="allowEmptyAddr"]').val(allow_empty_addr);
            $('input[name="byteOrder16"]').val(byte_order16);
            $('input[name="byteOrder32"]').val(byte_order32);
            $('input[name="byteOrder64"]').val(byte_order64);
            $('input[name="cmdCacheSize"]').val(cmd_cache_size);
            $('input[name="active"]').val(active);

            form.render();
        }

        //监听提交
        form.on('submit(add)', function (data) {
            console.log(data);
            //发异步，把数据提交给php
            layer.alert("增加成功", {
                icon: 6
            }, function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
            return false;
        });

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