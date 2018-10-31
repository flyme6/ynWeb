package com.yn.controller.systemLog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : systemLogController
 * @Description：系统日志
 * @Date ：Created in 20:32 2018/10/31
 */
@Controller
@RequestMapping(value = "/systemLog")
public class systemLogController {
    /**
     * 系统日志页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String systemLog() throws Exception {
        return "systemLog/list";
    }
}
