package com.restservice.model.response;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Igor on 14.03.2017.
 */
public enum  ErrorCode {
    GLOBAL(2),

    AUTHENTICATION(10), JWT_TOKEN_EXPIRED(11);

    private int errorCode;

    private ErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @JsonValue
    public int getErrorCode() {
        return errorCode;
    }
}
