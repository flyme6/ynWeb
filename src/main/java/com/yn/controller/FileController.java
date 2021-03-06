package com.yn.controller;

import com.yn.common.Result;
import com.yn.util.ynService.SystemControllerUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author flyme
 * @Title: FileController
 * @ProjectName ynWeb
 * @Description: TODO
 * @date 2018/10/9 20:02
 */

@RequestMapping("file")
@Controller
public class FileController {
    /**
     * 文件上传功能
     *
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/upload/ynService", method = RequestMethod.POST)
    @ResponseBody
    public String upProject(MultipartFile file, HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        File dir = new File(path, fileName);
        System.out.println(path + "path");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        file.transferTo(dir);
        YNRPC.Result result1 = SystemControllerUtil.importProject(fileName);
        Result result = new Result();
        result.addMsg("文件:" + fileName + "上传成功，返回结果" + result1);
        result.addCode(200);
        return result.toString();
    }

    /**
     * 文件下载功能
     *
     * @param request
     * @param response
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
