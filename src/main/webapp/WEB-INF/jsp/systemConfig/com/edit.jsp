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
    <title>编辑-串口配置-后台管理系统</title>
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
            <label for="L_portNumber" class="layui-form-label">
                <span class="we-red">*</span>串口号
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_portNumber" name="portNumber" lay-verify="required"
                       autocomplete="off"
                       class="layui-input" readonly>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_sendDelay" class="layui-form-label">
                发送间隔
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_sendDelay" name="sendDelay" lay-verify="" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_recvTimeout" class="layui-form-label">
                接受超时
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_recvTimeout" name="recvTimeout" lay-verify="" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_baudRate" class="layui-form-label">
                波特率
            </label>
            <div class="layui-input-inline">
                <%--<input type="number" id="L_baudRate" name="baudRate" lay-verify="" autocomplete="off"--%>
                <%--class="layui-input">--%>
                <select name="baudRate" lay-verify="" id="L_baudRate">
                    <option value="1200">1200</option>
                    <option value="2400">2400</option>
                    <option value="4800">4800</option>
                    <option value="9600">9600</option>
                    <option value="14400">14400</option>
                    <option value="19200">19200</option>
                    <option value="38400">38400</option>
                    <option value="56000">56000</option>
                    <option value="57600">57600</option>
                    <option value="115200">115200</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_parity" class="layui-form-label">
                奇偶校验
            </label>
            <div class="layui-input-inline">
                <%--<input type="text" id="L_parity" name="parity" lay-verify=""--%>
                <%--autocomplete="off"--%>
                <%--class="layui-input">--%>
                <select name="parity" lay-verify="" id="L_parity">
                    <option value="NONE">NONE</option>
                    <option value="EVEN">EVEN</option>
                    <option value="ODD">ODD</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_dataBits" class="layui-form-label">
                数据位
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_dataBits" name="dataBits" lay-verify=""
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_stopBits" class="layui-form-label">
                停止位
            </label>
            <div class="layui-input-inline">
                <input type="number" id="L_stopBits" name="stopBits" autocomplete="off"
                       class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                提示信息
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

            var port_number = aa.data.port_number;
            var send_delay = aa.data.send_delay;
            var recv_timeout = aa.data.recv_timeout;
            var baud_rate = aa.data.baud_rate;
            var parity = aa.data.parity;
            var data_bits = aa.data.data_bits;
            var stop_bits = aa.data.stop_bits;


            $('input[name="portNumber"]').val(port_number);
            $('input[name="sendDelay"]').val(send_delay);
            $('input[name="recvTimeout"]').val(recv_timeout);
            $('input[name="baudRate"]').val(baud_rate);
            $('input[name="parity"]').val(parity);
            $('input[name="dataBits"]').val(data_bits);
            $('input[name="stopBits"]').val(stop_bits);
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
                    top.layer.close(index);
                    top.layer.msg(info.msg);
                }
            });
            return false;
        });

    });
</script>
</body>

</html>