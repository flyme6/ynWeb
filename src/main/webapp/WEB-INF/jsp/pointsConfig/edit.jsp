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
    <form class="layui-form">
        <div class="layui-form-item">
            <label for="L_name" class="layui-form-label">
                <span class="we-red">*</span>点名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_name" name="name" lay-verify="required|nikename"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_c_dev" class="layui-form-label">
                <span class="we-red">*</span>采集设备名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_c_dev" name="c_dev" lay-verify="required|nikename" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_c_devid" class="layui-form-label">
                <span class="we-red">*</span>采集设备IP
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_c_devid" name="c_devid" lay-verify="required|nikename" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_c_inaddr" class="layui-form-label">
                <span class="we-red">*</span>采集地址
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_c_inaddr" name="c_inaddr" lay-verify="required|nikename" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_c_intype" class="layui-form-label">
                <span class="we-red">*</span>采集点类型
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_c_intype" name="c_intype" lay-verify="required|nikename" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_f_dev" class="layui-form-label">
                <span class="we-red">*</span>转发设备名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_f_dev" name="f_dev" lay-verify="required|nikename"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_f_devid" class="layui-form-label">
                <span class="we-red">*</span>转发设备ID
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_f_devid" name="f_devid" lay-verify="required|nikename"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_f_inaddr" class="layui-form-label">
                <span class="we-red">*</span>转发地址
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_f_inaddr" name="f_inaddr" autocomplete="off"
                       class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                提示信息
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_f_intype" class="layui-form-label">
                <span class="we-red">*</span>转发点类型
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_f_intype" name="f_intype" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_desc" class="layui-form-label">
                <span class="we-red">*</span>点描述
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_desc" name="desc" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
            </label>
            <button class="layui-btn" id="L_repass" lay-filter="add" lay-submit="">确定</button>
        </div>
    </form>
</div>
<script src="../lib/layui/layui.js" charset="utf-8"></script>
<script>
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