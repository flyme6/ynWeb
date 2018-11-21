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
                        <form class="layui-form" action="common/goAdd" method="post">
                            <div class="layui-form-item">
                                <label class="layui-form-label">
                                    <span class="we-red">*</span>名称</label>
                                <%--<div class="layui-input-block">--%>
                                <%--<input type="text" name="projectName" lay-verify="required" autocomplete="off"--%>
                                <%--placeholder="请输入名称" class="layui-input">--%>
                                <%--</div>--%>
                                <div class="layui-input-inline">
                                    <input type="text" name="projectName" lay-verify="required" autocomplete="off"
                                           placeholder="请输入名称" class="layui-input">

                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">
                                    <span class="we-red">*</span>启用冗余</label>
                                <div class="layui-input-block">
                                    <input type="checkbox" checked="checked" name="enableRedun" lay-verify="required"
                                           lay-skin="switch"
                                           lay-filter="switchTest" lay-text="开|关">

                                </div>

                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">
                                    发送间隔
                                </label>
                                <div class="layui-input-inline">
                                    <input type="text" name="ip1" lay-verify="required|ip" autocomplete="off"
                                           placeholder="请输入IP1" class="layui-input">

                                </div>
                                <div class="layui-input-inline">
                                    <input type="text" name="ip2" lay-verify="back_ip" autocomplete="off"
                                           placeholder="请输入IP2" class="layui-input">

                                </div>
                                <div class="layui-input-inline">
                                    <input type="text" name="ip3" lay-verify="back_ip" autocomplete="off"
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
                                    <button class="layui-btn" lay-submit="" lay-filter="add">立即提交</button>
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

        var form = layui.form
            , layer = layui.layer;

        form.verify({
            ip: [
                /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/
                , 'IP地址不符合规则'
            ],
            back_ip: function (value) {
                var reg = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
                if (value.length > 0) {
                    if (!reg.test(value)) {
                        return "请检查IP地址";
                    }
                }
            }
        });

        //监听指定开关
        form.on('switch(switchTest)', function (data) {
            console.info(data);
            // if(data.value == "on") {
            //     data.value = "1";
            //     layer.msg('开关checked：' + data.value + (this.checked ? 'true' : 'false'), {
            //                 offset: '6px'
            //             });
            // } else {
            //     data.value = "0";
            //     layer.msg('开关： 关掉了' + data.value, {
            //                 offset: '6px'
            //             });
            // }

            // if (this.checked) {
            //     data.value = "1";
            //     layer.msg('开关checked：' + data.value + (this.checked ? 'true' : 'false'), {
            //         offset: '6px'
            //     });
            //     layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅 仅是ON|OFF', data.othis)
            // } else {
            //     data.value = "0";
            //     layer.msg('开关： 关掉了' + +data.value, {
            //         offset: '6px'
            //     });
            //
            // }
            $(data.elem).attr('type', 'hidden').val(this.checked ? 1 : 0);
            //do some ajax opeartiopns;
        });

        form.on('submit(add)', function (data) {
            var index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});
            $.ajax({
                url: data.form.action,
                type: data.form.method,
                data: $(data.form).serialize(),
                dataType: "json",
                success: function (info) {
                    // console.log(info);
                    // console.log(info.code);
                    if (info.code === 301) {
                        setTimeout(function () {
                            top.layer.close(index);
                            top.layer.msg("配置成功");
                        }, 1000);
                    } else {
                        // top.layer.close(index);
                        top.layer.msg(info.msg);
                    }
                },
                error: function (info) {
                    if (info.code === 300) {
                        setTimeout(function () {
                            top.layer.close(index);
                            top.layer.msg(info.msg);
                        }, 1000);
                    }
                    top.layer.close(index);
                    top.layer.msg(info.msg);
                }
            });
            return false;
        });

        form.render();
    });


</script>
</html>