package com.yn.controller;

import com.yn.bmo.IUsermgrBmo;
import com.yn.common.Result;
import com.yn.controller.systemConfig.user.userController;
import com.yn.entity.Usermgr;
import com.yn.entity.UsermgrExample;
import com.yn.smo.IUsermgrService;
import com.yn.util.MD5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author flyme
 * @Title: LoginController
 * @ProjectName ynWeb
 * @Description: TODO
 * @date 2018/9/26 16:43
 */
@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(userController.class);

    @Autowired
    private IUsermgrService service;

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
    @ResponseBody
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String Login(String username, String password,ModelMap map) throws Exception {
        Usermgr recod = new Usermgr();
        recod.setUsername(username);
        String s = MD5.md5(password);
        recod.setPassword(s);
        Result result = service.query(recod);
        map.addAttribute("username", username);
        System.out.println("casdsa" + result);
//        return "redirect:index";
        return result.toString();
//        return "index";
    }

}
