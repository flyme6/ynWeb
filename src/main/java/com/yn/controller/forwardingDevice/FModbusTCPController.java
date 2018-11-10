package com.yn.controller.forwardingDevice;

import com.yn.common.CommonUtils;
import com.yn.common.Result;
import com.yn.entity.FModbusTcp;
import com.yn.entity.FModbusTcpExample;
import com.yn.smo.IFModbusTcpService;
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
 * @Title : FModbusTCPController
 * @Description：ModbusTCP转发页面
 * @Date ：Created in 12:46 2018/10/28
 */
@Controller
@RequestMapping(value = "/forwardingDevice/modbusTCP")
public class FModbusTCPController {
    private static final Logger log = LoggerFactory.getLogger(FModbusTCPController.class);

    @Autowired
    private IFModbusTcpService service;

    /**
     * ModbusTCP转发页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String FModbusTcp() throws Exception {
        return "forwardingDevice/modbusTCP/list";
    }

    /**
     * ModbusTCP转发页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String FModbusTcpEdit() throws Exception {
        return "forwardingDevice/modbusTCP/edit";
    }

    /**
     * ModbusTCP转发页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String FModbusTcpAdd() throws Exception {
        return "forwardingDevice/modbusTCP/add";
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
            FModbusTcp recod = new FModbusTcp();
            FModbusTcpExample example = new FModbusTcpExample();
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
    public String addFModbusTcp(FModbusTcp recod) {
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
    public String editFModbusTcp(FModbusTcp recod) {
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
    public String edlFModbusTcp(String name) {
        FModbusTcp recod = new FModbusTcp();
        recod.setName(name);
        String result = service.del(recod).toString();
        return result;
    }
}
