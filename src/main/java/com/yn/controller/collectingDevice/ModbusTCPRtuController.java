package com.yn.controller.collectingDevice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : ModbusTCPRtuController
 * @Description：Modbus诱传采集页面
 * @Date ：Created in 12:46 2018/10/28
 */
@Controller
@RequestMapping(value = "/collectingDevice/modbusTCPRtu")
public class ModbusTCPRtuController {
    /**
     * Modbus诱传采集页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String modbusTCPRtu() throws Exception {
        return "collectingDevice/modbusTCPRtu/list";
    }

    /**
     * Modbus诱传采集页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String modbusTCPRtuEdit() throws Exception {
        return "collectingDevice/modbusTCPRtu/edit";
    }

    /**
     * Modbus诱传采集页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String modbusTCPRtuAdd() throws Exception {
        return "collectingDevice/modbusTCPRtu/add";
    }

}
