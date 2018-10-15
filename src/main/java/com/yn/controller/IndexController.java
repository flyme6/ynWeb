package com.yn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author flyme
 * @Title: IndexController
 * @ProjectName ynWeb
 * @Description: 拦截请求，跳转页面
 * @date 2018/9/26 16:55
 */
@Controller
public class IndexController {
    /**
     * 跳转主页
     */
    @GetMapping(value = "/index")
    public String index() throws Exception {
        return "index";
    }

    /**
     * 跳转控制台
     */
    @GetMapping(value = "/console")
    public String console() throws Exception {
        return "console";
    }

    /**
     * 跳转WTX配置页面
     */
    @GetMapping(value = "/wtxConfig")
    public String wtxConfig() throws Exception {
        return "wtxConfig";
    }

    /**
     * 跳转modbus收集页面
     *
     */
    @GetMapping(value = "/modbus_list")
    public String modbusCollection() throws Exception {
        return "modbus/modbus_list";
    }




    /**
     * 跳转站点列表
     */
    @GetMapping(value = "/siteList")
    public String siteList() throws Exception {
        return "siteList";
    }

    /**
     * 跳转系统配置页面
     */
    @GetMapping(value = "/systemConfiguration")
    public String systemConfiguration() throws Exception {
        return "systemConfiguration";
    }

    /**
     * 跳转系统控制页面
     */
    @GetMapping(value = "/systemControl")
    public String systemControl() throws Exception {
        return "systemControl";
    }

    /**
     * 跳转设备管理页面
     */
    @GetMapping(value = "/equipManage")
    public String equipManage() throws Exception {
        return "equipManage";
    }

    /**
     * 跳转数据监视页面
     */
    @GetMapping(value = "/dataMonitoring")
    public String dataMonitoring() throws Exception {
        return "dataMonitoring";
    }

    /**
     * 跳转系统信息页面
     */
    @GetMapping(value = "/systemInfo")
    public String systemInfo() throws Exception {
        return "systemInfo";
    }

    /**
     * 跳转用户列表页面
     */
    @GetMapping(value = "/users")
    public String users() throws Exception {
        return "users";
    }

    /**
     * 跳转新增用户页面
     */
    @GetMapping(value = "/useradd")
    public String useradd() throws Exception {
        return "userAdd";
    }

}
