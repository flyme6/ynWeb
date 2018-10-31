package com.yn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author flyme
 * @Title: LoginController
 * @ProjectName ynWeb
 * @Description: TODO
 * @date 2018/9/26 16:43
 */
@Controller
public class LoginController {
    /**
     * 跳转登录页面
     */
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String toLogin() throws Exception {
        return "../../login";
    }

    /**
     * 请求登录接口
     */
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String Login() throws Exception {
        return "redirect:index";
//        return "index";
    }

}
