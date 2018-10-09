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
    <title>站点列表</title>
</head>
<body class="layui-view-body">
<div class="layui-content">
    <div class="layui-page-header">
        <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a href="">首页</a>
                  <a href="">站点列表</a>
                </span>
            <h2 class="title">站点列表</h2>
        </div>
    </div>
    <div class="layui-row">
        <div class="layui-card">
            <div class="layui-card-body">
                <div class="form-box">
                    <div class="layui-form layui-form-item">
                        <div class="layui-inline">
                            <div class="layui-form-mid">采集设备选择:</div>
                            <div class="layui-input-inline" style="width: 100px;">
                                <select name="collection">
                                    <option value="1">设备1</option>
                                    <option value="2">设备2</option>
                                </select>
                                <!--<input type="text" autocomplete="off" class="layui-input">-->
                            </div>
                            <div class="layui-form-mid">邮箱:</div>
                            <div class="layui-input-inline" style="width: 100px;">
                                <input type="text" autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-form-mid">转发设备选择:</div>
                            <div class="layui-input-inline" style="width: 100px;">
                                <select name="forward">
                                    <option value="1">设备1</option>
                                    <option value="2">设备2</option>
                                </select>
                            </div>
                            <button class="layui-btn layui-btn-blue">筛选</button>
                            <button class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                    <button class="layui-btn layui-btn-blue"><i class="layui-icon">&#xe654;</i>新增</button>

                    <button data-method="offset" data-type="auto" class="layui-btn layui-btn-normal">新增</button>


                    <table id="demo"></table>
                </div>
            </div>
        </div>
    </div>

</div>
<script src="assets/layui.all.js"></script>
<script>
    var element = layui.element;
    var table = layui.table;
    var form = layui.form;

    //展示已知数据
    table.render({
        elem: '#demo'
        , cols: [[ //标题栏
            {field: 'id', title: '站点ID', width: 80, sort: true}
            , {field: 'username', title: '名称/Name', width: 80}
            , {field: 'email', title: '值/Value', width: 160}
            , {field: 'sign', title: '时间标签/Timestamp', width: 160}
            , {field: 'sex', title: '采集设备 In dev', width: 160}
            , {field: 'city', title: '采集地址 In addr', width: 160}
            , {field: 'experience', title: 'Modbus转发地址', width: 160, sort: true}
        ]]
        , data: [{
            "id": "10001"
            , "username": "杜甫"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "116"
            , "ip": "192.168.0.8"
            , "logins": "108"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10002"
            , "username": "李白"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "12"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
            , "LAY_CHECKED": true
        }, {
            "id": "10003"
            , "username": "王勃"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "65"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10004"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "666"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10005"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "86"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10006"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "12"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10007"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "16"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }, {
            "id": "10008"
            , "username": "贤心"
            , "email": "xianxin@layui.com"
            , "sex": "男"
            , "city": "浙江杭州"
            , "sign": "人生恰似一场修行"
            , "experience": "106"
            , "ip": "192.168.0.8"
            , "logins": "106"
            , "joinTime": "2016-10-14"
        }]
        , skin: 'line' //表格风格
        , even: true
        , page: true //是否显示分页
        , limits: [5, 7, 10]
        , limit: 5 //每页默认显示的数量
    });
</script>
</body>
</html>