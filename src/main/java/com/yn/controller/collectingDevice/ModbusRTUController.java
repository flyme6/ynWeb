package com.yn.controller.collectingDevice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : ModbusRTUController
 * @Description：Modbus诱传采集页面
 * @Date ：Created in 12:46 2018/10/28
 */
@Controller
@RequestMapping(value = "/collectingDevice/modbusRTU")
public class ModbusRTUController {
    /**
     * ModbusRTU采集页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String modbusRTU() throws Exception {
        return "collectingDevice/modbusRTU/list";
    }

    /**
     * ModbusTCP采集页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String modbusRTUEdit() throws Exception {
        return "collectingDevice/modbusRTU/edit";
    }

    /**
     * ModbusTCP采集页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String modbusRTUAdd() throws Exception {
        return "collectingDevice/modbusRTU/add";
    }
}
