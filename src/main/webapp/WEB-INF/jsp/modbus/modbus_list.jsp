<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="assets/css/layui.css">
    <link rel="stylesheet" href="assets/css/view.css"/>
    <title></title>
</head>
<body class="layui-view-body">
<div class="layui-content">
    <div class="layui-row layui-col-space20">
        <div class="layui-col-sm12 layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body chart-card">
                    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                        <legend>工程管理</legend>
                    </fieldset>
                    <div class="layui-card-body">
                        <div class="layui-upload">
                            <button type="button" class="layui-btn layui-btn-normal" id="chooseFile">选择文件（打开本地工程）
                            </button>
                            <button type="button" class="layui-btn" id="uploadFile">开始上传（上载）</button>
                            <button type="button" class="layui-btn" id="test10">新建工程</button>
                            <button type="button" class="layui-btn" id="test11">保存工程</button>
                            <form action="<%=basePath %>file/down" method="get">
                                <input type="submit" class="layui-btn" value="下载">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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
                                    <input type="text" name="title" lay-verify="title" autocomplete="off"
                                           placeholder="请输入名称" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">开关-默认关</label>
                                <div class="layui-input-block">
                                    <input type="checkbox" name="close" lay-skin="switch" lay-text="ON|OFF">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">是否启用冗余（默认开）</label>
                                <div class="layui-input-block">
                                    <input type="checkbox" checked="" name="open" lay-skin="switch"
                                           lay-filter="switchTest_hash" lay-text="ON|OFF">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">备用产品IP地址：</label>
                                <div class="layui-input-block">
                                    <input type="text" name="ip1" lay-verify="ip" autocomplete="off"
                                           placeholder="请输入IP" class="layui-input">
                                    <input type="text" name="ip2" lay-verify="ip" autocomplete="off"
                                           placeholder="请输入IP2" class="layui-input">
                                    <input type="text" name="ip3" lay-verify="ip" autocomplete="off"
                                           placeholder="请输入IP3" class="layui-input">
                                </div>
                            </div>

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
        <div class="layui-col-sm12 layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body chart-card">
                    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                        <legend>IP地址配置</legend>
                    </fieldset>
                    <div class="layui-card-body">
                        <div class="form-box">
                            <a class="layui-btn layui-btn-blue" id="addUser"><i class="layui-icon">&#xe654;</i>新增</a>
                            <table id="ipConfig"></table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-col-sm12 layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-body chart-card">
                        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                            <legend>COM口配置</legend>
                        </fieldset>
                        <div class="layui-card-body">
                            <div class="form-box">
                                <table id="comConfig"></table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</body>
<script src="assets/layui.all.js"></script>
<script>
    var element = layui.element;
</script>
<script type="text/html" id="operateTpl">
    <a title="编辑" onclick="WeLogEdit('编辑','<%=basePath %>modbus_edit', 1, 600, 400)" href="javascript:;">
        <i class="layui-icon">&#xe642;</i>
    </a>
    <a title="查看" onclick="WeAdminShow('查看文章','./show.html',600,400)" href="javascript:;">
        <i class="layui-icon">&#xe63c;</i>
    </a>
    <a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;">
        <i class="layui-icon">&#xe640;</i>
    </a>
</script>
<script>

    layui.use('upload', function () {
        var $ = layui.jquery,
            upload = layui.upload;
        //选完文件后不自动上传
        upload.render({
            elem: '#chooseFile',
            url: '<%=basePath %>file/upload',
            auto: false,
            accept: 'file', //普通文件
            bindAction: '#uploadFile',
            done: function (res) {
                //假设code=0代表上传成功
                if (res.code == 200) {
                    layer.msg(res.msg, {
                        icon: 16
                        , shade: 0.01
                    });
                }
            },
            error: function (index, upload) {
                layer.msg("上传失败,联系管理员", {
                    icon: 16
                    , shade: 0.01
                });
            }
        });
    });

    /*弹出层+传递ID参数*/
    window.WeLogEdit = function (title, url, id, w, h) {

        if (title == null || title == '') {
            title = false;
        }
        ;
        if (url == null || url == '') {
            url = "404.html";
        }
        ;
        if (w == null || w == '') {
            w = ($(window).width() * 0.9);
        }
        ;
        if (h == null || h == '') {
            h = ($(window).height() - 50);
        }
        ;
        layer.open({
            type: 2,
            area: [w + 'px', h + 'px'],
            fix: false, //不固定
            maxmin: true,
            shadeClose: true,
            shade: 0.4,
            title: title,
            content: url,
            success: function (layero, index) {
                //向iframe页的id=house的元素传值  // 参考 https://yq.aliyun.com/ziliao/133150
                var body = layer.getChildFrame('body', index);
                body.contents().find("#dataId").val(id);
                console.log(id);
            },
            error: function (layero, index) {
                alert("aaa");
            }
        });
    };
</script>
<script>
    var element = layui.element;
    var table = layui.table;
    var form = layui.form;

    layui.use('layer', function () {
        var $ = layui.jquery, layer = layui.layer;
        $(document).on('click', '#addUser', function () {
            layer.open({
                type: 1,
                skin: 'layui-layer-rim', //加上边框
                area: ['420px', '240px'], //宽高
                content: 'html内容'
            });
        });
    });

    layui.use('form', function () {
        var form = layui.form;
        form.verify({
            ip: [
                /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/
                , 'IP地址不符合规则'
            ]
        });

    });

    //展示IP配置数据
    table.render({
        elem: '#ipConfig'
        , cols: [[ //标题栏
            {field: 'id', title: 'ID', width: 80, sort: true}
            , {field: 'ethName', title: '网口', width: 80}
            , {field: 'ipAddr', title: '地址', width: 160}
            , {field: 'subnetMask', title: '子网掩码', width: 160}
            , {field: 'gateway', title: '默认网关', width: 160}
        ]]
        , data: [{
            "id": "10001"
            , "ethName": "ETH1"
            , "ipAddr": "192.168.1.100"
            , "subnetMask": "255.255.255.0"
            , "gateway": "192.168.1.1"
        }, {
            "id": "10001"
            , "ethName": "ETH1"
            , "ipAddr": "192.168.1.100"
            , "subnetMask": "255.255.255.0"
            , "gateway": "192.168.1.1"
        }, {
            "id": "10001"
            , "ethName": "ETH1"
            , "ipAddr": "192.168.1.100"
            , "subnetMask": "255.255.255.0"
            , "gateway": "192.168.1.1"
        }, {
            "id": "10001"
            , "ethName": "ETH1"
            , "ipAddr": "192.168.1.100"
            , "subnetMask": "255.255.255.0"
            , "gateway": "192.168.1.1"
        }, {
            "id": "10001"
            , "ethName": "ETH1"
            , "ipAddr": "192.168.1.100"
            , "subnetMask": "255.255.255.0"
            , "gateway": "192.168.1.1"
        }, {
            "id": "10001"
            , "ethName": "ETH1"
            , "ipAddr": "192.168.1.100"
            , "subnetMask": "255.255.255.0"
            , "gateway": "192.168.1.1"
        }]
        , skin: 'line' //表格风格
        , even: true
        , page: true //是否显示分页
        , limits: [5, 7, 10]
        , limit: 5 //每页默认显示的数量
    });

    //展示com配置数据
    table.render({
        elem: '#comConfig'
        , cols: [[ //标题栏
            {field: 'id', title: 'ID', width: 80, sort: true}
            , {field: 'ethName', title: 'COM口', width: 80}
            , {field: 'ipAddr', title: '协议类型', width: 80}
            , {field: 'subnetMask', title: '通信模式', width: 80}
            , {field: 'gateway', title: '波特率', width: 80}
            , {field: 'gateway', title: '奇偶校验位', width: 80}
            , {field: 'gateway', title: '数据位', width: 80}
            , {field: 'gateway', title: '停止位', width: 80}
            , {field: 'gateway', title: '发送延迟(ms)', width: 80}
            , {field: 'operate', title: '操作', toolbar: '#operateTpl', unresize: true}
        ]]
        , data: [{
            "id": "10001"
            , "ethName": "ETH1"
            , "ipAddr": "192.168.1.100"
            , "subnetMask": "255.255.255.0"
            , "gateway": "192.168.1.1"
        }, {
            "id": "10001"
            , "ethName": "ETH1"
            , "ipAddr": "192.168.1.100"
            , "subnetMask": "255.255.255.0"
            , "gateway": "192.168.1.1"
        }, {
            "id": "10001"
            , "ethName": "ETH1"
            , "ipAddr": "192.168.1.100"
            , "subnetMask": "255.255.255.0"
            , "gateway": "192.168.1.1"
        }, {
            "id": "10001"
            , "ethName": "ETH1"
            , "ipAddr": "192.168.1.100"
            , "subnetMask": "255.255.255.0"
            , "gateway": "192.168.1.1"
        }, {
            "id": "10001"
            , "ethName": "ETH1"
            , "ipAddr": "192.168.1.100"
            , "subnetMask": "255.255.255.0"
            , "gateway": "192.168.1.1"
        }, {
            "id": "10001"
            , "ethName": "ETH1"
            , "ipAddr": "192.168.1.100"
            , "subnetMask": "255.255.255.0"
            , "gateway": "192.168.1.1"
        }]
        , skin: 'line' //表格风格
        , even: true
        , page: true //是否显示分页
        , limits: [5, 7, 10]
        , limit: 5 //每页默认显示的数量
    });
</script>

</html>