layui.extend({
    admin: '{/}../../../static/js/admin'
});

layui.use(['table', 'jquery', 'form', 'admin'], function () {
    var table = layui.table,
        $ = layui.jquery,
        form = layui.form,
        admin = layui.admin;

    form.verify({
        ip: [
            /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/
            , 'IP地址不符合规则'
        ]
    });

    //展示IP配置数据
    table.render({
        elem: '#modbusTCPRtu',
        cellMinWidth: 80,
        cols: [[ //标题栏
            {field: 'name', title: '设备名称'}
            , {field: 'weight', title: '权重'}
            , {field: 'main_ip', title: '主IP'}
            , {field: 'back_ip', title: '备IP'}
            , {field: 'port', title: '端口号'}
            , {field: 'clct_interval', title: '采集周期'}
            , {field: 'clct_timeout', title: '采集超时'}
            , {field: 'cmd_timeout', title: '命令超时'}
            , {field: 'fault_count', title: '允许失败次数'}
            , {field: 'package_len', title: '包长度'}
            ,{
                field: 'operate', title: '操作', toolbar: '#operateTpl', unresize: true
            }
        ]],
        data: [{
            "name": "DEV1"
            , "weight": "60"
            , "main_ip": "192.168.1.1"
            , "back_ip": "192.168.1.1"
            , "port": "502"
            , "clct_interval": "1000"
            , "clct_timeout": "2000"
            , "cmd_timeout": "4000"
            , "fault_count": "3"
            , "package_len": "256"
        },{
            "name": "DEV1"
            , "weight": "60"
            , "main_ip": "192.168.1.1"
            , "back_ip": "192.168.1.1"
            , "port": "502"
            , "clct_interval": "1000"
            , "clct_timeout": "2000"
            , "cmd_timeout": "4000"
            , "fault_count": "3"
            , "package_len": "256"
        },{
            "name": "DEV1"
            , "weight": "60"
            , "main_ip": "192.168.1.1"
            , "back_ip": "192.168.1.1"
            , "port": "502"
            , "clct_interval": "1000"
            , "clct_timeout": "2000"
            , "cmd_timeout": "4000"
            , "fault_count": "3"
            , "package_len": "256"
        },{
            "name": "DEV1"
            , "weight": "60"
            , "main_ip": "192.168.1.1"
            , "back_ip": "192.168.1.1"
            , "port": "502"
            , "clct_interval": "1000"
            , "clct_timeout": "2000"
            , "cmd_timeout": "4000"
            , "fault_count": "3"
            , "package_len": "256"
        },{
            "name": "DEV1"
            , "weight": "60"
            , "main_ip": "192.168.1.1"
            , "back_ip": "192.168.1.1"
            , "port": "502"
            , "clct_interval": "1000"
            , "clct_timeout": "2000"
            , "cmd_timeout": "4000"
            , "fault_count": "3"
            , "package_len": "256"
        }]
        , skin: 'line' //表格风格
        , even: true
        , page: true //是否显示分页
        , limits: [5, 7, 10]
        , limit: 5 //每页默认显示的数量
    });


    /*
     *数据表格中form表单元素是动态插入,所以需要更新渲染下
     * http://www.layui.com/doc/modules/form.html#render
     * */
    $(function () {
        form.render();
    });


    /*iec-删除*/
    window.modbusPassThrough_del = function (obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已删除!', {
                icon: 1,
                time: 1000
            });
        });
    }
});
