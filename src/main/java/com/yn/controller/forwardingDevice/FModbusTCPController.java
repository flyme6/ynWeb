package com.yn.controller.forwardingDevice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : FModbusTCPController
 * @Description：ModbusTCP转发页面
 * @Date ：Created in 12:46 2018/10/28
 */
@Controller
@RequestMapping(value = "/forwardingDevice/modbusTCP")
public class FModbusTCPController {
    /**
     * ModbusTCP转发页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String modbusTCP() throws Exception {
        return "forwardingDevice/modbusTCP/list";
    }

    /**
     * ModbusTCP转发页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String modbusTCPEdit() throws Exception {
        return "forwardingDevice/modbusTCP/edit";
    }

    /**
     * ModbusTCP转发页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String modbusTCPAdd() throws Exception {
        return "forwardingDevice/modbusTCP/add";
    }

}
