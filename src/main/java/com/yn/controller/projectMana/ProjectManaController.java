package com.yn.controller.projectMana;


import com.yn.common.Result;
import com.yn.smo.ISystemControlService;
import com.yn.util.ynService.SystemControllerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : projectManaConller
 * @Description：工程管理接口
 * @Date ：Created in 14:10 2018/11/21
 */
@Controller
@RequestMapping(value = "/project")
public class ProjectManaController {
    private static final Logger log = LoggerFactory.getLogger(ProjectManaController.class);

    @Autowired
    private ISystemControlService service;

    /**
     * 保存工程到本地
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/exportProject")
    public String exportProject() throws Exception {
        Result result = service.exportProject();
        return result.toString();
    }

    /**
     * 新建工程
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/newProject")
    public String newProject() throws Exception {
        Result result = service.newProject();
        return result.toString();
    }

    /**
     * 工程文件下载 (检测)
     *
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value = "/saveProject")
    public String saveProject() throws Exception {
        Result result = service.saveProject();
        return result.toString();
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
        Result result = service.checkProject();
        return result.toString();
    }

//    /**
//     * 打开本地工程接口
//     *
//     * @return
//     * @throws Exception
//     */
//    @ResponseBody
//    @GetMapping(value = "/importProject")
//    public String importProject() throws Exception {
//        Object o = SystemControllerUtil.importProject();
//        return "打开本地工程" + o;
//    }

    /**
     * 打开本地工程页面(检测)
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/importProjectPage")
    public String importProjectPage() throws Exception {
        return "projectMana/importProject";
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
        Result result = service.startProject();
        return result.toString();
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
        Result result = service.stopProject();
        return result.toString();
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
        Result result = service.rebootBox();
        return result.toString();
    }


}
