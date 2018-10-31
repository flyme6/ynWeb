package com.yn.controller.collectingDevice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : IEC104Controller
 * @Description：IEC104采集页面
 * @Date ：Created in 12:46 2018/10/28
 */
@Controller
@RequestMapping(value = "/collectingDevice/IEC104")
public class IEC104Controller {

    /**
     * IEC104采集页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String IEC104() throws Exception {
        return "collectingDevice/IEC104/list";
    }

    /**
     * IEC104采集页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String IEC104Edit() throws Exception {
        return "collectingDevice/IEC104/edit";
    }

    /**
     * IEC104采集页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String IEC104Add() throws Exception {
        return "collectingDevice/IEC104/add";
    }
}
