package com.overseachem.petluggage.controller;

import com.overseachem.petluggage.config.PathConfig;
import com.overseachem.petluggage.utils.Command;
import com.overseachem.petluggage.utils.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Calendar;

@RestController
@RequestMapping("/preview")
@CrossOrigin
public class PreviewController {

    @Autowired
    private PathConfig pathConfig;

    @RequestMapping("/upload")
    public Return saveFile(
            @RequestParam("file") MultipartFile files,
            HttpServletRequest request, HttpServletResponse response) {
        String addr = request.getLocalAddr();
        int port = request.getLocalPort();
        String fileName = Calendar.getInstance().getTimeInMillis() + files.getOriginalFilename();
        String imgPath = pathConfig.getImgInputPath() + fileName;
        try (
                InputStream in = files.getInputStream();
                OutputStream out = new FileOutputStream(imgPath)
        ) {
            int n = -1;
            byte[] buf = new byte[1024];
            while ((n = in.read(buf)) != -1) {
                out.write(buf, 0, n);
            }
        } catch (Exception e) {
            return Return.error(e.getMessage());
        }
        String commandStr = pathConfig.getBlenderExePath() + " -b " + pathConfig.getBlenderFilePath() + " --python " + pathConfig.getPyFilePath() + " -- " + imgPath;
        System.out.println("prepare to execute command line: " + commandStr);
        Command.exeCmd(commandStr);
        System.out.println("output path is: " + pathConfig.getImgOutputPath() + fileName);
        return Return.ok(pathConfig.getImgOutputPath() + fileName);
    }


    @RequestMapping("/step2")
    public void test(
            HttpServletResponse res,
            @RequestParam("filePath") String filePath
    ) throws Exception {
        InputStream in = new FileInputStream(filePath);
        byte[] b = new byte[in.available()];
        in.read(b);
        res.getOutputStream().write(b);
        res.getOutputStream().flush();
        in.close();
        res.getOutputStream().close();
    }
}
