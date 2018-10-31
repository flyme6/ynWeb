package com.yn.controller.forwardingDevice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : FModbusRTUController
 * @Description：Modbus诱传转发页面
 * @Date ：Created in 12:46 2018/10/28
 */
@Controller
@RequestMapping(value = "/forwardingDevice/modbusRTU")
public class FModbusRTUController {
    /**
     * Modbus诱传转发页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String modbusRTU() throws Exception {
        return "forwardingDevice/modbusRTU/list";
    }

    /**
     * Modbus诱传转发页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String modbusRTUEdit() throws Exception {
        return "forwardingDevice/modbusRTU/edit";
    }

    /**
     * Modbus诱传转发页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String modbusRTUAdd() throws Exception {
        return "forwardingDevice/modbusRTU/add";
    }
}
