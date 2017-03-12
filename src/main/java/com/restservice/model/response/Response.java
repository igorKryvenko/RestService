package com.restservice.model.response;

import com.restservice.model.response.Error;

/**
 * Created by Igor on 10.03.2017.
 */
public class Response {

    private int code;

    private String message;

    private com.restservice.model.response.Error error;

    public Response(int code, String message, Error error) {
        this.code = code;
        this.message = message;
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
