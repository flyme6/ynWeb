package com.yn.controller.systemConfig.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/systemConfig/user")
public class userController {

    /**
     * 用户配置页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String User() throws Exception {
        return "systemConfig/user/list";
    }

    /**
     * 用户配置页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String UserEdit() throws Exception {
        return "systemConfig/user/edit";
    }

    /**
     * 用户配置页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String UserAdd() throws Exception {
        return "systemConfig/user/add";
    }
}
