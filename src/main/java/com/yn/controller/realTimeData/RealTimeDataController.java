package com.yn.controller.realTimeData;

import com.yn.common.Result;
import com.yn.entity.Points;
import com.yn.smo.IRealTimeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : PointsConfigController
 * @Description：实时数据展示页面
 * @Date ：Created in 20:46 2018/10/28
 */
@Controller
@RequestMapping(value = "/realTimeData")
public class RealTimeDataController {

    @Autowired
    private IRealTimeDataService service;

    /**
     * 实时数据展示页面
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public String pointsConfig2() throws Exception {
        return "RealTimeData/list";
    }

    /**
     * csv文件导出功能
     *
     * @param request
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/export")
    public String export(HttpServletRequest request, String name, String cdev, String fdev) throws Exception {

        try {
            Points points = new Points();
//            points.setName(name);
            points.setName("%" + name + "%");
            points.setcDev(cdev);
            points.setfDev(fdev);

            String path = request.getSession().getServletContext().getRealPath("upload");

            Result export = service.export(points, path);

            return export.toString();
        } catch (Exception e) {
            return Result.getAddFailResult(e).toString();
        }
    }

    /**
     * csv文件下载功能
     *
     * @param request
     * @throws Exception
     */
    @RequestMapping("/down")
    public void down(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            String fileDownName = request.getParameter("filename");
            //模拟文件，myfile.txt为需要下载的文件
            String fileName = request.getSession().getServletContext().getRealPath("upload") + "/" + fileDownName;
            //获取输入流
            InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
            //假如以中文名下载的话
            String filename = fileDownName;
            //转码，免得文件名中文乱码
            filename = URLEncoder.encode(filename, "UTF-8");
            //设置文件下载头
            response.addHeader("Content-Disposition", "attachment;filename=" + filename);
            //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            int len = 0;
            while ((len = bis.read()) != -1) {
                out.write(len);
                out.flush();
            }
            out.close();
        } catch (Exception e) {

        }

    }

}
