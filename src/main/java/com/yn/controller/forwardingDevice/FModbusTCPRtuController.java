package com.yn.controller.forwardingDevice;

import com.yn.common.CommonUtils;
import com.yn.common.Result;
import com.yn.entity.FModbusTcp;
import com.yn.entity.FModbusTcpExample;
import com.yn.entity.FModbusTcpRtu;
import com.yn.entity.FModbusTcpRtuExample;
import com.yn.smo.IFModbusRtuService;
import com.yn.smo.IFModbusTcpRtuService;
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
 * @Title : FModbusTCPRtuController
 * @Description：Modbus诱传转发页面
 * @Date ：Created in 12:46 2018/10/28
 */
@Controller
@RequestMapping(value = "/forwardingDevice/modbusTCPRtu")
public class FModbusTCPRtuController {
    private static final Logger log = LoggerFactory.getLogger(FModbusTCPRtuController.class);

    @Autowired
    private IFModbusTcpRtuService service;

    /**
     * Modbus诱传转发页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String FModbusTcpRtu() throws Exception {
        return "forwardingDevice/modbusTCPRtu/list";
    }

    /**
     * Modbus诱传转发页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String FModbusTcpRtuEdit() throws Exception {
        return "forwardingDevice/modbusTCPRtu/edit";
    }

    /**
     * Modbus诱传转发页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String FModbusTcpRtuAdd() throws Exception {
        return "forwardingDevice/modbusTCPRtu/add";
    }

    /**
     * 查询modbusTCP，提供api接口
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/query")
    public String queryFModbusTcpRtu(HttpServletRequest request) {
        String result;
        try {
            String limit = CommonUtils.getStrFromObject(request.getParameter("limit"));
            String page = CommonUtils.getStrFromObject(request.getParameter("page"));
            FModbusTcp recod = new FModbusTcp();
            FModbusTcpRtuExample example = new FModbusTcpRtuExample();
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
    public String addFModbusTcpRtu(FModbusTcpRtu recod) {
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
    public String editFModbusTcpRtu(FModbusTcpRtu recod) {
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
    public String edlFModbusTcpRtu(String name) {
        FModbusTcpRtu recod = new FModbusTcpRtu();
        recod.setName(name);
        String result = service.del(recod).toString();
        return result;
    }

}
