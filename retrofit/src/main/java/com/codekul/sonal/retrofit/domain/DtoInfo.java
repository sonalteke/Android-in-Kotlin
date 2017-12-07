package com.codekul.sonal.retrofit.domain;

/**
 * Created by sonal on 6/12/17.
 */

public class DtoInfo {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DtoInfo{" +
                "message='" + message + '\'' +
                '}';
    }

//    private String userid;
//    private String status;



}
