package com.yn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : WelcomeController
 * @Description：欢迎页面
 * @Date ：Created in 10:38 2018/10/31
 */
@Controller
@RequestMapping(value = "/welcome")
public class WelcomeController {
    /**
     * 跳转登录页面
     */
    @GetMapping(value = "")
    public String Welcome() throws Exception {
        return "welcome";
    }
}
