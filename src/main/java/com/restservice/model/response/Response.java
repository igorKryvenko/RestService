package com.restservice.model.response;


import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * Created by Igor on 10.03.2017.
 */
//TODO rewrite the Respone system
public class Response {

    private HttpStatus status;

    private String message;

    private Date timeStamp;

    public Response() {

    }
    public Response(String message) {
        this.message = message;
        status = HttpStatus.OK;
        this.timeStamp = new Date();
    }
    public Response(String message,HttpStatus status) {
        this.message = message;
        this.status = status;
        timeStamp = new Date();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
