package com.yn.controller.systemConfig.user;

import IceInternal.Ex;
import com.yn.common.CommonUtils;
import com.yn.common.Result;
import com.yn.controller.systemConfig.tcp.TcpController;
import com.yn.entity.*;
import com.yn.smo.ITcpService;
import com.yn.smo.IUsermgrService;
import com.yn.util.MD5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/systemConfig/user")
public class userController {
    private static final Logger log = LoggerFactory.getLogger(userController.class);

    @Autowired
    private IUsermgrService service;

    /**
     * 用户配置页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String User() throws Exception {
        return "systemConfig/user/list";
    }

    /**
     * 用户配置页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String UserEdit() throws Exception {
        return "systemConfig/user/edit";
    }

    /**
     * 用户配置页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String UserAdd() throws Exception {
        return "systemConfig/user/add";
    }

    /**
     * 查询，提供api接口
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/query")
    public String queryTcp(HttpServletRequest request) {
        String result;
        try {
            String limit = CommonUtils.getStrFromObject(request.getParameter("limit"));
            String page = CommonUtils.getStrFromObject(request.getParameter("page"));
            Com recod = new Com();
            UsermgrExample example = new UsermgrExample();
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
    public String addCommon(String username, String password, Integer role) throws Exception {
        Usermgr recod = new Usermgr();
        recod.setUsername(username);
        String passwordMd5 = MD5.md5(password);
        recod.setPassword(passwordMd5);
        recod.setRole(role);

        String result = service.add(recod).toString();
        return result;
    }

}
