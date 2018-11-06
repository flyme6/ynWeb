package com.yn.controller.collectingDevice;

import com.yn.common.CommonUtils;
import com.yn.common.Result;
import com.yn.entity.CModbusTcp;
import com.yn.entity.CModbusTcpExample;
import com.yn.smo.ICModbusTcpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : ModbusTCPController
 * @Description：ModbusRTU采集页面
 * @Date ：Created in 12:46 2018/10/28
 */
@Controller
@RequestMapping(value = "/collectingDevice/modbusTCP")
public class ModbusTCPController {
    private static final Logger log = LoggerFactory.getLogger(ModbusTCPController.class);

    @Autowired
    private ICModbusTcpService service;

    /**
     * ModbusTCP采集页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String modbusTCP() throws Exception {
        return "collectingDevice/modbusTCP/list";
    }

    /**
     * ModbusTCP采集页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String modbusTCPEdit() throws Exception {
        return "collectingDevice/modbusTCP/edit";
    }

    /**
     * ModbusTCP采集页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String modbusTCPAdd() throws Exception {
        return "collectingDevice/modbusTCP/add";
    }

    /**
     * 查询modbusTCP，提供api接口
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/query")
    public String queryModbusTCP(HttpServletRequest request) {
        String result;
        try {
            String limit = CommonUtils.getStrFromObject(request.getParameter("limit"));
            String page = CommonUtils.getStrFromObject(request.getParameter("page"));
            CModbusTcp cModbusTcp = new CModbusTcp();
            CModbusTcpExample example = new CModbusTcpExample();
            int showCount = Integer.parseInt(limit);
            int currentPage = Integer.parseInt(page);
            example.setLastCount((currentPage - 1) * showCount);
            example.setPageSize(showCount);
            return service.queryICModbusTcp(example).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * 修改modbusTCP，提供api接口
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/goDel")
    public String edlModbusTCP(String name) {
        CModbusTcp cModbusTcp = new CModbusTcp();
        cModbusTcp.setName(name);
        String result = service.delICModbusTcp(cModbusTcp).toString();
        return result;
    }

    /**
     * 修改modbusTCP，提供api接口
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/goAdd")
    public String addModbusTCP(String name, Integer weight, String main_ip, String back_ip,
                               Integer port, Integer clct_interval, Integer clct_timeout, Integer cmd_timeout, Integer fault_count,
                               Integer package_len, Integer allow_empty_addr, String byte_order16, String byte_order32,
                               String byte_order64, Integer cmd_cache_size, Integer active) {
        CModbusTcp cModbusTcp = new CModbusTcp();
        cModbusTcp.setName(name);
        cModbusTcp.setWeight(weight);
        cModbusTcp.setMainIp(main_ip);
        cModbusTcp.setPort(port);
        cModbusTcp.setBackIp(back_ip);

        cModbusTcp.setClctInterval(clct_interval);
        cModbusTcp.setClctTimeout(clct_timeout);
        cModbusTcp.setCmdTimeout(cmd_timeout);
        cModbusTcp.setFaultCount(fault_count);
        cModbusTcp.setPackageLen(package_len);
        cModbusTcp.setAllowEmptyAddr(allow_empty_addr);
        cModbusTcp.setByteOrder16(byte_order16);
        cModbusTcp.setByteOrder32(byte_order32);
        cModbusTcp.setByteOrder64(byte_order64);
        cModbusTcp.setCmdCacheSize(cmd_cache_size);
        cModbusTcp.setActive(active);
        String result = service.addICModbusTcp(cModbusTcp).toString();
        return result;
    }

    /**
     * 修改modbusTCP，提供api接口
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/goEdit")
    public String editModbusTCP(String name, Integer weight, String main_ip, String back_ip,
                                Integer port, Integer clct_interval, Integer clct_timeout, Integer cmd_timeout, Integer fault_count,
                                Integer package_len, Integer allow_empty_addr, String byte_order16, String byte_order32,
                                String byte_order64, Integer cmd_cache_size, Integer active
    ) {
//        String result = service.saveICModbusTcp(parseRequestCModbusTcp(request)).toString();
        CModbusTcp cModbusTcp = new CModbusTcp();
        cModbusTcp.setName(name);
        cModbusTcp.setWeight(weight);
        cModbusTcp.setMainIp(main_ip);
        cModbusTcp.setPort(port);
        cModbusTcp.setBackIp(back_ip);

        cModbusTcp.setClctInterval(clct_interval);
        cModbusTcp.setClctTimeout(clct_timeout);
        cModbusTcp.setCmdTimeout(cmd_timeout);
        cModbusTcp.setFaultCount(fault_count);
        cModbusTcp.setPackageLen(package_len);
        cModbusTcp.setAllowEmptyAddr(allow_empty_addr);
        cModbusTcp.setByteOrder16(byte_order16);
        cModbusTcp.setByteOrder32(byte_order32);
        cModbusTcp.setByteOrder64(byte_order64);
        cModbusTcp.setCmdCacheSize(cmd_cache_size);
        cModbusTcp.setActive(active);
        String result = service.saveICModbusTcp(cModbusTcp).toString();
        return result;
    }

    private CModbusTcp parseRequestCModbusTcp(HttpServletRequest request) {
        String name = CommonUtils.getStrFromObject(request.getParameter("name"));
        Integer weight = CommonUtils.getIntFromObject(request.getParameter("weight"));
        String main_ip = CommonUtils.getStrFromObject(request.getParameter("main_ip"));
        String back_ip = CommonUtils.getStrFromObject(request.getParameter("back_ip"));
        Integer port = CommonUtils.getIntFromObject(request.getParameter("port"));

        Integer clct_interval = Integer.valueOf(CommonUtils.getStrFromObject(request.getParameter("clct_interval")));
        Integer clct_timeout = Integer.valueOf(CommonUtils.getStrFromObject(request.getParameter("clct_timeout")));
        Integer cmd_timeout = Integer.valueOf(CommonUtils.getStrFromObject(request.getParameter("cmd_timeout")));
        Integer fault_count = Integer.valueOf(CommonUtils.getStrFromObject(request.getParameter("fault_count")));
        Integer package_len = Integer.valueOf(CommonUtils.getStrFromObject(request.getParameter("package_len")));
        Integer allow_empty_addr = Integer.valueOf(CommonUtils.getStrFromObject(request.getParameter("allow_empty_addr")));

        String byte_order16 = CommonUtils.getStrFromObject(request.getParameter("byte_order16"));
        String byte_order32 = CommonUtils.getStrFromObject(request.getParameter("byte_order32"));
        String byte_order64 = CommonUtils.getStrFromObject(request.getParameter("byte_order64"));

        Integer cmd_cache_size = Integer.valueOf(CommonUtils.getStrFromObject(request.getParameter("cmd_cache_size")));
        Integer active = Integer.valueOf(CommonUtils.getStrFromObject(request.getParameter("active")));

        CModbusTcp cModbusTcp = new CModbusTcp();
        cModbusTcp.setName(name);
        cModbusTcp.setWeight(weight);
        cModbusTcp.setMainIp(main_ip);
        cModbusTcp.setPort(port);
        cModbusTcp.setBackIp(back_ip);

        cModbusTcp.setClctInterval(clct_interval);
        cModbusTcp.setClctTimeout(clct_timeout);
        cModbusTcp.setCmdTimeout(cmd_timeout);
        cModbusTcp.setFaultCount(fault_count);
        cModbusTcp.setPackageLen(package_len);
        cModbusTcp.setAllowEmptyAddr(allow_empty_addr);
        cModbusTcp.setByteOrder16(byte_order16);
        cModbusTcp.setByteOrder32(byte_order32);
        cModbusTcp.setByteOrder64(byte_order64);
        cModbusTcp.setCmdCacheSize(cmd_cache_size);
        cModbusTcp.setActive(active);
        return cModbusTcp;
    }

}
