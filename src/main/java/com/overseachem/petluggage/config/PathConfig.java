package com.overseachem.petluggage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PathConfig {

    @Value("${custom.blenderExePath}")
    private String blenderExePath;

    @Value("${custom.blenderFilePath}")
    private String blenderFilePath;

    @Value("${custom.pyFilePath}")
    private String pyFilePath;

    @Value("${custom.imgOutputPath}")
    private String imgOutputPath;

    @Value("${custom.imgInputPath}")
    private String imgInputPath;

    public String getBlenderExePath() {
        return blenderExePath;
    }

    public void setBlenderExePath(String blenderExePath) {
        this.blenderExePath = blenderExePath;
    }

    public String getBlenderFilePath() {
        return blenderFilePath;
    }

    public void setBlenderFilePath(String blenderFilePath) {
        this.blenderFilePath = blenderFilePath;
    }

    public String getPyFilePath() {
        return pyFilePath;
    }

    public void setPyFilePath(String pyFilePath) {
        this.pyFilePath = pyFilePath;
    }

    public String getImgOutputPath() {
        return imgOutputPath;
    }

    public void setImgOutputPath(String imgOutputPath) {
        this.imgOutputPath = imgOutputPath;
    }

    public String getImgInputPath() {
        return imgInputPath;
    }

    public void setImgInputPath(String imgInputPath) {
        this.imgInputPath = imgInputPath;
    }
}
