package com.restservice.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Igor on 13.01.2017.
 */
public enum Role implements GrantedAuthority {
    USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
