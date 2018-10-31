layui.extend({
    admin: '{/}../../../static/js/admin'
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