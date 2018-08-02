package com.overseachem.petluggage.utils;

import org.springframework.stereotype.Component;

public class Return {

    private boolean status;
    private String message;

    private static Return ok = new Return(true, "");
    private static Return error = new Return(false, "");

    public Return(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Return ok(String message){
        ok.message = message;
        return ok;
    }

    public static Return error(String message){
        error.message = message;
        return error;
    }
}
