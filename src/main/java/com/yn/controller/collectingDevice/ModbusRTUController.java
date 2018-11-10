package com.yn.controller.collectingDevice;

import com.yn.common.CommonUtils;
import com.yn.common.Result;
import com.yn.entity.CModbusRtu;
import com.yn.entity.CModbusRtuExample;
import com.yn.entity.CModbusTcp;
import com.yn.smo.ICModbusRtuService;
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
 * @Title : ModbusRTUController
 * @Description：Modbus诱传采集页面
 * @Date ：Created in 12:46 2018/10/28
 */
@Controller
@RequestMapping(value = "/collectingDevice/modbusRTU")
public class ModbusRTUController {
    private static final Logger log = LoggerFactory.getLogger(ModbusRTUController.class);

    @Autowired
    private ICModbusRtuService service;

    /**
     * ModbusRTU采集页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String modbusRTU() throws Exception {
        return "collectingDevice/modbusRTU/list";
    }

    /**
     * ModbusTCP采集页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String modbusRTUEdit() throws Exception {
        return "collectingDevice/modbusRTU/edit";
    }

    /**
     * ModbusTCP采集页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String modbusRTUAdd() throws Exception {
        return "collectingDevice/modbusRTU/add";
    }

    /**
     * 查询modbusTCP，提供api接口
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/query")
    public String queryModbusRTU(HttpServletRequest request) {
        String result;
        try {
            String limit = CommonUtils.getStrFromObject(request.getParameter("limit"));
            String page = CommonUtils.getStrFromObject(request.getParameter("page"));
            CModbusRtu recod = new CModbusRtu();
            CModbusRtuExample example = new CModbusRtuExample();
            int showCount = Integer.parseInt(limit);
            int currentPage = Integer.parseInt(page);
            example.setLastCount((currentPage - 1) * showCount);
            example.setPageSize(showCount);
            return service.query(example).toString();
        } catch (Exception e) {
            return Result.getQueryFailResult(e).toString();
        }
    }

    /**
     * 添加modbusTCP，提供api接口
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/goAdd")
    public String addModbusRTU(CModbusRtu recod) {
        String result = service.add(recod).toString();
        return result;
    }

    /**
     * 修改modbusTCP，提供api接口
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/goEdit")
    public String editModbusRTU(CModbusRtu recod) {
        String result = service.save(recod).toString();
        return result;
    }

    /**
     * 修改modbusTCP，提供api接口
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/goDel")
    public String edlModbusTCP(String name) {
        CModbusRtu recod = new CModbusRtu();
        recod.setName(name);
        String result = service.del(recod).toString();
        return result;
    }

}
