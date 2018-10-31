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
    <title>添加-采集设备配置-ABCIP采集-后台管理系统</title>
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
            <label for="L_name" class="layui-form-label">
                <span class="we-red">*</span>设备名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_name" name="name" lay-verify="required|nikename"
                       autocomplete="off"
                       class="layui-input">
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
                <input type="text" id="L_main_ip" name="main_ip" lay-verify="required|nikename" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_back_ip" class="layui-form-label">
                <span class="we-red">*</span>备IP
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_back_ip" name="back_ip" lay-verify="required|nikename" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_port" class="layui-form-label">
                <span class="we-red">*</span>端口号
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_port" name="port" lay-verify="required|nikename" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_clct_interval" class="layui-form-label">
                <span class="we-red">*</span>采集周期
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_clct_interval" name="clct_interval" lay-verify="required|nikename"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_clct_timeout" class="layui-form-label">
                <span class="we-red">*</span>采集超时
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_clct_timeout" name="clct_timeout" lay-verify="required|nikename"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_cmd_timeout" class="layui-form-label">
                <span class="we-red">*</span>命令超时
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_cmd_timeout" name="cmd_timeout" autocomplete="off"
                       class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                提示信息
            </div>
        </div>
        <!--<div class="layui-form-item">-->
            <!--<label for="L_allowedFailures" class="layui-form-label">-->
                <!--<span class="we-red">*</span>允许失败次数-->
            <!--</label>-->
            <!--<div class="layui-input-inline">-->
                <!--<input type="password" id="L_allowedFailures" name="allowedFailures" autocomplete="off"-->
                       <!--class="layui-input">-->
            <!--</div>-->
        <!--</div>-->
        <div class="layui-form-item">
            <label for="L_package_len" class="layui-form-label">
                <span class="we-red">*</span>包长度
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_package_len" name="package_len" autocomplete="off" class="layui-input">
            </div>
        </div>
        <!--缺省表 3个属性-->
        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
            </label>
            <button class="layui-btn" id="L_repass" lay-filter="add" lay-submit="">确定</button>
            <!--<input type="text" name="dataId" id="dataId" value=""/>-->
        </div>
    </form>
</div>
<script src="../../lib/layui/layui.js" charset="utf-8"></script>
</body>

</html>