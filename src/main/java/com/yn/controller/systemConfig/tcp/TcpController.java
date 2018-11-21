package com.yn.controller.systemConfig.tcp;

import com.yn.common.CommonUtils;
import com.yn.common.Result;
import com.yn.controller.systemConfig.common.commonController;
import com.yn.entity.Com;
import com.yn.entity.ComExample;
import com.yn.entity.Tcp;
import com.yn.entity.TcpExample;
import com.yn.smo.IGeneralService;
import com.yn.smo.ITcpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/systemConfig/tcp")
public class TcpController {
    private static final Logger log = LoggerFactory.getLogger(TcpController.class);

    @Autowired
    private ITcpService service;

    /**
     * 网口配置页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String Tcp() throws Exception {
        return "systemConfig/tcp/list";
    }

    /**
     * 点表配置页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String TcpEdit() throws Exception {
        return "systemConfig/tcp/edit";
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
            TcpExample example = new TcpExample();
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
     * 修改，提供api接口
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/goEdit")
    public String editTcp(Tcp recod) {
        String result = service.save(recod).toString();
        return result;
    }

}
