package com.restservice.error;

import org.springframework.security.authentication.AuthenticationServiceException;

/**
 * Created by Igor on 11.03.2017.
 */
public class AuthMethodNotSupportedException extends AuthenticationServiceException {
    private static final long serialVersionUID = 3705043083010304496L;

    public AuthMethodNotSupportedException(String msg) {
        super(msg);
    }
}
