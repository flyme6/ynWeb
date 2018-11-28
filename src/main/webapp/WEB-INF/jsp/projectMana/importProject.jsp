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
    <title>打开本地工程-后台管理系统</title>
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
                        <legend>打开本地工程(只支持zip|rar|7z格式)</legend>
                    </fieldset>
                    <div class="layui-card-body">
                        <div class="form-box">
                            <div class="layui-upload">
                                <button type="button" class="layui-btn layui-btn-normal" id="chooseFile">选择文件</button>
                                <button type="button" class="layui-btn" id="statrFile">开始上传</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="../lib/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'layer', 'jquery', 'upload'], function () {
        var $ = layui.jquery
            , upload = layui.upload;

        //选完文件后不自动上传
        upload.render({
            elem: '#chooseFile'
            , url: '../file/upload/ynService'
            , auto: false
            , bindAction: '#statrFile'
            , accept: 'file'
            , exts: 'zip|rar|7z'
            , done: function (res) {
                console.log(res);
                top.layer.msg(res.msg);
            }, error: function () {
                top.layer.msg("接口出现问题");
            }
        });
    })
    ;
</script>
</html>