package com.yn.controller.communicationMessage;

import com.yn.common.Result;
import com.yn.smo.IDataMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : communicationMessageController
 * @Description：通信报文监视
 * @Date ：Created in 20:29 2018/10/31
 */
@Controller
@RequestMapping(value = "/communicationMessage")
public class communicationMessageController {

    @Autowired
    private IDataMonitorService dataMonitorService;

    /**
     * 通信报文监视页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String CommunicationMessage() throws Exception {
        return "communicationMessage/list";
    }

    @ResponseBody
    @GetMapping(value = "/getDeviceDataFrames")
    public String getDeviceDataFrames(String devName, int dataPos, int itemLimit) throws Exception {
        Result result = dataMonitorService.queryDeviceDataStream(devName, dataPos, itemLimit);
        return result.toString();
    }
}
