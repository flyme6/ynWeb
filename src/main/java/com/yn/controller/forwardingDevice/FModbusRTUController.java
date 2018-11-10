package com.yn.controller.forwardingDevice;

import com.yn.common.CommonUtils;
import com.yn.common.Result;
import com.yn.entity.FModbusRtu;
import com.yn.entity.FModbusRtuExample;
import com.yn.smo.IFModbusRtuService;
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
 * @Title : FModbusRTUController
 * @Description：Modbus诱传转发页面
 * @Date ：Created in 12:46 2018/10/28
 */
@Controller
@RequestMapping(value = "/forwardingDevice/modbusRTU")
public class FModbusRTUController {
    private static final Logger log = LoggerFactory.getLogger(FModbusTCPController.class);

    @Autowired
    private IFModbusRtuService service;

    /**
     * Modbus诱传转发页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String FModbusRtu() throws Exception {
        return "forwardingDevice/modbusRTU/list";
    }

    /**
     * Modbus诱传转发页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String FModbusRtuEdit() throws Exception {
        return "forwardingDevice/modbusRTU/edit";
    }

    /**
     * Modbus诱传转发页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String FModbusRtuAdd() throws Exception {
        return "forwardingDevice/modbusRTU/add";
    }

    /**
     * 查询modbusTCP，提供api接口
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/query")
    public String queryFModbusTcp(HttpServletRequest request) {
        String result;
        try {
            String limit = CommonUtils.getStrFromObject(request.getParameter("limit"));
            String page = CommonUtils.getStrFromObject(request.getParameter("page"));
            FModbusRtu recod = new FModbusRtu();
            FModbusRtuExample example = new FModbusRtuExample();
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
    public String addFModbusRtu(FModbusRtu recod) {
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
    public String editFModbusRtu(FModbusRtu recod) {
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
    public String edlFModbusRtu(String name) {
        FModbusRtu recod = new FModbusRtu();
        recod.setName(name);
        String result = service.del(recod).toString();
        return result;
    }

}
