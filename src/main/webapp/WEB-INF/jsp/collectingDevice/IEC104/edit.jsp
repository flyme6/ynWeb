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
    <title>编辑-采集设备配置-IEC104采集-后台管理系统</title>
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
                <input type="number" id="L_weight" name="weight" lay-verify="required" autocomplete="off"
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
                <input type="number" id="L_port" name="port" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_s_init" class="layui-form-label">
                发送初始序号
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_s_init" name="sInit" lay-verify=""
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_r_init" class="layui-form-label">
                接收初始序号
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_r_init" name="rInit" lay-verify=""
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_r_cache_size" class="layui-form-label">
                允许接收未确认帧数
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_r_cache_size" name="rCacheSize" autocomplete="off"
                       class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                提示信息
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_s_cache_size" class="layui-form-label">
                允许发送未确认帧数
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_s_cache_size" name="sCacheSize" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_pub_addr_size" class="layui-form-label">
                公共地址长度
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_pub_addr_size" name="pubAddrSize" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_reason_size" class="layui-form-label">
                传输原因长度
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_reason_size" name="reasonSize" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_infoAddrSize" class="layui-form-label">
                信息地址长度
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_infoAddrSize" name="infoAddrSize" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_Timer0" class="layui-form-label">
                定时器0
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_Timer0" name="timer0" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_Timer1" class="layui-form-label">
                定时器1
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_Timer1" name="timer1" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_Timer2" class="layui-form-label">
                定时器2
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_Timer2" name="timer2" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_Timer3" class="layui-form-label">
                定时器3
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_Timer3" name="timer3" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_cmd_cache_size" class="layui-form-label">
                命令队列大小
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_cmd_cache_size" name="cmdCacheSize" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_active" class="layui-form-label">
                激活
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_active" name="active" autocomplete="off"
                       class="layui-input">
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
            // nikename: function (value) {
            //     if (value.length < 1) {
            //         return '不能为空';
            //     }
            // },
            nikename: function (value) {
                var reg = /^[a-z]\w{1,19}$/;
                if (value.length > 0) {
                    if (!reg.test(value)) {
                        return "必须以字母开头";
                    }
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
            var s_init = aa.data.s_init;
            var r_init = aa.data.r_init;
            var r_cache_size = aa.data.r_cache_size;
            var s_cache_size = aa.data.s_cache_size;
            var pub_addr_size = aa.data.pub_addr_size;
            var reason_size = aa.data.reason_size;
            var info_addr_size = aa.data.info_addr_size;
            var timer0 = aa.data.timer0;
            var timer1 = aa.data.timer1;
            var timer2 = aa.data.timer2;
            var timer3 = aa.data.timer3;
            var cmd_cache_size = aa.data.cmd_cache_size;
            var active = aa.data.active;

            $('input[name="name"]').val(name);
            $('input[name="weight"]').val(weight);
            $('input[name="mainIp"]').val(main_ip);
            $('input[name="backIp"]').val(back_ip);
            $('input[name="port"]').val(port);
            $('input[name="sInit"]').val(s_init);
            $('input[name="rInit"]').val(r_init);
            $('input[name="rCacheSize"]').val(r_cache_size);
            $('input[name="sCacheSize"]').val(s_cache_size);
            $('input[name="pubAddrSize"]').val(pub_addr_size);
            $('input[name="reasonSize"]').val(reason_size);
            $('input[name="infoAddrSize"]').val(info_addr_size);
            $('input[name="timer0"]').val(timer0);
            $('input[name="timer1"]').val(timer1);
            $('input[name="timer2"]').val(timer2);
            $('input[name="timer3"]').val(timer3);
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
                            top.layer.msg(info.msg);
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