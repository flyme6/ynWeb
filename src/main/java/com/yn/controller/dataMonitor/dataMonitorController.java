package com.yn.controller.dataMonitor;

import YNRPC.ISystemControl;
import com.yn.common.CommonUtils;
import com.yn.common.Result;
import com.yn.entity.CModbusTcp;
import com.yn.entity.CModbusTcpExample;
import com.yn.entity.Points;
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

import javax.servlet.http.HttpServletRequest;

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
    public String queryRealData(String limit, String page) throws Exception {
        try {

            Points points = new Points();
            int showCount = Integer.parseInt(limit);
            int currentPage = Integer.parseInt(page);
            points.setLastCount((currentPage - 1) * showCount);
            points.setPageSize(showCount);

            return service.queryRealData(points).toString();
        } catch (Exception e) {
            return Result.getQueryFailResult(e).toString();
        }
    }

    /**
     * 查询，提供api接口
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/searchRealData")
    public String searchRealData(String limit, String page, String cdev, String fdev, HttpServletRequest request) {
        String name = CommonUtils.getStrFromObject(request.getParameter("name"));
        try {
            Points recod = new Points();
            int showCount = Integer.parseInt(limit);
            int currentPage = Integer.parseInt(page);

            recod.setName("%" + name + "%");
            recod.setcDev(cdev);
            recod.setfDev(fdev);

            recod.setLastCount((currentPage - 1) * showCount);
            recod.setPageSize(showCount);

            System.out.println(recod+ "asd");
            return service.queryRealData(recod).toString();
        } catch (Exception e) {
            return Result.getQueryFailResult(e).toString();
        }
    }

//    /**
//     * 获得设备的通信数据流
//     *
//     * @return
//     * @throws Exception
//     */
//    @ResponseBody
//    @GetMapping(value = "/queryDeviceDataStream")
//    public String queryDeviceDataStream() throws Exception {
//        Object o = DataMonitorUtil.queryDeviceDataStream();
//        return "获得设备的通信数据流" + o;
//    }

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
