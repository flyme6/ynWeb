package com.yn.controller.systemConfig.common;

import com.yn.common.CommonUtils;
import com.yn.common.Result;
import com.yn.controller.pointsConfig.PointsConfigController;
import com.yn.entity.*;
import com.yn.smo.IGeneralService;
import com.yn.smo.IPointsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/systemConfig/common")
public class commonController {

    private static final Logger log = LoggerFactory.getLogger(commonController.class);

    @Autowired
    private IGeneralService service;

    /**
     * 通用配置页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String common() throws Exception {
        return "systemConfig/common/list";
    }

    /**
     * 查询，提供api接口
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/query")
    public String queryCommon(HttpServletRequest request) {
        String result;
        try {
            String limit = CommonUtils.getStrFromObject(request.getParameter("limit"));
            String page = CommonUtils.getStrFromObject(request.getParameter("page"));
            General recod = new General();
            GeneralExample example = new GeneralExample();
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
     * 添加，提供api接口
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/goAdd")
    public String addCommon(String projectName, String enableRedun, String ip1, String ip2, String ip3) {
        General recod = new General();
        recod.setProjectName(projectName);
        recod.setIp1(ip1);
        recod.setIp2(ip2);
        recod.setIp3(ip3);
//        enableRedun.equals("on")
        if ("on".equals(enableRedun)) {
            recod.setEnableRedun(1);
        }
        recod.setModify(1);
        System.out.println(recod.toString() + "测试");

        GeneralExample example = new GeneralExample();
        String result = service.add(recod, example).toString();
        return result;
    }

    /**
     * 修改，提供api接口
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/goEdit")
    public String editCommon(General recod) {
        GeneralExample example = new GeneralExample();
        String projectName = recod.getProjectName();
        example.setOrderByClause(projectName);
        String result = service.save(recod, example).toString();
        return result;
    }

    /**
     * 修改，提供api接口
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/goDel")
    public String edlCommon(General recod) {
        GeneralExample example = new GeneralExample();
        example.setOrderByClause(recod.getProjectName());
        String result = service.del(example).toString();
        return result;
    }
}
