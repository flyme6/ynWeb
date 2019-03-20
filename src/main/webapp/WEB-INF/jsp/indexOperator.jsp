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
    <title>操作员后台管理系统</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="shortcut icon" href="./favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="./static/css/font.css">
    <link rel="stylesheet" href="./static/css/weadmin.css">
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>

</head>

<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo">
        <a href="./indexOperator">YN后台管理系统</a>
    </div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">工程管理</a>
            <dl class="layui-nav-child">
                <!-- 工程管理二级菜单 -->
                <%--<dd>--%>
                <%--<a onclick="WeAdminShow('保存工程到本地','./exportProject.jsp')">保存工程到本地</a>--%>
                <%--</dd>--%>
                <%--<dd>--%>
                <%--<a onclick="WeAdminShow('新建工程','./newProject.jsp')">新建工程</a>--%>
                <%--</dd>--%>
                <%--<dd>--%>
                <%--<a onclick="WeAdminShow('工程文件下载','./saveProject.jsp')">工程文件下载</a>--%>
                <%--</dd>--%>
                <%--<dd>--%>
                <%--<a onclick="WeAdminShow('检查工程','./checkProject.jsp')">检查工程</a>--%>
                <%--</dd>--%>
                <%--<dd>--%>
                <%--<a onclick="WeAdminShow('打开本地工程','./importProject.jsp')">打开本地工程</a>--%>
                <%--</dd>--%>
                <%--<dd>--%>
                <%--&lt;%&ndash;<a onclick="WeAdminShow('工程文件下载','./saveProject.jsp')">工程文件下载</a>&ndash;%&gt;--%>
                <%--</dd>--%>
                <dd>
                    <a onclick="WeAdminShow('启动工程','./startProject .jsp')">启动工程</a>
                </dd>
                <dd>
                    <a onclick="WeAdminShow('停止工程','./stopProject .jsp')">停止工程</a>
                </dd>
                <dd>
                    <a onclick="WeAdminShow('重启盒子','./rebootBox .jsp')">重启盒子</a>
                </dd>
            </dl>
        </li>
        <li class="layui-nav-item">
            <a href="javascript:;" id="username">未登录</a>
            <dl class="layui-nav-child">
                <!-- 个人管理二级菜单 -->
                <%--<dd>--%>
                <%--<a onclick="WeAdminShow('个人信息','http://www.baidu.com')">个人信息</a>--%>
                <%--</dd>--%>
                <%--<dd>--%>
                <%--<a onclick="WeAdminShow('切换帐号','./login.jsp')">切换帐号</a>--%>
                <%--</dd>--%>
                <dd>
                    <a class="loginout" href="login" onclick="clearCookie()">退出</a>
                </dd>
            </dl>
        </li>

        <%--<li class="layui-nav-item to-index">--%>
        <%--<a href="/">前台首页</a>--%>
        <%--</li>--%>
    </ul>

</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <%--<!--系统配置-->--%>
            <%--<li>--%>
            <%--<a href="javascript:;">--%>
            <%--<i class="iconfont">&#xe6b8;</i>--%>
            <%--<cite>系统配置</cite>--%>
            <%--<i class="iconfont nav_right">&#xe697;</i>--%>
            <%--</a>--%>
            <%--<ul class="sub-menu">--%>
            <%--<li>--%>
            <%--<a _href="./systemConfig/common">--%>
            <%--<i class="iconfont">&#xe6a7;</i>--%>
            <%--<cite>通用配置</cite>--%>

            <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a _href="./systemConfig/tcp">--%>
            <%--<i class="iconfont">&#xe6a7;</i>--%>
            <%--<cite>网口配置</cite>--%>

            <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a _href="./systemConfig/com">--%>
            <%--<i class="iconfont">&#xe6a7;</i>--%>
            <%--<cite>串口配置</cite>--%>

            <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a _href="./systemConfig/user">--%>
            <%--<i class="iconfont">&#xe6a7;</i>--%>
            <%--<cite>用户配置</cite>--%>

            <%--</a>--%>
            <%--</li>--%>
            <%--</ul>--%>
            <%--</li>--%>
            <%--<!--采集设备配置-->--%>
            <%--<li>--%>
            <%--<a href="javascript:;">--%>
            <%--<i class="iconfont">&#xe6b8;</i>--%>
            <%--<cite>采集设备配置</cite>--%>
            <%--<i class="iconfont nav_right">&#xe697;</i>--%>
            <%--</a>--%>
            <%--<ul class="sub-menu">--%>
            <%--<li>--%>
            <%--<a _href="./collectingDevice/modbusTCP">--%>
            <%--<i class="iconfont">&#xe6a7;</i>--%>
            <%--<cite>Modbus TCP采集</cite>--%>

            <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a _href="./collectingDevice/modbusRTU">--%>
            <%--<i class="iconfont">&#xe6a7;</i>--%>
            <%--<cite>Modbus RTU采集</cite>--%>

            <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a _href="./collectingDevice/modbusTCPRtu">--%>
            <%--<i class="iconfont">&#xe6a7;</i>--%>
            <%--<cite>Modbus 透传采集</cite>--%>

            <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a _href="./collectingDevice/ABCIP">--%>
            <%--<i class="iconfont">&#xe6a7;</i>--%>
            <%--<cite>ABCIP采集</cite>--%>

            <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a _href="./collectingDevice/IEC104">--%>
            <%--<i class="iconfont">&#xe6a7;</i>--%>
            <%--<cite>IEC104采集</cite>--%>

            <%--</a>--%>
            <%--</li>--%>
            <%--</ul>--%>
            <%--</li>--%>
            <%--<!--转发设备配置-->--%>
            <%--<li>--%>
            <%--<a href="javascript:;">--%>
            <%--<i class="iconfont">&#xe705;</i>--%>
            <%--<cite>转发设备配置</cite>--%>
            <%--<i class="iconfont nav_right">&#xe697;</i>--%>
            <%--</a>--%>
            <%--<ul class="sub-menu">--%>
            <%--<li>--%>
            <%--<a _href="./forwardingDevice/modbusTCP">--%>
            <%--<i class="iconfont">&#xe6a7;</i>--%>
            <%--<cite>Modbus TCP转发</cite>--%>

            <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a _href="./forwardingDevice/modbusRTU">--%>
            <%--<i class="iconfont">&#xe6a7;</i>--%>
            <%--<cite>Modbus RTU转发</cite>--%>

            <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a _href="./forwardingDevice/modbusTCPRtu">--%>
            <%--<i class="iconfont">&#xe6a7;</i>--%>
            <%--<cite>Modbus 透传转发</cite>--%>

            <%--</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a _href="./forwardingDevice/IEC104">--%>
            <%--<i class="iconfont">&#xe6a7;</i>--%>
            <%--<cite>IEC104转发</cite>--%>

            <%--</a>--%>
            <%--</li>--%>
            <%--</ul>--%>
            <%--</li>--%>
            <%--<!--点表配置-->--%>
            <%--<li>--%>
            <%--<a _href="./pointsConfig">--%>
            <%--<i class="iconfont">&#xe705;</i>--%>
            <%--<cite>点表配置</cite>--%>
            <%--<i class="iconfont nav_right">&#xe697;</i>--%>
            <%--</a>--%>
            <%--</li>--%>
            <!--运行状态监视-->
            <li>
                <a _href="./operationalStatus">
                    <i class="iconfont">&#xe705;</i>
                    <cite>运行状态监视</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
            </li>
            <!--实时数据监视-->
            <li>
                <a _href="./realTimeData">
                    <i class="iconfont">&#xe705;</i>
                    <cite>实时数据监视</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
            </li>
            <!--通信报文监视-->
            <li>
                <a _href="./communicationMessage">
                    <i class="iconfont">&#xe705;</i>
                    <cite>通信报文监视</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
            </li>

            <!--系统日志-->
            <li>
                <a _href="./console">
                    <i class="iconfont">&#xe705;</i>
                    <cite>系统日志</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
            </li>
        </ul>
    </div>
</div>
<!-- <div class="x-slide_left"></div> -->
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="wenav_tab" id="WeTabTip" lay-allowclose="true">
        <ul class="layui-tab-title" id="tabName">
            <li>我的桌面</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='./welcome' frameborder="0" scrolling="yes" class="weIframe"></iframe>
            </div>
        </div>
    </div>
</div>
<div class="page-content-bg"></div>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
<!-- 底部开始 -->
<div class="footer">
    <div class="copyright">Copyright ©2018 ynWeb v1.0.0 Beta</div>
</div>
<!-- 底部结束 -->
<script type="text/javascript">
    //			layui扩展模块的两种加载方式-示例
    //		    layui.extend({
    //			  admin: '{/}../../static/js/admin' // {/}的意思即代表采用自有路径，即不跟随 base 路径
    //			});
    //			//使用拓展模块
    //			layui.use('admin', function(){
    //			  var admin = layui.admin;
    //			});
    layui.config({
        base: './static/js/'
        , version: '101100'
    }).use('admin');
    layui.use(['jquery', 'admin'], function () {
        var $ = layui.jquery;

        var username = getCookie("username");

        console.info(username)
        $("#username").html(username);

        checkCookie(username);

        $(function () {
            // var login = JSON.parse(localStorage.getItem("login"));
            // if (login) {
            //     if (login = 0) {
            //         window.location.href = './login.jsp';
            //         return false;
            //     } else {
            //         return false;
            //     }
            // } else {
            //     window.location.href = './login.jsp';
            //     return false;
            // }
        });
    });

</script>
<script type="text/javascript">
    function setCookie(c_name, value, expiredays) {
        var exdate = new Date()
        exdate.setDate(exdate.getDate() + expiredays);
        document.cookie = c_name + "=" + escape(value) +
            ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString())
    }

    function getCookie(c_name) {
        if (document.cookie.length > 0) {
            c_start = document.cookie.indexOf(c_name + "=");
            if (c_start != -1) {
                c_start = c_start + c_name.length + 1;
                c_end = document.cookie.indexOf(";", c_start);
                if (c_end == -1) c_end = document.cookie.length;
                return unescape(document.cookie.substring(c_start, c_end))
            }
        }
        return ""
    }

    function checkCookie() {
        username = getCookie('username');
        role = getCookie('role');
        console.info(role + "asd")
        if (username != null && username != "" && role == 1) {
            // alert('Welcome again ' + username + '!')
        }
        else {
            layer.confirm('请您前往登录', {
                btn: ['是', '否']
                , btn1: function () {
                    location.href = "./login";
                    clearCookie();
                }
                , btn2: function () {
                    location.href = "./login";
                    clearCookie();
                }
            });
        }
    }

    function clearCookie() {
        var keys = document.cookie.match(/[^ =;]+(?=\=)/g);
        if (keys) {
            for (var i = keys.length; i--;)
                document.cookie = keys[i] + '=0;expires=' + new Date(0).toUTCString()
        }
    }

</script>
</body>
<!--Tab菜单右键弹出菜单-->
<ul class="rightMenu" id="rightMenu">
    <li data-type="fresh">刷新</li>
    <li data-type="current">关闭当前</li>
    <li data-type="other">关闭其它</li>
    <li data-type="all">关闭所有</li>
</ul>

</html>