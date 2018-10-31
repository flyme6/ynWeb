package com.yn.controller.forwardingDevice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : FModbusTCPRtuController
 * @Description：Modbus诱传转发页面
 * @Date ：Created in 12:46 2018/10/28
 */
@Controller
@RequestMapping(value = "/forwardingDevice/modbusTCPRtu")
public class FModbusTCPRtuController {
    /**
     * Modbus诱传转发页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String modbusTCPRtu() throws Exception {
        return "forwardingDevice/modbusTCPRtu/list";
    }

    /**
     * Modbus诱传转发页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String modbusTCPRtuEdit() throws Exception {
        return "forwardingDevice/modbusTCPRtu/edit";
    }

    /**
     * Modbus诱传转发页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String modbusTCPRtuAdd() throws Exception {
        return "forwardingDevice/modbusTCPRtu/add";
    }

}
