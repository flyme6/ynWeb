<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path+ "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="assets/css/layui.css">
    <link rel="stylesheet" href="assets/css/view.css"/>
    <title>YNVIEW实时监视页面</title>
</head>
<body class="layui-view-body">
<div class="layui-content">
    <div class="layui-page-header">
        <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a href="">首页</a>
                  <a href="">YNVIEW实时监视页面</a>
                  <a><cite>系统信息</cite></a>
                </span>
            <h2 class="title">系统信息</h2>
        </div>
    </div>
    <div class="layui-row">
        <div class="layui-card">
            <div class="layui-card-body">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                    <legend>CPU使用率</legend>
                </fieldset>
                <div class="layui-progress layui-progress-big" lay-showpercent="true" lay-filter="cpu_hash">
                    <div class="layui-progress-bar layui-bg-red" lay-percent="0%"></div>
                </div>

                <div class="site-demo_hash-button" style="margin-top: 20px; margin-bottom: 0;">
                    <button class="layui-btn site-demo_hash-active" data-type="setCpuPercent">设置50%</button>
                    <!--<button class="layui-btn site-demo_hash-active" data-type="loading">模拟loading</button>-->
                </div>

                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                    <legend>存储空间</legend>
                </fieldset>
                <div class="layui-progress layui-progress-big" lay-showpercent="true" lay-filter="space_hash">
                    <div class="layui-progress-bar layui-bg-red" lay-percent="0%"></div>
                </div>

                <div class="site-demo_hash-button" style="margin-top: 20px; margin-bottom: 0;">
                    <button class="layui-btn site-demo_hash-active" data-type="setSpacePercent">设置50%</button>
                    <!--<button class="layui-btn site-demo_hash-active" data-type="loading">模拟loading</button>-->
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/layui.all.js"></script>
<script>
    layui.use('element', function () {
        var $ = layui.jquery,
            element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

        element.init();
        //触发事件
        var active = {
            setCpuPercent: function () {
                //设置50%进度
                element.progress('cpu_hash', '50%')
            },
            setSpacePercent: function () {
                // 设置30%进度
                element.progress('space_hash', '30%')
            }
            // ,
            //     loading: function(othis) {
            //         var DISABLED = 'layui-btn-disabled';
            //         if (othis.hasClass(DISABLED)) return;
            //
            //         //模拟loading
            //         var n = 0,
            //             timer = setInterval(function() {
            //                 n = n + Math.random() * 10 | 0;
            //                 if (n > 100) {
            //                     n = 100;
            //                     clearInterval(timer);
            //                     othis.removeClass(DISABLED);
            //                 }
            //                 element.progress('demo_hash', n + '%');
            //             }, 300 + Math.random() * 1000);
            //
            //         othis.addClass(DISABLED);
            //     }
        };

        $('.site-demo_hash-active').on('click', function () {
            var othis = $(this),
                type = $(this).data('type');
            active[type] ? active[type].call(this, othis) : '';
        });
    });
</script>
</body>
</html>