package com.yn.controller.collectingDevice;

import com.yn.common.CommonUtils;
import com.yn.entity.CModbusRtu;
import com.yn.entity.CModbusTcpRtu;
import com.yn.entity.CModbusTcpRtuExample;
import com.yn.smo.ICModbusTcpRtuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : ModbusTCPRtuController
 * @Description：Modbus诱传采集页面
 * @Date ：Created in 12:46 2018/10/28
 */
@Controller
@RequestMapping(value = "/collectingDevice/modbusTCPRtu")
public class ModbusTCPRtuController {

    @Autowired
    private ICModbusTcpRtuService service;

    /**
     * Modbus诱传采集页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String modbusTCPRtu() throws Exception {
        return "collectingDevice/modbusTCPRtu/list";
    }

    /**
     * Modbus诱传采集页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String modbusTCPRtuEdit() throws Exception {
        return "collectingDevice/modbusTCPRtu/edit";
    }

    /**
     * Modbus诱传采集页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String modbusTCPRtuAdd() throws Exception {
        return "collectingDevice/modbusTCPRtu/add";
    }

    /**
     * 查询，提供api接口
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/query")
    public String queryModbusTcpRtu(HttpServletRequest request) {
        String result;
        try {
            String limit = CommonUtils.getStrFromObject(request.getParameter("limit"));
            String page = CommonUtils.getStrFromObject(request.getParameter("page"));
            CModbusTcpRtuExample example = new CModbusTcpRtuExample();
            int showCount = Integer.parseInt(limit);
            int currentPage = Integer.parseInt(page);
            example.setLastCount((currentPage - 1) * showCount);
            example.setPageSize(showCount);
            return service.query(example).toString();
        } catch (Exception e) {
            return e.getMessage();
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
    public String addModbusRTU(CModbusTcpRtu recod) {
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
    public String editModbusRTU(CModbusTcpRtu recod) {
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
        CModbusTcpRtu recod = new CModbusTcpRtu();
        recod.setName(name);
        String result = service.del(recod).toString();
        return result;
    }

}
