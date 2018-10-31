package com.yn.controller.collectingDevice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : ABCIPController
 * @Description：ABCIP采集页面
 * @Date ：Created in 12:46 2018/10/28
 */
@Controller
@RequestMapping(value = "/collectingDevice/ABCIP")
public class ABCIPController {
    /**
     * ABCIP采集页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String ABCIP() throws Exception {
        return "collectingDevice/ABCIP/list";
    }

    /**
     * ABCIP采集页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String ABCIPEdit() throws Exception {
        return "collectingDevice/ABCIP/edit";
    }

    /**
     * ABCIP采集页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String ABCIPAdd() throws Exception {
        return "collectingDevice/ABCIP/add";
    }
}
