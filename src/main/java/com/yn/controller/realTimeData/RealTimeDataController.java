package com.yn.controller.realTimeData;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : PointsConfigController
 * @Description：点表配置页面
 * @Date ：Created in 20:46 2018/10/28
 */
@Controller
@RequestMapping(value = "/realTimeData")
public class RealTimeDataController{

    /**
     * 点表配置页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String pointsConfig2() throws Exception {
        return "RealTimeData/list";
    }

}
