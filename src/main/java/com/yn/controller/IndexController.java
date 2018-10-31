package com.yn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : systemConfigController
 * @Description：首页面
 * @Date ：Created in 16:55 2018/9/26
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
}
