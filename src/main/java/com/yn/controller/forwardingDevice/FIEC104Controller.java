package com.yn.controller.forwardingDevice;

import com.yn.common.CommonUtils;
import com.yn.common.Result;
import com.yn.entity.FIec104;
import com.yn.entity.FIec104Example;
import com.yn.entity.FModbusRtu;
import com.yn.entity.FModbusRtuExample;
import com.yn.smo.IFIec104Service;
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
 * @Title : FIEC104Controller
 * @Description：IEC104转发页面
 * @Date ：Created in 12:46 2018/10/28
 */
@Controller
@RequestMapping(value = "/forwardingDevice/IEC104")
public class FIEC104Controller {

    private static final Logger log = LoggerFactory.getLogger(FIEC104Controller.class);

    @Autowired
    private IFIec104Service service;

    /**
     * IEC104转发页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String FIec104() throws Exception {
        return "forwardingDevice/IEC104/list";
    }

    /**
     * IEC104转发页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String FIec104Edit() throws Exception {
        return "forwardingDevice/IEC104/edit";
    }

    /**
     * IEC104转发页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String FIec104Add() throws Exception {
        return "forwardingDevice/IEC104/add";
    }

    /**
     * 查询，提供api接口
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/query")
    public String queryFIec104(HttpServletRequest request) {
        String result;
        try {
            String limit = CommonUtils.getStrFromObject(request.getParameter("limit"));
            String page = CommonUtils.getStrFromObject(request.getParameter("page"));
            FModbusRtu recod = new FModbusRtu();
            FIec104Example example = new FIec104Example();
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
    public String addFModbusRtu(FIec104 recod) {
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
    public String editFModbusRtu(FIec104 recod) {
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
    public String edlFModbusRtu(String name) {
        FIec104 recod = new FIec104();
        recod.setName(name);
        String result = service.del(recod).toString();
        return result;
    }

}
