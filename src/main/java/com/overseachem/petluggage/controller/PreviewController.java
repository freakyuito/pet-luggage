package com.overseachem.petluggage.controller;

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

@RestController
@RequestMapping("/preview")
@CrossOrigin
public class PreviewController {

    @RequestMapping("/upload")
    public Return saveFile(
            @RequestParam("file") MultipartFile files,
            HttpServletRequest request, HttpServletResponse response) {
        String addr = request.getLocalAddr();
        int port = request.getLocalPort();
        String separator = File.separator;
        String outputPath = "D:" + separator + "freakyuito" + separator + "web" + separator + "pet-luggage-master" + separator;
        String fileName = files.getOriginalFilename();
        try (
                InputStream in = files.getInputStream();
                OutputStream out = new FileOutputStream(outputPath + fileName)
        ) {
            int n = -1;
            byte[] buf = new byte[1024];
            while ((n = in.read(buf)) != -1) {
                out.write(buf, 0, n);
            }
        } catch (Exception e) {
            return Return.error(e.getMessage());
        }
        String imgPath = outputPath + fileName;
        String blenderPath = "C:\\Program Files\\Blender Foundation\\Blender\\blender.exe";
        String blenderFilePath = "C:" + separator + "Users" + separator + "Wismo_Developer" + separator + "Desktop" + separator + "blender_processing" + separator + "suitcase.blend";
        String pyFilePath = "C:" + separator + "Users" + separator + "Wismo_Developer" + separator + "Desktop" + separator + "blender_processing" + separator + "texture_change.py";
        String commandStr = blenderPath + " -b " + blenderFilePath + " --python " + pyFilePath + " -- " + imgPath;
        String blenderOutputPath = "C:" + separator + "Users" + separator + "Wismo_Developer" + separator + "Desktop" + separator + "blender_processing" + separator + "output" + separator;
        System.out.println("prepare to execute command line: " + commandStr);
        Command.exeCmd(commandStr);
        System.out.println("output path is: " + blenderOutputPath + fileName);

        FileInputStream fis = null;
        response.setContentType("image/jpeg");
        try {
            OutputStream out = response.getOutputStream();
            File file = new File(blenderOutputPath + fileName);
            fis = new FileInputStream(file);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            out.write(b);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return Return.error(e.getMessage());
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return Return.error(e.getMessage());
                }
            }
        }
        System.out.println(blenderOutputPath + fileName);

        return Return.ok("Load Completed!");
    }

}
