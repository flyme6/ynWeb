package com.yn.controller.pointsConfig;

import com.yn.common.CommonUtils;
import com.yn.common.Result;
import com.yn.controller.forwardingDevice.FModbusTCPRtuController;
import com.yn.entity.FModbusTcp;
import com.yn.entity.FModbusTcpExample;
import com.yn.entity.Points;
import com.yn.entity.PointsExample;
import com.yn.smo.IFModbusRtuService;
import com.yn.smo.IPointsService;
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
 * @Title : PointsConfigController
 * @Description：点表配置页面
 * @Date ：Created in 20:46 2018/10/28
 */
@Controller
@RequestMapping(value = "/pointsConfig")
public class PointsConfigController {
    private static final Logger log = LoggerFactory.getLogger(PointsConfigController.class);

    @Autowired
    private IPointsService service;

    /**
     * 点表配置页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String Points() throws Exception {
        return "pointsConfig/list";
    }

    /**
     * 点表配置页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String PointsEdit() throws Exception {
        return "pointsConfig/edit";
    }

    /**
     * 点表配置页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String PointsAdd() throws Exception {
        return "pointsConfig/add";
    }

    /**
     * 查询modbusTCP，提供api接口
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/query")
    public String queryPoints(HttpServletRequest request) {
        String result;
        try {
            String limit = CommonUtils.getStrFromObject(request.getParameter("limit"));
            String page = CommonUtils.getStrFromObject(request.getParameter("page"));
            FModbusTcp recod = new FModbusTcp();
            PointsExample example = new PointsExample();
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
    public String addPoints(Points recod) {
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
    public String editPoints(Points recod) {
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
    public String edlPoints(String name) {
        Points recod = new Points();
        recod.setName(name);
        String result = service.del(recod).toString();
        return result;
    }
}
