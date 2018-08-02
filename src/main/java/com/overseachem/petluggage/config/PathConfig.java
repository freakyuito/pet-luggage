package com.overseachem.petluggage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PathConfig {

    @Value("${custom.blenderPath}")
    private String blenderPath;

    @Value("${custom.blenderFilePath}")
    private String blenderFilePath;

    @Value("${custom.pyFilePath}")
    private String pyFilePath;

    @Value("${custom.blenderOutputPath}")
    private String blenderOutputPath;

    public String getBlenderPath() {
        return blenderPath;
    }

    public void setBlenderPath(String blenderPath) {
        this.blenderPath = blenderPath;
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

    public String getBlenderOutputPath() {
        return blenderOutputPath;
    }

    public void setBlenderOutputPath(String blenderOutputPath) {
        this.blenderOutputPath = blenderOutputPath;
    }
}
