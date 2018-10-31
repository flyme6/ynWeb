package com.yn.controller.collectingDevice;

import com.yn.common.CommonUtils;
import com.yn.entity.CModbusTcp;
import com.yn.entity.CModbusTcpExample;
import com.yn.smo.ICModbusTcpService;
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
    public String querymodbusTCP(HttpServletRequest request) {

        String limit = CommonUtils.getStrFromObject(request.getParameter("limit"));
        String page = CommonUtils.getStrFromObject(request.getParameter("page"));
        CModbusTcp cModbusTcp = new CModbusTcp();
//        try {
//            int showCount = Integer.parseInt(limit);
//            int currentPage = Integer.parseInt(page);
//            cModbusTcp.setLastCount((currentPage - 1) * showCount);
//            cModbusTcp.setPageSize(showCount);
//        } catch (Exception e) {
//            log.error(e.toString());
//        }
        CModbusTcpExample example = new CModbusTcpExample();
        try {
            int showCount = Integer.parseInt(limit);
            int currentPage = Integer.parseInt(page);
            example.setLastCount((currentPage - 1) * showCount);
            example.setPageSize(showCount);
        } catch (Exception e) {
            log.error(e.toString());
        }
        String result = service.queryICModbusTcp(example).toString();
        return result;
    }

}
