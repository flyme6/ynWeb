package com.yn.controller.operationalStatus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : OperationalStatusController
 * @Description：运行状态监视
 * @Date ：Created in 20:24 2018/10/31
 */
@Controller
@RequestMapping(value = "/operationalStatus")
public class OperationalStatusController {
    /**
     * 实时数据监视页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String OperationalStatus() throws Exception {
        return "operationalStatus/list";
    }
}
