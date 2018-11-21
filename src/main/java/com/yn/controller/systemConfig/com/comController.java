package com.yn.controller.systemConfig.com;

import com.yn.common.CommonUtils;
import com.yn.common.Result;
import com.yn.entity.Com;
import com.yn.entity.ComExample;
import com.yn.entity.Points;
import com.yn.smo.IComService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/systemConfig/com")
public class comController {
    private static final Logger log = LoggerFactory.getLogger(comController.class);

    @Autowired
    private IComService service;
    /**
     * 串口配置页面
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String Com() throws Exception {
        return "systemConfig/com/list";
    }

    /**
     * 点表配置页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String ComEdit() throws Exception {
        return "systemConfig/com/edit";
    }

    /**
     * 查询，提供api接口
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/query")
    public String queryCom(HttpServletRequest request) {
        String result;
        try {
            String limit = CommonUtils.getStrFromObject(request.getParameter("limit"));
            String page = CommonUtils.getStrFromObject(request.getParameter("page"));
            Com recod = new Com();
            ComExample example = new ComExample();
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
    public String editCom(Com recod) {
        String result = service.save(recod).toString();
        return result;
    }


}
