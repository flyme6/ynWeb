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
    <form class="layui-form">
        <div class="layui-form-item">
            <label for="L_equipmentName" class="layui-form-label">
                <span class="we-red">*</span>设备名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_equipmentName" name="equipmentName" lay-verify="required|nikename"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_Weights" class="layui-form-label">
                <span class="we-red">*</span>权重
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_Weights" name="username" lay-verify="required|nikename" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_primaryIp" class="layui-form-label">
                <span class="we-red">*</span>主IP
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_primaryIp" name="primaryIp" lay-verify="required|nikename" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_backupIP" class="layui-form-label">
                <span class="we-red">*</span>备IP
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_backupIP" name="backupIP" lay-verify="required|nikename" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_portNumber" class="layui-form-label">
                <span class="we-red">*</span>端口号
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_portNumber" name="portNumber" lay-verify="required|nikename" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_acquisitionCycle" class="layui-form-label">
                <span class="we-red">*</span>采集周期
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_acquisitionCycle" name="acquisitionCycle" lay-verify="required|nikename"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_acquisitionTimeout" class="layui-form-label">
                <span class="we-red">*</span>采集超时
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_acquisitionTimeout" name="acquisitionTimeout" lay-verify="required|nikename"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_commandTimeout" class="layui-form-label">
                <span class="we-red">*</span>命令超时
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_commandTimeout" name="commandTimeout" autocomplete="off"
                       class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                6到16个字符
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_allowedFailures" class="layui-form-label">
                <span class="we-red">*</span>允许失败次数
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_allowedFailures" name="allowedFailures" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_packetLength" class="layui-form-label">
                <span class="we-red">*</span>包长度
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_packetLength" name="packetLength" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
            </label>
            <button class="layui-btn" id="L_repass" lay-filter="add" lay-submit="">确定</button>
            <!--<input type="text" name="dataId" id="dataId" value=""/>-->
        </div>
    </form>
</div>
<script src="../../lib/layui/layui.js" charset="utf-8"></script>
<script>
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
                if (value.length < 5) {
                    return '昵称至少得5个字符啊';
                }
            }
        });
        //页面初始化加载
        $(function () {
            setTimeout(function () {
                frameVal();
            }, 100);
        });

        function frameVal() {
            var dataId = $('input[name="dataId"]').val();
            var index = parent.layer.getFrameIndex(window.name);
            parent.layui.jquery("#memberList tr").each(function () {
                if ($(this).attr('data-id') == dataId) {
                    console.log($(this));
                    var tdArr = $(this).children('td');
                    var username = tdArr.eq(2).text(); //姓名
                    var sex = tdArr.eq(3).text(); //性别
                    var phone = tdArr.eq(4).text(); //电话
                    var email = tdArr.eq(5).text(); //邮箱
                    var address = tdArr.eq(6).text(); //地址

                    $('input[name="username"]').val(username);
                    console.log("sex:" + sex);
                    $('input[name="sex"][value="' + sex + '"]').attr("checked", true);
                    $('input[name="phone"]').val(phone);
                    $('input[name="email"]').val(email);
                    $('input[name="address"]').val(address);
                    form.render();
                }
            });
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

    });
</script>
</body>

</html>