package com.yn.controller.dataMonitor;

import YNRPC.ISystemControl;
import com.yn.common.Result;
import com.yn.smo.IDataMonitorService;
import com.yn.smo.ISystemControlService;
import com.yn.util.ynService.DataMonitorUtil;
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
 * @Date ：Created in 09:20 2018/11/23
 */
@Controller
@RequestMapping(value = "/dataMonitor")
public class dataMonitorController {
    private static final Logger log = LoggerFactory.getLogger(dataMonitorController.class);


    @Autowired
    private IDataMonitorService service;
    @Autowired
    private ISystemControlService systemControlService;

    /**
     * 获得设备状态
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/getDevicesState")
    public String getDevicesState() throws Exception {
        Result query = service.getDevicesState();
        return query.toString();
    }

    /**
     * 启动设备
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/startDevice")
    public String startDevice(String deviceName) throws Exception {
        Result query = systemControlService.startDevice(deviceName);
        return query.toString();
    }

    /**
     * 停止设备
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/stopDevice")
    public String stopDevice(String deviceName) throws Exception {
        Result query = systemControlService.stopDevice(deviceName);
        return query.toString();
    }

    /**
     * 获得实时数据
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/queryRealData")
    public String queryRealData() throws Exception {
        Result query = service.queryRealData();
        return query.toString();
    }

    /**
     * 获得设备的通信数据流
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/queryDeviceDataStream")
    public String queryDeviceDataStream() throws Exception {
        Object o = DataMonitorUtil.queryDeviceDataStream();
        return "获得设备的通信数据流" + o;
    }

    /**
     * 获得系统日志信息
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/querySystemLog")
    public String querySystemLog() throws Exception {
        Object o = DataMonitorUtil.querySystemLog();
        return "获得系统日志信息" + o;
    }
}
