<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员登录-后台管理系统</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="shortcut icon" href="./favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="./static/css/font.css">
    <link rel="stylesheet" href="./static/css/weadmin.css">
    <script src="./lib/layui/layui.js" charset="utf-8"></script>

</head>
<body class="login-bg">

<div class="login">
    <div class="message">YN后台管理系统</div>
    <div id="darkbannerwrap"></div>
    <form action="<%=basePath %>/login" method="post" class="layui-form">
        <input name="username" id="username" placeholder="用户名" type="text" lay-verify="required" class="layui-input">
        <hr class="hr15">
        <input name="password" lay-verify="required" placeholder="密码" type="password" class="layui-input">
        <hr class="hr15">
        <button lay-submit lay-filter="login" class="layui-btn" style="width:100%; height: 55px">登录</button>
        <hr class="hr20">
        <%--<div>--%>
        <%--前端静态展示，请随意输入，即可登录。--%>
        <%--</div>--%>
    </form>
</div>

<script type="text/javascript">

    layui.extend({
        admin: '{/}./static/js/admin'
    });

    checkCookie();

    function setCookie(c_name, value, expiredays) {
        var exdate = new Date()
        exdate.setDate(exdate.getDate() + expiredays)
        document.cookie = c_name + "=" + escape(value) +
            ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString())
    }

    function getCookie(c_name) {
        if (document.cookie.length > 0) {
            c_start = document.cookie.indexOf(c_name + "=")
            if (c_start != -1) {
                c_start = c_start + c_name.length + 1
                c_end = document.cookie.indexOf(";", c_start)
                if (c_end == -1) c_end = document.cookie.length
                return unescape(document.cookie.substring(c_start, c_end))
            }
        }
        return ""
    }

    function checkCookie() {
        username = getCookie('username');
        role = getCookie('role');
        if (username != null && username != "" && role == 0) {
            location.href = "./index";
        }
        else {

        }
    }

    function clearCookie() {
        var keys = document.cookie.match(/[^ =;]+(?=\=)/g);
        if (keys) {
            for (var i = keys.length; i--;)
                document.cookie = keys[i] + '=0;expires=' + new Date(0).toUTCString()
        }
    }

    layui.use(['form', 'layer', 'jquery'], function () {

        // 操作对象
        var form = layui.form;
        var $ = layui.jquery;
        form.on('submit(login)', function (data) {
            var index = layer.msg('登录提交中，请稍等', {icon: 16, time: false, shade: 0.8});
            setTimeout(function () {
                index;
            }, 2000);
            $.ajax({
                url: data.form.action,
                type: data.form.method,
                data: data.field,
                dataType: "json",
                success: function (info) {
                    var username = $("#username").val();
                    setCookie("username", username, 1);
                    if (info.code == 501) {
                        console.info(info.data);
                        if (info.data == "0") {
                            console.info(info.data);

                            setTimeout(function () {
                                top.layer.msg(info.msg);
                                top.layer.close(index);
                                location.href = "./index";
                            }, 2000);
                            setCookie("role", 0, 1);
                        } else if (info.data == "1") {
                            setTimeout(function () {
                                top.layer.msg(info.msg);
                                top.layer.close(index);
                                location.href = "./indexOperator";
                            }, 2000);
                            setCookie("role", 1, 1);
                        } else {
                            setTimeout(function () {
                                top.layer.msg("无权限");
                                top.layer.close(index);
                                location.href = "./login";
                            }, 2000);
                        }
                    } else {
                        layer.msg(info.msg);
                    }
                }
            });
            return false;
        })

    });
    // layui.use(['form', 'admin'], function () {
    //     var form = layui.form
    //         , admin = layui.admin;
    //
    //     form.on('submit(login)', function (data) {
    //         // alert(888)
    //         var index = layer.msg('登录中', {
    //             icon: 16
    //             , shade: 0.01
    //         }
    //         // , function () {
    //         //
    //         //     location.href = './index.html'
    //         // }
    //         );
    //         // layer.msg(JSON.stringify(data.field), function () {
    //         //     location.href = './index.html'
    //         // });
    //         return false;
    //     });
    //     // layer.msg('玩命卖萌中', function(){
    //     //   //关闭后的操作
    //     //   });
    //     //监听提交
    //     // form.on('submit(login)', function(data){
    //     //
    //     //     //加载层-风格3
    //     //     layer.load(2);
    //     //       //此处演示关闭
    //     //     setTimeout(function(){
    //     //         layer.closeAll('loading');
    //     //     }, 2000);
    //     //
    //     //   layer.msg(JSON.stringify(data.field),function(){
    //     //       location.href='./index'
    //     //   });
    //     //   return false;
    //     // });
    //
    //
    //     // form.on('submit(login)', function (data) {
    //     //     // var index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});
    //     //     //加载层-风格3
    //     //     var index = layer.msg('登录中', {
    //     //         icon: 16
    //     //         , shade: 0.01
    //     //     });
    //     //     // layer.load(2);
    //     //     // //此处演示关闭
    //     //     // setTimeout(function(){
    //     //     //     layer.close(index);
    //     //     // }, 2000);
    //     //     console.log("asd");
    //     //     location.href='./index';
    //     //     $.ajax({
    //     //         url: data.form.action,
    //     //         type: data.form.method,
    //     //         data: $(data.form).serialize(),
    //     //         dataType: "json",
    //     //         success: function (info) {
    //     //             console.log(info);
    //     //             console.log(info.code);
    //     //             top.layer.close(index);
    //     //             top.layer.msg(info.msg);
    //     //             // if (info.code === 501) {
    //     //             //     setTimeout(function () {
    //     //             //         top.layer.close(index);
    //     //             //         top.layer.msg(info.msg);
    //     //
    //     //             //         // layer.closeAll("iframe");
    //     //             //         // //刷新父页面
    //     //             //         // parent.location.reload();
    //     //             //     }, 1000);
    //     //             // }else if (info.code === 500){
    //     //             //     top.layer.close(index);
    //     //             //     top.layer.msg(info.msg);
    //     //             // }else {
    //     //             //     top.layer.close(index);
    //     //             //     top.layer.msg(info.msg);
    //     //             // }
    //     //         },
    //     //         error: function (info) {
    //     //             // if (info.code === 200) {
    //     //             //     setTimeout(function () {
    //     //             //         top.layer.close(index);
    //     //             //         top.layer.msg(info.msg);
    //     //             //         layer.closeAll("iframe");
    //     //             //         //刷新父页面
    //     //             //         parent.location.reload();
    //     //             //     }, 1000);
    //     //             // }
    //     //             setTimeout(function () {
    //     //                 top.layer.close(index);
    //     //                 top.layer.msg(info.msg);
    //     //             }, 1000);
    //     //
    //     //         }
    //     //     });
    //     //     return false;
    //     // });
    //
    // });
</script>
<!-- 底部结束 -->
</body>
</html>