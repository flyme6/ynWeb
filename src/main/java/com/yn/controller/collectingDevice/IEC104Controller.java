package com.yn.controller.collectingDevice;

import com.yn.common.CommonUtils;
import com.yn.common.Result;
import com.yn.entity.CIec104;
import com.yn.entity.CIec104Example;
import com.yn.entity.CModbusRtu;
import com.yn.entity.CModbusRtuExample;
import com.yn.smo.ICIec104Service;
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
 * @Title : IEC104Controller
 * @Description：IEC104采集页面
 * @Date ：Created in 12:46 2018/10/28
 */
@Controller
@RequestMapping(value = "/collectingDevice/IEC104")
public class IEC104Controller {
    private static final Logger log = LoggerFactory.getLogger(IEC104Controller.class);

    @Autowired
    private ICIec104Service service;

    /**
     * IEC104采集页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String IEC104() throws Exception {
        return "collectingDevice/IEC104/list";
    }

    /**
     * IEC104采集页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String IEC104Edit() throws Exception {
        return "collectingDevice/IEC104/edit";
    }

    /**
     * IEC104采集页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String IEC104Add() throws Exception {
        return "collectingDevice/IEC104/add";
    }

    /**
     * 查询，提供api接口
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
            CIec104Example example = new CIec104Example();
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
    public String addCIec104(CIec104 recod) {
        String result = service.add(recod).toString();
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
    public String editCIec104(CIec104 recod) {
        String result = service.save(recod).toString();
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
    public String edlCIec104(String name) {
        CIec104 recod = new CIec104();
        recod.setName(name);
        String result = service.del(recod).toString();
        return result;
    }
}
