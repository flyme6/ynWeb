package com.yn.controller.systemInformation;

import com.yn.common.Result;
import com.yn.smo.IsystemInformationService;
import com.yn.util.ynService.systemInformationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : projectManaConller
 * @Description：数据监视
 * @Date ：Created in 09:30 2018/11/23
 */
@Controller
@RequestMapping(value = "/systemInformation")
public class systemInformationController {
    private static final Logger log = LoggerFactory.getLogger(systemInformationController.class);


    @Autowired
    private IsystemInformationService informationService;

    /**
     * 获得系统资源使用情况
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/getSystemResourcesState")
    public String getSystemResourcesState() throws Exception {
        Result systemResourcesState = informationService.getSystemResourcesState();
        return systemResourcesState.toString();
    }

    /**
     * 获得嵌入式应用的运行情况
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/getAppRunState")
    public String getAppRunState() throws Exception {
        Result systemResourcesState = informationService.getAppRunState();
        return systemResourcesState.toString();
    }


    /**
     * 获得系统网口的运行情况
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/getNetportsState")
    public String getNetportsState() throws Exception {
        Result systemResourcesState = informationService.getNetportsState();
        return systemResourcesState.toString();
    }


    /**
     * 获得系统串口的运行情况
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/getComportsState")
    public String getComportsState() throws Exception {
        Result systemResourcesState = informationService.getComportsState();
        return systemResourcesState.toString();
    }

}
