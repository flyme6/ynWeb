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
    <title>添加-转发设备配置-Modbus诱传-后台管理系统</title>
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
            <label for="L_port" class="layui-form-label">
                <span class="we-red">*</span>端口号
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_port" name="port" lay-verify="required|nikename" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_comm_timeout" class="layui-form-label">
                <span class="we-red">*</span>通信超时
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_comm_timeout" name="comm_timeout" lay-verify="required|nikename" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_client_limit" class="layui-form-label">
                <span class="we-red">*</span>最大客户端数量
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_client_limit" name="client_limit" lay-verify="required|nikename" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_cmd_timeout" class="layui-form-label">
                <span class="we-red">*</span>命令超时
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_cmd_timeout" name="cmd_timeout" lay-verify="required|nikename" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_allow_empty_addr" class="layui-form-label">
                <span class="we-red">*</span>转发空地址
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_allow_empty_addr" name="allow_empty_addr" lay-verify="required|nikename"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_byte_order16" class="layui-form-label">
                <span class="we-red">*</span>16位数据字节序
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_byte_order16" name="byte_order16" lay-verify="required|nikename"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_byte_order32" class="layui-form-label">
                <span class="we-red">*</span>32位数据字节序
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_byte_order32" name="byte_order32" autocomplete="off"
                       class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                提示信息
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_byte_order64" class="layui-form-label">
                <span class="we-red">*</span>64位数据字节序
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_byte_order64" name="byte_order64" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_cmd_cache_size" class="layui-form-label">
                <span class="we-red">*</span>命令队列大小
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_cmd_cache_size" name="cmd_cache_size" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_active" class="layui-form-label">
                <span class="we-red">*</span>激活
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_active" name="active" autocomplete="off" class="layui-input">
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
</body>

</html>