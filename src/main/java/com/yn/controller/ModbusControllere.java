package com.yn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author flyme
 * @Title: ModbusCollectionControllere
 * @ProjectName ynWeb
 * @Description: TODO
 * @date 2018/10/15 16:51
 */
@Controller
public class ModbusControllere {
    /**
     * 跳转控制台
     */
    @GetMapping(value = "/modbus_edit")
    public String console() throws Exception {
        return "modbus/modbus_edit";
    }
}
