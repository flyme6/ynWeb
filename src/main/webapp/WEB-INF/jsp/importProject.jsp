<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="assets/css/layui.css">
    <link rel="stylesheet" href="assets/css/view.css"/>
    <title></title>
</head>
<body class="layui-view-body">
<div class="layui-content">
    <div class="layui-page-header">
        <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a href="">首页</a>
                  <a href="">用户</a>
                  <a><cite>权限配置</cite></a>
                </span>
            <h2 class="title">权限配置</h2>
        </div>
    </div>
    <div class="layui-row">
        <div class="layui-card">
            <div class="layui-card-body">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                    <legend>选完文件后不自动上传</legend>
                </fieldset>

                <div class="layui-upload">
                    <button type="button" class="layui-btn layui-btn-normal" id="test8">选择文件</button>
                    <button type="button" class="layui-btn" id="test9">开始上传</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/layui.all.js"></script>
<script>
    layui.use('upload', function () {
        var $ = layui.jquery,
            upload = layui.upload;
        //选完文件后不自动上传
        upload.render({
            elem: '#test8',
            url: '/upload/',
            auto: false
            //,multiple: true
            ,
            bindAction: '#test9',
            done: function (res) {
                console.log(res)
            }
        });
    });
</script>
</body>
</html>