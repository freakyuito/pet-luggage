package com.overseachem.petluggage.utils;

import org.springframework.stereotype.Component;

public class Return {

    private boolean status;
    private Object message;

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

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public static Return ok(Object message){
        ok.message = message;
        return ok;
    }

    public static Return error(Object message){
        error.message = message;
        return error;
    }
}
