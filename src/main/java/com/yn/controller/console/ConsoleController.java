package com.yn.controller.console;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制台打印输出页面
 */
@Controller
@RequestMapping(value = "/console")
public class ConsoleController {

    @GetMapping(value = "")
    public String CommunicationMessage() throws Exception {
        return "console/list";
    }
}
