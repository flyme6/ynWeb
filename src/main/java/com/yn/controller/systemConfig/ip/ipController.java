package com.yn.controller.systemConfig.ip;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/systemConfig/ip")
public class ipController {
    /**
     * 网口配置页面
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String Ip() throws Exception {
        return "systemConfig/ip/list";
    }

    /**
     * 点表配置页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String ComEdit() throws Exception {
        return "systemConfig/ip/edit";
    }

}
