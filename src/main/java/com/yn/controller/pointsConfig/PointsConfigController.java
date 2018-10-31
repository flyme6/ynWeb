package com.yn.controller.pointsConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    /**
     * 点表配置页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String PointsConfig() throws Exception {
        return "pointsConfig/list";
    }

    /**
     * 点表配置页面——修改
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/edit")
    public String PointsConfigEdit() throws Exception {
        return "pointsConfig/edit";
    }

    /**
     * 点表配置页面——添加
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public String PointsConfigAdd() throws Exception {
        return "pointsConfig/add";
    }
}
