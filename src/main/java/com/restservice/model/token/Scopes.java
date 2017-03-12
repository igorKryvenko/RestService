package com.restservice.model.token;

/**
 * Created by Igor on 11.03.2017.
 */
public enum  Scopes {
    REFRESH_TOKEN;

    public String authority() {
        return "ROLE_" + this.name();
    }
}
