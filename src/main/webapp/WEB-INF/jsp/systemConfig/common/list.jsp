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
    <title>通用配置-后台管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../static/css/font.css">
    <link rel="stylesheet" href="../static/css/weadmin.css">
    <link rel="stylesheet" href="../static/css/view.css"/>
    <link rel="stylesheet" href="../static/css/layui.css">
    <!--&lt;!&ndash; 让IE8/9支持媒体查询，从而兼容栅格 &ndash;&gt;-->
    <!--&lt;!&ndash;[if lt IE 9]>-->
    <!--<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>-->
    <!--<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>-->
    <![endif]-->
</head>

<body class="layui-view-body">
<div class="layui-content">
    <div class="layui-row layui-col-space20">

        <div class="layui-col-sm12 layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body chart-card">
                    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                        <legend>通用配置</legend>
                    </fieldset>
                    <div class="layui-card-body">
                        <form class="layui-form" action="">
                            <div class="layui-form-item">
                                <label class="layui-form-label">名称</label>
                                <div class="layui-input-block">
                                    <input type="text" name="Project_name" lay-verify="title" autocomplete="off"
                                           placeholder="请输入名称" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">是否启用冗余（默认开）</label>
                                <div class="layui-input-block">
                                    <input type="checkbox" checked="" name="enable_redun" lay-skin="switch"
                                           lay-filter="switchTest_hash" lay-text="ON|OFF">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">备用产品IP地址：</label>
                                <div class="layui-input-block">
                                    <input type="text" name="IP1" lay-verify="ip" autocomplete="off"
                                           placeholder="请输入IP1" class="layui-input">

                                </div>
                                <div class="layui-input-block">

                                    <input type="text" name="IP2" lay-verify="ip" autocomplete="off"
                                           placeholder="请输入IP2" class="layui-input">

                                </div>
                                <div class="layui-input-block">

                                    <input type="text" name="IP3" lay-verify="ip" autocomplete="off"
                                           placeholder="请输入IP3" class="layui-input">

                                </div>
                            </div>
                            <!--<div class="layui-form-item layui-form-text">
                                  <label class="layui-form-label">编辑器</label>
                                  <div class="layui-input-block">
                                    <textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="LAY_demo_editor_hash"></textarea>
                                  </div>
                                </div>-->
                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <button class="layui-btn" lay-submit="" lay-filter="demo1_hash">立即提交</button>
                                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="../lib/layui/layui.js" charset="utf-8"></script>
<script>
    layui.extend({
        admin: '{/}../static/js/admin'
    });

    layui.use(['table', 'form', 'admin'], function () {
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
    });


</script>
</html>