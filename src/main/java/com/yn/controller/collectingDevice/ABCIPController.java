package com.yn.controller.collectingDevice;

import com.yn.common.CommonUtils;
import com.yn.entity.CAbcip;
import com.yn.entity.CAbcipExample;
import com.yn.entity.CModbusRtu;
import com.yn.entity.CModbusRtuExample;
import com.yn.smo.ICAbcipService;
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
 * @Title : ABCIPController
 * @Description：ABCIP采集页面
 * @Date ：Created in 12:46 2018/10/28
 */
@Controller
@RequestMapping(value = "/collectingDevice/ABCIP")
public class ABCIPController {

    private static final Logger log = LoggerFactory.getLogger(ModbusRTUController.class);

    @Autowired
    private ICAbcipService service;

    /**
     * ABCIP采集页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String ABCIP() throws Exception {
        return "collectingDevice/ABCIP/list";
    }

    /**
     * ABCIP采集页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String ABCIPEdit() throws Exception {
        return "collectingDevice/ABCIP/edit";
    }

    /**
     * ABCIP采集页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String ABCIPAdd() throws Exception {
        return "collectingDevice/ABCIP/add";
    }

    /**
     * 查询modbusTCP，提供api接口
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/query")
    public String queryCAbcip(HttpServletRequest request) {
        String result;
        try {
            String limit = CommonUtils.getStrFromObject(request.getParameter("limit"));
            String page = CommonUtils.getStrFromObject(request.getParameter("page"));
            CModbusRtu recod = new CModbusRtu();
            CAbcipExample example = new CAbcipExample();
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
    public String addCAbcip(CAbcip recod) {
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
    public String editCAbcip(CAbcip recod) {
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
    public String edlCAbcip(String name) {
        CAbcip recod = new CAbcip();
        recod.setName(name);
        String result = service.del(recod).toString();
        return result;
    }

}
