package com.yn.controller.forwardingDevice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : FIEC104Controller
 * @Description：IEC104转发页面
 * @Date ：Created in 12:46 2018/10/28
 */
@Controller
@RequestMapping(value = "/forwardingDevice/IEC104")
public class FIEC104Controller {

    /**
     * IEC104转发页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String IEC104() throws Exception {
        return "forwardingDevice/IEC104/list";
    }

    /**
     * IEC104转发页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String IEC104Edit() throws Exception {
        return "forwardingDevice/IEC104/edit";
    }

    /**
     * IEC104转发页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String IEC104Add() throws Exception {
        return "forwardingDevice/IEC104/add";
    }
}
