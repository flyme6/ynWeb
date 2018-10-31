package com.yn.controller.systemConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : systemConfigController
 * @Description：系统配置
 * @Date ：Created in 11:45 2018/10/28
 */
@Controller
@RequestMapping(value = "/systemConfig")
public class systemConfigController {
    /**
     * 通用配置页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/common")
    public String Com() throws Exception {
        return "systemConfig/common/list";
    }

    /**
     * 网口配置页面
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/ip")
    public String Ip() throws Exception {
        return "systemConfig/ip/list";
    }

    /**
     * 串口配置页面
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/com")
    public String Common() throws Exception {
        return "systemConfig/com/list";
    }

    /**
     * 用户配置页面
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/user")
    public String User() throws Exception {
        return "systemConfig/user/list";
    }

    /**
     * 用户配置页面——修改
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/user/edit")
    public String UserEdit() throws Exception {
        return "systemConfig/user/edit";
    }

    /**
     * 用户配置页面——添加
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/user/add")
    public String UserAdd() throws Exception {
        return "systemConfig/user/add";
    }
}
