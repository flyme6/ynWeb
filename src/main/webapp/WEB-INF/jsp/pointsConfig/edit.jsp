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
    <title>编辑-点表配置-ABCIP采集-后台管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../static/css/font.css">
    <link rel="stylesheet" href="../static/css/weadmin.css">
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
                <span class="we-red">*</span>点名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_name" name="name" lay-verify="required"
                       autocomplete="off"
                       class="layui-input" readonly>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_desc" class="layui-form-label">
                点描述
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_desc" name="desc" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_c_dev" class="layui-form-label">
                <span class="we-red">*</span>采集设备名
            </label>
            <div class="layui-input-inline">
                <%--<input type="text" id="L_c_dev" name="cDev" lay-verify="required" autocomplete="off"--%>
                <%--class="layui-input">--%>
                <select name="cDev" id="L_c_dev" lay-filter="cDev" style="width: 10px">
                    <option value="请选择"></option>
                </select>
            </div>
        </div>
        <%--<div class="layui-form-item">--%>
        <%--<label for="L_c_devid" class="layui-form-label">--%>
        <%--采集设备ID--%>
        <%--</label>--%>
        <%--<div class="layui-input-inline">--%>
        <%--<input type="number" id="L_c_devid" name="cDevid" lay-verify="" autocomplete="off"--%>
        <%--class="layui-input">--%>
        <%--</div>--%>
        <%--</div>--%>
        <div class="layui-form-item">
            <label for="L_c_inaddr" class="layui-form-label">
                <span class="we-red">*</span>采集地址
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_c_inaddr" name="cInaddr" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_c_intype" class="layui-form-label">
                <span class="we-red">*</span>采集地址类型
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_c_intype" name="cIntype" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_cInbit" class="layui-form-label">
                采集数据位
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_cInbit" name="cInbit" lay-verify="" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_f_dev" class="layui-form-label">
                <span class="we-red">*</span>转发设备名
            </label>
            <div class="layui-input-inline">
                <%--<input type="text" id="L_f_dev" name="fDev" lay-verify="required"--%>
                <%--autocomplete="off"--%>
                <%--class="layui-input">--%>
                <select name="fDev" id="L_f_dev" lay-filter="fDev">
                    <option value="请选择"></option>
                </select>
            </div>
        </div>
        <%--<div class="layui-form-item">--%>
        <%--<label for="L_f_devid" class="layui-form-label">--%>
        <%--转发设备ID--%>
        <%--</label>--%>
        <%--<div class="layui-input-inline">--%>
        <%--<input type="number" id="L_f_devid" name="fDevid" lay-verify=""--%>
        <%--autocomplete="off"--%>
        <%--class="layui-input">--%>
        <%--</div>--%>
        <%--</div>--%>
        <div class="layui-form-item">
            <label for="L_f_inaddr" class="layui-form-label">
                <span class="we-red">*</span>转发地址
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_f_inaddr" name="fInaddr" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>

        </div>
        <div class="layui-form-item">
            <label for="L_f_intype" class="layui-form-label">
                <span class="we-red">*</span>转发点类型
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_f_intype" name="fIntype" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
            </label>
            <button class="layui-btn" id="L_repass" lay-filter="edit" lay-submit="">确定</button>
        </div>
    </form>
</div>
<script src="../lib/layui/layui.js" charset="utf-8"></script>
<script>
    var aa = window.parent.aa;
    layui.extend({
        admin: '{/}../static/js/admin'
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

        var resultData;

        var htmls = '<option value="">请选择</option>'; //全局变量
        var htmls2 = '<option value="">请选择</option>'; //全局变量
        $.ajax({
            url: "./queryDriver",
            type: "get",
            dataType: "json",
            // contentType: "application/json",
            async: false,//这得注意是同步
            success: function (result) {
                resultData = result.data;
                console.info(resultData + "resultData");
                for (var x in resultData) {
                    htmls += '<option value = "' + resultData[x].c_dev + '">' + resultData[x].c_dev + '</option>';
                    htmls2 += '<option value = "' + resultData[x].f_dev + '">' + resultData[x].f_dev + '</option>'
                }
                $("#L_c_dev").html(htmls);
                $("#L_f_dev").html(htmls2);
            }
        });
        form.render('select');//需要渲染一下

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
            var desc = aa.data.desc;
            var c_dev = aa.data.c_dev;
            var c_devid = aa.data.c_devid;
            var c_inaddr = aa.data.c_inaddr;
            var c_intype = aa.data.c_intype;
            var c_inbit = aa.data.c_inbit;
            var f_dev = aa.data.f_dev;
            var f_devid = aa.data.f_devid;
            var f_inaddr = aa.data.f_inaddr;
            var f_intype = aa.data.f_intype;


            $('input[name="name"]').val(name);
            $('input[name="desc"]').val(desc);
            $('select[name="cDev"]').val(c_dev);
            $('input[name="cDevid"]').val(c_devid);
            $('input[name="cInaddr"]').val(c_inaddr);
            $('input[name="cIntype"]').val(c_intype);
            $('input[name="cInbit"]').val(c_inbit);
            $('select[name="fDev"]').val(f_dev);
            $('input[name="fDevid"]').val(f_devid);
            $('input[name="fInaddr"]').val(f_inaddr);
            $('input[name="fIntype"]').val(f_intype);

            form.render();
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