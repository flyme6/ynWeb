package com.yn.controller.projectMana;


import com.yn.util.ynService.SystemControllerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : projectManaConller
 * @Description：点表配置页面
 * @Date ：Created in 14:10 2018/11/21
 */
@Controller
@RequestMapping(value = "/project")
public class projectManaConller {
    private static final Logger log = LoggerFactory.getLogger(projectManaConller.class);

    /**
     * 保存工程到本地
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/exportProject")
    public String exportProject() throws Exception {
        Object o = SystemControllerUtil.exportProject();
        return "保存工程到本地" + o;
    }

    /**
     * 新建工程
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/newProject")
    public String project() throws Exception {
        Object o = SystemControllerUtil.newProject();
        return "新建工程" + o;
    }

    /**
     * 工程文件下载
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/saveProject")
    public String saveProject() throws Exception {
        Object o = SystemControllerUtil.saveProject();
        return "工程文件下载" + o;
    }

    /**
     * 检查工程
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/checkProject")
    public String checkProject() throws Exception {
        Object o = SystemControllerUtil.checkProject();
        return "检查工程" + o;
    }

    /**
     * 打开本地工程
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/importProject")
    public String importProject() throws Exception {
        Object o = SystemControllerUtil.importProject();
        return "打开本地工程" + o;
    }

    /**
     * 启动工程
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/startProject")
    public String startProject() throws Exception {
        Object o = SystemControllerUtil.startProject();
        return "启动工程" + o;
    }

    /**
     * 停止工程
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/stopProject")
    public String stopProject() throws Exception {
        Object o = SystemControllerUtil.stopProject();
        return "停止工程" + o;
    }

    /**
     * 重启盒子
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/rebootBox")
    public String rebootBox() throws Exception {
        Object o = SystemControllerUtil.rebootBox();
        return "重启盒子" + o;
    }


}
