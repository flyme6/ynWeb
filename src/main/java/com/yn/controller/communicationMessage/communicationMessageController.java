package com.yn.controller.communicationMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
