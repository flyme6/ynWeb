<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 引入jstl库 -->
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
    <title>后台管理系统</title>
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
        <a href="./index">YN后台管理系统</a>
    </div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">工程管理</a>
            <dl class="layui-nav-child">
                <!-- 工程管理二级菜单 -->
                <dd>
                    <%--<a onclick="WeAdminShow('保存工程到本地','./project/exportProject')">保存工程到本地</a>--%>
                    <a title="保存工程到本地" onclick="export_project()" href="javascript:">保存工程到本地</a>
                </dd>
                <dd>
                    <%--<a onclick="WeAdminShow('新建工程','./project/newProject')">新建工程</a>--%>
                    <a title="新建工程" onclick="new_project()" href="javascript:">新建工程</a>
                </dd>
                <dd>
                    <%--<a onclick="WeAdminShow('工程文件下载','./file/down?filename=1.rar')">工程文件下载</a>--%>
                    <a href="./file/down?filename=1.rar">工程文件下载</a>
                </dd>
                <dd>
                    <%--<a onclick="WeAdminShow('检查工程','./project/checkProject')">检查工程</a>--%>
                    <a title="检查工程" onclick="check_project()" href="javascript:">检查工程</a>
                </dd>
                <dd>
                    <%--<a onclick="WeAdminShow('打开本地工程','./projectPage/importProject')">打开本地工程</a>--%>
                    <a onclick="WeAdminShow('打开本地工程','./project/importProjectPage')">打开本地工程</a>
                </dd>
                <dd>
                    &nbsp;&nbsp;
                </dd>
                <dd>
                    <%--<a onclick="WeAdminShow('启动工程','./project/startProject')">启动工程</a>--%>
                    <a title="启动工程" onclick="start_project()" href="javascript:">启动工程</a>
                </dd>
                <dd>
                    <%--<a onclick="WeAdminShow('停止工程','./project/stopProject')">停止工程</a>--%>
                    <a title="停止工程" onclick="stop_project()" href="javascript:">停止工程</a>
                </dd>
                <dd>
                    <%--<a onclick="WeAdminShow('重启盒子','./project/rebootBox')">重启盒子</a>--%>
                    <a title="重启盒子" onclick="reboot_project()" href="javascript:">重启盒子</a>
                </dd>
            </dl>
        </li>
        <li class="layui-nav-item">
            <a href="javascript:;">admin</a>
            <dl class="layui-nav-child">
                <!-- 个人管理二级菜单 -->
                <%--<dd>--%>
                <%--<a onclick="WeAdminShow('个人信息','http://www.baidu.com')">个人信息</a>--%>
                <%--</dd>--%>
                <%--<dd>--%>
                <%--<a onclick="WeAdminShow('切换帐号','./login.jsp')">切换帐号</a>--%>
                <%--</dd>--%>
                <dd>
                    <a class="loginout" href="login.html">退出</a>
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
            <!--系统配置-->
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>系统配置</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="./systemConfig/common">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>通用配置</cite>

                        </a>
                    </li>
                    <li>
                        <a _href="./systemConfig/tcp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>网口配置</cite>

                        </a>
                    </li>
                    <li>
                        <a _href="./systemConfig/com">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>串口配置</cite>

                        </a>
                    </li>
                    <li>
                        <a _href="./systemConfig/user">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>用户配置</cite>

                        </a>
                    </li>
                </ul>
            </li>
            <!--采集设备配置-->
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>采集设备配置</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="./collectingDevice/modbusTCP">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>Modbus TCP采集</cite>

                        </a>
                    </li>
                    <li>
                        <a _href="./collectingDevice/modbusRTU">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>Modbus RTU采集</cite>

                        </a>
                    </li>
                    <li>
                        <a _href="./collectingDevice/modbusTCPRtu">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>Modbus 透传采集</cite>

                        </a>
                    </li>
                    <li>
                        <a _href="./collectingDevice/ABCIP">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>ABCIP采集</cite>

                        </a>
                    </li>
                    <li>
                        <a _href="./collectingDevice/IEC104">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>IEC104采集</cite>

                        </a>
                    </li>
                </ul>
            </li>
            <!--转发设备配置-->
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe705;</i>
                    <cite>转发设备配置</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="./forwardingDevice/modbusTCP">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>Modbus TCP转发</cite>

                        </a>
                    </li>
                    <li>
                        <a _href="./forwardingDevice/modbusRTU">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>Modbus RTU转发</cite>

                        </a>
                    </li>
                    <li>
                        <a _href="./forwardingDevice/modbusTCPRtu">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>Modbus 透传转发</cite>

                        </a>
                    </li>
                    <li>
                        <a _href="./forwardingDevice/IEC104">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>IEC104转发</cite>

                        </a>
                    </li>
                </ul>
            </li>
            <!--点表配置-->
            <li>
                <a _href="./pointsConfig">
                    <i class="iconfont">&#xe705;</i>
                    <cite>点表配置</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
            </li>
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
            <%--<li>--%>
            <%--<a _href="./systemLog">--%>
            <%--<i class="iconfont">&#xe705;</i>--%>
            <%--<cite>系统日志</cite>--%>
            <%--<i class="iconfont nav_right">&#xe697;</i>--%>
            <%--</a>--%>
            <%--</li>--%>

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

    layui.config({
        base: './static/js/'
        , version: '101100'
    }).use('admin');
    layui.use(['jquery', 'admin'], function () {
            var $ = layui.jquery;


            /*控制设备运行状态新建工程*/
            window.new_project = function () {
                $.ajax({
                    url: "./project/newProject",
                    timeout: 3000, //超时时间设置，单位毫秒
                    // data: "name=" + obj.data.name,
                    type: "GET",
                    dataType: "json",
                    success: function (info) {
                        if (info.msg == "RTOK") {
                            layer.msg('新建工程成功', {
                                icon: 1,
                                time: 3000
                            });
                        } else {
                            layer.msg('新建工程失败，请检查配置是否已调试，错误代码：' + info.msg, {
                                icon: 2,
                                time: 3000
                            });
                        }
                    },
                    error: function (error) {
                        layer.msg('出现异常，请刷新页面', {
                            icon: 2,
                            time: 3000
                        });
                    },
                    complete: function (XMLHttpRequest, status) { //请求完成后最终执行参数
                        if (status == 'timeout') {//超时,status还有success,error等值的情况
                            layer.msg('出现超时异常，请及时检查ynService是否开启', {
                                icon: 2,
                                time: 3000
                            });
                        }
                    }
                });
            };

            /*控制设备运行状态保存工程到本地*/
            window.export_project = function () {
                $.ajax({
                    url: "./project/exportProject",
                    timeout: 3000, //超时时间设置，单位毫秒
                    // data: "name=" + obj.data.name,
                    type: "GET",
                    dataType: "json",
                    success: function (info) {
                        if (info.msg == "RTOK") {
                            // top.layer.msg("保存工程到本地成功");
                            layer.msg('保存工程到本地成功', {
                                icon: 1,
                                time: 3000
                            });
                        } else {
                            layer.msg('保存工程到本地失败，请检查配置是否已调试，错误代码：' + info.msg, {
                                icon: 2,
                                time: 3000
                            });
                        }

                    },
                    error: function (error) {
                        layer.msg('出现异常，请刷新页面', {
                            icon: 2,
                            time: 3000
                        });
                    },
                    complete: function (XMLHttpRequest, status) { //请求完成后最终执行参数
                        if (status == 'timeout') {//超时,status还有success,error等值的情况
                            layer.msg('出现超时异常，请及时检查ynService是否开启', {
                                icon: 2,
                                time: 3000
                            });
                        }
                    }
                });
            };


            /*控制设备运行状态检查工程*/
            window.check_project = function () {
                $.ajax({
                    url: "./project/checkProject",
                    timeout: 3000, //超时时间设置，单位毫秒
                    // data: "name=" + obj.data.name,
                    type: "GET",
                    dataType: "json",
                    success: function (info) {
                        if (info.msg == "RTOK") {
                            layer.msg('检查成功', {
                                icon: 1,
                                time: 3000
                            });
                        } else {
                            layer.msg('检查失败，请检查配置是否已调试，错误代码：' + info.msg, {
                                icon: 2,
                                time: 3000
                            });
                        }

                    },
                    error: function (error) {
                        layer.msg('出现异常，请刷新页面', {
                            icon: 2,
                            time: 3000
                        });
                    },
                    complete: function (XMLHttpRequest, status) { //请求完成后最终执行参数
                        if (status == 'timeout') {//超时,status还有success,error等值的情况
                            layer.msg('出现超时异常，请及时检查ynService是否开启', {
                                icon: 2,
                                time: 3000
                            });
                        }
                    }
                });
            };

            /*控制项目工程开始*/
            window.start_project = function () {
                $.ajax({
                    url: "./project/startProject",
                    timeout: 3000, //超时时间设置，单位毫秒
                    type: "GET",
                    dataType: "json",
                    success: function (info) {
                        if (info.msg == "RTOK") {
                            layer.msg('启动成功,已正常获取数据', {
                                icon: 1,
                                time: 3000
                            });
                        } else {
                            layer.msg('启动失败，请检查配置是否已调试，错误代码：' + info.msg, {
                                icon: 2,
                                time: 3000
                            });
                        }

                    },
                    error: function (error) {
                        layer.msg('出现异常，请刷新页面', {
                            icon: 2,
                            time: 3000
                        });
                    },
                    complete: function (XMLHttpRequest, status) { //请求完成后最终执行参数
                        if (status == 'timeout') {//超时,status还有success,error等值的情况
                            layer.msg('出现异常，请刷新页面 或者检查ynService是否开启', {
                                icon: 2,
                                time: 3000
                            });
                        }
                    }
                });
            };

            /*控制项目工程停止*/
            window.stop_project = function () {
                $.ajax({
                    url: "./project/stopProject",
                    timeout: 3000, //超时时间设置，单位毫秒
                    type: "GET",
                    dataType: "json",
                    success: function (info) {
                        if (info.msg == "RTOK") {
                            layer.msg('停止成功', {
                                icon: 1,
                                time: 3000
                            });
                        } else {
                            layer.msg('停止失败，请检查配置是否已调试，错误代码：' + info.msg, {
                                icon: 2,
                                time: 3000
                            });
                        }

                    },
                    error: function (error) {
                        layer.msg('出现异常，请刷新页面', {
                            icon: 2,
                            time: 3000
                        });
                    },
                    complete: function (XMLHttpRequest, status) { //请求完成后最终执行参数
                        if (status == 'timeout') {//超时,status还有success,error等值的情况
                            layer.msg('出现超时异常，请及时检查ynService是否开启', {
                                icon: 2,
                                time: 3000
                            });
                        }
                    }
                });
            };

            /*控制项目工程重启*/
            window.reboot_project = function () {
                $.ajax({
                    url: "./project/rebootBox",
                    timeout: 3000, //超时时间设置，单位毫秒
                    type: "GET",
                    dataType: "json",
                    success: function (info) {
                        layer.msg('重启成功', {
                            icon: 1,
                            time: 3000
                        });
                    },
                    error: function (error) {
                        layer.msg('出现异常，请刷新页面，错误代码：' + error.msg, {
                            icon: 2,
                            time: 3000
                        });
                    },
                    complete: function (XMLHttpRequest, status) { //请求完成后最终执行参数
                        if (status == 'timeout') {//超时,status还有success,error等值的情况
                            layer.msg('出现超时异常，请及时检查ynService是否开启', {
                                icon: 2,
                                time: 3000
                            });
                        }
                    }
                });
            }
        }
    );

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